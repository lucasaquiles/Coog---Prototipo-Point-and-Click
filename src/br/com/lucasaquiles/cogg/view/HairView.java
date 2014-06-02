package br.com.lucasaquiles.cogg.view;

import android.content.Context;

public class HairView extends FaceItemView{
	
	public HairView(Context context, ImageItemEnum imageItem) {
		super(context, imageItem);
	}

	@Override
	public boolean isHair() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEye() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMouth() {
		// TODO Auto-generated method stub
		return false;
	}

}
