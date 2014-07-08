package edu.oit.cst407.cm.trunk;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	static final int REQUEST_IMAGE_CAPTURE = 3000; //
	private Button buttonTakePicture = null;
	private Button buttonStartOpinion = null;
	private ImageView myImageView = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState){ //
		super.onCreate(savedInstanceState);			//	
		setContentView(R.layout.activity_main);		//
		
		myImageView = (ImageView)findViewById(R.id.imagePhoto); //
		buttonTakePicture = (Button)findViewById (R.id.buttonSelectImage); //
		buttonStartOpinion = (Button)findViewById (R.id.buttonBeginOpinion);
		
		buttonTakePicture.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent takePictureIntent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
				if(takePictureIntent.resolveActivity(getPackageManager()) != null ) {
					startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
				}
			}
		});
		buttonStartOpinion.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				//if (v == buttonStartOpinion) {
				Intent opinionIntent = new Intent(MainActivity.this, OpinionActivity.class);
				startActivity(opinionIntent);
				//}
			}
		});
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
			Bitmap photo = (Bitmap) data.getExtras().get("data");
			myImageView.setImageBitmap(photo);
		}
	}
}