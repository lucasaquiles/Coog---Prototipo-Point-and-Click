package br.com.lucasaquiles.cogg.main;

import android.widget.FrameLayout;

public class SharedResources {
	
	private static SharedResources instance = null;
	private FrameLayout frameEyes = null;
	private FrameLayout frameHair = null;
	private FrameLayout frameMouth = null;
	
	protected SharedResources(){}
	
	public static SharedResources getInstance(){
		if(instance == null){
			
			instance = new SharedResources();
		}
		
		return instance;
	}
	
	public FrameLayout getFrameEyes() {
		return frameEyes;
	}
	
	public void setFrameEyes(FrameLayout frameEyes) {
		this.frameEyes = frameEyes;
	}
	
	public FrameLayout getFrameHair() {
		return frameHair;
	}
	
	public void setFrameHair(FrameLayout frameHair) {
		this.frameHair = frameHair;
	}
	
	public void setFrameMouth(FrameLayout frameMouth) {
		this.frameMouth = frameMouth;
	}
	
	public FrameLayout getFrameMouth() {
		return frameMouth;
	}
}
