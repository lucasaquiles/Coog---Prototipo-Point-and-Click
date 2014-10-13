package br.com.lucasaquiles.cogg.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import br.com.lucasaquiles.cogg.R;

public class ImageScrollerView extends HorizontalScrollView{
	
	static private LinearLayout scrollLayout;
//	static private LinearLayout indicator;
//	private int resourceIndicator = -1;
	
	public ImageScrollerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Indicator);
		
		int count = typedArray.getIndexCount();
	    try{
		    for (int i = 0; i < count; ++i) {
		    	int attr = typedArray.getIndex(i);

		    	if(attr == R.styleable.Indicator_indicator) {
		    		
		    		int ident = typedArray.getResourceId(attr, -1);

//		    		resourceIndicator = ident;
		    	}
		    }
	    }catch(Exception e){
	    	
	    }
		
		configLayout(context);
		configImages();
		
		this.addView(scrollLayout);

	}

//	public static void setIndicator(LinearLayout indicator) {
//		ImageScrollerView.indicator = indicator;
//	}
//	
//	public void createIndicator(){
//		
//		if(indicator != null && scrollLayout != null){
//			
//			int count = scrollLayout.getChildCount()-1;
//			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
//			
//			TextView text  = null;
//			for(int i =0; i < count;i++){
//				
//				text = new TextView(this.getContext());
//				text.setText("["+i+"]");
//				
//				indicator.addView(text, params);
//				
//				text = null;
//			}
//		}
//	}
	
	public void configImages(){
		
		FaceItemView faceItem = new EyeView(this.getContext(), ImageItemEnum.EYE_1);
		
		FaceItemView faceItem2 = new EyeView(this.getContext(), ImageItemEnum.EYE_2);
//		
		FaceItemView faceItem3 = new EyeView(this.getContext(), ImageItemEnum.EYE_3);

		scrollLayout.addView(faceItem);
		scrollLayout.addView(faceItem2);
		scrollLayout.addView(faceItem3);
		scrollLayout.addView(new HairView(this.getContext(), ImageItemEnum.HAIR_1));
		scrollLayout.addView(new HairView(this.getContext(), ImageItemEnum.HAIR_2));
		scrollLayout.addView(new HairView(this.getContext(), ImageItemEnum.HAIR_3));
		scrollLayout.addView(new HairView(this.getContext(), ImageItemEnum.HAIR_4));
		scrollLayout.addView(new MouthView(this.getContext(), ImageItemEnum.MOUTH_1));
		scrollLayout.addView(new MouthView(this.getContext(), ImageItemEnum.MOUTH_2));
		scrollLayout.addView(new MouthView(this.getContext(), ImageItemEnum.MOUTH_3));
	}
	
	private void configLayout(Context context) {
		
		scrollLayout = new LinearLayout(context);
		scrollLayout.setOrientation(LinearLayout.HORIZONTAL);
		scrollLayout.setBackgroundColor(Color.rgb(255, 228, 235));
		
		scrollLayout.setPadding(15, 0, 15, 0);
		
		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);

		scrollLayout.setWeightSum(10f);
		scrollLayout.setLayoutParams(params);
	}

}
