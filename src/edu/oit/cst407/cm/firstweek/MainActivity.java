package edu.oit.cst407.cm.firstweek;

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
	private ImageView myImageView = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState){ //
		super.onCreate(savedInstanceState);			//	
		setContentView(R.layout.activity_main);		//
		
		myImageView = (ImageView)findViewById(R.id.imagePhoto); //
		buttonTakePicture = (Button)findViewById (R.id.buttonSelectImage); //
		
		buttonTakePicture.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent takePictureIntent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
				if(takePictureIntent.resolveActivity(getPackageManager()) != null ) {
					startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
				}
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