package br.com.lucasaquiles.cogg.view;

import br.com.lucasaquiles.cogg.R;

public enum ImageItemEnum {

	EYE_1(""){

		@Override
		public int getDisplayedResource() {
			
			return R.drawable.eye_1;
		}

		@Override
		public int getSelectedResource() {
	
			return R.drawable.eyes_1_selected;
		}
		
	},
	
	EYE_2(""){

		@Override
		public int getDisplayedResource() {
			
			return R.drawable.eye_2;
		}

		@Override
		public int getSelectedResource() {
	
			return R.drawable.eyes_2_selected;
		}
	},
	
	EYE_3(""){

		@Override
		public int getDisplayedResource() {
			
			return R.drawable.eye_3;
		}

		@Override
		public int getSelectedResource() {
	
			return R.drawable.eye_selected;
		}
		
	},
	
	EYE_4(""){

		@Override
		public int getDisplayedResource() {
			
			return R.drawable.eye_4;
		}

		@Override
		public int getSelectedResource() {
	
			return R.drawable.selected_4_eye;
		}
		
	},
	
	EYE_5(""){

		@Override
		public int getDisplayedResource() {
			
			return R.drawable.eye_5;
		}

		@Override
		public int getSelectedResource() {
	
			return R.drawable.selected_5_eye;
		}
		
	},
	
	EYE_6(""){

		@Override
		public int getDisplayedResource() {
			
			return R.drawable.eye_6;
		}

		@Override
		public int getSelectedResource() {
	
			return R.drawable.selected_6_eye;
		}
		
	},
	
	
	HAIR_1(""){

		@Override
		public int getDisplayedResource() {
			
			return R.drawable.hair_1_;
		}

		@Override
		public int getSelectedResource() {
	
			return R.drawable.hair_1_selected;
		}
		
	},
	
	HAIR_2(""){

		@Override
		public int getDisplayedResource() {
			
			return R.drawable.hair_2;
		}

		@Override
		public int getSelectedResource() {
	
			return R.drawable.hair_2_selected;
		}
		
	},
	
	HAIR_3(""){

		@Override
		public int getDisplayedResource() {
			
			return R.drawable.hair_3;
		}

		@Override
		public int getSelectedResource() {
	
			return R.drawable.hair_3_selected;
		}
		
	},
	
	HAIR_4(""){

		@Override
		public int getDisplayedResource() {
			
			return R.drawable.hair_4;
		}

		@Override
		public int getSelectedResource() {
	
			return R.drawable.hair_4_selected;
		}
		
	},
	
	HAIR_5(""){

		@Override
		public int getDisplayedResource() {
			
			return R.drawable.hair_5;
		}

		@Override
		public int getSelectedResource() {
	
			return R.drawable.hair_5_selected;
		}
		
	},
	
	MOUTH_1(""){

		@Override
		public int getDisplayedResource() {
			
			return R.drawable.mouth_1;
		}

		@Override
		public int getSelectedResource() {
	
			return R.drawable.mouth_1_selected;
		}
		
	},
	
	
	MOUTH_2(""){

		@Override
		public int getDisplayedResource() {
			
			return R.drawable.mouth_2;
		}

		@Override
		public int getSelectedResource() {
	
			return R.drawable.mouth_2_selected;
		}
		
	},
	
	MOUTH_3(""){

		@Override
		public int getDisplayedResource() {
			
			return R.drawable.mouth_3;
		}

		@Override
		public int getSelectedResource() {
	
			return R.drawable.mouth_3_selected;
		}
		
	}
	
	;
	
	private String displayedImage;
	
	ImageItemEnum(String a){
		
	}
	
	public String getDisplayedImage(){
		
		return this.displayedImage;
	}
	
	public abstract int getDisplayedResource();
	public abstract int getSelectedResource();
}
