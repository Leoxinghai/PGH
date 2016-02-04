package com.thelikes.thegot2run;

import java.nio.ByteBuffer;

import org.xmlpull.v1.XmlPullParser;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
//import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.graphics.*;
import android.content.res.*;
import android.util.Xml;

import com.xiyu.flash.framework.resources.reanimator.*;

public class ParseXML {
	private SGZView sgzview;
	private XmlResourceParser parser;
	private String result = "";
	public ParseXML(SGZView _sgzview) {
		sgzview = _sgzview;
	}
	
	public void doIt() {
	  	  parser= sgzview.getResources().getXml(R.xml.blover);
/*	  	  
	  	  try {
	  		XMLReanimDescriptor xmlDesc = new XMLReanimDescriptor(sgzview, parser);
	  		ReanimDefinition zombie = xmlDesc.createReanimData(null);
	  		result += zombie.numTracks;
	  		result += ";";
	  		result += zombie.tracks.length();
	  	  } catch(Exception iex) {
		  		result += iex.toString();
	  	  }
*/	  	  
	  	  
//	  	  sgzview.xmlStr = result;
	}
	
	
}
