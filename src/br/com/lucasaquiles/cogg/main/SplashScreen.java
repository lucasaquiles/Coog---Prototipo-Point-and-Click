package br.com.lucasaquiles.cogg.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import br.com.lucasaquiles.cogg.R;

public class SplashScreen extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.splash_screen);
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				Intent i = new Intent(SplashScreen.this, MainActivity.class);
				SplashScreen.this.startActivity(i);
				SplashScreen.this.finish();
			}
		}, 4000);
	}
}
