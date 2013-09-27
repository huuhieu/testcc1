package com.example.project01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;


public class Result extends Activity {
	private int arr[]=null;
	private TextView result, tv1, input;
	private String number="";
	private int receiveChoice;
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
		requestWindowFeature(Window.FEATURE_LEFT_ICON);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_screen);
		input=(TextView)findViewById(R.id.input);
		tv1=(TextView)findViewById(R.id.TextView1);
		result=(TextView)findViewById(R.id.result);
		Bundle rebundle = new Bundle();
		rebundle = this.getIntent().getExtras();
		arr = rebundle.getIntArray("value");
		Bundle receiveBundle = this.getIntent().getExtras();
	  	receiveChoice = receiveBundle.getInt("choice");
	  	for (int i = 0; i < arr.length; i++) {
	  		number = number + " " + arr[i];
	  	}
	  	input.setText("Input: " + number);
	  	//Merge Sort
	  	if (receiveChoice == 1){
	  		tv1.setText("Merge Sort with steps");
	  		MergeSortSteps m = new MergeSortSteps();
	  		result.setText(m.mergeResult(arr));
	  	}
	  	//Timsort
	  	if (receiveChoice == 2){
	  		tv1.setText("Timsort with steps");
	  		TimsortSteps t = new TimsortSteps();
	  		result.setText(t.Tim(arr));
	  	}
	  	//Counting Sort
	  	if (receiveChoice == 3){
	  		tv1.setText("Counting Sort with steps");
	  		CountingSortSteps c = new CountingSortSteps();
	  		result.setText(c.CountingSort(arr));
	  	}
	}

	public void btReset(View view)
	{
		Intent intent = new Intent(this, Choice.class);
		startActivity(intent);
	}
}