package br.com.lucasaquiles.cogg.main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import br.com.lucasaquiles.cogg.R;
import br.com.lucasaquiles.cogg.config.Config;

public class SplashScreen extends Activity implements OnClickListener{
	
	private Button takePicButton;
	private Button choosePicButton;
	private Button howToUseButton;
	
	private Bitmap bitmap;
	
	static final int REQUEST_CODE_SELECT_PIC = 1;
	static final int REQUEST_CODE_TAKE_PIC = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		choosePicButton = (Button) findViewById(R.id.choosePicButton);
		takePicButton = (Button) findViewById(R.id.takePicButton);
		howToUseButton = (Button) findViewById(R.id.howToUseButton);
		
		initDir();
		
		choosePicButton.setOnClickListener(this);
		takePicButton.setOnClickListener(this);
		howToUseButton.setOnClickListener(this);
	}

	private void initDir() {
		
		File mFolder = new File(Config.getMainPath());
        if (!mFolder.exists()) {
             
        	mFolder.mkdir();
        }
	}
	
	public String createTmpFile(Bitmap bitmap){
		
         String tmpDir = Config.getMainPath() + "/tmp";
		 File mFolder = new File(tmpDir);
         if (!mFolder.exists()) {
             
        	mFolder.mkdir();
         }
         
         String s = "tmp.jpg";
         String strMyImagePath = null;
         
         File f = new File(mFolder.getAbsolutePath(), s);

         strMyImagePath = f.getAbsolutePath();
         FileOutputStream fos = null;
       
         try {
             fos = new FileOutputStream(f);
             bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
             fos.flush();
             fos.close();
         } catch (FileNotFoundException e) {

             e.printStackTrace();
         } catch (Exception e) {

             e.printStackTrace();
         }

         bitmap.recycle();
         
        return strMyImagePath;
	}

	@Override
	public void onClick(View v) {
		
		if(v.equals(choosePicButton)){
			
			Intent intent = new Intent();
		    intent.setType("image/*");
		    intent.setAction(Intent.ACTION_GET_CONTENT);
		    intent.addCategory(Intent.CATEGORY_OPENABLE);
		    startActivityForResult(intent, REQUEST_CODE_SELECT_PIC);
		}

		if(v.equals(takePicButton)){
			
			try{
				
				Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			    startActivityForResult(intent, REQUEST_CODE_TAKE_PIC);
				
			}catch(Exception e){
				
				Toast.makeText(this, "Ops: "+e.getMessage(), Toast.LENGTH_LONG).show();
			}
		}
		
		if(v.equals(howToUseButton)){
			
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		InputStream stream = null;
		
		
		if(requestCode == REQUEST_CODE_TAKE_PIC && resultCode == Activity.RESULT_OK){
			
			super.onActivityResult(requestCode, resultCode, data);
		    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
		    
		    initMainActivity(bitmap);
		    
		    //selectedImageView.setImageBitmap(bp);
		}
		
		if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
			try {

				if (bitmap != null) {
					bitmap.recycle();
				}
				stream = getContentResolver().openInputStream(data.getData());
				
				bitmap = BitmapFactory.decodeStream(stream);
				
				initMainActivity(bitmap);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (stream != null) {
					try {
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void initMainActivity(Bitmap bitMap) {
		String imagePath = createTmpFile(bitMap);
		Intent i = new Intent(SplashScreen.this, MainActivity.class);
		i.putExtra("selectedImage", imagePath);
		SplashScreen.this.startActivity(i);
		SplashScreen.this.finish();
	}

	public byte[] compressBitmap(Bitmap bitmap) {
		ByteArrayOutputStream compress = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.JPEG, 40, compress);
		
		byte[] bytes = compress.toByteArray();
		return bytes;
	}
	
	public static Bitmap uncompressBitmap(byte[] bytes){
		
	    Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
	
	    return bmp;
	}
}
