package br.com.lucasaquiles.cogg.config;

import android.os.Environment;

public class Config {
	
	
	public static String getMainPath(){
		
		String extr = Environment.getExternalStorageDirectory().toString();
		String mainFolder = extr + "/br.com.lucasaqiles.cogg";

		return mainFolder;
	}
}
