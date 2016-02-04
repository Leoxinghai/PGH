package com.pgh.mahjong.view;
import android.view.View;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Canvas;

public class ProgressView extends View {
	private ShapeDrawable mDrawable;
	private int progress;
	ProgressDialog mProgressBar;

	
	public ProgressView(Context context) {
		super(context);
		int x = 40;
		int y = 200;
		progress = 50;
		int height = 50;
		
		mDrawable = new ShapeDrawable(new RectShape());
		mDrawable.getPaint().setColor(0xff74AC23);
		mDrawable.setBounds(x, y, x + progress * 3, y + height);

		mProgressBar = new ProgressDialog(context);
		mProgressBar.setCancelable(false);
		mProgressBar.setMessage("Loading");
		mProgressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		mProgressBar.setProgress(0);
		mProgressBar.setMax(100);
		mProgressBar.show();
		progress = 0;
		new Thread(new Runnable()
		{
			public void run() {
				while(progress < 100) {
					try {
						Thread.sleep(1000);
					} catch(InterruptedException ie) {
						ie.printStackTrace();
					}
					mProgressBar.setProgress(progress);
				}
				mProgressBar.dismiss();
			}
			
		}
	    ).start();
	}
	
	protected void onDraw(Canvas canvas) {
		mDrawable.draw(canvas);
	}
	
	public void setProgress(int _progress) {
		progress = _progress;
		if(_progress>=100) {
			mProgressBar.dismiss();
		}
	}
}
