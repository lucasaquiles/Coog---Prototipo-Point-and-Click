package br.com.lucasaquiles.cogg.main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import br.com.lucasaquiles.cogg.R;
import br.com.lucasaquiles.cogg.view.ImageScrollerView;

public class MainActivity extends Activity implements OnClickListener{
	
	private ImageScrollerView scroller;
	private RelativeLayout relativeLayout;
	private RelativeLayout panel;
	private FrameLayout frameEyes;
	private FrameLayout frameHair;
	private Button saveButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main_layout);
		
		scroller = (ImageScrollerView) findViewById(R.id.scroller);
		relativeLayout = (RelativeLayout) findViewById(R.id.face);
		
		panel = (RelativeLayout) findViewById(R.id.panel);
		panel.setBackgroundColor(Color.rgb(73, 202, 194));
		
		frameEyes = (FrameLayout) findViewById(R.id.frameEyes);
		frameHair = (FrameLayout) findViewById(R.id.frameHair);
		
		saveButton = (Button) findViewById(R.id.save);
		
		SharedResources.getInstance().setFrameEyes(frameEyes);
		SharedResources.getInstance().setFrameHair(frameHair);
		
		saveButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		if(v.equals(saveButton)){

			Bitmap bitmap;
			relativeLayout.setDrawingCacheEnabled(true);
			bitmap = Bitmap.createBitmap(relativeLayout.getDrawingCache());
			relativeLayout.setDrawingCacheEnabled(false);
			
			ByteArrayOutputStream bytes = new ByteArrayOutputStream();
			bitmap.compress(Bitmap.CompressFormat.JPEG, 40, bytes);
			File f = new File(Environment.getExternalStorageDirectory()+ File.separator + "test.jpg");
			
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
			
			Toast.makeText(this, "Imagem foi salva", Toast.LENGTH_LONG).show();

		}
	}
	
	
}
