package com.example.project01;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;


/**
 * @author Administrator
 *
 */
public class Array_screen extends Activity {

private  TextView tv1, tv2;
private TextView	notice;
private String number="";
private int sentarr[] = null;
private int receiveChoice;
private int temp;
		
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
		requestWindowFeature(Window.FEATURE_LEFT_ICON);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.array_screen);
		tv1=(TextView)findViewById(R.id.TextView1);
		tv2=(TextView)findViewById(R.id.TextView2);
		notice=(TextView)findViewById(R.id.notice);
		Bundle rev = this.getIntent().getExtras();
		temp = rev.getInt("value");
		notice.setText(temp+"");
		sentarr = new int[temp];
		Random rand = new Random();
		
		for (int i = 0; i < temp; i++) {
		sentarr[i]=rand.nextInt(10);
		number=number+" "+sentarr[i];
		}
		Bundle receiveBundle = this.getIntent().getExtras();
	  	receiveChoice = receiveBundle.getInt("choice");
		if (receiveChoice == 1)
			tv1.setText("Merge Sort is processing...");
		if (receiveChoice == 2)
			tv1.setText("Timsort is processing...");
		if (receiveChoice == 3)
			tv1.setText("Counting Sort is processing...");
		tv2.setText(number);
	}
	
	public void btBack(View view)
	{
		Intent intent = new Intent(this, Sort_screen.class);
		startActivity(intent);
	}
	
	public void btNew(View view)
	{
		number = "";
		Random rand = new Random();
		for (int i = 0; i < temp; i++) {
			sentarr[i]=rand.nextInt(10);
			number=number+" "+sentarr[i];
		}
		tv2.setText(number);
		
	}

	public void btNext(View view)
	{
	  	Bundle sendChoice = new Bundle();
		sendChoice.putInt("choice", receiveChoice);
		Intent intent = new Intent(this, Result.class);
		Bundle sent_array = new Bundle();
		sent_array.putIntArray("value", sentarr);
		intent.putExtras(sent_array);
		intent.putExtras(sendChoice);
		startActivity(intent);
	}
	
}