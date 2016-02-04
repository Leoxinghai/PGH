package com.thelikes.thegot2run;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
 

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.thelikes.thegot2run.R;
import com.pgh.mahjong.resource.MahJongImages;
import com.pgh.mahjong.resource.MahJongProgress;
import android.content.res.AssetManager;
import android.content.Intent;
import com.xiyu.flash.games.pvz.PVZApp;

public class MainActivity extends Activity implements OnClickListener{
 
 private ProgressBar progressBar1;
 private ProgressBar progressBar2;
 private String filepath = "MyFileStorage";
 private File directory;
 private TextView finished;
 private AssetManager mAM;
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAM = this.getAssets();
        
        setContentView(R.layout.activity_main);
         
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        directory = contextWrapper.getDir(filepath, Context.MODE_PRIVATE);
   
        progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar1.setVisibility(View.GONE);
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar2.setVisibility(View.GONE);
        finished = (TextView) findViewById(R.id.textView1);
        finished.setVisibility(View.GONE);
         
        Button start = (Button) findViewById(R.id.start);
		  start.setOnClickListener(this);
		  Button stop = (Button) findViewById(R.id.stop);
		  stop.setOnClickListener(this);
		  Button download = (Button) findViewById(R.id.download);
		  download.setOnClickListener(this);

	         String url = "http://upload.wikimedia.org/wikipedia/commons/0/05/Sna_large.png";
	         grabURL(url);
		  
    }
     
    public void onClick(View v) {
		 
		  switch (v.getId()) {
		  case R.id.start:
		         progressBar1.setVisibility(View.VISIBLE);
		   break;
		    
		  case R.id.stop:
				Intent i=new Intent(this,PVZApp.class);
				startActivity(i);
		         
		   break;
		    
		  case R.id.download:
		         String url = "http://upload.wikimedia.org/wikipedia/commons/0/05/Sna_large.png";
		         grabURL(url);
		         break; 
		    
		   // More buttons go here (if any) ...
		 
		  }
    }
    
    
   public void grabURL(String url) {
	   new GrabURL().execute(url);
   }
 
private class GrabURL extends AsyncTask<String, Integer, String> implements MahJongProgress {
  
  
   protected void onPreExecute() {
        progressBar2.setVisibility(View.VISIBLE);
        progressBar2.setProgress(0);
        finished.setVisibility(View.GONE);
         
    }

 protected String doInBackground(String... urls) {
		String filename = "MySampleFile.png";
		//finished.setVisibility(View.VISIBLE);
  		try {
  			MahJongImages.loadMahJongImages(mAM, this);
        } catch (Exception e) {
         e.printStackTrace();
        }

  		return filename;
   
 }
 
 public void updateMJProgress(int progress) {
	  //finished.setVisibility(View.VISIBLE);
	  //finished.setText(String.valueOf(progress) + "%");
	  progressBar2.setProgress(progress);
 }

 protected void onProgressUpdate(Integer... progress) {
  finished.setVisibility(View.VISIBLE);
  finished.setText(String.valueOf(progress[0]) + "%");
  progressBar2.setProgress(progress[0]);
    }
  
 protected void onCancelled() {
  Toast toast = Toast.makeText(getBaseContext(), 
    "Error connecting to Server", Toast.LENGTH_LONG);
  toast.setGravity(Gravity.TOP, 25, 400);
  toast.show();
 }

 protected void onPostExecute(String filename) {
  progressBar2.setProgress(100);
  finished.setVisibility(View.VISIBLE);
  finished.setText("Finished downloading...");

	Intent i=new Intent(MainActivity.this, PVZApp.class);
	startActivity(i);
  
  //File myFile = new File(directory , filename);
  //ImageView myImage = (ImageView) findViewById(R.id.imageView1);
  //myImage.setImageBitmap(BitmapFactory.decodeFile(myFile.getAbsolutePath()));
 }

}

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
       //getMenuInflater().inflate(R.menu.activity_main, menu);
       return true;
   }
}