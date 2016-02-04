package com.xinghai.engine;
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

import com.xiyu.util.Array;
import com.xiyu.util.*;

//import flash.display.*;
//import flash.events.*;
//import flash.text.*;
import com.xinghai.init.*;

    public class PZGlobal extends Object
    {

        public static boolean DEBUG_MODE_TRACE =false ;
        private static String visiting ;
        public static String townName ;
        public static Array friendbar ;
        public static Object queryString ;
        public static int lastInputTick =0;
        public static boolean appActive =true ;
        public static Object mission =new Object ();
        public static String missionHostFirstName =null ;
        public static int pendingPresents =0;
        public static boolean autoPublishEnabled =false ;
        public static Object playAnimations =true ;
        public static Object flashHotParams =new Object ();
        public static boolean zmcOpenedOnInit =false ;
        public static boolean isTransitioningWorld =false ;

        public  PZGlobal ()
        {
            return;
        }//end

        public static void  setVisiting (String param1 )
        {
            PZGlobal.visiting = param1;
            return;
        }//end

        public static String  getVisiting ()
        {
            return PZGlobal.visiting;
        }//end

        public static boolean  isVisiting ()
        {
            return PZGlobal.visiting != null;
        }//end


        public static void  startTutorial ()
        {
            return;
        }//end

    }
