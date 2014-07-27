package com.example.basketnew;

import java.util.ArrayList;
import java.util.Random;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
   
public class ballview extends View {
   private int xMax;
   private int yMax;
   private int dropimgwidh1,dropimgwidh2;
   private int totalball=0,distyaxe;
   private int mX,i,j,t=1,s=1;
   private int cath=0,drop=0;
   int wimage,himage,flag=1,flag1=1;
   private Bitmap bitmap;
   private boolean isright;
   private float x=0,ballX = 0;  // Ball's center (x,y)
   private float y=0,ballY = 0;
   private Paint paint;           // The paint (e.g. style, color) used for drawing
   private Random rn=null;
   private int p=1,q=1;
  // Bitmap[] myStringArray = new Bitmap[7];
   ArrayList< Bitmap> arlist;
   private ProgressBar progresss;
   Resources res = getResources();
  
  
   // Constructor
   public ballview(Context context) {
      super(context);
      paint = new Paint();
      rn=new Random();
      arlist=new ArrayList<Bitmap>();
      progresss=new ProgressBar(getContext());
      bitmap = BitmapFactory.decodeResource(res, R.drawable.finalcartquickr);
      arlist.add(BitmapFactory.decodeResource(res, R.drawable.car));
	   arlist.add(BitmapFactory.decodeResource(res, R.drawable.inverter));
	   arlist.add(BitmapFactory.decodeResource(res, R.drawable.laptop));
	   arlist.add(BitmapFactory.decodeResource(res, R.drawable.dvd));
	   arlist.add(BitmapFactory.decodeResource(res, R.drawable.bike));
	   arlist.add(BitmapFactory.decodeResource(res, R.drawable.samsungmobile));
	   arlist.add(BitmapFactory.decodeResource(res, R.drawable.camera));
   }
   
   // Called back to draw the view. Also called by invalidate().
   @Override
   protected void onDraw(Canvas canvas) {
	   paint.setColor(Color.BLUE);
	   paint.setStrokeWidth(50);
	   paint.setTextSize(30);
	   canvas.drawText("Catch: "+Integer.toString(cath), 10.0f, 30.0f, paint);
	   canvas.drawText("Drop: "+Integer.toString(drop), xMax-100, 30.0f, paint);
	   //draw image
//	   Drawable draw=res.getDrawable(R.drawable.progrsbar);
//	// set the drawable as progress drawable
//	    progresss.setProgressDrawable(draw);
	  
	   
	   
	   
	    
	    wimage = bitmap.getWidth();
		himage=bitmap.getHeight();
	   canvas.drawBitmap(bitmap , mX,yMax-(himage+20), null);
	  
      // Draw the image
	   
	   if(ballY<(yMax/2) && flag==1)
	   {  
		   if(t==1)
		   {
			   distyaxe=yMax/70;
		      j=i=rn.nextInt(arlist.size());
		      dropimgwidh2=dropimgwidh1=arlist.get(i).getWidth();
		      t=0;
		   }
		   canvas.drawBitmap(arlist.get(i), ballX, ballY, null);
		   
		     x=(float)rn.nextInt(xMax-dropimgwidh1);
		     
	   }

	   else
	   {
		   flag=0;
		   
		   if(y<(yMax-(himage+20)))
		   {
			   
			   y=y+distyaxe;
			  
		   }
		   else if((x+dropimgwidh1)>mX && x<(mX+wimage) && y>=(yMax-(himage+20)) && y<=(yMax-20))
		   {
			   if(totalball==10)
				{
					   distyaxe++;
					totalball=0;
					
				}
				else
				{
					totalball++;
					
				}
			     if(i==0)
			     {
			        cath++;
			     if(cath==10)
			       {
					   
					   MainActivity a=(MainActivity)getContext();
						  a.res(cath);
			      }
			     }
			     else
			     {
			    	 drop++;
			    	 if(drop==5)
				       {
						   
						   MainActivity a=(MainActivity)getContext();
							  a.res(cath);
				      }
			     }
			     y=0; 
			     i=rn.nextInt(arlist.size());
			     dropimgwidh1=arlist.get(i).getWidth();
			     x=(float)rn.nextInt(xMax-dropimgwidh1);
			     
		   }
		   else if(y<yMax)
		   {
			   y=y+distyaxe;
		   }
		   else
		   {
			   if(totalball==10)
				{

					   distyaxe++;
					totalball=0;
					
				}
				else
				{
					totalball++;
					
				}

			   if(i==0)
			   {
			   drop++;
			   if(drop==5)
		       {
				   
				   MainActivity a=(MainActivity)getContext();
					  a.res(cath);
		      }
			   }
			   y=0; 
			   
			   i=rn.nextInt(arlist.size());
			   dropimgwidh1=arlist.get(i).getWidth();
			   x=(float)rn.nextInt(xMax-dropimgwidh1);
		   }

		         canvas.drawBitmap(arlist.get(j), ballX, ballY, null);
		         canvas.drawBitmap(arlist.get(i), x, y, null);
			     canvas.drawBitmap(bitmap , mX,yMax-(himage+20), null);
	   }
      

       // Update the position of the image, including collision detection and reaction.
      movecircle();
   
      invalidate();  // Force a re-draw
      
    
  
   }
   
   // Detect collision and update the position of the ball.
	public void movecircle()
	{
		if(this.isright)
		{
			
				   this.ballY=ballY+distyaxe;
			
		}
		else
		{
			this.ballY-=5;
		}
		if(this.ballY>=yMax)
		{
			if(totalball==10)
			{
				   distyaxe++;
				totalball=0;
				
			}
			else
			{
				totalball++;
			
			}
		    
			ballY=0;

            
        	j=rn.nextInt(arlist.size());
        	dropimgwidh2=arlist.get(j).getWidth();
			ballX=(float)rn.nextInt(xMax-dropimgwidh2);
			if(j==0)
			{
	            drop++;
			if(drop==5)
		       {
				 MainActivity a=(MainActivity)getContext();
				  a.res(cath);
		      }
			}
		}
		else if(this.ballY<=yMax)
		{
			isright=true;

			if((ballX+dropimgwidh2)>mX && ballX<(mX+wimage) && ballY>=(yMax-(himage+20)) && ballY<=(yMax-20))
			{
				if(totalball==10)
				{

					   distyaxe++;
					totalball=0;
					
					
				}
				else
				{
					totalball++;
					
				}
				if(j==0)
				{
				cath++;
				if(cath==10)
			       {
					   
					   MainActivity a=(MainActivity)getContext();
						  a.res(cath);
			      }
				}
				else
				{
					drop++;
					 if(drop==5)
				       {
						   
						   MainActivity a=(MainActivity)getContext();
							  a.res(cath);
				      }
				}
				ballY=0;
				j=rn.nextInt(arlist.size());
				dropimgwidh2=arlist.get(j).getWidth();
				ballX=(float)rn.nextInt(xMax-dropimgwidh2);
			}
		}
	}

// Called back when the view is first created or its size changes.
   @Override
   public void onSizeChanged(int w, int h, int oldW, int oldH) {
      // Set the movement bounds for the ball
      xMax = w-1;
      yMax = h-1;
   }
   @Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
	   switch (event.getAction()) {
	case MotionEvent.ACTION_MOVE:
	{
		mX = (int) event.getX();
		if(mX>(xMax-wimage))
		{
			mX=xMax-wimage;
		}
		invalidate();
		break;
	}
	default:
		break;
	}
	   
		return true;
	}

}