package br.com.lucasaquiles.cogg.view;

import android.content.Context;

public class MouthView extends FaceItemView{
	
	public MouthView(Context context, ImageItemEnum imageItem) {
		super(context, imageItem);
		
		
	}

	@Override
	public boolean isHair() {
		return false;
	}

	@Override
	public boolean isEye() {
		return false;
	}

	@Override
	public boolean isMouth() {
		return true;
	}

}
