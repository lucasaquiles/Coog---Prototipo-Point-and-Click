package br.com.lucasaquiles.cogg.view;

import android.content.Context;

public class EyeView extends FaceItemView{

	public EyeView(Context context, ImageItemEnum imageItem) {
		super(context, imageItem);
	}

	@Override
	public boolean isHair() {
		return false;
	}

	@Override
	public boolean isEye() {
		return true;
	}

	@Override
	public boolean isMouth() {
		return false;
	}

}
