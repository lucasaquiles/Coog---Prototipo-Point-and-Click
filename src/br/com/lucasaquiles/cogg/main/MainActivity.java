package br.com.lucasaquiles.cogg.main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import br.com.lucasaquiles.cogg.R;
import br.com.lucasaquiles.cogg.view.ImageScrollerView;

public class MainActivity extends android.support.v7.app.ActionBarActivity implements OnClickListener{
	
	private ImageScrollerView scroller;
	private RelativeLayout relativeLayout;
	private RelativeLayout panel;
	private RelativeLayout foto;
	private FrameLayout frameEyes;
	private FrameLayout frameHair;
	private FrameLayout frameMouth;
	
	private ImageView selectedImageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main_layout);
		
		scroller = (ImageScrollerView) findViewById(R.id.scroller);
		relativeLayout = (RelativeLayout) findViewById(R.id.face);
		
		panel = (RelativeLayout) findViewById(R.id.panel);
		panel.setBackgroundColor(Color.rgb(73, 202, 194));
		
		foto = (RelativeLayout) findViewById(R.id.foto);
		
		frameEyes = (FrameLayout) findViewById(R.id.frameEyes);
		frameHair = (FrameLayout) findViewById(R.id.frameHair);
		frameMouth = (FrameLayout) findViewById(R.id.frameMouth);
		
		SharedResources.getInstance().setFrameEyes(frameEyes);
		SharedResources.getInstance().setFrameHair(frameHair);
		SharedResources.getInstance().setFrameMouth(frameMouth);
		
		selectedImageView = (ImageView) findViewById(R.id.imageView1);
		
		Intent intent = getIntent();
		
		String imagePath = intent.getStringExtra("selectedImage");
		
		Bitmap bitmap2 = BitmapFactory.decodeFile(imagePath);
		selectedImageView.setImageBitmap(bitmap2);
		
	
	}

	@Override
	public void onBackPressed() {
		
		moveTaskToBack(true); 
	    MainActivity.this.finish();
	}
	
	@Override
	public void onClick(View v) {
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
	    	case R.id.action_save:
	    		Bitmap bitmap;
				relativeLayout.setDrawingCacheEnabled(true);
				bitmap = Bitmap.createBitmap(relativeLayout.getDrawingCache());
				relativeLayout.setDrawingCacheEnabled(false);
				
				ByteArrayOutputStream bytes = new ByteArrayOutputStream();
				bitmap.compress(Bitmap.CompressFormat.JPEG, 40, bytes);
				String dir = Environment.getExternalStorageDirectory()+ File.separator + "test.jpg";
				File f = new File(dir);
				
				try {
					f.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				  FileOutputStream fo = null;
				try {
					fo = new FileOutputStream(f);
					fo.write(bytes.toByteArray());
					fo.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Toast.makeText(this, "Imagem foi salva em: "+dir, Toast.LENGTH_LONG).show();
	    	;
	    	
	    	case android.R.id.home: ;
	    	default:;
	    }
		return super.onOptionsItemSelected(item);
	}
}
