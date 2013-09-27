package com.example.project01;

import android.util.Log;
import android.os.Bundle;
import android.os.Message;
import android.app.Activity;
import android.os.Handler;
import android.content.Intent;
import android.view.Window;

public class Project01 extends Activity {
	
    private Handler handler=new Handler() {
		@Override
		public void handleMessage(Message msg) 
		{
			try 
			{
				if (isRunning==false)
		        {
					Thread.sleep(10);
					finish();
					Intent intent = new Intent(Project01.this, Choice.class);
					startActivity(intent);
		        }
				else
				{
					isRunning = true;
				}	
			} 
			catch (Exception e) 
			{
			}
		}
	};

	boolean isRunning=false;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
	{
		requestWindowFeature(Window.PROGRESS_START);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_screen);
	}


    @Override
	public void onStart() 
	{
    	isRunning = true;
    	super.onStart();
    	
    	Thread background=new Thread(new Runnable() 
        {
			public void run() {
				for (int i=0;i<10 && isRunning;i++) 
					try
					{
						Thread.sleep(100);
						handler.sendMessage(handler.obtainMessage());
					}
					catch (Throwable t)
					{
						Log.e("run", "failed");
					}
				onStop();
			}
        });	
    	isRunning = true;
    	background.start();
	}
    
    @Override
	public void onStop()
    {
    	super.onStop();
    	isRunning = false;
    }
    
}
