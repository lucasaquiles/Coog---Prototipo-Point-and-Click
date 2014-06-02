package br.com.lucasaquiles.cogg.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import br.com.lucasaquiles.cogg.R;
import br.com.lucasaquiles.cogg.main.SharedResources;

public abstract class FaceItemView extends ImageView implements OnClickListener{
	
	private ImageItemEnum imageItem;
	
	private static FaceItemView tmpClickedItem = null;
	
	public FaceItemView(Context context, ImageItemEnum imageItem) {
		super(context);
		
		this.setImageResource(imageItem.getDisplayedResource());
		
		final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(15, 0, 0, 0);
		
		this.setPadding(15, 15, 15, 15);
		
		this.setLayoutParams(layoutParams);
		
		setOnClickListener(this);
		
		this.imageItem = imageItem;
	}

	@Override
	public void onClick(View v) {
		
		FaceItemView faceItemView = (FaceItemView) v;
		final int displayedResource = faceItemView.getImageItem().getSelectedResource();
		
		final SharedResources instance = SharedResources.getInstance();
		
		if(faceItemView.isEye()){
			instance.getFrameEyes().setBackgroundResource(displayedResource);
		}
		
		if(faceItemView.isHair()){
			instance.getFrameHair().setBackgroundResource(displayedResource);
		}
		
		if(tmpClickedItem != null){
			
			tmpClickedItem.setBackgroundResource(R.drawable.blank_border);
			tmpClickedItem = null;
		}
		
		faceItemView.setBackgroundResource(R.drawable.border);
		tmpClickedItem = faceItemView;
		
	}
	
	public ImageItemEnum getImageItem() {
		return imageItem;
	}
	
	public abstract boolean isHair();
	public abstract boolean isEye();
	public abstract boolean isMouth();
}
