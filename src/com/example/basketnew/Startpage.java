package com.example.basketnew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.StaticLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Startpage extends Activity{
	Button strt,exit;
	public static Startpage ob;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		strt=(Button) findViewById(R.id.button1);
		exit=(Button) findViewById(R.id.button3);
		if (getIntent().getBooleanExtra("EXIT", false)) {
		    finish();
		}
		strt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(), MainActivity.class);
				//startActivityForResult(i, 1);
				startActivity(i);
				
			}
		});
		exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

}
