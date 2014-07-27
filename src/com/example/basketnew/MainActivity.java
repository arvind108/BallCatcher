package com.example.basketnew;

import java.security.PublicKey;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
  
public class MainActivity extends Activity {
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
     
     this.requestWindowFeature(Window.FEATURE_NO_TITLE);
      setContentView(R.layout.main_screen);
      Ballview bouncingBallView = (Ballview) findViewById(R.id.ballview);
      
      bouncingBallView.setBackgroundColor(Color.BLACK);
      bouncingBallView.setBackgroundResource(R.drawable.bg1);
   
  
   }
   public void res(int catc)
   {
   Intent i=new Intent(getApplicationContext(),endpage.class);
   i.putExtra("b", Integer.toString(catc));
   startActivity(i);
   }
}