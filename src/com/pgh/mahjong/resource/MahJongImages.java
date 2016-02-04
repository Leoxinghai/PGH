package com.pgh.mahjong.resource;

import java.io.IOException;

import com.thelikes.thegot2run.R;
import com.xiyu.util.BitmapData;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Hashtable;
import java.util.zip.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

//import com.pgh.mahjong.view.ProgressView;
import android.os.AsyncTask;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MahJongImages { 
	private static MahJongImages inst = null;
	private static String wanzi[] = {"1wan","2wan","3wan","4wan","5wan","6wan","7wan","8wan","9wan"};
	private static String tiaozi[] = {"1tiao","2tiao","3tiao","4tiao","5tiao","6tiao","7tiao","8tiao","9tiao"};
	private static String tongzi[] = {"1tong","2tong","3tong","4tong","5tong","6tong","7tong","8tong","9tong"};
	private static String zipan[] = {"dong","nan","xi","bei","zhong","fa","ban"};
	private static String huapan[] = {"chun","xia","qiu","dongtian","mei","lai","zhu","ju"};
	
	private static Bitmap wanziImages[];
	private static Bitmap tiaoziImages[];
	private static Bitmap tongziImages[];
	private static Bitmap zipanImages[];
	private static Bitmap huapanImages[];
	private static Bitmap masterImages[];
	private static Hashtable refs;
	
	private static Hashtable gameImages;
	private static AsyncTask mAsyncTask;
	
	private MahJongImages(AssetManager am) {
		
	}
	
	public static void loadMahJongImages(AssetManager am, MahJongProgress mjProgress) {
		wanziImages = new Bitmap[9];
		zipanImages = new Bitmap[7];
		huapanImages = new Bitmap[8]; 
		tongziImages = new Bitmap[9];
		tiaoziImages = new Bitmap[9];
		masterImages = new Bitmap[2];
		int xCoord = 0;
		int yCoord = 0;
		int chunkHeight = 90;
		int chunkWidth = 58;
		
		refs = new Hashtable();
		gameImages = new Hashtable();
		
		try {
			Bitmap bitmap = BitmapFactory.decodeStream(am.open("MBBS_1.png"));
			
			int i = 0;
        	yCoord = 0;
			for(;i<8;i++) {
			
    			Bitmap tmpBitmap = Bitmap.createBitmap(bitmap,xCoord + 1,yCoord+2,chunkWidth-1,chunkHeight-1);
    			xCoord +=chunkWidth;
    			wanziImages[i] = tmpBitmap;
			}
			//mjProgress.updateMJProgress(20);
        	yCoord += chunkHeight;
        	xCoord = 0;
			for(i = 0;i<8;i++) {
			
				Bitmap tmpBitmap = Bitmap.createBitmap(bitmap,xCoord + 1,yCoord + 2,chunkWidth-1,chunkHeight-1);
    			xCoord +=chunkWidth;
    			if(i < 1)
    				wanziImages[8] = tmpBitmap;
    			else {
    				tiaoziImages[i-1] = tmpBitmap;
    			}
			}
			//mjProgress.updateMJProgress(30);
			
        	yCoord += chunkHeight;
        	xCoord = 0;
			for(i = 0;i<8;i++) {
			
				Bitmap tmpBitmap = Bitmap.createBitmap(bitmap,xCoord + 1,yCoord+2,chunkWidth-1,chunkHeight-1);
    			xCoord +=chunkWidth;
    			if(i < 2)
    				tiaoziImages[i + 7] = tmpBitmap;
    			else {
    				tongziImages[i-2] = tmpBitmap;
    			}
			}
			
			//mjProgress.updateMJProgress(40);
        	yCoord += chunkHeight;
        	xCoord = 0;
			for(i = 0;i<8;i++) {
			
				Bitmap tmpBitmap = Bitmap.createBitmap(bitmap,xCoord,yCoord+2,chunkWidth-1,chunkHeight-1);
    			xCoord +=chunkWidth;
    			if(i < 3)
    				tongziImages[i + 6] = tmpBitmap;
    			else {
    				zipanImages[i-3] = tmpBitmap;
    			}
			}
			
			//mjProgress.updateMJProgress(50);
        	yCoord += chunkHeight;
        	xCoord = 0;
			for(i = 0;i<8;i++) {
			
				Bitmap tmpBitmap = Bitmap.createBitmap(bitmap,xCoord + 1,yCoord+2,chunkWidth-1,chunkHeight-1);
    			xCoord +=chunkWidth;
    			if(i < 2)
    				zipanImages[i + 5] = tmpBitmap;
    			else {
    				huapanImages[i-2] = tmpBitmap;
    			}
			}
			
			//mjProgress.updateMJProgress(60);
        	yCoord += chunkHeight;
        	xCoord = 0;
			for(i = 0;i<2;i++) {
			
				Bitmap tmpBitmap = Bitmap.createBitmap(bitmap,xCoord + 1,yCoord+2,chunkWidth-1,chunkHeight-1);
    			xCoord +=chunkWidth;
				huapanImages[i+6] = tmpBitmap;
			}

			//mjProgress.updateMJProgress(70);
        	yCoord += chunkHeight;
        	xCoord = 0;
			for(i = 0;i<2;i++) {
			
				Bitmap tmpBitmap = Bitmap.createBitmap(bitmap,xCoord + 1,yCoord+3,chunkWidth-1,chunkHeight-1);
    			xCoord +=chunkWidth;
				masterImages[i] = tmpBitmap;
			}
			
			mjProgress.updateMJProgress(20);
			int j =0;
			for(i=0;i<wanzi.length;i++) {
				refs.put(wanzi[i].toUpperCase(), j);
				j++;
			}
			
			for(i=0;i<tiaozi.length;i++) {
				refs.put(tiaozi[i].toUpperCase(), j);
				j++;
			}
			for(i=0;i<tongzi.length;i++) {
				refs.put(tongzi[i].toUpperCase(), j);
				j++;
			}

			for(i=0;i<zipan.length;i++) {
				refs.put(zipan[i].toUpperCase(), j);
				j++;
			}
			for(i=0;i<huapan.length;i++) {
				refs.put(huapan[i].toUpperCase(), j);
				j++;
			}
			
			//mjProgress.updateMJProgress(90);
			loadGameImages(am, mjProgress);
			mjProgress.updateMJProgress(100);
		} catch(IOException iex) {
			iex.printStackTrace();
		}
	}
	
	  
	public static void loadGameImages(AssetManager am,MahJongProgress mjProgress) {
		
		try {
			InputStream is = am.open("images.zip");
			ZipInputStream zis = new ZipInputStream(is);

			ZipEntry ze = zis.getNextEntry();
			int i = 0;
			while(ze != null) {
				Bitmap result = BitmapFactory.decodeStream(zis);
				String name = ze.getName().toUpperCase();
				int offset = name.lastIndexOf('.');
				name = name.substring(0,offset);
				gameImages.put(name, result);
				i++;
				mjProgress.updateMJProgress(20+i/100);
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
			zis.close();
			is.close();
					
		} catch(IOException iex) {
			iex.printStackTrace();
		}
	}
	
	public static Bitmap getGameImage(String id) {
		return (Bitmap)gameImages.get(id);
	}
	
	
	public static Bitmap getMahJongImage(String id) {
		Bitmap bitmap = null;
		int i = ((Integer)refs.get(id)).intValue();
		if(i<9) {
			bitmap = (Bitmap)wanziImages[i];
		} else if( i>=9 && i < 18) {
			bitmap = (Bitmap)tiaoziImages[i-9];
		} else if( i>=18 && i < 27) {
			bitmap = (Bitmap)tongziImages[i-18];
		} else if( i>=27 && i < 34) {
			bitmap = (Bitmap)zipanImages[i-27];
		} else if( i>=34 && i < 42) {
			bitmap = (Bitmap)huapanImages[i-34];
		}
		if(bitmap == null) {
			System.out.println("getMahJongImage."+id);
		}
		
		Bitmap result = Bitmap.createBitmap(masterImages[0].getWidth(),masterImages[0].getHeight(),Bitmap.Config.ARGB_8888);
		Canvas comboImage = new Canvas(result);
		
		comboImage.drawBitmap(masterImages[0], 0, 0, null);
		
		comboImage.drawBitmap(bitmap, 0, 0, null);
		
		return result;
	}

	public static Bitmap getMahJongMaskImage(String id) {
		Bitmap bitmap = null;
		int i = ((Integer)refs.get(id)).intValue();
		if(i<9) {
			bitmap = (Bitmap)wanziImages[i];
		} else if( i>=9 && i < 18) {
			bitmap = (Bitmap)tiaoziImages[i-9];
		} else if( i>=18 && i < 27) {
			bitmap = (Bitmap)tongziImages[i-18];
		} else if( i>=27 && i < 34) {
			bitmap = (Bitmap)zipanImages[i-27];
		} else if( i>=34 && i < 42) {
			bitmap = (Bitmap)huapanImages[i-34];
		}
		
		Bitmap result = Bitmap.createBitmap(masterImages[0].getWidth(),masterImages[0].getHeight(),Bitmap.Config.ARGB_8888);
		Canvas comboImage = new Canvas(result);
		
		comboImage.drawBitmap(masterImages[1], 0, 0, null);
		
		//comboImage.drawBitmap(bitmap, 0, 0, null);
		
		return result;
	}

	
	public static MahJongImages getInstance(AssetManager am, AsyncTask _mAsyncTask) {
		mAsyncTask = _mAsyncTask;
		if(inst == null) {
			inst = new MahJongImages(am);
		}
		return inst;
	}
	
	
	
}
