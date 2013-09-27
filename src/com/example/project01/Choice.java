package com.example.project01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;


public class Choice extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choice_screen);
		
	}

	public void onButtonClick01(View v)
	{
		Intent intent = new Intent(Choice.this, Sort_screen.class);
		Bundle sendChoice = new Bundle();
		sendChoice.putInt("choice", 1);
		intent.putExtras(sendChoice);
		startActivity(intent);
		finish();
	}
	
	public void onButtonClick02(View v)
	{
		Intent intent = new Intent(this, Sort_screen.class);
		Bundle sendChoice = new Bundle();
		sendChoice.putInt("choice", 2);
		intent.putExtras(sendChoice);
		startActivity(intent);
		finish();
	}
	
	public void onButtonClick03(View v)
	{
		Intent intent = new Intent(this, Sort_screen.class);
		Bundle sendChoice = new Bundle();
		sendChoice.putInt("choice", 3);
		intent.putExtras(sendChoice);
		startActivity(intent);
		finish();
	}
}