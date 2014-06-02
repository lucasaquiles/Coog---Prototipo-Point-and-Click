package br.com.lucasaquiles.cogg.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import br.com.lucasaquiles.cogg.R;

public class ImageScrollerView extends HorizontalScrollView{
	
	static private LinearLayout layout;
	
	public ImageScrollerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		configLayout(context);
		configImages();
		
		this.addView(layout);
	}

	public void configImages(){
		
		FaceItemView faceItem = new EyeView(this.getContext(), ImageItemEnum.EYE_1);
		
		FaceItemView faceItem2 = new EyeView(this.getContext(), ImageItemEnum.EYE_2);
//		
		FaceItemView faceItem3 = new EyeView(this.getContext(), ImageItemEnum.EYE_3);

		layout.addView(faceItem);
		layout.addView(faceItem2);
		layout.addView(faceItem3);
		layout.addView(new HairView(this.getContext(), ImageItemEnum.HAIR_1));
		layout.addView(new HairView(this.getContext(), ImageItemEnum.HAIR_2));
		layout.addView(new HairView(this.getContext(), ImageItemEnum.HAIR_3));
		layout.addView(new HairView(this.getContext(), ImageItemEnum.HAIR_4));
		
//		layout.addView(faceItem4);
	}
	
	private void configLayout(Context context) {
		
		layout = new LinearLayout(context);
		layout.setOrientation(LinearLayout.HORIZONTAL);
		layout.setBackgroundColor(Color.rgb(255, 228, 235));
		
		layout.setPadding(15, 0, 15, 0);
		
		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);

		layout.setWeightSum(10f);
		layout.setLayoutParams(params);
	}

}
