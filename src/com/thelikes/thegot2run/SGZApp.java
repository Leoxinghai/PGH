package com.thelikes.thegot2run;

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

import com.thelikes.thegot2run.R;
import com.thelikes.thegot2run.SGZView;
import com.xiyu.util.*;
import com.xiyu.flash.framework.AppBase;
import com.xiyu.flash.games.pvz.logic.Board;
import com.xiyu.flash.games.pvz.logic.ChallengeScreen;
import com.xiyu.flash.framework.resources.foley.FoleyManager;
//import flash.display.Loader;
import com.xiyu.flash.framework.resources.particles.ParticleManager;
import com.xiyu.flash.framework.resources.foley.FoleyType;
import com.xiyu.flash.framework.resources.reanimator.Reanimator;
//import flash.utils.describeType;
import com.xiyu.flash.games.pvz.logic.SeedChooserScreen;
import com.xiyu.flash.games.pvz.logic.UI.UpsellScreen;
import com.xiyu.flash.games.pvz.states.loading.LoadingState;
import com.xiyu.flash.games.pvz.states.loading.TitleScreenState;
import com.xiyu.flash.games.pvz.states.mainmenu.MainMenuState;
import com.xiyu.flash.games.pvz.states.playing.LevelIntroState;
import com.xiyu.flash.games.pvz.states.playing.LawnViewState;
import com.xiyu.flash.games.pvz.states.playing.PanLeftState;
import com.xiyu.flash.games.pvz.states.playing.PanRightState;
import com.xiyu.flash.games.pvz.states.playing.ChooseSeedsState;
import com.xiyu.flash.games.pvz.states.playing.ReadySetStartState;
import com.xiyu.flash.games.pvz.states.playing.SlideUIState;
import com.xiyu.flash.games.pvz.states.playing.StartLevelState;
import com.xiyu.flash.games.pvz.states.playing.SodRollState;
import com.xiyu.flash.games.pvz.states.playing.ShowAwardState;
import com.xiyu.flash.games.pvz.states.playing.ZombiesWonState;
import com.xiyu.flash.games.pvz.states.playing.CrazyDaveState;
import com.xiyu.flash.games.pvz.states.playing.SurvivalRepickState;
import com.xiyu.flash.games.pvz.states.playing.OptionsMenuState;
import com.xiyu.flash.games.pvz.states.playing.ChallengeScreenState;
import com.xiyu.flash.games.pvz.states.playing.DialogState;
import com.xiyu.flash.games.pvz.states.playing.PlayLevelState;
import com.xiyu.flash.games.pvz.states.playing.UpsellScreenState;
import com.xiyu.flash.games.pvz.states.playing.PauseState;
import com.xiyu.flash.games.pvz.logic.UI.OptionsDialog;
import com.xiyu.flash.games.pvz.logic.UI.DialogBox;
import com.xiyu.flash.games.pvz.logic.AwardScreen;


    public class SGZApp extends Activity {

        public static  String STATE_PAUSE_SCREEN ="PauseScreen";
        public static  String STATE_RESUME_FROM_PAUSE ="ResumeFromPause";
        public static final int GAMEMODE_SURVIVAL_ENDLESS_STAGE_2 =1;
        public static  String STATE_SLIDE_UI ="SlideUI";
        public static final int BACKGROUND_IMAGE_WIDTH =945;
        public static  String STATE_SHOWAWARD ="ShowAward";
        public static final int BOARDRESULT_RESTART =3;
        public static  String STATE_SODROLL ="SodRoll";
        public static  String APP_ID ="pvz";
        public static  String STATE_PLAY_LEVEL ="PlayLevel";
        public static final int SCENE_CREDIT =6;
        public static  String STATE_UPSELL_SCREEN ="UpsellScreen";
        public static final int GAMEMODE_SURVIVAL_NORMAL_STAGE_3 =3;
        public static final int GAMEMODE_SURVIVAL_NORMAL_STAGE_5 =5;
        public static  String STATE_SURVIVAL_REPICK ="SurvivalRepick";
        public static final int SCENE_CHALLENGE =7;
        public static final int GAMEMODE_SURVIVAL_NORMAL_STAGE_4 =4;
        public static final int SCENE_PLAYING =3;
        public static final int GAMEMODE_SURVIVAL_NORMAL_STAGE_2 =17;
        public static final int BOARD_OFFSET =148;
        public static final int SCENE_LOADING =0;
        public static  String STATE_LOADING ="Loading";
        public static final int SCENE_MENU =1;
        public static  String STATE_ZOMBIES_WON ="ZombiesWon";
        public static final int GAMEMODE_UPSELL =7;
        public static  String STATE_START_LEVEL ="StartLevel";
        public static  String STATE_TITLE_SCREEN ="TitleScreen";
        public static final int SCENE_LEVEL_INTRO =2;
        public static  String STATE_PAN_RIGHT ="PanRight";
        public static final int BOARDRESULT_QUIT_APP =5;
        public static  String STATE_READY_SET_START ="ReadySetStart";
        public static final int BOARDRESULT_LOST =2;
        public static  String STATE_CRAZY_DAVE ="CrazyDave";
        public static  String STATE_OPTIONS_MENU ="OptionsMenu";
        public static final int BOARDRESULT_NONE =0;
        public static  String STATE_PAN_LEFT ="PanLeft";
        public static final int BOARDRESULT_WON =1;
        public static final int GAMEMODE_CHALLENGE_WALLNUT_BOWLING =6;
        public static  String STATE_LAWN_VIEW ="LawnView";
        public static final int BOARDRESULT_QUIT =4;
        public static final int SCENE_CRAZY_DAVE =8;
        public static final int GAMEMODE_SCARY_POTTER_1 =8;
        public static final int GAMEMODE_SCARY_POTTER_2 =9;
        public static final int SCENE_AWARD =5;
        public static final int GAMEMODE_SCARY_POTTER_6 =13;
        public static final int GAMEMODE_SCARY_POTTER_8 =15;
        public static final int GAMEMODE_SCARY_POTTER_9 =16;
        public static final int GAMEMODE_SCARY_POTTER_3 =10;
        public static final int GAMEMODE_SCARY_POTTER_4 =11;
        public static final int GAMEMODE_SCARY_POTTER_5 =12;
        public static  String STATE_SEEDCHOOSER ="SeedChooser";
        public static final int GAMEMODE_SCARY_POTTER_7 =14;
        public static  String STATE_DIALOG_BOX ="DialogBox";
        public static final int GAMEMODE_ADVENTURE =0;
        public static final int SCENE_ZOMBIES_WON =4;
        public static final int GAMEMODE_SCARY_POTTER_ENDLESS =2;
        public static  String STATE_MAIN_MENU ="MainMenu";
        public static final int BOARDRESULT_CHEAT =6;
        public static  String STATE_LEVEL_INTRO ="LevelIntro";
        public static  String STATE_CHALLENGE_SCREEN ="ChallengeScreen";

		public static  String STATE_ANIMATEEDITOR_SCREEN ="AnimateEditor";


		public Board mBoard ;
        public ChallengeScreen mChallengeScreen ;
        private FoleyManager mFoleyManager ;


        public int mCutsceneTime ;
        public int mSurvivalFlags ;
//        private Loader mResourceLoader ;

        public FoleyManager  foleyManager (){
            return (this.mFoleyManager);
        }

        private ParticleManager mParticleManager ;
        public int mLevel ;


        public boolean mSoundOn ;
        public boolean mPlacedZombies =false ;
        public int mMaxTime ;
        public SeedChooserScreen mSeedChooserScreen ;

        public boolean  IsSurvivalEndless (){
            if (this.mGameMode == GAMEMODE_SURVIVAL_ENDLESS_STAGE_2)
            {
                return (true);
            };
            return (false);
        }
        public boolean  IsAdventureMode (){
            if (this.mGameMode == GAMEMODE_ADVENTURE)
            {
                return (true);
            };
            return (false);
        }

        public Reanimator  reanimator (){
            return (this.mReanimator);
        }

        public boolean mSurvivalLocked ;
        public boolean mMusicOn ;
        public boolean mUpsellOn ;

        public boolean  IsScaryPotterLevel (){
            if (this.mGameMode == GAMEMODE_SCARY_POTTER_ENDLESS)
            {
                return (true);
            };
            return (false);
        }

        public int mGameMode ;
        public UpsellScreen mUpsellScreen ;
        public int mGamesPlayed ;
        public int mSodTime ;
        public int mMaxPlays ;
        public int mTotalZombiesKilled =0;
        public String mUpsellLink ;

        public ParticleManager  particleManager (){
            return (this.mParticleManager);
        }


        private Reanimator mReanimator ;
        public Object mSaveObject ;

        public boolean  IsSurvivalMode (){
            if (this.mGameMode == GAMEMODE_SURVIVAL_ENDLESS_STAGE_2)
            {
                return (true);
            };
            return (false);
        }

        public OptionsDialog mOptionsMenu ;
        public boolean mPuzzleLocked ;
        public DialogBox mDialogBox ;
//        public MSNAdAPI adAPI ;
        public int mMaxExecutions ;
        public boolean mShowedCrazyDaveVasebreaker ;
        public AwardScreen mAwardScreen ;
        public int mBoardResult ;

    	protected void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		//for no title
    		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    		SGZView Title  =new SGZView(this);
    		
//    		setContentView(new CrazyDaveState(this));
    		setContentView(Title);
    		
//    		ParseXML parse = new ParseXML(sgzview);
//    	  	parse.doIt();
    		
    	}

    	@Override
    	public boolean onCreateOptionsMenu(Menu menu) {
    		// Inflate the menu; this adds items to the action bar if it is present.
    		getMenuInflater().inflate(R.menu.main, menu);
   
    		return true;
    	}

    	public  SGZApp (){
            super();
//            this.mResourceLoader = new Loader();
        }
    }
