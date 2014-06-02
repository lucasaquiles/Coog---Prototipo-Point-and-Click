package br.com.lucasaquiles.cogg.main;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import br.com.lucasaquiles.cogg.R;
import br.com.lucasaquiles.cogg.view.ImageScrollerView;

public class MainActivity extends Activity{
	
	private ImageScrollerView scroller;
	private RelativeLayout relativeLayout;
	private RelativeLayout panel;
	private FrameLayout frameEyes;
	private FrameLayout frameHair;
	
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
		
		SharedResources.getInstance().setFrameEyes(frameEyes);
		SharedResources.getInstance().setFrameHair(frameHair);
	}
}
