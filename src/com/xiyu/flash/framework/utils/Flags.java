package com.xiyu.flash.framework.utils;
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

    public class Flags {
        public void  clearFlags (int flags ){
            this.mFlags = (this.mFlags & ~(flags));
        }

        private int mFlags =0;

        public void  setFlags (int flags ){
            this.mFlags = (this.mFlags | flags);
        }
        public boolean  hasFlags (int testFlags ){
            return (!(((this.mFlags & testFlags) == 0)));
        }

    }
