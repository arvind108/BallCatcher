package com.example.basketnew;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class endpage extends Activity{
	Button restart,exit;
	TextView score,high;
	private int highscore=0;
	SharedPreferences pef;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.endpage);
		restart=(Button) findViewById(R.id.button1);
		exit=(Button) findViewById(R.id.button2);
		score=(TextView) findViewById(R.id.textView3);
		high=(TextView) findViewById(R.id.textView4);
		Intent i=getIntent();
		String st=i.getStringExtra("b");
		int temp=Integer.parseInt(st);
		 pef=getSharedPreferences("high_score", MODE_PRIVATE);
		Editor edit=pef.edit();
		 String s=pef.getString("score", null);
		     
		 if(s==null)
		 {
			 highscore=temp;
				high.setText(Integer.toString(highscore));
				edit.putString("score",st);
				edit.commit();
		 }
		 else{
			 highscore=Integer.parseInt(s);
			 if(highscore<temp)
			 {
				 highscore=temp;
					high.setText(Integer.toString(highscore));
					edit.putString("score",st);
					edit.commit();
		     }
		 else 
		{
			high.setText(Integer.toString(highscore));
		}
		 }
		score.setText(st);
		restart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),MainActivity.class);
				startActivity(i);
			}
		});
        exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), Startpage.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("EXIT", true);
				startActivity(intent);
			}
		});
	}
@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
	Intent intent = new Intent(getApplicationContext(),Startpage.class);
    this.startActivity(intent);
    return;
}
}
