package br.com.lucasaquiles.cogg.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import br.com.lucasaquiles.cogg.R;
import br.com.lucasaquiles.cogg.main.SharedResources;

public abstract class FaceItemView extends ImageView implements OnClickListener, AnimationListener{
	
	private ImageItemEnum imageItem;
	private Animation animation;
	private Animation fadeInAnimation;
	
	private static FaceItemView tmpClickedItem = null;
	
	public FaceItemView(Context context, ImageItemEnum imageItem) {
		super(context);
		
		this.setImageResource(imageItem.getDisplayedResource());
		
		final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(15, 0, 0, 0);
		
		this.setPadding(15, 15, 15, 15);
		
		this.setLayoutParams(layoutParams);
		
		setOnClickListener(this);
		
		animation = AnimationUtils.loadAnimation(context,R.anim.slide_down);
		animation.setAnimationListener(this);
		this.imageItem = imageItem;
		
		fadeInAnimation = AnimationUtils.loadAnimation(context,R.anim.fade_in);
		fadeInAnimation.setAnimationListener(this);
		
		this.startAnimation(animation);
	}

	@Override
	public void onClick(View v) {
		
		FaceItemView faceItemView = (FaceItemView) v;
		
		final int displayedResource = faceItemView.getImageItem().getSelectedResource();
		
		final SharedResources instance = SharedResources.getInstance();
		
		if(faceItemView.isEye()){
			instance.getFrameEyes().setBackgroundResource(displayedResource);
			instance.getFrameEyes().startAnimation(fadeInAnimation);
		}
		
		if(faceItemView.isHair()){
			instance.getFrameHair().setBackgroundResource(displayedResource);
			instance.getFrameHair().startAnimation(fadeInAnimation);
		}
		
		if(faceItemView.isMouth()){
			instance.getFrameMouth().setBackgroundResource(displayedResource);
			instance.getFrameMouth().startAnimation(fadeInAnimation);
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
	
	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}
	
	public abstract boolean isHair();
	public abstract boolean isEye();
	public abstract boolean isMouth();
}
