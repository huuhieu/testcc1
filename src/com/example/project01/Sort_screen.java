package com.example.project01;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Sort_screen extends Activity {
	
	public EditText edittext;
	private int receiveChoice;

	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
		requestWindowFeature(Window.FEATURE_LEFT_ICON);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sort_screen);
		TextView tv1=(TextView)findViewById(R.id.TextView1);
	    Bundle receiveBundle = this.getIntent().getExtras();
	  	receiveChoice = receiveBundle.getInt("choice");
		if (receiveChoice == 1)
			tv1.setText("Merge Sort is chosen");
		if (receiveChoice == 2)
			tv1.setText("Timsort is chosen");
		if (receiveChoice == 3)
			tv1.setText("Counting Sort is chosen");
	    addKeyListener();
	}
	
	public void addKeyListener() {
		 
		// get edittext component
		edittext = (EditText) findViewById(R.id.editText1);
	 
		// add a keylistener to keep track user input
		edittext.setOnKeyListener(new OnKeyListener()		 {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
	 
				// if keydown and "enter" is pressed
				if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
	 
					// display a floating message
					Toast.makeText(Sort_screen.this, edittext.getText(), Toast.LENGTH_LONG).show();
					
					return true;
					
				}
				return false;
			}
		});
	}
	
	public void btOK(View view)
	{
		//Button bt1=(Button)findViewById(R.id.button1);
		Bundle bundle = new Bundle();
		Bundle sendChoice = new Bundle();
		sendChoice.putInt("choice", receiveChoice);
		if (edittext.getText().toString().equals("")){
			AlertDialog.Builder builder = new AlertDialog.Builder(Sort_screen.this);
			builder.setTitle("Info missing");
			builder.setMessage("Please enter the number of array elements into the box!");
			builder.setPositiveButton("Continue", new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog, int which) {
					//TODO Auto-generated method stub
				}
			});
			builder.show();
		}
		else {
			int tem = Integer.valueOf(edittext.getText().toString());
			if(tem<=10&&
					tem >0){
			bundle.putInt("value", tem);
			//Log.d(tag, msg)
			Intent intent = new Intent(this, Array_screen.class);
			intent.putExtras(bundle);
			intent.putExtras(sendChoice);
			startActivity(intent);
			}
			else
				Toast.makeText(Sort_screen.this," you must enter a numer from 1 to 10 ", Toast.LENGTH_LONG).show();
		}
	}
	
	
}