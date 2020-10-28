package com.nhl;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.*;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import android.icu.text.DateFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.AlignmentSpan;
import android.util.DisplayMetrics;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
import org.jsoup.helper.Validate;

import java.sql.Array;
import java.util.*;
import java.util.concurrent.*;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final long START_DELAY = 0;
    private static final int DURATION_NEXT_VIEW_FACTOR = 200 ;
    private static final int DURATION_INITIAL = 200 ;
    private static final float INTERPOLATOR_FACTOR = 5 ;
    public static String URLmain="http://nhl.ru/index.php?action=shedul&op=byteam&id=";
    public static String URL;
    private boolean animated = false;
    public static String FavTeam;
    public static String FavTeamP;
    public static TextView mTextMessage;
    private     ImageView teamlogo;
    public static TextView date1,date2,date3,date4,date5,date6;
    public static TextView homet1,homet2,homet3,homet4,homet5,homet6;
    public static TextView homet7,homet8,homet9,homet10,homet11,homet12,homet13,homet14,homet15;
    public static TextView date7,date8,date9,date10,date11,date12,date13,date14,date15;
    public static TextView time1,time2,time3,time4,time5,time6,today;
    public static TextView time7,time8,time9,time10,time11,time12,time13,time14,time15;
    public static TableLayout table;
    private int month,year,day;
    public static TableRow row1,row2,row3,row4,row5,row6;
    public static TableRow row7,row8,row9,row10,row11,row12,row13,row14,row15;
    public static ImageView alert1,alert2,alert3,alert4,alert5,alert6;
    public static ImageView remall,addall,info,results,settings;
    public static ImageView alert7,alert8,alert9,alert10,alert11,alert12,alert13,alert14,alert15;
    private Handler mUiHandler = new Handler();
    public static ArrayList<String> teamsid = new ArrayList<String>();
    public static ArrayList<String> onEng = new ArrayList<String>();
    public static ArrayList<String> onRus = new ArrayList<String>();
    public static ArrayList<String> remindlist = new ArrayList<String>();
    public static Button Buttonexit;
    public static Button Buttonlist;
    public static boolean state=true;
    public static String stat1;
    public static String stat2;
    public static String stat3;
    public static String stat4;
    public static String stat5;
    public static String stat6;
    public static String stat7;
    public static String stat8;
    public static String stat9;
    public static String stat10;
    public static String stat11;
    public static String stat12;
    public static String stat13;
    public static String stat14;
    public static String stat15;
    public static boolean ToRemind1,ToRemind2,ToRemind3,ToRemind4,ToRemind5,ToRemind6,ToRemind7,ToRemind8,ToRemind9,ToRemind10,ToRemind11,ToRemind12,ToRemind13,ToRemind14,ToRemind15;
    public static ArrayList<String[]> alarmlist = new ArrayList<String[]>();
    public static ArrayList<String[]> AlarmsBigList = new ArrayList<String[]>();
    public static ArrayList<String[]> AlarmsBigList2 = new ArrayList<String[]>();

    public static ArrayList alarms = new ArrayList<String>();
    public static int CountfromSaveAlarms;
    public static int CountfromBigList;
    public static int CountfromHashList;

    public static ArrayList<String> textboofer= new ArrayList<String>();
    public static HashSet<String[]> AlarmsBigSet = new HashSet<String[]>();

    public static boolean color1=false;
    public static boolean color2=false;
    public static boolean color3=false;
    public static boolean color4=false;
    public static boolean color5=false;
    public static boolean color6=false;
    public static boolean color7=false;
    public static boolean color8=false;
    public static boolean color9=false;
    public static boolean color10=false;
    public static boolean color11=false;
    public static boolean color12=false;
    public static boolean color13=false;
    public static boolean color14=false;
    public static boolean color15=false;
    private HorizontalCalendar horizontalCalendar;
    public static int newmonth;
    public static boolean alertpresses1,alertpresses2,alertpresses3,alertpresses4,alertpresses5,alertpresses6,alertpresses7;
    public static boolean alertpresses8,alertpresses9,alertpresses10,alertpresses11,alertpresses12,alertpresses13,alertpresses14,alertpresses15;
    public static ArrayList<Integer> scoreshome = new ArrayList<Integer>();
    public static ArrayList<Integer> scoresguest = new ArrayList<Integer>();
    public static ScrollView scroll1;
    public static boolean changemonth;
    private PopupWindow POPUP_WINDOW_SCORE = null;
    public static String winlost="";
    public static String position="";
    public static String points="";
    public static String strk="";
    ProgressBar loading;
    public static String age="";
    public static String positiononice="";
    public static String height1="";
    public static String weight="";
    public static String country="";
    public static String team="";
    public static String GP="";
    public static String G="";
    public static String A="";
    public static String P="";
    public static String plusminus="";
    public static String playername="";
    public static String saveprocent="";

    public static CharSequence query1;
    public ArrayList<String> result1;
    Date dateN1 = null;
    Date dateN2 = null;
    Date dateN3 = null;
    Date dateN4 = null;
    Date dateN5 = null;
    Date dateN6 = null;
    Date dateN7 = null;
    Date dateN8 = null;
    Date dateN9 = null;
    Date dateN10 = null;
    Date dateN11 = null;
    Date dateN12 = null;
    Date dateN13 = null;
    Date dateN14 = null;
    Date dateN15 = null;
    String[] string = new String[7];
    public static ImageView	homeornot1;
    public static ImageView	homeornot2;
    public static ImageView	homeornot3;
    public static ImageView	homeornot4;
    public static ImageView	homeornot5;
    public static ImageView	homeornot6;
    public static ImageView	homeornot7;
    public static ImageView	homeornot8;
    public static ImageView	homeornot9;
    public static ImageView	homeornot10;
    public static ImageView	homeornot11;
    public static ImageView	homeornot12;
    public static ImageView	homeornot13;
    public static ImageView	homeornot14;
    public static ImageView	homeornot15;
    //public Toolbar toolbar;
    private DrawerLayout drawer;
    public static boolean sw=true;
    public static boolean rB1=false;
    public static boolean rB2=false;
    public static boolean rB3=false;
    public static boolean rB4=false;


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus && !animated) {
            startSlideInAnimation();
            animated = true;
        }
    }

    public void ShowPopupPlayer()

    {
         System.out.println("marker1");
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        // Inflate the popup_layout.xml
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.popup_window2, null);
        System.out.println("marker2");

        // Creating the PopupWindow
        POPUP_WINDOW_SCORE = new PopupWindow(this);
        POPUP_WINDOW_SCORE.setContentView(layout);
        POPUP_WINDOW_SCORE.setWidth(width);
        POPUP_WINDOW_SCORE.setHeight(height);
        POPUP_WINDOW_SCORE.setFocusable(true);

        // prevent clickable background
        POPUP_WINDOW_SCORE.setBackgroundDrawable(null);

        POPUP_WINDOW_SCORE.showAtLocation(layout, Gravity.CENTER, 1, 1);
        System.out.println("marker3");

        TextView txtPlayerName = (TextView) layout.findViewById(R.id.textView3);
        TextView txtage = (TextView) layout.findViewById(R.id.textView4);
        TextView txtPosition = (TextView) layout.findViewById(R.id.textView5);
        TextView txtheight = (TextView) layout.findViewById(R.id.textView6);
        TextView txtweight = (TextView) layout.findViewById(R.id.textView7);
        TextView txtcountry = (TextView) layout.findViewById(R.id.textView8);
        TextView txtteam = (TextView) layout.findViewById(R.id.textView9);
        TextView txtGP = (TextView) layout.findViewById(R.id.textView17);
        TextView txtG = (TextView) layout.findViewById(R.id.textView18);
        TextView txtA = (TextView) layout.findViewById(R.id.textView19);
        TextView txtP = (TextView) layout.findViewById(R.id.textView20);
        TextView txtplusminus = (TextView) layout.findViewById(R.id.textView21);
        TextView svprocent = (TextView) layout.findViewById(R.id.textView22);

        System.out.println("marker4");

        ImageView teamimage = (ImageView) layout.findViewById(R.id.imageView37);
        ImageView nationimage = (ImageView) layout.findViewById(R.id.imageView2);

        txtPlayerName.setText(playername);
        System.out.println("marker5");

        txtage.setText(age);
        System.out.println("marker6");

        txtPosition.setText(positiononice);
        txtheight.setText(height1);
        txtweight.setText(weight);
        txtcountry.setText(country);
        txtteam.setText(team);
        svprocent.setText(saveprocent);
        System.out.println("marker7");

        txtGP.setText(GP);
        txtG.setText(G);
        txtA .setText(A);
        txtP .setText(P);
        txtplusminus.setText(plusminus);

        teamimage.setImageResource(new Methods().GetLogo(getApplicationContext(),team));

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                POPUP_WINDOW_SCORE.dismiss();
                return false;
            }
        });
        // Getting a reference to button one and do something


        // Getting a reference to button two and do something
    }

    public void ShowPopupSettings()

    {
        System.out.println("marker1");
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        TinyDB tinydb = new TinyDB(getApplicationContext());
        sw=true;
        sw=tinydb.getBoolean("sw");
        rB1=tinydb.getBoolean("rB1");
        rB2=tinydb.getBoolean("rB2");
        rB3=tinydb.getBoolean("rB3");
        rB4=tinydb.getBoolean("rB4");


        // Inflate the popup_layout.xml
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.popup_window_settings, null);
        System.out.println("marker2");

        // Creating the PopupWindow
        POPUP_WINDOW_SCORE = new PopupWindow(this);
        POPUP_WINDOW_SCORE.setContentView(layout);
        POPUP_WINDOW_SCORE.setWidth(width);
        POPUP_WINDOW_SCORE.setHeight(height);
        POPUP_WINDOW_SCORE.setFocusable(true);

        // prevent clickable background
        POPUP_WINDOW_SCORE.setBackgroundDrawable(null);

        POPUP_WINDOW_SCORE.showAtLocation(layout, Gravity.CENTER, 1, 1);
        Switch switch1 = (Switch) layout.findViewById(R.id.switch1);
        RadioButton rb1 = (RadioButton) layout.findViewById(R.id.radioButton);
        RadioButton rb2 = (RadioButton) layout.findViewById(R.id.radioButton2);
        RadioButton rb3 = (RadioButton) layout.findViewById(R.id.radioButton3);
        RadioButton rb4 = (RadioButton) layout.findViewById(R.id.radioButton4);
        Button okbutton = (Button) layout.findViewById(R.id.button4);
       Button canbutton = (Button) layout.findViewById(R.id.button6);


        if (sw) switch1.setChecked(sw);
        if (!sw) switch1.setChecked(sw);



        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               // POPUP_WINDOW_SCORE.dismiss();
                return false;
            }
        });
        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sw=switch1.isChecked();
                tinydb.putBoolean("sw",sw);
                POPUP_WINDOW_SCORE.dismiss();
            }
        });
        canbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                POPUP_WINDOW_SCORE.dismiss();
            }
        });// Getting a reference to button one and do something


        // Getting a reference to button two and do something
    }

    private boolean isNetworkReachable(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return  isConnected;
    }

    public void ShowPopup()

    {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        // Inflate the popup_layout.xml
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.popup_window, null);

        // Creating the PopupWindow
        POPUP_WINDOW_SCORE = new PopupWindow(this);
        POPUP_WINDOW_SCORE.setContentView(layout);
        POPUP_WINDOW_SCORE.setWidth(width);
        POPUP_WINDOW_SCORE.setHeight(height);
        POPUP_WINDOW_SCORE.setFocusable(true);

        // prevent clickable background
        POPUP_WINDOW_SCORE.setBackgroundDrawable(null);

        POPUP_WINDOW_SCORE.showAtLocation(layout, Gravity.CENTER, 1, 1);

        TextView txtMessage = (TextView) layout.findViewById(R.id.layout_popup_txtMessage);
        TextView txtMessage2 = (TextView) layout.findViewById(R.id.layout_popup_txtMessage2);
        ImageView image = (ImageView) layout.findViewById(R.id.imageView3);
        TextView txtMessage3 = (TextView) layout.findViewById(R.id.layout_popup_txtMessage3);
        TextView txtMessage4 = (TextView) layout.findViewById(R.id.layout_popup_txtMessage4);

        txtMessage.setText(winlost);
        txtMessage2.setText(position);
        txtMessage3.setText(points);
        txtMessage4.setText(strk);
        image.setImageDrawable(teamlogo.getDrawable());

        txtMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                POPUP_WINDOW_SCORE.dismiss();
                return false;
            }
        });
        // Getting a reference to button one and do something


        // Getting a reference to button two and do something
    }

    private void startSlideInAnimation() {
        ViewGroup windowRoot = (ViewGroup) findViewById(android.R.id.content);
        ViewGroup contentRoot = (ViewGroup) windowRoot.getChildAt(0);

        for (int i = 0; i < contentRoot.getChildCount(); i++) {
            View v = contentRoot.getChildAt(i);

            animateSingleView(windowRoot, i, v);
        }
    }

    private void animateSingleView(ViewGroup windowRoot, int viewPosition, View view) {
        view.setTranslationY(windowRoot.getHeight());
        view.setAlpha(0);

        view.animate()
                .translationY(0)
                .alpha(1)
                .setStartDelay(START_DELAY)
                .setDuration(DURATION_INITIAL + DURATION_NEXT_VIEW_FACTOR * viewPosition)
                .setInterpolator(new DecelerateInterpolator(INTERPOLATOR_FACTOR)).start();
    }


    public void CalendarV() {
        Calendar endDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();

        int month = endDate.get(Calendar.MONTH)+1;
        if (month==10) {
            endDate.add(Calendar.MONTH, 7);
            startDate.add(Calendar.MONTH, 0);
        }
        if (month==11) {
            endDate.add(Calendar.MONTH, 6);
            startDate.add(Calendar.MONTH, -1);
        }
        if (month==12) {
            endDate.add(Calendar.MONTH, 5);
            startDate.add(Calendar.MONTH, -2);
        }
        if (month==1) {
            endDate.add(Calendar.MONTH, 4);
            startDate.add(Calendar.MONTH, -3);
        }
        if (month==2) {
            endDate.add(Calendar.MONTH, 3);
            startDate.add(Calendar.MONTH, -4);
        }
        if (month==3) {
            endDate.add(Calendar.MONTH, 2);
            startDate.add(Calendar.MONTH, -5);
        }
        if (month==4) {
            endDate.add(Calendar.MONTH, 1);
            startDate.add(Calendar.MONTH, -6);
        }

        Calendar datenow = Calendar.getInstance();
        datenow.add(Calendar.MONTH, 0);


        horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .defaultSelectedDate(datenow)
                .range(startDate, endDate)
                .datesNumberOnScreen(3)
                .mode(HorizontalCalendar.Mode.MONTHS)
                .configure()
                .formatMiddleText("MMM")
                .formatBottomText("yyyy")
                .showTopText(false)
                .showBottomText(false)
                .textColor(Color.LTGRAY, Color.WHITE)
                .end()
                .build();


        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                TinyDB tinydb = new TinyDB(getApplicationContext());
                tinydb.putBoolean("click",true);
                newmonth=date.get(Calendar.MONTH)+1;
                changemonth=true;
                table.setVisibility(View.GONE);
                loading.setVisibility(View.VISIBLE);
                TableLoader(getApplicationContext());
               // alarms=getAlarmList(getApplicationContext());
                //AlarmsBigList=getBigList2(getApplicationContext());

                alert1.setImageResource(R.drawable.alarm_black1);
                alert2.setImageResource(R.drawable.alarm_black1);
                alert3.setImageResource(R.drawable.alarm_black1);
                alert4.setImageResource(R.drawable.alarm_black1);
                alert5.setImageResource(R.drawable.alarm_black1);
                alert6.setImageResource(R.drawable.alarm_black1);
                alert7.setImageResource(R.drawable.alarm_black1);
                alert8.setImageResource(R.drawable.alarm_black1);
                alert9.setImageResource(R.drawable.alarm_black1);
                alert10.setImageResource(R.drawable.alarm_black1);
                alert11.setImageResource(R.drawable.alarm_black1);
                alert12.setImageResource(R.drawable.alarm_black1);
                alert13.setImageResource(R.drawable.alarm_black1);
                alert14.setImageResource(R.drawable.alarm_black1);
                alert15.setImageResource(R.drawable.alarm_black1);
                alert1.setTag("0");
                alert2.setTag("0");
                alert3.setTag("0");
                alert4.setTag("0");
                alert5.setTag("0");
                alert6.setTag("0");
                alert7.setTag("0");
                alert8.setTag("0");
                alert9.setTag("0");
                alert10.setTag("0");
                alert11.setTag("0");
                alert12.setTag("0");
                alert13.setTag("0");
                alert14.setTag("0");
                alert15.setTag("0");

               /* alertpresses1=true;
                alertpresses2=true;
                alertpresses3=true;
                alertpresses4=true;
                alertpresses5=true;
                alertpresses6=true;
                alertpresses7=true;
                alertpresses8=true;
                alertpresses9=true;
                alertpresses10=true;
                alertpresses11=true;
                alertpresses12=true;
                alertpresses13=true;
                alertpresses14=true;
                alertpresses15=true;
                */

                if (row8.getBackground() instanceof ColorDrawable) {

                    ColorDrawable cd = (ColorDrawable) row8.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){

                        scroll1.post(new Runnable() {
                            public void run() {
                                scroll1.fullScroll(scroll1.FOCUS_DOWN);
                            }
                        });
                    }else {
                        scroll1.post(new Runnable() {

                            public void run() {
                                scroll1.fullScroll(scroll1.FOCUS_UP);
                            }
                        });
                    }
                }

                // CheckRows(getApplicationContext());
            }



        });
    }



        public void TableLoader(Context context) {
            TinyDB tinydb = new TinyDB(getApplicationContext());
           // tinydb.putBoolean("click",false);

    URL = URLmain + onRus.indexOf(FavTeamP) + "&season=22&month=" + (month + 1);
    if (changemonth) {
        URL = URLmain + onRus.indexOf(FavTeamP) + "&season=22&month=" + (newmonth);
        changemonth=false;
    }

    if (FavTeam.equals(getString(R.string.Anaheim))) {
        teamlogo.setImageResource(R.drawable.anaheim);
        mTextMessage.setText(getString(R.string.Anaheim));

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Winnipeg))) {
        teamlogo.setImageResource(R.drawable.winnipeg);
        mTextMessage.setText(getString(R.string.Winnipeg));

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();

    }
    if (FavTeam.equals(getString(R.string.Boston))) {
        teamlogo.setImageResource(R.drawable.boston);
        mTextMessage.setText(getString(R.string.Boston));

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Buffalo))) {
        teamlogo.setImageResource(R.drawable.buffalo);
        mTextMessage.setText(getString(R.string.Buffalo));

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();

    }
    if (FavTeam.equals(getString(R.string.Calgary))) {
        teamlogo.setImageResource(R.drawable.calgary);
        mTextMessage.setText(getString(R.string.Calgary));

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Carolina))) {
        teamlogo.setImageResource(R.drawable.carolina);
        mTextMessage.setText(getString(R.string.Carolina));

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Chicago))) {
        mTextMessage.setText(getString(R.string.Chicago));
        teamlogo.setImageResource(R.drawable.chicago);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Colorado))) {
        mTextMessage.setText(getString(R.string.Colorado));
        teamlogo.setImageResource(R.drawable.colorado);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.DallasStars))) {
        mTextMessage.setText(getString(R.string.DallasStars));
        teamlogo.setImageResource(R.drawable.dallas);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Detroit))) {
        mTextMessage.setText(getString(R.string.Detroit));
        teamlogo.setImageResource(R.drawable.detroit);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Edmonton))) {
        mTextMessage.setText(getString(R.string.Edmonton));
        teamlogo.setImageResource(R.drawable.oilers);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Florida))) {
        mTextMessage.setText(getString(R.string.Florida));
        teamlogo.setImageResource(R.drawable.florida);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Montreal))) {
        mTextMessage.setText(getString(R.string.Montreal));
        teamlogo.setImageResource(R.drawable.monreal);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Nashville))) {
        mTextMessage.setText(getString(R.string.Nashville));
        teamlogo.setImageResource(R.drawable.nashvill);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.NewJersey))) {
        mTextMessage.setText(getString(R.string.NewJersey));
        teamlogo.setImageResource(R.drawable.devils);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.NYRangers))) {
        mTextMessage.setText(getString(R.string.NYRangers));
        teamlogo.setImageResource(R.drawable.rangers);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Islanders))) {
        mTextMessage.setText(getString(R.string.Islanders));
        teamlogo.setImageResource(R.drawable.islanders);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.LosAngeles))) {
        mTextMessage.setText(getString(R.string.LosAngeles));
        teamlogo.setImageResource(R.drawable.la);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();

    }
    if (FavTeam.equals(getString(R.string.Ottawa))) {
        mTextMessage.setText(getString(R.string.Ottawa));
        teamlogo.setImageResource(R.drawable.ottawa);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Pittsburgh))) {
        mTextMessage.setText(getString(R.string.Pittsburgh));
        teamlogo.setImageResource(R.drawable.pitsburg);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Philadelphia))) {
        mTextMessage.setText(getString(R.string.Philadelphia));
        teamlogo.setImageResource(R.drawable.filadelfia);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Arizona))) {
        mTextMessage.setText(getString(R.string.Arizona));
        teamlogo.setImageResource(R.drawable.arizona);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.SanJose))) {
        mTextMessage.setText(getString(R.string.SanJose));
        teamlogo.setImageResource(R.drawable.sharks);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Blues))) {
        mTextMessage.setText(getString(R.string.Blues));
        teamlogo.setImageResource(R.drawable.blues);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Toronto))) {
        mTextMessage.setText(getString(R.string.Toronto));
        teamlogo.setImageResource(R.drawable.toronto);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.TampaBay))) {
        mTextMessage.setText(getString(R.string.TampaBay));
        teamlogo.setImageResource(R.drawable.tampa);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Vancouver))) {
        mTextMessage.setText(getString(R.string.Vancouver));
        teamlogo.setImageResource(R.drawable.vancouver);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.WashingtonCap))) {
        mTextMessage.setText(getString(R.string.WashingtonCap));
        teamlogo.setImageResource(R.drawable.washington);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Minnesota))) {
        mTextMessage.setText(getString(R.string.Minnesota));
        teamlogo.setImageResource(R.drawable.minnessota);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Columbus))) {
        mTextMessage.setText(getString(R.string.Columbus));
        teamlogo.setImageResource(R.drawable.colambus);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
    if (FavTeam.equals(getString(R.string.Vegas))) {
        mTextMessage.setText(getString(R.string.Vegas));
        teamlogo.setImageResource(R.drawable.vegas);

        // today.animate().scaleX(1).scaleY(1).setDuration(3000);
        new Task(context).execute();
    }
        }


    public void addAll() {

      //  Intent intent = new Intent(MainActivity.this, ListActivity.class);
       // startActivity(intent);
       // finish();
    }


        public static void saveBigList(Context context) {
        CountfromBigList=0;
        ArrayList<String> biglist = new ArrayList<String>();
        TinyDB tinydb = new TinyDB(context);

        for (int i=0;i<AlarmsBigList.size();i++) {
            biglist.addAll(Arrays.asList(AlarmsBigList.get(i)));
            tinydb.putListString("Big"+String.valueOf(i), biglist);
            biglist.clear();
            CountfromBigList++;
        }
        tinydb.putInt("CountfromBigList",CountfromBigList);
        if (AlarmsBigList.size()>300) AlarmsBigList.clear();

    }
    public static void saveHashSet(Context context, HashSet<String[]> hs) {
        CountfromHashList=0;
        ArrayList<String> biglist = new ArrayList<String>();
        TinyDB tinydb = new TinyDB(context);
        AlarmsBigList = new ArrayList<String[]>(hs);
        for (int i=0;i<AlarmsBigList.size();i++) {
            biglist.addAll(Arrays.asList(AlarmsBigList.get(i)));
            tinydb.putListString("Hash"+String.valueOf(i), biglist);
            biglist.clear();
            CountfromHashList++;
        }
        tinydb.putInt("CountfromHashList",CountfromHashList);
        if (AlarmsBigList.size()>300) AlarmsBigList.clear();

    }


    public static void saveAlarmList(Context context) {
        CountfromSaveAlarms=0;

        TinyDB tinydb = new TinyDB(context);

        ArrayList<String> list = new ArrayList<String>();

        for (int i=0;i<alarmlist.size();i++){
            list.addAll(Arrays.asList(alarmlist.get(i)));
            tinydb.putListString(String.valueOf(i), list);
            list.clear();
            CountfromSaveAlarms++;
        }
        tinydb.putInt("CountfromSaveAlarms",CountfromSaveAlarms);
        alarmlist.clear();

    }
    public static ArrayList getBigList(Context context) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> listboof = new ArrayList<String>();
        TinyDB tinydb = new TinyDB(context);
        int countfB = tinydb.getInt("CountfromBigList");
        list = tinydb.getListString("0");
            for (int i=0;i<countfB;i++) {
                listboof=tinydb.getListString("Big"+String.valueOf(i));
                String text="";
                for(int j=0;j<listboof.size();j++){
                    text=text+" "+listboof.get(j);
                }
                textboofer.add(text);
            }

        return null;

    }
    public static ArrayList getBigList2(Context context) {
         ArrayList<String[]> AlarmsBigList = new ArrayList<String[]>();
        ArrayList<String> listboof = new ArrayList<String>();
        TinyDB tinydb = new TinyDB(context);
        int countfB = tinydb.getInt("CountfromBigList");
        for (int i=0;i<countfB;i++) {
            listboof=tinydb.getListString("Big"+String.valueOf(i));
            String[] array = listboof.toArray(new String[listboof.size()]);
            AlarmsBigList.add(array);
        }

        return AlarmsBigList;

    }
    public static HashSet getHashList(Context context) {
        HashSet<String[]> hs = new HashSet<String[]>();
        ArrayList<String> listboof = new ArrayList<String>();
        TinyDB tinydb = new TinyDB(context);
        int countfB = tinydb.getInt("CountfromHashList");
        for (int i=0;i<countfB;i++) {
            listboof=tinydb.getListString("Hash"+String.valueOf(i));
            String[] array = listboof.toArray(new String[listboof.size()]);
            hs.add(array);
        }

        return hs;

    }
    public static ArrayList getAlarmList(Context context) {
        ArrayList<String> listboof = new ArrayList<String>();
        TinyDB tinydb = new TinyDB(context);
        int countfA = tinydb.getInt("CountfromSaveAlarms");


        if (countfA!=0){
        for (int i=0;i<countfA;i++) {
        listboof=tinydb.getListString(String.valueOf(i));
            System.out.println("Alarms added: "+listboof.toString());

            NotificationHelper.scheduleRepeatingRTCNotification(context,
                    Integer.parseInt(listboof.get(0).toString()),
                    Integer.parseInt(listboof.get(1).toString()),
                    Integer.parseInt(listboof.get(2).toString()),
                    Integer.parseInt(listboof.get(3).toString()),
                    Integer.parseInt(listboof.get(4).toString()),
                    listboof.get(5).toString(),
                    Integer.parseInt(listboof.get(6).toString()),
                    FavTeam);
            listboof.clear();

        }
        }
        tinydb.putInt("CountfromSaveAlarms",0);

        return null;

    }


    public HashSet<String[]> Translater(ArrayList<String[]> list){

        HashSet<String[]> hashset = new HashSet<String[]>();
        for (int i=0;i<list.size();i++){
               hashset.add(list.get(i));
                              }

        return hashset;
    }

    public Date dateParser(String text) {


            LocalDate date = LocalDate.now();

            DateTimeFormatter formatter = null;
            formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

            LocalDate parsedDate;

            parsedDate = LocalDate.parse(text, formatter);

            Date result = Date.from(parsedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return result;
    }

   /* @Override
    public boolean equals(Object o) {

        if (this == o) {

            return true;

        }

        if (o == null || getClass() != o.getClass()) {

            return false;

        }


        MainActivity that = (MainActivity) o;

        return !(string != null ? !Arrays.equals(string, that.string) : that.string != null);


    }


    @Override
    public int hashCode() {

            final int prime = 31;
            int result = 1;
            result = prime * result + ((string == null) ? 0 : string.hashCode());

            return result;
    }

    */

    class ArrayWrapper
    {
        private String[] array;

        public ArrayWrapper(String[] array)
        {
            this.array = array;
        }

        public String[] getArray()
        {
            return array;
        }

        @Override
        public int hashCode()
        {
            return Arrays.hashCode(array);
        }

        @Override
        public boolean equals(Object obj)
        {
            if (!(obj instanceof ArrayWrapper))
            {
                return false;
            }

            return Arrays.equals(array, ((ArrayWrapper) obj).getArray());
        }

        @Override
        public String toString() {
            return "ArrayWrapper{" +
                    "array=" + Arrays.toString(array) +
                    '}';
        }
    }


    public void Reminder(Context context) {
         Calendar cal = Calendar.getInstance();


         AlarmsBigList=getBigList2(context);
        for(int i=0;i<AlarmsBigList.size();i++){
            System.out.println("After loading "+Arrays.toString(AlarmsBigList.get(i)));
        }
        List<ArrayWrapper> list = new ArrayList<ArrayWrapper>();
        List<ArrayWrapper> list2 = new ArrayList<ArrayWrapper>();

        if (AlarmsBigList.size()>0) {
            for (int i = 0; i < AlarmsBigList.size(); i++) {
                list.add(new ArrayWrapper(AlarmsBigList.get(i)));
            }
        }
        List<ArrayWrapper> list3 = new ArrayList<ArrayWrapper>(list);


      /*  HashSet<String[]> AlarmsHashSet = new HashSet<String[]>();
        HashSet<String[]> AlarmsHashSetBoof = new HashSet<String[]>();


        for (int a = 0; a<AlarmsBigList.size(); a++) {
           AW.setStrArray(AlarmsBigList.get(a));
           AlarmsHashSet.add(AW.getStrArray());
        }


     //       String[][] w = new String[AlarmsBigList.size()][];
     //   for (int a = 0; a<AlarmsBigList.size(); a++) {
    //        w[a] = AlarmsBigList.get(a);
    //    }


        for (int i=0;i<w.length;i++){
            System.out.println("array "+Arrays.toString(w[i]));
            AW.setStrArray(w[i]);
            AlarmsHashSet.add(AW.getStrArray());
        }

        for (String[] temp : AlarmsHashSet)
            System.out.println("AlarmsHashSet all " + Arrays.toString(temp));

      */
       //  AlarmsHashSet.add(new String[]{"2020", "2", "5", "1", "0", "Tampa Bay Lightning", "2"});

        boolean alreadyhas;
        int year, month, day, hour, min;
        Date date = null;
        String teamname=null;
        date = dateParser(date1.getText().toString());


        if (row1.getVisibility() == View.VISIBLE) {
        dateN1 = dateParser(date1.getText().toString());
            System.out.println("date works"+dateN1);

        cal.setTime(dateN1);
        teamname = homet1.getText().toString();

        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH) + 1;
        year = cal.get(Calendar.YEAR);
        hour = Integer.parseInt(time1.getText().toString().substring(0, 2));
        min = Integer.parseInt(time1.getText().toString().substring(3));


        if (ToRemind1) {

            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(1)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);

            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(1)};
            alreadyhas=false;
            System.out.println("in reminder "+alertpresses1);

            if (!alertpresses1) {
                if (list.contains(wrapperToSearchFor)) {
                    alreadyhas = true;
                }
            }
            if (alertpresses1&&!alreadyhas) {
                list.add(new ArrayWrapper(string));
                list2.add(new ArrayWrapper(string));

                // System.out.println("Added "+Arrays.toString(new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(1)}));
                alert1.setImageResource(R.drawable.alarm_white);
                ToRemind1 = false;

                //    for (int i=0;i<AlarmsBigList.size();i++)
                //        System.out.println("1 "+ Arrays.toString(AlarmsBigList.get(i)));
            }
        } else {
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(1)};
            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(1)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            if (!alertpresses1) {
                if (list.contains(wrapperToSearchFor)) {
                    list.remove(wrapperToSearchFor);
                    list3.remove(wrapperToSearchFor);
                   // alert1.setImageResource(R.drawable.alarm_black1);

                }

                if (list2.contains(wrapperToSearchFor)) {
                    list2.remove(wrapperToSearchFor);

                }

            }
        }
    }
        if (row2.getVisibility() == View.VISIBLE) {

            dateN2 = dateParser(date2.getText().toString());
            System.out.println("date works2"+dateN2);

            cal.setTime(dateN2);
            teamname = homet2.getText().toString();

        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH) + 1;
        year = cal.get(Calendar.YEAR);
        hour = Integer.parseInt(time2.getText().toString().substring(0, 2));
        min = Integer.parseInt(time2.getText().toString().substring(3));


        if (ToRemind2) {
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(2)};
            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(2)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            alreadyhas=false;

            if (!alertpresses2) {
                if (list.contains(wrapperToSearchFor)) {
                    alreadyhas = true;
                }
            }
            if (alertpresses2&&!alreadyhas) {

                list.add(new ArrayWrapper(string));
                list2.add(new ArrayWrapper(string));

                alert2.setImageResource(R.drawable.alarm_white);

                ToRemind2 = false;
            }

        } else {
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(2)};
            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(2)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);

            if (!alertpresses2) {
                if (list.contains(wrapperToSearchFor)) {
                    list.remove(wrapperToSearchFor);
                    list3.remove(wrapperToSearchFor);

                    //alert2.setImageResource(R.drawable.alarm_black1);

                }
                if (list2.contains(wrapperToSearchFor)) {
                    list2.remove(wrapperToSearchFor);

                }
            }
        }
    }
        if (row3.getVisibility() == View.VISIBLE) {

            //date = simpleDateFormat.parse(date3.getText().toString());
            dateN3 = dateParser(date3.getText().toString());

            cal.setTime(dateN3);
            teamname = homet3.getText().toString();

        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH) + 1;
        year = cal.get(Calendar.YEAR);
        hour = Integer.parseInt(time3.getText().toString().substring(0, 2));
        min = Integer.parseInt(time3.getText().toString().substring(3));



        if (ToRemind3) {
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(3)};
            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(3)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            alreadyhas=false;
            if (!alertpresses3) {
                if (list.contains(wrapperToSearchFor)) {
                    alreadyhas = true;
                }
            }
            if (alertpresses3&&!alreadyhas) {
                list.add(new ArrayWrapper(string));
                list2.add(new ArrayWrapper(string));

                alert3.setImageResource(R.drawable.alarm_white);

                ToRemind3 = false;
            }

        } else {

            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(3)};
            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(3)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            if (!alertpresses3) {
                if (list.contains(wrapperToSearchFor)) {
                    list.remove(wrapperToSearchFor);
                    list3.remove(wrapperToSearchFor);

                   // alert3.setImageResource(R.drawable.alarm_black1);

                }
                if (list2.contains(wrapperToSearchFor)) {
                    list2.remove(wrapperToSearchFor);

                }
            }

        }
    }
        if (row4.getVisibility() == View.VISIBLE) {


           // date = simpleDateFormat.parse(date4.getText().toString());
            dateN4 = dateParser(date4.getText().toString());
        cal.setTime(dateN4);
            teamname = homet4.getText().toString();

        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH) + 1;
        year = cal.get(Calendar.YEAR);
        hour = Integer.parseInt(time4.getText().toString().substring(0, 2));
        min = Integer.parseInt(time4.getText().toString().substring(3));


        if (ToRemind4) {
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(4)};
            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(4)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            alreadyhas=false;
            if (!alertpresses4) {
                if (list.contains(wrapperToSearchFor)) {
                    alreadyhas = true;
                }
            }
            if (alertpresses4&&!alreadyhas) {
                list.add(new ArrayWrapper(string));
                list2.add(new ArrayWrapper(string));
                alert4.setImageResource(R.drawable.alarm_white);

                ToRemind4 = false;
            }

        } else {
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(4)};
            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(4)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            if (!alertpresses4) {
                System.out.println("Before " + AlarmsBigList.size());
                System.out.println(Arrays.toString(string));

                if (list.contains(wrapperToSearchFor)) {
                    list.remove(wrapperToSearchFor);
                    list3.remove(wrapperToSearchFor);

                    System.out.println("Working!!!!!!!!!!!!!!!!!!!!!!!!");


                 //   alert4.setImageResource(R.drawable.alarm_black1);
                    System.out.println("removed");


                }
                System.out.println("after  " + AlarmsBigList.size());

                if (list2.contains(wrapperToSearchFor)) {
                    list2.remove(wrapperToSearchFor);

                }
            }

        }
    }
        if (row5.getVisibility() == View.VISIBLE) {


           // date = simpleDateFormat.parse(date5.getText().toString());

            dateN5 = dateParser(date5.getText().toString());
            cal.setTime(dateN5);
            teamname = homet5.getText().toString();

        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH) + 1;
        year = cal.get(Calendar.YEAR);
        hour = Integer.parseInt(time5.getText().toString().substring(0, 2));
        min = Integer.parseInt(time5.getText().toString().substring(3));



        if (ToRemind5) {
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(5)};
            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(5)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            alreadyhas=false;
            if (!alertpresses5) {
                if (list.contains(wrapperToSearchFor)) {
                    alreadyhas = true;
                }
            }
            if (alertpresses5&&!alreadyhas) {
                list.add(new ArrayWrapper(string));
                list2.add(new ArrayWrapper(string));
                alert5.setImageResource(R.drawable.alarm_white);

                ToRemind5 = false;
            }


        } else {
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(5)};
            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(5)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);

            if (!alertpresses5) {
                if (list.contains(wrapperToSearchFor)) {
                    list.remove(wrapperToSearchFor);
                    list3.remove(wrapperToSearchFor);

                 //   alert5.setImageResource(R.drawable.alarm_black1);

                }
                if (list2.contains(wrapperToSearchFor)) {
                    list2.remove(wrapperToSearchFor);

                }
            }

        }
    }
        if (row6.getVisibility() == View.VISIBLE) {


           // date = simpleDateFormat.parse(date6.getText().toString());

            dateN6 = dateParser(date6.getText().toString());
            cal.setTime(dateN6);
            teamname = homet6.getText().toString();

        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH) + 1;
        year = cal.get(Calendar.YEAR);
        hour = Integer.parseInt(time6.getText().toString().substring(0, 2));
        min = Integer.parseInt(time6.getText().toString().substring(3));


        if (ToRemind6) {
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(6)};
            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(6)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            alreadyhas=false;
            if (!alertpresses6) {
                if (list.contains(wrapperToSearchFor)) {
                    alreadyhas = true;
                }
            }
            if (alertpresses6&&!alreadyhas) {
                list.add(new ArrayWrapper(string));
                list2.add(new ArrayWrapper(string));
                alert6.setImageResource(R.drawable.alarm_white);

                ToRemind6 = false;
            }

        } else {

            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(6)};
            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(6)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            if (!alertpresses6) {
                if (list.contains(wrapperToSearchFor)) {
                    list.remove(wrapperToSearchFor);
                    list3.remove(wrapperToSearchFor);

                 //   alert6.setImageResource(R.drawable.alarm_black1);

                }
                if (list2.contains(wrapperToSearchFor)) {
                    list2.remove(wrapperToSearchFor);

                }
            }

        }
    }

        if (row7.getVisibility() == View.VISIBLE) {


               // date = simpleDateFormat.parse(date7.getText().toString());

            dateN7 = dateParser(date7.getText().toString());
            cal.setTime(dateN7);            teamname = homet7.getText().toString();

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour=Integer.parseInt(time7.getText().toString().substring(0,2));
            min=Integer.parseInt(time7.getText().toString().substring(3));



            if (ToRemind7) {
                string= new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(7)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(7)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
                alreadyhas=false;
                if (!alertpresses7) {
                    if (list.contains(wrapperToSearchFor)) {
                        alreadyhas = true;
                    }
                }
                if (alertpresses7&&!alreadyhas) {
                list.add(new ArrayWrapper(string));
                    list2.add(new ArrayWrapper(string));
                    alert7.setImageResource(R.drawable.alarm_white);

                ToRemind7=false;
            }

        }
        else {

                string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(7)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(7)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
                if (!alertpresses7) {
                    if (list.contains(wrapperToSearchFor)) {
                        list.remove(wrapperToSearchFor);
                        list3.remove(wrapperToSearchFor);

                     //   alert7.setImageResource(R.drawable.alarm_black1);

                    }
                    if (list2.contains(wrapperToSearchFor)) {
                        list2.remove(wrapperToSearchFor);

                    }
                }

            }
        }


        if (row8.getVisibility() == View.VISIBLE) {


               // date = simpleDateFormat.parse(date8.getText().toString());

            dateN8 = dateParser(date8.getText().toString());
            cal.setTime(dateN8);            teamname = homet8.getText().toString();

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour=Integer.parseInt(time8.getText().toString().substring(0,2));
            min=Integer.parseInt(time8.getText().toString().substring(3));


            if (ToRemind8) {
                string= new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(8)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(8)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
                alreadyhas=false;
                if (!alertpresses8) {
                    if (list.contains(wrapperToSearchFor)) {
                        alreadyhas = true;
                    }
                }
                if (alertpresses8&&!alreadyhas) {
                list.add(new ArrayWrapper(string));
                    list2.add(new ArrayWrapper(string));

                    alert8.setImageResource(R.drawable.alarm_white);

                ToRemind8=false;
            }

        }
        else {

                string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(8)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(8)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
                if (!alertpresses8) {
                    if (list.contains(wrapperToSearchFor)) {
                        list.remove(wrapperToSearchFor);
                        list3.remove(wrapperToSearchFor);

                      //  alert8.setImageResource(R.drawable.alarm_black1);

                    }
                    if (list2.contains(wrapperToSearchFor)) {
                        list2.remove(wrapperToSearchFor);

                    }
                }

            }
        }


        if (row9.getVisibility() == View.VISIBLE) {


               // date = simpleDateFormat.parse(date9.getText().toString());

            dateN9 = dateParser(date9.getText().toString());
            cal.setTime(dateN9);
            teamname = homet9.getText().toString();

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour=Integer.parseInt(time9.getText().toString().substring(0,2));
            min=Integer.parseInt(time9.getText().toString().substring(3));



            if (ToRemind9) {
                string= new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(9)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(9)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
                alreadyhas=false;
                if (!alertpresses9) {
                    if (list.contains(wrapperToSearchFor)) {
                        alreadyhas = true;
                    }
                }
                if (alertpresses9&&!alreadyhas) {
                list.add(new ArrayWrapper(string));

                    list2.add(new ArrayWrapper(string));
                alert9.setImageResource(R.drawable.alarm_white);

                ToRemind9=false;
            }

        }
        else {
                string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(9)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(9)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);

                if (!alertpresses9) {
                    if (list.contains(wrapperToSearchFor)) {
                        list.remove(wrapperToSearchFor);
                        list3.remove(wrapperToSearchFor);

                      //  alert9.setImageResource(R.drawable.alarm_black1);

                    }
                    if (list2.contains(wrapperToSearchFor)) {
                        list2.remove(wrapperToSearchFor);

                    }
                }

            }
        }

        if (row10.getVisibility() == View.VISIBLE) {


            dateN10 = dateParser(date10.getText().toString());
            cal.setTime(dateN10);
            teamname = homet10.getText().toString();

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour=Integer.parseInt(time10.getText().toString().substring(0,2));
            min=Integer.parseInt(time10.getText().toString().substring(3));


            if (ToRemind10) {
                string= new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(10)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(10)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
                alreadyhas=false;
                if (!alertpresses10) {
                    if (list.contains(wrapperToSearchFor)) {
                        alreadyhas = true;
                    }
                }

                if (alertpresses10&&!alreadyhas) {
                list.add(new ArrayWrapper(string));

                    list2.add(new ArrayWrapper(string));
                alert10.setImageResource(R.drawable.alarm_white);

                ToRemind10=false;
            }


        }
        else {
                string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(10)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(10)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);

                if (!alertpresses10) {
                    if (list.contains(wrapperToSearchFor)) {
                        list.remove(wrapperToSearchFor);
                        list3.remove(wrapperToSearchFor);

                     //   alert10.setImageResource(R.drawable.alarm_black1);
                        System.out.println("10Working!!!!!!!!!!!!!!!!!!!!!!!!");

                    }
                    if (list2.contains(wrapperToSearchFor)) {
                        list2.remove(wrapperToSearchFor);

                    }
                }

            }
        }

        if (row11.getVisibility() == View.VISIBLE) {


               // date = simpleDateFormat.parse(date11.getText().toString());

            dateN11 = dateParser(date11.getText().toString());
            cal.setTime(dateN11);
            teamname = homet11.getText().toString();

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour=Integer.parseInt(time11.getText().toString().substring(0,2));
            min=Integer.parseInt(time11.getText().toString().substring(3));



            if (ToRemind11) {
                string= new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(11)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(11)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
                alreadyhas=false;
                if (!alertpresses11) {
                    if (list.contains(wrapperToSearchFor)) {
                        alreadyhas = true;
                    }
                }
                if (alertpresses11&&!alreadyhas) {
                    list.add(new ArrayWrapper(string));

                    list2.add(new ArrayWrapper(string));
                    alert11.setImageResource(R.drawable.alarm_white);

                    ToRemind11=false;
                }


        }
        else {

                string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(11)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(11)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
                    if (!alertpresses11) {
                        if (list.contains(wrapperToSearchFor)) {
                            list.remove(wrapperToSearchFor);
                            list3.remove(wrapperToSearchFor);
                            System.out.println("11Working!!!!!!!!!!!!!!!!!!!!!!!!");

                           // alert11.setImageResource(R.drawable.alarm_black1);

                        }
                        if (list2.contains(wrapperToSearchFor)) {
                            list2.remove(wrapperToSearchFor);

                        }
                    }

            }
        }
        if (row12.getVisibility() == View.VISIBLE) {


               // date = simpleDateFormat.parse(date12.getText().toString());

            dateN12 = dateParser(date12.getText().toString());
            cal.setTime(dateN12);
            teamname = homet12.getText().toString();

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour=Integer.parseInt(time12.getText().toString().substring(0,2));
            min=Integer.parseInt(time12.getText().toString().substring(3));


            if (ToRemind12) {
                string= new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(12)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(12)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
                alreadyhas=false;
                if (!alertpresses12) {
                    if (list.contains(wrapperToSearchFor)) {
                        alreadyhas = true;
                    }
                }
                if (alertpresses12&&!alreadyhas) {
                    list.add(new ArrayWrapper(string));

                    list2.add(new ArrayWrapper(string));
                alert12.setImageResource(R.drawable.alarm_white);

                ToRemind12=false;
            }

        }
        else {
                string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(12)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(12)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);

                if (!alertpresses12) {
                    if (list.contains(wrapperToSearchFor)) {
                        list.remove(wrapperToSearchFor);
                        list3.remove(wrapperToSearchFor);
                        System.out.println("12Working!!!!!!!!!!!!!!!!!!!!!!!!");

                      //  alert12.setImageResource(R.drawable.alarm_black1);

                    }
                    if (list2.contains(wrapperToSearchFor)) {
                        list2.remove(wrapperToSearchFor);

                    }
                }

            }
        }

        if (row13.getVisibility() == View.VISIBLE) {

              //  date = simpleDateFormat.parse(date13.getText().toString());

            dateN13 = dateParser(date13.getText().toString());
            cal.setTime(dateN13);
            teamname = homet13.getText().toString();

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour=Integer.parseInt(time13.getText().toString().substring(0,2));
            min=Integer.parseInt(time13.getText().toString().substring(3));


            if (ToRemind13) {
                string= new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(13)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(13)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
                alreadyhas=false;
                if (!alertpresses13) {
                    if (list.contains(wrapperToSearchFor)) {
                        alreadyhas = true;
                    }
                }
                if (alertpresses13&&!alreadyhas) {
                    list.add(new ArrayWrapper(string));

                    list2.add(new ArrayWrapper(string));
                alert13.setImageResource(R.drawable.alarm_white);

                ToRemind13=false;
            }

        }
        else {
                string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(13)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(13)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
                if (!alertpresses13) {
                    if (list.contains(wrapperToSearchFor)) {
                        list.remove(wrapperToSearchFor);
                        list3.remove(wrapperToSearchFor);

                      //  alert13.setImageResource(R.drawable.alarm_black1);
                        System.out.println("13Working!!!!!!!!!!!!!!!!!!!!!!!!");

                    }
                    if (list2.contains(wrapperToSearchFor)) {
                        list2.remove(wrapperToSearchFor);

                    }
                }

            }
        }

        if (row14.getVisibility() == View.VISIBLE) {
               // date = simpleDateFormat.parse(date14.getText().toString());

            dateN14 = dateParser(date14.getText().toString());
            cal.setTime(dateN14);
            teamname = homet14.getText().toString();

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour=Integer.parseInt(time14.getText().toString().substring(0,2));
            min=Integer.parseInt(time14.getText().toString().substring(3));


            if (ToRemind14) {
                string= new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(14)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(14)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
                alreadyhas=false;
                if (!alertpresses14) {
                    if (list.contains(wrapperToSearchFor)) {
                        alreadyhas = true;
                    }
                }
                if (alertpresses14&&!alreadyhas) {
                    list.add(new ArrayWrapper(string));

                    list2.add(new ArrayWrapper(string));
                alert14.setImageResource(R.drawable.alarm_white);

                ToRemind14=false;
            }

        }
        else {
                string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(14)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(14)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);

                if (!alertpresses14) {
                    if (list.contains(wrapperToSearchFor)) {
                        list.remove(wrapperToSearchFor);
                        list3.remove(wrapperToSearchFor);


                      //  alert14.setImageResource(R.drawable.alarm_black1);

                    }
                    if (list2.contains(wrapperToSearchFor)) {
                        list2.remove(wrapperToSearchFor);

                    }
                }

            }
        }
        if (row15.getVisibility() == View.VISIBLE) {


               // date = simpleDateFormat.parse(date15.getText().toString());

            dateN15 = dateParser(date15.getText().toString());
            cal.setTime(dateN15);
            teamname = homet15.getText().toString();

            day = cal.get(Calendar.DAY_OF_MONTH);
            month = cal.get(Calendar.MONTH) + 1;
            year = cal.get(Calendar.YEAR);
            hour = Integer.parseInt(time15.getText().toString().substring(0, 2));
            min = Integer.parseInt(time15.getText().toString().substring(3));

            if (ToRemind15) {
                string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(15)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(15)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
                alreadyhas=false;
                if (!alertpresses15) {
                    if (list.contains(wrapperToSearchFor)) {
                        alreadyhas = true;
                    }
                }
                if (alertpresses15&&!alreadyhas) {
                    list.add(new ArrayWrapper(string));

                    list2.add(new ArrayWrapper(string));
                    alert15.setImageResource(R.drawable.alarm_white);

                    ToRemind15 = false;
                }

            } else {
                string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(15)};
                String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(15)};
                ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);

                if (!alertpresses15) {
                    if (list.contains(wrapperToSearchFor)) {
                        list.remove(wrapperToSearchFor);
                        list3.remove(wrapperToSearchFor);
                      //  alert15.setImageResource(R.drawable.alarm_black1);

                    }
                    if (list2.contains(wrapperToSearchFor)) {
                        list2.remove(wrapperToSearchFor);

                    }
                }

            }
        }

        AlarmsBigList.clear();

        for(int i=0;i<list3.size();i++){
            AlarmsBigList.add(list3.get(i).getArray());
            System.out.println(list3.get(i).toString());
        }

        for(int i=0;i<list.size();i++){
            AlarmsBigList.add(list.get(i).getArray());
            System.out.println(list.get(i).toString());
        }

        Set<String[]> s = new LinkedHashSet<String[]>(AlarmsBigList);
        AlarmsBigList = new ArrayList<String[]>(s);

        System.out.println("list size "+list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(Arrays.toString(AlarmsBigList.get(i)));
        }
        System.out.println("ALBL size "+AlarmsBigList.size());

        for(int i=0;i<list2.size();i++){
            alarmlist.add(list2.get(i).getArray());
        }
        saveBigList(context);

       Intent startServiceIntent = new Intent(getApplicationContext(), MessageService.class);
        getApplicationContext().startService(startServiceIntent);
        }






    @SuppressLint("ResourceAsColor")
    public void CheckRows(Context context){

        AlarmsBigList=getBigList2(context);
        Set<String[]> s = new LinkedHashSet<String[]>(AlarmsBigList);
        AlarmsBigList = new ArrayList<String[]>(s);
        System.out.println("Checkrows string "+AlarmsBigList.size());
        for (int i = 0; i < AlarmsBigList.size(); i++) {
            System.out.println("ALBL in check rows "+Arrays.toString(AlarmsBigList.get(i)));

        }
        List<ArrayWrapper> list = new ArrayList<ArrayWrapper>();

        if (AlarmsBigList.size()>0) {
            for (int i = 0; i < AlarmsBigList.size(); i++) {
                list.add(new ArrayWrapper(AlarmsBigList.get(i)));
            }
        }

        java.util.Calendar c = java.util.Calendar.getInstance();

        int month1= c.get(java.util.Calendar.MONTH);

        int day1= c.get(java.util.Calendar.DAY_OF_MONTH);

        int hour1= c.get(java.util.Calendar.HOUR_OF_DAY);

        int year,month,day,hour,min;
        String teamname;
        String[] string = new String[7];
        TinyDB tinydb = new TinyDB(context);
        Calendar cal = Calendar.getInstance();
        String pattern = "dd-MMM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);


        if (row1.getVisibility()==View.VISIBLE&&!alert1.getTag().equals(R.drawable.find_black_24dp)) {

            teamname = homet1.getText().toString();
            Date date = null;
            try {
                date = simpleDateFormat.parse(date1.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.setTime(date);

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour = Integer.parseInt(time1.getText().toString().substring(0, 2));
            min = Integer.parseInt(time1.getText().toString().substring(3));

            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(1)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(1)};

            System.out.println("Checkrows string " + Arrays.toString(string));


            tinydb.putBoolean("alertpresses1",false);
            System.out.println("after check "+tinydb.getBoolean("alertpresses1"));

            if (list.contains(wrapperToSearchFor)) {

                    alert1.setImageResource(R.drawable.alarm_white);
                    alert1.setTag(R.drawable.alarm_white);

                    tinydb.putBoolean("alertpresses1",true);
                System.out.println("after check "+tinydb.getBoolean("alertpresses1"));

                    // row1.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                    // row1.animate().scaleX(1).scaleY(1).setDuration(500);
                }
            else
            {
                alert1.setImageResource(R.drawable.alarm_black1);
                alert1.setTag(R.drawable.alarm_black1);
            }



        }
     /*   if (month1>month) {
            row1.setBackgroundColor(R.color.colorPrimaryDark);
        }
        if (month1==month) {
            if (day1>day) {
            row1.setBackgroundColor(R.color.colorPrimaryDark);
                if (day1==day) {
                    if (hour1>hour) {
                        row1.setBackgroundColor(R.color.colorPrimaryDark);
                    }
                }
        }}

      */


if (row2.getVisibility()==View.VISIBLE&&!alert2.getTag().equals(R.drawable.find_black_24dp)) {
    teamname = homet2.getText().toString();
    Date date = null;
    try {
        date = simpleDateFormat.parse(date2.getText().toString());
    } catch (ParseException e) {
        e.printStackTrace();
    }
    cal.setTime(date);

    day=cal.get(Calendar.DAY_OF_MONTH);
    month=cal.get(Calendar.MONTH)+1;
    year=cal.get(Calendar.YEAR);
    hour = Integer.parseInt(time2.getText().toString().substring(0, 2));
    min = Integer.parseInt(time2.getText().toString().substring(3));

    String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(2)};
    ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
    string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(2)};
    tinydb.putBoolean("alertpresses2",false);

    if (list.contains(wrapperToSearchFor)) {

        alert2.setImageResource(R.drawable.alarm_white);
                    alert2.setTag(R.drawable.alarm_white);
            tinydb.putBoolean("alertpresses2",true);
        }
    else
    {
        alert2.setImageResource(R.drawable.alarm_black1);
        alert2.setTag(R.drawable.alarm_black1);
    }

    /*    if (day1>day) {
            row2.setBackgroundColor(R.color.colorPrimaryDark);
        }
        if (day1==day) {
            if (hour1>hour) {
                row2.setBackgroundColor(R.color.colorPrimaryDark);
            }
        }

     */
}
        if (row3.getVisibility()==View.VISIBLE&&!alert3.getTag().equals(R.drawable.find_black_24dp)) {

            teamname = homet3.getText().toString();
            Date date = null;
            try {
                date = simpleDateFormat.parse(date3.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.setTime(date);

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour = Integer.parseInt(time3.getText().toString().substring(0, 2));
            min = Integer.parseInt(time3.getText().toString().substring(3));

            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(3)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(3)};
            tinydb.putBoolean("alertpresses3",false);

            if (list.contains(wrapperToSearchFor)) {

                alert3.setImageResource(R.drawable.alarm_white);
                    alert3.setTag(R.drawable.alarm_white);

                    tinydb.putBoolean("alertpresses3",true);
                }
            else
            {
                alert3.setImageResource(R.drawable.alarm_black1);
                alert3.setTag(R.drawable.alarm_black1);
            }

      /*  if (day1>day) {
            row3.setBackgroundColor(R.color.colorPrimaryDark);
        }
        if (day1==day) {
            if (hour1>hour) {
                row3.setBackgroundColor(R.color.colorPrimaryDark);
            }
        }

       */
        }
        if (row4.getVisibility()==View.VISIBLE&&!alert4.getTag().equals(R.drawable.find_black_24dp)) {

            teamname = homet4.getText().toString();
            Date date = null;
            try {
                date = simpleDateFormat.parse(date4.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.setTime(date);

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour = Integer.parseInt(time4.getText().toString().substring(0, 2));
            min = Integer.parseInt(time4.getText().toString().substring(3));

            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(4)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(4)};
            tinydb.putBoolean("alertpresses4",false);

            if (list.contains(wrapperToSearchFor)) {

                alert4.setImageResource(R.drawable.alarm_white);
                    alert4.setTag(R.drawable.alarm_white);

                    tinydb.putBoolean("alertpresses4",true);
                }
            else
            {
                alert4.setImageResource(R.drawable.alarm_black1);
                alert4.setTag(R.drawable.alarm_black1);
            }

     /*   if (day1>day) {
            row4.setBackgroundColor(R.color.colorPrimaryDark);
        }
        if (day1==day) {
            if (hour1>hour) {
                row4.setBackgroundColor(R.color.colorPrimaryDark);
            }
        }

      */
        }
        if (row5.getVisibility()==View.VISIBLE&&!alert5.getTag().equals(R.drawable.find_black_24dp)) {

            teamname = homet5.getText().toString();
            Date date = null;
            try {
                date = simpleDateFormat.parse(date5.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.setTime(date);

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour = Integer.parseInt(time5.getText().toString().substring(0, 2));
            min = Integer.parseInt(time5.getText().toString().substring(3));

            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(5)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(5)};
            tinydb.putBoolean("alertpresses5",false);

            if (list.contains(wrapperToSearchFor)) {

                alert5.setImageResource(R.drawable.alarm_white);
                    alert5.setTag(R.drawable.alarm_white);

                    tinydb.putBoolean("alertpresses5",true);
                }
            else
            {
                alert5.setImageResource(R.drawable.alarm_black1);
                alert5.setTag(R.drawable.alarm_black1);
            }

        }

        if (row6.getVisibility()==View.VISIBLE&&!alert6.getTag().equals(R.drawable.find_black_24dp)) {

            teamname = homet6.getText().toString();
            Date date = null;
            try {
                date = simpleDateFormat.parse(date6.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.setTime(date);

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour = Integer.parseInt(time6.getText().toString().substring(0, 2));
            min = Integer.parseInt(time6.getText().toString().substring(3));

            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(6)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(6)};
            tinydb.putBoolean("alertpresses6",false);

            if (list.contains(wrapperToSearchFor)) {

                alert6.setImageResource(R.drawable.alarm_white);
                    alert6.setTag(R.drawable.alarm_white);

                    tinydb.putBoolean("alertpresses6",true);
                }
            else
            {
                alert6.setImageResource(R.drawable.alarm_black1);
                alert6.setTag(R.drawable.alarm_black1);
            }
            }


        if (row7.getVisibility()==View.VISIBLE&&!alert7.getTag().equals(R.drawable.find_black_24dp)) {

            teamname = homet7.getText().toString();
            Date date = null;
            try {
                date = simpleDateFormat.parse(date7.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.setTime(date);

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour = Integer.parseInt(time7.getText().toString().substring(0, 2));
            min = Integer.parseInt(time7.getText().toString().substring(3));

            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(7)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(7)};
            tinydb.putBoolean("alertpresses7",false);

            if (list.contains(wrapperToSearchFor)) {

                alert7.setImageResource(R.drawable.alarm_white);
                    alert7.setTag(R.drawable.alarm_white);

                    tinydb.putBoolean("alertpresses7",true);
                }
            else
            {
                alert7.setImageResource(R.drawable.alarm_black1);
                alert7.setTag(R.drawable.alarm_black1);
            }

        }
        if (row8.getVisibility()==View.VISIBLE&&!alert8.getTag().equals(R.drawable.find_black_24dp)) {

            teamname = homet8.getText().toString();
            Date date = null;
            try {
                date = simpleDateFormat.parse(date8.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.setTime(date);

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour = Integer.parseInt(time8.getText().toString().substring(0, 2));
            min = Integer.parseInt(time8.getText().toString().substring(3));

            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(8)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(8)};
            tinydb.putBoolean("alertpresses8",false);

            if (list.contains(wrapperToSearchFor)) {

                alert8.setImageResource(R.drawable.alarm_white);
                    alert8.setTag(R.drawable.alarm_white);

                    tinydb.putBoolean("alertpresses8",true);
                }
            else
            {
                alert8.setImageResource(R.drawable.alarm_black1);
                alert8.setTag(R.drawable.alarm_black1);
            }
            }

        if (row9.getVisibility()==View.VISIBLE&&!alert9.getTag().equals(R.drawable.find_black_24dp)) {

            teamname = homet9.getText().toString();
            Date date = null;
            try {
                date = simpleDateFormat.parse(date9.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.setTime(date);

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour = Integer.parseInt(time9.getText().toString().substring(0, 2));
            min = Integer.parseInt(time9.getText().toString().substring(3));

            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(9)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(9)};
            tinydb.putBoolean("alertpresses9",false);

            if (list.contains(wrapperToSearchFor)) {

                alert9.setImageResource(R.drawable.alarm_white);
                    alert9.setTag(R.drawable.alarm_white);

                    tinydb.putBoolean("alertpresses9",true);


            }
            else
            {
                alert9.setImageResource(R.drawable.alarm_black1);
                alert9.setTag(R.drawable.alarm_black1);
            }
        }
      /*  if (day1>day) {
            row9.setBackgroundColor(R.color.colorPrimaryDark);
        }
        if (day1==day) {
            if (hour1>hour) {
                row9.setBackgroundColor(R.color.colorPrimaryDark);
            }
        }

       */
        if (row10.getVisibility()==View.VISIBLE&&!alert10.getTag().equals(R.drawable.find_black_24dp)) {

            teamname = homet10.getText().toString();
            Date date = null;
            try {
                date = simpleDateFormat.parse(date10.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.setTime(date);

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour = Integer.parseInt(time10.getText().toString().substring(0, 2));
            min = Integer.parseInt(time10.getText().toString().substring(3));

            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(10)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(10)};
            tinydb.putBoolean("alertpresses10",false);


            if (list.contains(wrapperToSearchFor)) {

                    alert10.setImageResource(R.drawable.alarm_white);
                    alert10.setTag(R.drawable.alarm_white);

                    tinydb.putBoolean("alertpresses10",true);

                }
            else
            {
                alert10.setImageResource(R.drawable.alarm_black1);
                alert10.setTag(R.drawable.alarm_black1);
            }
            }

     /*   if (day1>day) {
            row10.setBackgroundColor(R.color.colorPrimaryDark);
        }
        if (day1==day) {
            if (hour1>hour) {
                row10.setBackgroundColor(R.color.colorPrimaryDark);
            }
        }

      */
        if (row11.getVisibility()==View.VISIBLE&&!alert11.getTag().equals(R.drawable.find_black_24dp)) {

            teamname = homet11.getText().toString();
            Date date = null;
            try {
                date = simpleDateFormat.parse(date11.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.setTime(date);

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour = Integer.parseInt(time11.getText().toString().substring(0, 2));
            min = Integer.parseInt(time11.getText().toString().substring(3));

            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(11)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(11)};
            tinydb.putBoolean("alertpresses11",false);

            if (list.contains(wrapperToSearchFor)) {

                    alert11.setImageResource(R.drawable.alarm_white);
                    alert11.setTag(R.drawable.alarm_white);

                    tinydb.putBoolean("alertpresses11",true);
                }
            else
            {
                alert11.setImageResource(R.drawable.alarm_black1);
                alert11.setTag(R.drawable.alarm_black1);
            }
            }

     /*   if (day1>day) {
            row11.setBackgroundColor(R.color.colorPrimaryDark);
        }
        if (day1==day) {
            if (hour1>hour) {
                row11.setBackgroundColor(R.color.colorPrimaryDark);
            }
        }

      */
        if (row12.getVisibility()==View.VISIBLE&&!alert12.getTag().equals(R.drawable.find_black_24dp)) {
            teamname = homet12.getText().toString();
            Date date = null;
            try {
                date = simpleDateFormat.parse(date12.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.setTime(date);

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour = Integer.parseInt(time12.getText().toString().substring(0, 2));
            min = Integer.parseInt(time12.getText().toString().substring(3));
            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(12)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(12)};
            tinydb.putBoolean("alertpresses12",false);

            if (list.contains(wrapperToSearchFor)) {

                    alert12.setImageResource(R.drawable.alarm_white);
                    alert12.setTag(R.drawable.alarm_white);

                    tinydb.putBoolean("alertpresses12",true);
                }
            else
            {
                alert12.setImageResource(R.drawable.alarm_black1);
                alert12.setTag(R.drawable.alarm_black1);
            }
            }

          /*  if (day1>day) {
                row12.setBackgroundColor(R.color.colorPrimaryDark);
            }
            if (day1==day) {
                if (hour1>hour) {
                    row12.setBackgroundColor(R.color.colorPrimaryDark);
                }
            }

           */


        if (row13.getVisibility()==View.VISIBLE&&!alert13.getTag().equals(R.drawable.find_black_24dp)) {
            teamname = homet13.getText().toString();
            Date date = null;
            try {
                date = simpleDateFormat.parse(date13.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.setTime(date);

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour = Integer.parseInt(time13.getText().toString().substring(0, 2));
            min = Integer.parseInt(time13.getText().toString().substring(3));

            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(13)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(13)};
            tinydb.putBoolean("alertpresses13",false);

                if (list.contains(wrapperToSearchFor)) {

                alert13.setImageResource(R.drawable.alarm_white);
                    alert13.setTag(R.drawable.alarm_white);

                    tinydb.putBoolean("alertpresses13",true);

                }
                else
                {
                    alert13.setImageResource(R.drawable.alarm_black1);
                    alert13.setTag(R.drawable.alarm_black1);
                }
            }

       /*     if (day1>day) {
                row13.setBackgroundColor(R.color.colorPrimaryDark);
            }
            if (day1==day) {
                if (hour1>hour) {
                    row13.setBackgroundColor(R.color.colorPrimaryDark);
                }
            }

        */


        if (row14.getVisibility()==View.VISIBLE&&!alert14.getTag().equals(R.drawable.find_black_24dp)) {
            teamname = homet14.getText().toString();
            Date date = null;
            try {
                date = simpleDateFormat.parse(date14.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.setTime(date);

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
            hour = Integer.parseInt(time14.getText().toString().substring(0, 2));
            min = Integer.parseInt(time14.getText().toString().substring(3));
            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(14)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
            string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(14)};
            tinydb.putBoolean("alertpresses14",false);

                if (list.contains(wrapperToSearchFor)) {

                alert14.setImageResource(R.drawable.alarm_white);
                    alert14.setTag(R.drawable.alarm_white);

                    tinydb.putBoolean("alertpresses14",true);
                }
                else
                {
                    alert14.setImageResource(R.drawable.alarm_black1);
                    alert14.setTag(R.drawable.alarm_black1);
                }
            }

          /*  if (day1>day) {
                row14.setBackgroundColor(R.color.colorPrimaryDark);
            }
            if (day1==day) {
                if (hour1>hour) {
                    row14.setBackgroundColor(R.color.colorPrimaryDark);
                }
            }

           */

        if (row15.getVisibility()==View.VISIBLE&&!alert15.getTag().equals(R.drawable.find_black_24dp)) {
            teamname = homet15.getText().toString();
            Date date = null;
            try {
                date = simpleDateFormat.parse(date15.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.setTime(date);

            day=cal.get(Calendar.DAY_OF_MONTH);
            month=cal.get(Calendar.MONTH)+1;
            year=cal.get(Calendar.YEAR);
    hour = Integer.parseInt(time15.getText().toString().substring(0, 2));
    min = Integer.parseInt(time15.getText().toString().substring(3));
            String[] arrayToSearchFor = {String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(15)};
            ArrayWrapper wrapperToSearchFor = new ArrayWrapper(arrayToSearchFor);
    string = new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(15)};
            tinydb.putBoolean("alertpresses15",false);

                if (list.contains(wrapperToSearchFor)) {

                alert15.setImageResource(R.drawable.alarm_white);
            alert15.setTag(R.drawable.alarm_white);

            tinydb.putBoolean("alertpresses15",true);
        }
                else
                {
                    alert15.setImageResource(R.drawable.alarm_black1);
                    alert15.setTag(R.drawable.alarm_black1);
                }
    }
 /*   if (day1>day) {
        row15.setBackgroundColor(R.color.colorPrimaryDark);
    }
    if (day1==day) {
        if (hour1>hour) {
            row15.setBackgroundColor(R.color.colorPrimaryDark);
        }
    }

  */

    }

    public void showCustomAlert()
    {

     
    }

public synchronized void  addallThread () {

    Thread myThread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            mUiHandler.post(new Runnable() {
                @Override
                public void run() {
                    addall.setImageResource(R.drawable.ic_alarm_on_red);
                    addall.animate().setDuration(600);
                }
            });
            try {
                TimeUnit.MILLISECONDS.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mUiHandler.post(new Runnable() {
                @Override
                public void run() {
                    addall.setImageResource(R.drawable.ic_alarm_on_vit);
                    addall.animate().setDuration(600);

                }
            });
        }
    });
    myThread1.start();


}
    public synchronized void  remallThread () {

        Thread myThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mUiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        remall.setImageResource(R.drawable.ic_alarm_off_red);
                        remall.animate().setDuration(600);

                    }
                });
                mUiHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            TimeUnit.MILLISECONDS.sleep(600);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });


                mUiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        remall.setImageResource(R.drawable.ic_alarm_off_vit);
                        remall.animate().setDuration(600);

                    }
                });
            }
        });
        myThread1.start();

    }

    public static String shortname2 (String longname){
        ArrayList<String> shortnames= new ArrayList<String>();
        String result="";
        shortnames.add(0,"0");
        shortnames.add(1,"ANA");
        shortnames.add(2,"ARIZONA");
        shortnames.add(3,"BOS");
        shortnames.add(4,"BUF");
        shortnames.add(5,"CAR");
        shortnames.add(6,"CGY");
        shortnames.add(7,"CHI");
        shortnames.add(8,"CBJ");
        shortnames.add(9,"COL");
        shortnames.add(10,"DAL");
        shortnames.add(11,"DET");
        shortnames.add(12,"EDM");
        shortnames.add(13,"FLA");
        shortnames.add(14,"LA");
        shortnames.add(15,"MIN");
        shortnames.add(16,"MTL");
        shortnames.add(17,"NSH");
        shortnames.add(18,"NJD");
        shortnames.add(19,"NYI");
        shortnames.add(20,"NYR");
        shortnames.add(21,"OTT");
        shortnames.add(22,"PHI");
        shortnames.add(23,"PIT");
        shortnames.add(24,"SEN");
        shortnames.add(25,"SJ");
        shortnames.add(26,"STL");
        shortnames.add(27,"TampaBay");
        shortnames.add(28,"TOR");
        shortnames.add(29,"VAN");
        shortnames.add(30,"VEGAS");
        shortnames.add(31,"WPG");
        shortnames.add(32,"WSH");

        if (longname.equals("Anaheim Ducks"))  result=shortnames.get(1);
        if (longname.equals("Arizona Coyotes"))  result=shortnames.get(2);
        if (longname.equals("Boston Bruins"))  result=shortnames.get(3);
        if (longname.equals("Buffalo Sabres"))  result=shortnames.get(4);
        if (longname.equals("Carolina Hurricanes"))  result=shortnames.get(5);
        if (longname.equals("Calgary Flames"))  result=shortnames.get(6);
        if (longname.equals("Chicago Blackhawks"))  result=shortnames.get(7);
        if (longname.equals("Columbus Blue Jackets"))  result=shortnames.get(8);
        if (longname.equals("Colorado Avalanche"))  result=shortnames.get(9);
        if (longname.equals("Dallas Stars"))  result=shortnames.get(10);
        if (longname.equals("Detroit Red Wings"))  result=shortnames.get(11);
        if (longname.equals("Edmonton Oilers"))  result=shortnames.get(12);
        if (longname.equals("Florida Panthers"))  result=shortnames.get(13);
        if (longname.equals("Los Angeles Kings"))  result=shortnames.get(14);
        if (longname.equals("Minnesota Wild"))  result=shortnames.get(15);
        if (longname.equals("Montreal Canadiens"))  result=shortnames.get(16);
        if (longname.equals("Nashville Predators"))  result=shortnames.get(17);
        if (longname.equals("New Jersey Devils"))  result=shortnames.get(18);
        if (longname.equals("New York Islanders"))  result=shortnames.get(19);
        if (longname.equals("New York Rangers"))  result=shortnames.get(20);
        if (longname.equals("Ottawa Senators"))  result=shortnames.get(21);
        if (longname.equals("Philadelphia Flyers"))  result=shortnames.get(22);
        if (longname.equals("Pittsburgh Penguins"))  result=shortnames.get(23);
        if (longname.equals("Ottawa Senators (original)"))  result=shortnames.get(24);
        if (longname.equals("San Jose Sharks"))  result=shortnames.get(25);
        if (longname.equals("St. Louis Blues"))  result=shortnames.get(26);
        if (longname.equals("Tampa Bay Lightning"))  result=shortnames.get(27);
        if (longname.equals("Toronto Maple Leafs"))  result=shortnames.get(28);
        if (longname.equals("Vancouver Canucks"))  result=shortnames.get(29);
        if (longname.equals("Vegas Golden Knights"))  result=shortnames.get(30);
        if (longname.equals("Winnipeg Jets"))  result=shortnames.get(31);
        if (longname.equals("Washington Capitals"))  result=shortnames.get(32);
        return result;
    }
public static String shortname (String longname){
     ArrayList<String> shortnames= new ArrayList<String>();
     String result="";
    shortnames.add(0,"0");
    shortnames.add(1,"ANA");
    shortnames.add(2,"ARI");
    shortnames.add(3,"BOS");
    shortnames.add(4,"BUF");
    shortnames.add(5,"CAR");
    shortnames.add(6,"CGY");
    shortnames.add(7,"CHI");
    shortnames.add(8,"CBJ");
    shortnames.add(9,"COL");
    shortnames.add(10,"DAL");
    shortnames.add(11,"DET");
    shortnames.add(12,"EDM");
    shortnames.add(13,"FLA");
    shortnames.add(14,"LAK");
    shortnames.add(15,"MIN");
    shortnames.add(16,"MTL");
    shortnames.add(17,"NSH");
    shortnames.add(18,"NJD");
    shortnames.add(19,"NYI");
    shortnames.add(20,"NYR");
    shortnames.add(21,"OTT");
    shortnames.add(22,"PHI");
    shortnames.add(23,"PIT");
    shortnames.add(24,"SEN");
    shortnames.add(25,"SJS");
    shortnames.add(26,"STL");
    shortnames.add(27,"TBL");
    shortnames.add(28,"TOR");
    shortnames.add(29,"VAN");
    shortnames.add(30,"VGK");
    shortnames.add(31,"WPG");
    shortnames.add(32,"WSH");

    if (longname.equals("Anaheim Ducks"))  result=shortnames.get(1);
    if (longname.equals("Arizona Coyotes"))  result=shortnames.get(2);
    if (longname.equals("Boston Bruins"))  result=shortnames.get(3);
    if (longname.equals("Buffalo Sabres"))  result=shortnames.get(4);
    if (longname.equals("Carolina Hurricanes"))  result=shortnames.get(5);
    if (longname.equals("Calgary Flames"))  result=shortnames.get(6);
    if (longname.equals("Chicago Blackhawks"))  result=shortnames.get(7);
    if (longname.equals("Columbus Blue Jackets"))  result=shortnames.get(8);
    if (longname.equals("Colorado Avalanche"))  result=shortnames.get(9);
    if (longname.equals("Dallas Stars"))  result=shortnames.get(10);
    if (longname.equals("Detroit Red Wings"))  result=shortnames.get(11);
    if (longname.equals("Edmonton Oilers"))  result=shortnames.get(12);
    if (longname.equals("Florida Panthers"))  result=shortnames.get(13);
    if (longname.equals("Los Angeles Kings"))  result=shortnames.get(14);
    if (longname.equals("Minnesota Wild"))  result=shortnames.get(15);
    if (longname.equals("Montreal Canadiens"))  result=shortnames.get(16);
    if (longname.equals("Nashville Predators"))  result=shortnames.get(17);
    if (longname.equals("New Jersey Devils"))  result=shortnames.get(18);
    if (longname.equals("New York Islanders"))  result=shortnames.get(19);
    if (longname.equals("New York Rangers"))  result=shortnames.get(20);
    if (longname.equals("Ottawa Senators"))  result=shortnames.get(21);
    if (longname.equals("Philadelphia Flyers"))  result=shortnames.get(22);
    if (longname.equals("Pittsburgh Penguins"))  result=shortnames.get(23);
    if (longname.equals("Ottawa Senators (original)"))  result=shortnames.get(24);
    if (longname.equals("San Jose Sharks"))  result=shortnames.get(25);
    if (longname.equals("St. Louis Blues"))  result=shortnames.get(26);
    if (longname.equals("Tampa Bay Lightning"))  result=shortnames.get(27);
    if (longname.equals("Toronto Maple Leafs"))  result=shortnames.get(28);
    if (longname.equals("Vancouver Canucks"))  result=shortnames.get(29);
    if (longname.equals("Vegas Golden Knights"))  result=shortnames.get(30);
    if (longname.equals("Winnipeg Jets"))  result=shortnames.get(31);
    if (longname.equals("Washington Capitals"))  result=shortnames.get(32);
    return result;
}

    public void goToWebPage(String yourUrl)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(yourUrl));
        startActivity(intent);
    }
    public synchronized void cardflip (TableRow v,ImageView v1,TextView t,Integer s1,Integer s2, String teamboofer) {

        if (!t.getText().toString().contains(":")) {

            v.animate().withLayer()
                    .rotationY(90)
                    .setDuration(400)
                    .withEndAction(
                            new Runnable() {
                                @Override public void run() {
                                    //v1.setVisibility(View.GONE);
                                    String boofer = t.getText().toString();
                                    t.setText(shortname(FavTeam)+" "+s1+":"+s2+" "+shortname(boofer));
                                    float scale = getApplicationContext().getResources().getDisplayMetrics().density;
                                    float distance = v.getCameraDistance() * (scale + (scale / 3));
                                    v.setCameraDistance(distance * scale);
                                    v.setRotationY(-90);
                                    v.animate().withLayer()
                                            .rotationY(0)
                                            .setDuration(400)
                                            .start();
                                }
                            }
                    ).start();
        }

        if (t.getText().toString().contains(":")) {
            v.animate().withLayer()
                    .rotationY(90)
                    .setDuration(400)
                    .withEndAction(
                            new Runnable() {
                                @Override public void run() {
                                    //v1.setVisibility(View.GONE);
                                    t.setText(teamboofer);
                                    float scale = getApplicationContext().getResources().getDisplayMetrics().density;
                                    float distance = v.getCameraDistance() * (scale + (scale / 3));
                                    v.setCameraDistance(distance * scale);
                                    v.setRotationY(-90);
                                    v.animate().withLayer()
                                            .rotationY(0)
                                            .setDuration(400)
                                            .start();
                                }
                            }
                    ).start();        }


    }
    public synchronized void  animationN (TableRow row) {

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                mUiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        row.animate().scaleY((float) 0.8).scaleX((float) 0.8).setDuration(200);

                    }
                });

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mUiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        row.animate().scaleX(1).scaleY(1).setDuration(200);

                    }
                });
            }
        });
        myThread.start();

    }


    public boolean isServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings,menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.icon_one) {
            Toast.makeText(MainActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            finish();



            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case R.id.nav_message:
                intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_chat:
                intent = new Intent(MainActivity.this, StandingsActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_profile:
             ShowPopupSettings();
                break;

            case R.id.nav_send:
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void ifHuaweiAlert() {
        final SharedPreferences settings = getSharedPreferences("ProtectedApps", MODE_PRIVATE);
        final String saveIfSkip = "skipProtectedAppsMessage";
        boolean skipMessage = settings.getBoolean(saveIfSkip, false);
        if (!skipMessage) {
            final SharedPreferences.Editor editor = settings.edit();
            Intent intent = new Intent();
            intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity");
            if (isCallable(intent)) {
                final AppCompatCheckBox dontShowAgain = new AppCompatCheckBox(this);
                dontShowAgain.setText("Do not show again");
                dontShowAgain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        editor.putBoolean(saveIfSkip, isChecked);
                        editor.apply();
                    }
                });

                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Huawei Protected Apps")
                        .setMessage(String.format("%s requires to be enabled in 'Protected Apps' to function properly.%n", getString(R.string.app_name)))
                        .setView(dontShowAgain)
                        .setPositiveButton("Protected Apps", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                huaweiProtectedApps();
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, null)
                        .show();
            } else {
                editor.putBoolean(saveIfSkip, true);
                editor.apply();
            }
        }
    }

    private boolean isCallable(Intent intent) {
        List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    private void huaweiProtectedApps() {
        try {
            String cmd = "am start -n com.huawei.systemmanager/.optimize.process.ProtectActivity";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                cmd += " --user " + getUserSerial();
            }
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ignored) {
        }
    }

    private String getUserSerial() {
        //noinspection ResourceType
        Object userManager = getSystemService("user");
        if (null == userManager) return "";

        try {
            Method myUserHandleMethod = android.os.Process.class.getMethod("myUserHandle", (Class<?>[]) null);
            Object myUserHandle = myUserHandleMethod.invoke(android.os.Process.class, (Object[]) null);
            Method getSerialNumberForUser = userManager.getClass().getMethod("getSerialNumberForUser", myUserHandle.getClass());
            Long userSerial = (Long) getSerialNumberForUser.invoke(userManager, myUserHandle);
            if (userSerial != null) {
                return String.valueOf(userSerial);
            } else {
                return "";
            }
        } catch (NoSuchMethodException | IllegalArgumentException | InvocationTargetException | IllegalAccessException ignored) {
        }
        return "";
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

       // if (savedInstanceState == null) {
       //     getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
       //             new MessageFragment()).commit();
       //     navigationView.setCheckedItem(R.id.nav_message);
      //  }


        ifHuaweiAlert();  //protected app huawei


        if (Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
            StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        final Calendar c;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            c = Calendar.getInstance();
            month = c.get(Calendar.MONTH);
            year = c.get(Calendar.YEAR);
            day = c.get(Calendar.DAY_OF_MONTH);

        }

             if(!isServiceRunning(MessageService.class)) {
            startService(new Intent(this, MessageService.class));
        }

       /* toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
             getSupportActionBar().setDisplayShowTitleEnabled(false);
             getSupportActionBar().setDisplayShowCustomEnabled(true);

        */





        table = (TableLayout) findViewById(R.id.table);
        table.setVisibility(View.GONE);
        teamlogo = (ImageView) findViewById(R.id.imageView);
        teamlogo.setFocusable(true);
        teamlogo.clearFocus();
        mTextMessage = (TextView) findViewById(R.id.message);
        date1 = (TextView) findViewById(R.id.textView23);
        date2 = (TextView) findViewById(R.id.textView18);
        date3 = (TextView) findViewById(R.id.textView19);
        date4 = (TextView) findViewById(R.id.textView20);
        date5 = (TextView) findViewById(R.id.textView21);
        date6 = (TextView) findViewById(R.id.textView22);
        date7 = (TextView) findViewById(R.id.textView42);
        date8 = (TextView) findViewById(R.id.textView45);
        date9 = (TextView) findViewById(R.id.textView48);
        date10 = (TextView) findViewById(R.id.textView51);
        date11 = (TextView) findViewById(R.id.textView54);
        date12 = (TextView) findViewById(R.id.textView57);
        date13 = (TextView) findViewById(R.id.textView60);
        date14 = (TextView) findViewById(R.id.textView63);
        date15 = (TextView) findViewById(R.id.textView66);

        homet1 = (TextView) findViewById(R.id.textView17);
        homet2 = (TextView) findViewById(R.id.textView25);
        homet3 = (TextView) findViewById(R.id.textView26);
        homet4 = (TextView) findViewById(R.id.textView27);
        homet5 = (TextView) findViewById(R.id.textView28);
        homet6 = (TextView) findViewById(R.id.textView29);
        homet7 = (TextView) findViewById(R.id.textView43);
        homet8 = (TextView) findViewById(R.id.textView46);
        homet9 = (TextView) findViewById(R.id.textView49);
        homet10 = (TextView) findViewById(R.id.textView52);
        homet11 = (TextView) findViewById(R.id.textView55);
        homet12 = (TextView) findViewById(R.id.textView58);
        homet13 = (TextView) findViewById(R.id.textView61);
        homet14 = (TextView) findViewById(R.id.textView64);
        homet15 = (TextView) findViewById(R.id.textView67);

        Button but = (Button) findViewById(R.id.button2);

        time1 = (TextView) findViewById(R.id.textView36);
        time2 = (TextView) findViewById(R.id.textView37);
        time3 = (TextView) findViewById(R.id.textView38);
        time4 = (TextView) findViewById(R.id.textView39);
        time5 = (TextView) findViewById(R.id.textView40);
        time6 = (TextView) findViewById(R.id.textView41);
        time7 = (TextView) findViewById(R.id.textView44);
        time8 = (TextView) findViewById(R.id.textView47);
        time9 = (TextView) findViewById(R.id.textView50);
        time10 = (TextView) findViewById(R.id.textView53);
        time11 = (TextView) findViewById(R.id.textView56);
        time12 = (TextView) findViewById(R.id.textView59);
        time13 = (TextView) findViewById(R.id.textView62);
        time14 = (TextView) findViewById(R.id.textView65);
        time15 = (TextView) findViewById(R.id.textView68);

        today = (TextView) findViewById(R.id.today);
        row1 = (TableRow) findViewById(R.id.row1);
        row2 = (TableRow) findViewById(R.id.row2);
        row3 = (TableRow) findViewById(R.id.row3);
        row4 = (TableRow) findViewById(R.id.row4);
        row5 = (TableRow) findViewById(R.id.row5);
        row6 = (TableRow) findViewById(R.id.row6);
        row7 = (TableRow) findViewById(R.id.row7);
        row8 = (TableRow) findViewById(R.id.row8);
        row9 = (TableRow) findViewById(R.id.row9);
        row10 = (TableRow) findViewById(R.id.row10);
        row11 = (TableRow) findViewById(R.id.row11);
        row12 = (TableRow) findViewById(R.id.row12);
        row13 = (TableRow) findViewById(R.id.row13);
        row14 = (TableRow) findViewById(R.id.row14);
        row15 = (TableRow) findViewById(R.id.row15);

        homeornot1=(ImageView) findViewById(R.id.imageView401);
        homeornot2=(ImageView) findViewById(R.id.imageView402);
        homeornot3=(ImageView) findViewById(R.id.imageView403);
        homeornot4=(ImageView) findViewById(R.id.imageView404);
        homeornot5=(ImageView) findViewById(R.id.imageView405);
        homeornot6=(ImageView) findViewById(R.id.imageView406);
        homeornot7=(ImageView) findViewById(R.id.imageView407);
        homeornot8=(ImageView) findViewById(R.id.imageView408);
        homeornot9=(ImageView) findViewById(R.id.imageView409);
        homeornot10=(ImageView) findViewById(R.id.imageView410);
        homeornot11=(ImageView) findViewById(R.id.imageView411);
        homeornot12=(ImageView) findViewById(R.id.imageView412);
        homeornot13=(ImageView) findViewById(R.id.imageView413);
        homeornot14=(ImageView) findViewById(R.id.imageView414);
        homeornot15=(ImageView) findViewById(R.id.imageView415);


        alert1 = (ImageView) findViewById(R.id.imageView300);
        alert2 = (ImageView) findViewById(R.id.imageView301);
        alert3 = (ImageView) findViewById(R.id.imageView302);
        alert4 = (ImageView) findViewById(R.id.imageView303);
        alert5 = (ImageView) findViewById(R.id.imageView304);
        alert6 = (ImageView) findViewById(R.id.imageView305);
        alert7 = (ImageView) findViewById(R.id.imageView306);
        alert8 = (ImageView) findViewById(R.id.imageView307);
        alert9 = (ImageView) findViewById(R.id.imageView308);
        alert10 = (ImageView) findViewById(R.id.imageView309);
        alert11 = (ImageView) findViewById(R.id.imageView310);
        alert12 = (ImageView) findViewById(R.id.imageView311);
        alert13 = (ImageView) findViewById(R.id.imageView312);
        alert14 = (ImageView) findViewById(R.id.imageView313);
        alert15 = (ImageView) findViewById(R.id.imageView314);
        remall = (ImageView) findViewById(R.id.imageView501);
        info = (ImageView) findViewById(R.id.imageView502);
        results = (ImageView) findViewById(R.id.imageView503);
        addall = (ImageView) findViewById(R.id.imageView504);
        SearchView searchplayers = (SearchView) findViewById(R.id.search); // inititate a search view
        searchplayers.clearFocus();


        alert1.setTag("0");
        alert2.setTag("0");
        alert3.setTag("0");
        alert4.setTag("0");
        alert5.setTag("0");
        alert6.setTag("0");
        alert7.setTag("0");
        alert8.setTag("0");
        alert9.setTag("0");
        alert10.setTag("0");
        alert11.setTag("0");
        alert12.setTag("0");
        alert13.setTag("0");
        alert14.setTag("0");
        alert15.setTag("0");


        Buttonexit = (Button) findViewById(R.id.buttonexit);
        Buttonlist = (Button) findViewById(R.id.buttonlist);
        loading = (ProgressBar) findViewById(R.id.progressBar_cyclic);
        scroll1 = (ScrollView) findViewById(R.id.scroll);

        onEng.add("0"); onRus.add("0");
        onEng.add("Anaheim Ducks");   onRus.add("Анахайм");
        onEng.add("Winnipeg Jets");   onRus.add("Виннипег");
        onEng.add("Boston Bruins");onRus.add("Бостон");
        onEng.add("Buffalo Sabres");onRus.add("Баффало");
        onEng.add("Calgary Flames");onRus.add("Калгари");
        onEng.add("Carolina Hurricanes");onRus.add("Каролина");
        onEng.add("Chicago Blackhawks");onRus.add("Чикаго");
        onEng.add("Colorado Avalanche");onRus.add("Колорадо");
        onEng.add("Dallas Stars");onRus.add("Даллас");
        onEng.add("Detroit Red Wings");onRus.add("Детройт");
        onEng.add("Edmonton Oilers");onRus.add("Эдмонтон");
        onEng.add("Florida Panthers");onRus.add("Флорида");
        onEng.add("Montreal Canadiens");onRus.add("Монреаль");
        onEng.add("Nashville Predators");onRus.add("Нэшвилл");
        onEng.add("New Jersey Devils");onRus.add("Нью-Джерси");
        onEng.add("New York Rangers");onRus.add("Рейнджерс");
        onEng.add("New York Islanders");onRus.add("Айлендерс");
        onEng.add("Los Angeles Kings");onRus.add("Лос-Анджелес");
        onEng.add("Ottawa Senators");onRus.add("Оттава");
        onEng.add("Pittsburgh Penguins");onRus.add("Питтсбург");
        onEng.add("Philadelphia Flyers");onRus.add("Филадельфия");
        onEng.add("Arizona Coyotes");onRus.add("Аризона");
        onEng.add("San Jose Sharks");onRus.add("Сан-Хосе");
        onEng.add("St. Louis Blues");onRus.add("Сент-Луис");
        onEng.add("Toronto Maple Leafs");onRus.add("Торонто");
        onEng.add("Tampa Bay Lightning");onRus.add("Тампа-Бэй");
        onEng.add("Vancouver Canucks");onRus.add("Ванкувер");
        onEng.add("Washington Capitals");onRus.add("Вашингтон");
        onEng.add("Minnesota Wild");onRus.add("Миннесота");
        onEng.add("Columbus Blue Jackets");onRus.add("Коламбус");
        onEng.add("Vegas Golden Knights");onRus.add("Вегас");


        alarms=getAlarmList(getApplicationContext());
        AlarmsBigList=getBigList2(getApplicationContext());
        TinyDB tinydb = new TinyDB(getApplicationContext());
        loading.setVisibility(View.VISIBLE);

        CalendarV();


        searchplayers.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                query1 = query;

                FunnyCrawler2 obj = new FunnyCrawler2();
                result1 = obj.getDataFromGoogle(String.valueOf(query));
                if (result1 == null) {
                    Toast.makeText(MainActivity.this, "No results.", Toast.LENGTH_LONG).show();
                    loading.setVisibility(View.GONE);
                    table.setVisibility(View.VISIBLE);
                    return false;
                } else {
                    String playerURL = "https://www.foxsports.com" + result1.get(0);
                    System.out.println(playerURL);
                    searchplayers.clearFocus();
                    searchplayers.setVisibility(View.INVISIBLE);
                    searchplayers.setVisibility(View.VISIBLE);
                    loading.setVisibility(View.VISIBLE);
                    table.setVisibility(View.GONE);

                    searchplayers.post(new Runnable() {
                        @Override
                        public void run() {
                            searchplayers.clearFocus();

                            ArrayList<String> result = null;
                            try {
                                result = new Task4(getApplicationContext(), playerURL).execute().get();


                            } catch (ExecutionException e) {
                                System.out.println("task3 get 1");

                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                System.out.println("task3 get 2");

                                e.printStackTrace();
                            }

                            if (result==null) {
                                Toast.makeText(MainActivity.this, "No results.", Toast.LENGTH_LONG).show();
                                loading.setVisibility(View.GONE);
                                table.setVisibility(View.VISIBLE);
                            }
                            else{
                            try {
                                if (result != null) {
                                    age = result.get(6);
                                    positiononice = result.get(8);
                                    height1 = result.get(9);
                                    weight = result.get(10);
                                    country = result.get(7);
                                    team = result.get(0);
                                    GP = result.get(1);
                                    G = result.get(2);
                                    A = result.get(3);
                                    P = result.get(4);
                                    plusminus = result.get(5);
                                    playername = result.get(11);
                                    if (positiononice.equals("Goaltender")) {
                                        saveprocent = result.get(12);
                                    }
                                }
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("IO exeption111");

                                Context context = getApplicationContext();
                                // Create layout inflator object to inflate toast.xml file
                                LayoutInflater inflater = getLayoutInflater();

                                // Call toast.xml file for toast layout
                                View toast = inflater.inflate(R.layout.toasts, null);

                                Toast toast1 = new Toast(context);
                                // Set layout to toast
                                toast1.setView(toast);
                                toast1.setGravity(Gravity.CENTER,
                                        0, 0);
                                toast1.setDuration(Toast.LENGTH_LONG);
                                toast1.show();
                            }


                            try {
                                ShowPopupPlayer();
                            } catch
                            (IndexOutOfBoundsException e) {
                                System.out.println("show popup exeption");

                            }

                            loading.setVisibility(View.GONE);
                            table.setVisibility(View.VISIBLE);

                        }
                        }
                    });

                }
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                    return true;
                }

                @Override
                public boolean onQueryTextChange (String newText){
                    return false;
                }
            });

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        info.setClickable(true);
        info.setOnClickListener(new View.OnClickListener() {

                                      @Override
                                      public void onClick(View v) {
                                          loading.setVisibility(View.VISIBLE);
                                          table.setVisibility(View.GONE);

                                          info.post(new Runnable() {
                                              @Override
                                              public void run() {

                                                  ArrayList<String> result = null;
                                                  try {
                                                      result = new Task2(getApplicationContext()).execute().get();
                                                  } catch (ExecutionException e) {
                                                      System.out.println("task2 get 1");

                                                      e.printStackTrace();
                                                  } catch (InterruptedException e) {
                                                      System.out.println("task2 get 2");

                                                      e.printStackTrace();
                                                  }

                                                  try{
                                                      winlost=String.valueOf(result.get(0));
                                                      position=String.valueOf(result.get(1));
                                                      points=String.valueOf(result.get(2));
                                                      strk=String.valueOf(result.get(3));
                                                  } catch (IndexOutOfBoundsException e){
                                                      System.out.println("IO exeption111");

                                                      Context context = getApplicationContext();
                                                      // Create layout inflator object to inflate toast.xml file
                                                      LayoutInflater inflater = getLayoutInflater();

                                                      // Call toast.xml file for toast layout
                                                      View toast = inflater.inflate(R.layout.toasts, null);

                                                      Toast toast1 = new Toast(context);
                                                      // Set layout to toast
                                                      toast1.setView(toast);
                                                      toast1.setGravity(Gravity.CENTER,
                                                              0, 0);
                                                      toast1.setDuration(Toast.LENGTH_LONG);
                                                      toast1.show();
                                                  }



                                                  try {
                                                      ShowPopup();
                                                  }
                                                  catch
                                                  (IndexOutOfBoundsException e) {
                                                      System.out.println("show popup exeption");

                                                  }

                                                  loading.setVisibility(View.GONE);
                                                  table.setVisibility(View.VISIBLE);

                                              }
                                          });
                                          //-----


                                      }
                                  });

        results.setClickable(true);
        results.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
                finish();
            }
        });

            addall.setClickable(true);
        addall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addallThread();

                    if (!date1.getText().equals("Date"))
                        if (!alert1.getTag().equals(R.drawable.find_black_24dp)) {

                            MainActivity.ToRemind1 = true;
                            MainActivity.alertpresses1 = true;
                            tinydb.putBoolean("alertpresses1",alertpresses1);

                        }
                    if (!date2.getText().equals("Date"))
                        if (!alert2.getTag().equals(R.drawable.find_black_24dp)) {
                            MainActivity.ToRemind2 = true;
                            MainActivity.alertpresses2 = true;
                            tinydb.putBoolean("alertpresses2",alertpresses2);

                        }
                    if (!date3.getText().equals("Date"))
                        if (!alert3.getTag().equals(R.drawable.find_black_24dp)) {
                            MainActivity.ToRemind3 = true;
                            MainActivity.alertpresses3 = true;
                            tinydb.putBoolean("alertpresses3",alertpresses3);

                        }
                    if (!date4.getText().equals("Date"))
                        if (!alert4.getTag().equals(R.drawable.find_black_24dp)) {
                            MainActivity.ToRemind4 = true;
                            MainActivity.alertpresses4 = true;
                            tinydb.putBoolean("alertpresses4",alertpresses4);

                        }
                    if (!date5.getText().equals("Date"))
                        if (!alert5.getTag().equals(R.drawable.find_black_24dp)) {
                            MainActivity.ToRemind5 = true;
                            MainActivity.alertpresses5 = true;
                            tinydb.putBoolean("alertpresses5",alertpresses5);

                        }
                    if (!date6.getText().equals("Date"))
                        if (!alert6.getTag().equals(R.drawable.find_black_24dp)) {
                            MainActivity.ToRemind6 = true;
                            MainActivity.alertpresses6 = true;
                            tinydb.putBoolean("alertpresses6",alertpresses6);


                        }
                    if (!date7.getText().equals("Date"))
                        if (!alert7.getTag().equals(R.drawable.find_black_24dp)) {
                            MainActivity.ToRemind7 = true;
                            MainActivity.alertpresses7 = true;
                            tinydb.putBoolean("alertpresses7",alertpresses7);

                        }
                    if (!date8.getText().equals("Date"))
                        if (!alert8.getTag().equals(R.drawable.find_black_24dp)) {
                            MainActivity.ToRemind8 = true;
                            MainActivity.alertpresses8 = true;
                            tinydb.putBoolean("alertpresses8",alertpresses8);

                        }
                    if (!date9.getText().equals("Date"))
                        if (!alert9.getTag().equals(R.drawable.find_black_24dp)) {
                            MainActivity.ToRemind9 = true;
                            MainActivity.alertpresses9 = true;
                            tinydb.putBoolean("alertpresses9",alertpresses9);

                        }
                    if (!date10.getText().equals("Date"))
                        if (!alert10.getTag().equals(R.drawable.find_black_24dp)) {
                            MainActivity.ToRemind10 = true;
                            MainActivity.alertpresses10 = true;
                            tinydb.putBoolean("alertpresses10",alertpresses10);

                        }
                    if (!date11.getText().equals("Date"))
                        if (!alert11.getTag().equals(R.drawable.find_black_24dp)) {
                            MainActivity.ToRemind11 = true;
                            MainActivity.alertpresses11 = true;
                            tinydb.putBoolean("alertpresses11",alertpresses11);

                        }
                    if (!date12.getText().equals("Date"))
                        if (!alert12.getTag().equals(R.drawable.find_black_24dp)) {
                            MainActivity.ToRemind12 = true;
                            MainActivity.alertpresses12 = true;
                            tinydb.putBoolean("alertpresses12",alertpresses12);

                        }
                    if (!date13.getText().equals("Date"))
                        if (!alert13.getTag().equals(R.drawable.find_black_24dp)) {
                            MainActivity.ToRemind13 = true;
                            MainActivity.alertpresses13 = true;
                            tinydb.putBoolean("alertpresses13",alertpresses13);

                        }
                    if (!date14.getText().equals("Date"))
                        if (!alert14.getTag().equals(R.drawable.find_black_24dp)) {
                            MainActivity.ToRemind14 = true;
                            MainActivity.alertpresses14 = true;
                            tinydb.putBoolean("alertpresses14",alertpresses14);

                        }
                    if (!date15.getText().equals("Date"))
                        if (!alert15.getTag().equals(R.drawable.find_black_24dp)) {
                            MainActivity.ToRemind15 = true;
                            MainActivity.alertpresses15 = true;
                            tinydb.putBoolean("alertpresses15",alertpresses15);

                        }
                    Reminder(getApplicationContext());
                   // CheckRows(getApplicationContext());


            }
        });

        remall.setClickable(true);
        remall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remallThread();


                    if (!date1.getText().equals("Date")) {
                        MainActivity.ToRemind1 = false;
                        MainActivity.alertpresses1 = false;
                        tinydb.putBoolean("alertpresses1",alertpresses1);
                    }
                    if (!date2.getText().equals("Date")) {
                        MainActivity.ToRemind2 = false;
                        MainActivity.alertpresses2 = false;
                        tinydb.putBoolean("alertpresses2",alertpresses2);
                    }
                    if (!date3.getText().equals("Date")) {
                        MainActivity.ToRemind3 = false;
                        MainActivity.alertpresses3 = false;
                        tinydb.putBoolean("alertpresses3",alertpresses3);
                    }
                    if (!date4.getText().equals("Date")) {
                        MainActivity.ToRemind4 = false;
                        MainActivity.alertpresses4 = false;
                        tinydb.putBoolean("alertpresses4",alertpresses4);

                    }
                    if (!date5.getText().equals("Date")) {
                        MainActivity.ToRemind5 = false;
                        MainActivity.alertpresses5 = false;
                        tinydb.putBoolean("alertpresses5",alertpresses5);

                    }
                    if (!date6.getText().equals("Date")) {
                        MainActivity.ToRemind6 = false;
                        MainActivity.alertpresses6 = false;
                        tinydb.putBoolean("alertpresses6",alertpresses6);

                    }
                    if (!date7.getText().equals("Date")) {
                        MainActivity.ToRemind7 = false;
                        MainActivity.alertpresses7 = false;
                        tinydb.putBoolean("alertpresses7",alertpresses7);

                    }
                    if (!date8.getText().equals("Date")) {
                        MainActivity.ToRemind8 = false;
                        MainActivity.alertpresses8 = false;
                        tinydb.putBoolean("alertpresses8",alertpresses8);

                    }
                    if (!date9.getText().equals("Date")) {
                        MainActivity.ToRemind9 = false;
                        MainActivity.alertpresses9 = false;
                        tinydb.putBoolean("alertpresses9",alertpresses9);

                    }
                    if (!date10.getText().equals("Date")) {
                        MainActivity.ToRemind10 = false;
                        MainActivity.alertpresses10 = false;
                        tinydb.putBoolean("alertpresses10",alertpresses10);

                    }
                    if (!date11.getText().equals("Date")) {
                        MainActivity.ToRemind11 = false;
                        MainActivity.alertpresses11 = false;
                        tinydb.putBoolean("alertpresses11",alertpresses11);

                    }
                    if (!date12.getText().equals("Date")) {
                        MainActivity.ToRemind12 = false;
                        MainActivity.alertpresses12 = false;
                        tinydb.putBoolean("alertpresses12",alertpresses12);

                    }
                    if (!date13.getText().equals("Date")) {
                        MainActivity.ToRemind13 = false;
                        MainActivity.alertpresses13 = false;
                        tinydb.putBoolean("alertpresses13",alertpresses13);

                    }
                    if (!date14.getText().equals("Date")) {
                        MainActivity.ToRemind14 = false;
                        MainActivity.alertpresses14 = false;
                        tinydb.putBoolean("alertpresses14",alertpresses14);

                    }
                    if (!date15.getText().equals("Date")) {
                        MainActivity.ToRemind15 = false;
                        MainActivity.alertpresses15 = false;
                        tinydb.putBoolean("alertpresses15",alertpresses15);

                    }
                    Reminder(getApplicationContext());
                    CheckRows(getApplicationContext());



            }
        });

        Buttonexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
           }
        });


        Buttonlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textboofer.add(String.valueOf(alarmlist.size()));
               getBigList(getApplicationContext());


                Intent intent = new Intent(MainActivity.this, AlarmsList.class);
                startActivity(intent);
                //finish();
            }
        });


        for (int i=0;i<onEng.size();i++){
            if (FavTeam.equals(onEng.get(i))) {
                FavTeamP=onRus.get(i);
                break;
            }
        }

        teamlogo.setClickable(true);
        today.setVisibility(View.GONE);
        today.setText(day+"."+(month+1)+"."+year);

        /*TranslateAnimation animation = new TranslateAnimation(0, 400, 800, 600);
        animation.setDuration(5000);
        animation.setFillAfter(false);
        animation.setAnimationListener(new MyAnimationListener());
        dallas.startAnimation(animation);
         */

        if (isNetworkReachable(getApplicationContext()))
        TableLoader(getApplicationContext());
        else{
            Toast.makeText(MainActivity.this, "No internet connection.", Toast.LENGTH_LONG).show();

        }


        Context context = getApplicationContext();
        // Create layout inflator object to inflate toast.xml file
        LayoutInflater inflater = getLayoutInflater();

        // Call toast.xml file for toast layout
        View toast = inflater.inflate(R.layout.toasts, null);

        Toast toast1 = new Toast(context);
        // Set layout to toast
        toast1.setView(toast);
        toast1.setGravity(Gravity.CENTER,
                0, 0);
        toast1.setDuration(Toast.LENGTH_LONG);
        toast1.show();

        date8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                toast1.cancel();
              winlost="";
              position="";
             points="";
          strk="";
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                stat1=homet1.getText().toString();
                stat2=homet2.getText().toString();
                stat3=homet3.getText().toString();
                stat4=homet4.getText().toString();
                stat5=homet5.getText().toString();
                stat6=homet6.getText().toString();
                stat7=homet7.getText().toString();
                stat8=homet8.getText().toString();
                stat9=homet9.getText().toString();
                stat10=homet10.getText().toString();
                stat11=homet11.getText().toString();
                stat12=homet12.getText().toString();
                stat13=homet13.getText().toString();
                stat14=homet14.getText().toString();
                stat15=homet15.getText().toString();




            }
        });


        date1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                toast1.cancel();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                table.setVisibility(View.VISIBLE);
                loading.setVisibility(View.GONE);
                searchplayers.clearFocus();


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                mUiHandler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        });


        alert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color1=false;

                if (row1.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) row1.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){
                        color1=true;
                        cardflip(row1,alert1,homet1,scoreshome.get(0),scoresguest.get(0),stat1);
                        //animationN(row1);
                         
                        ToRemind1=false;

                    }
                }

                alertpresses1=tinydb.getBoolean("alertpresses1");
                System.out.println(alertpresses1);

                         if (!color1)       //true
                {
                    if (!alertpresses1) {      //true
                        ToRemind1=true;
                        alert1.setImageResource(R.drawable.alarm_white);
                        alertpresses1=true;
                        tinydb.putBoolean("alertpresses1",alertpresses1);
                        Reminder(getApplicationContext());

                    }
                    else {
                        if (alertpresses1) {

                            ToRemind1=false;
                            alert1.setImageResource(R.drawable.alarm_black1);
                            alertpresses1=false;
                            tinydb.putBoolean("alertpresses1",alertpresses1);
                            Reminder(getApplicationContext());


                        }

                    }
                }
                //CheckRows(getApplicationContext());


            }
        });
        alert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color2=false;

                if (row2.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) row2.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){
                        color2=true;
                        cardflip(row2,alert2,homet2,scoreshome.get(1),scoresguest.get(1),stat2);

                       // animationN(row2);
                         
                        ToRemind2=false;

                    }
                }
                alertpresses2=tinydb.getBoolean("alertpresses2");

                if (!color2)       //true
                {
                    if (!alertpresses2) {      //true
                        ToRemind2=true;
                        alert2.setImageResource(R.drawable.alarm_white);
                        alertpresses2=true;
                        tinydb.putBoolean("alertpresses2",alertpresses2);

                        Reminder(getApplicationContext());

                    }
                    else {
                        if (alertpresses2) {

                            ToRemind2=false;
                            alert2.setImageResource(R.drawable.alarm_black1);
                            alertpresses2=false;
                            tinydb.putBoolean("alertpresses2",alertpresses2);

                            Reminder(getApplicationContext());


                        }

                    }
                }
                //CheckRows(getApplicationContext());
            }
        });

        alert3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color3=false;

                if (row3.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) row3.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){
                        color3=true;
                        cardflip(row3,alert3,homet3,scoreshome.get(2),scoresguest.get(2),stat3);
                       // animationN(row3);
                         
                        ToRemind3=false;

                    }
                }
                alertpresses3=tinydb.getBoolean("alertpresses3");

                if (!color3)       //true
                {
                    if (!alertpresses3) {      //true
                        ToRemind3=true;
                        alert3.setImageResource(R.drawable.alarm_white);
                        alertpresses3=true;
                        tinydb.putBoolean("alertpresses3",alertpresses3);

                        Reminder(getApplicationContext());

                    }
                    else {
                        if (alertpresses3) {

                            ToRemind3=false;
                            alert3.setImageResource(R.drawable.alarm_black1);
                            alertpresses3=false;
                            tinydb.putBoolean("alertpresses3",alertpresses3);

                            Reminder(getApplicationContext());


                        }

                    }
                }
                //CheckRows(getApplicationContext());
            }
        });
        alert4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color4=false;

                if (row4.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) row4.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){
                        color4=true;
                        cardflip(row4,alert4,homet4,scoreshome.get(3),scoresguest.get(3),stat4);
                       // animationN(row4);
                         
                        ToRemind4=false;

                    }
                }
                alertpresses4=tinydb.getBoolean("alertpresses4");

                if (!color4)       //true
                {
                    if (!alertpresses4) {      //true
                        ToRemind4=true;
                        alert4.setImageResource(R.drawable.alarm_white);
                        alertpresses4=true;
                        tinydb.putBoolean("alertpresses4",alertpresses4);

                        Reminder(getApplicationContext());

                    }
                    else {
                        if (alertpresses4) {

                            ToRemind4=false;
                            alert4.setImageResource(R.drawable.alarm_black1);
                            alertpresses4=false;
                            tinydb.putBoolean("alertpresses4",alertpresses4);

                            Reminder(getApplicationContext());


                        }

                    }
                }
                //CheckRows(getApplicationContext());
            }
        });

        alert5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color5=false;

                if (row5.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) row5.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){
                        color5=true;
                        cardflip(row5,alert5,homet5,scoreshome.get(4),scoresguest.get(4),stat5);
                        //animationN(row5);
                         
                        ToRemind5=false;

                    }
                }
                alertpresses5=tinydb.getBoolean("alertpresses5");

                if (!color5)       //true
                {
                    if (!alertpresses5) {      //true
                        ToRemind5=true;
                        alert5.setImageResource(R.drawable.alarm_white);
                        alertpresses5=true;
                        tinydb.putBoolean("alertpresses5",alertpresses5);

                        Reminder(getApplicationContext());

                    }
                    else {
                        if (alertpresses5) {

                            ToRemind5=false;
                            alert5.setImageResource(R.drawable.alarm_black1);
                            alertpresses5=false;
                            tinydb.putBoolean("alertpresses5",alertpresses5);

                            Reminder(getApplicationContext());


                        }

                    }
                }
                //CheckRows(getApplicationContext());
            }
        });
        alert6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                color6=false;

                if (row6.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) row6.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){
                        color6=true;
                        cardflip(row6,alert6,homet6,scoreshome.get(5),scoresguest.get(5),stat6);
                        //animationN(row6);
                         
                        ToRemind6=false;

                    }
                }
                alertpresses6=tinydb.getBoolean("alertpresses6");

                if (!color6)       //true
                {
                    if (!alertpresses6) {      //true
                        ToRemind6=true;
                        alert6.setImageResource(R.drawable.alarm_white);
                        alertpresses6=true;
                        tinydb.putBoolean("alertpresses6",alertpresses6);

                        Reminder(getApplicationContext());

                    }
                    else {
                        if (alertpresses6) {

                            ToRemind6=false;
                            alert6.setImageResource(R.drawable.alarm_black1);
                            alertpresses6=false;
                            tinydb.putBoolean("alertpresses6",alertpresses6);

                            Reminder(getApplicationContext());


                        }

                    }
                }
                //CheckRows(getApplicationContext());
            }
        });
        alert7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color7=false;

                if (row7.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) row7.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){
                        color7=true;
                        cardflip(row7,alert7,homet7,scoreshome.get(6),scoresguest.get(6),stat7);
                       // animationN(row7);
                         
                        ToRemind7=false;

                    }
                }
                alertpresses7=tinydb.getBoolean("alertpresses7");

                if (!color7)       //true
                {
                    if (!alertpresses7) {      //true
                        ToRemind7=true;
                        alert7.setImageResource(R.drawable.alarm_white);
                        alertpresses7=true;
                        tinydb.putBoolean("alertpresses7",alertpresses7);

                        Reminder(getApplicationContext());

                    }
                    else {
                        if (alertpresses7) {

                            ToRemind7=false;
                            alert7.setImageResource(R.drawable.alarm_black1);
                            alertpresses7=false;
                            tinydb.putBoolean("alertpresses7",alertpresses7);

                            Reminder(getApplicationContext());


                        }

                    }
                }
                //CheckRows(getApplicationContext());
            }
        });
        alert8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color8=false;

                if (row8.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) row8.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){
                        color8=true;
                        cardflip(row8,alert8,homet8,scoreshome.get(7),scoresguest.get(7),stat8);
                        //animationN(row8);
                         
                        ToRemind8=false;

                    }
                }
                alertpresses8=tinydb.getBoolean("alertpresses8");

                if (!color8)       //true
                {
                    if (!alertpresses8) {      //true
                        ToRemind8=true;
                        alert8.setImageResource(R.drawable.alarm_white);
                        alertpresses8=true;
                        tinydb.putBoolean("alertpresses8",alertpresses8);

                        Reminder(getApplicationContext());

                    }
                    else {
                        if (alertpresses8) {

                            ToRemind8=false;
                            alert8.setImageResource(R.drawable.alarm_black1);
                            alertpresses8=false;
                            tinydb.putBoolean("alertpresses8",alertpresses8);

                            Reminder(getApplicationContext());


                        }

                    }
                }
                //CheckRows(getApplicationContext());
            }
        });
        alert9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color9=false;

                if (row9.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) row9.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){
                        color9=true;
                        cardflip(row9,alert9,homet9,scoreshome.get(8),scoresguest.get(8),stat9);
                        //animationN(row9);
                         
                        ToRemind9=false;

                    }
                }
                alertpresses9=tinydb.getBoolean("alertpresses9");

                if (!color9)       //true
                {
                    if (!alertpresses9) {      //true
                        ToRemind9=true;
                        alert9.setImageResource(R.drawable.alarm_white);
                        alertpresses9=true;
                        tinydb.putBoolean("alertpresses9",alertpresses9);

                        Reminder(getApplicationContext());

                    }
                    else {
                        if (alertpresses9) {

                            ToRemind9=false;
                            alert9.setImageResource(R.drawable.alarm_black1);
                            alertpresses9=false;
                            tinydb.putBoolean("alertpresses9",alertpresses9);

                            Reminder(getApplicationContext());


                        }

                    }
                }
                //CheckRows(getApplicationContext());
            }
        });
        alert10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color10=false;

                if (row10.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) row10.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){
                        color10=true;
                        cardflip(row10,alert10,homet10,scoreshome.get(9),scoresguest.get(9),stat10);
                        //animationN(row10);
                         
                        ToRemind10=false;

                    }
                }
                alertpresses10=tinydb.getBoolean("alertpresses10");

                if (!color10)       //true
                {
                    if (!alertpresses10) {      //true
                        ToRemind10=true;
                        alert10.setImageResource(R.drawable.alarm_white);
                        alertpresses10=true;
                        tinydb.putBoolean("alertpresses10",alertpresses10);

                        Reminder(getApplicationContext());

                    }
                    else {
                        if (alertpresses10) {

                            ToRemind10=false;
                            alert10.setImageResource(R.drawable.alarm_black1);
                            alertpresses10=false;
                            tinydb.putBoolean("alertpresses10",alertpresses10);

                            Reminder(getApplicationContext());


                        }

                    }
                }
                //CheckRows(getApplicationContext());

            }
        });
        alert11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color11=false;

                if (row11.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) row11.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){
                        color11=true;
                        cardflip(row11,alert11,homet11,scoreshome.get(10),scoresguest.get(10),stat11);
                        //animationN(row11);
                         
                        ToRemind11=false;

                    }
                }
                alertpresses11=tinydb.getBoolean("alertpresses11");

                if (!color11)       //true
                {
                    if (!alertpresses11) {      //true
                        ToRemind11=true;
                        alert11.setImageResource(R.drawable.alarm_white);
                        alertpresses11=true;
                        tinydb.putBoolean("alertpresses11",alertpresses11);

                        Reminder(getApplicationContext());

                    }
                    else {
                        if (alertpresses11) {

                                ToRemind11=false;
                            alert11.setImageResource(R.drawable.alarm_black1);
                            alertpresses11=false;
                            tinydb.putBoolean("alertpresses11",alertpresses11);

                            Reminder(getApplicationContext());


                        }

                    }
                }
                //CheckRows(getApplicationContext());
            }

        });
        alert12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color12=false;

                if (row12.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) row12.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){
                        color12=true;
                        cardflip(row12,alert12,homet12,scoreshome.get(11),scoresguest.get(11),stat12);
                        //animationN(row12);
                         
                        ToRemind12=false;

                    }
                }
                alertpresses12=tinydb.getBoolean("alertpresses12");

                if (!color12)       //true
                {
                    if (!alertpresses12) {      //true
                        ToRemind12=true;
                        alert12.setImageResource(R.drawable.alarm_white);
                        alertpresses12=true;
                        tinydb.putBoolean("alertpresses12",alertpresses12);

                        Reminder(getApplicationContext());

                    }
                    else {
                        if (alertpresses12) {

                            ToRemind12=false;
                            alert12.setImageResource(R.drawable.alarm_black1);
                            alertpresses12=false;
                            tinydb.putBoolean("alertpresses12",alertpresses12);

                            Reminder(getApplicationContext());


                        }

                    }
                }
                //CheckRows(getApplicationContext());
            }
        });
        alert13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color13=false;

                if (row13.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) row13.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){
                        color13=true;
                        cardflip(row13,alert13,homet13,scoreshome.get(12),scoresguest.get(12),stat13);
                        //animationN(row13);
                         
                        ToRemind13=false;

                    }
                }
                alertpresses13=tinydb.getBoolean("alertpresses13");

                if (!color13)       //true
                {
                    if (!alertpresses13) {      //true
                        ToRemind13=true;
                        alert13.setImageResource(R.drawable.alarm_white);
                        alertpresses13=true;
                        tinydb.putBoolean("alertpresses13",alertpresses13);

                        Reminder(getApplicationContext());

                    }
                    else {
                        if (alertpresses13) {

                            ToRemind13=false;
                            alert13.setImageResource(R.drawable.alarm_black1);
                            alertpresses13=false;
                            tinydb.putBoolean("alertpresses13",alertpresses13);

                            Reminder(getApplicationContext());


                        }

                    }
                }
                //CheckRows(getApplicationContext());
            }
        });
        alert14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color14=false;

                if (row14.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) row14.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){
                        color14=true;
                        cardflip(row14,alert14,homet14,scoreshome.get(13),scoresguest.get(13),stat14);
                        //animationN(row14);
                         
                        ToRemind14=false;

                    }
                }
                alertpresses14=tinydb.getBoolean("alertpresses14");

                if (!color14)       //true
                {
                    if (!alertpresses14) {      //true
                        ToRemind14=true;
                        alert14.setImageResource(R.drawable.alarm_white);
                        alertpresses14=true;
                        tinydb.putBoolean("alertpresses14",alertpresses14);

                        Reminder(getApplicationContext());

                    }
                    else {
                        if (alertpresses14) {

                            ToRemind14=false;
                            alert14.setImageResource(R.drawable.alarm_black1);
                            alertpresses14=false;
                            tinydb.putBoolean("alertpresses14",alertpresses14);

                            Reminder(getApplicationContext());


                        }

                    }
                }
                //CheckRows(getApplicationContext());
            }
        });
        alert15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color15=false;

                if (row15.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) row15.getBackground();
                    int colorCode = cd.getColor();
                    if (colorCode==R.color.colorPrimaryDark){
                        color15=true;
                        cardflip(row15,alert15,homet15,scoreshome.get(14),scoresguest.get(14),stat15);
                       // animationN(row15);
                         
                        ToRemind15=false;

                    }
                }

                alertpresses15=tinydb.getBoolean("alertpresses15");

                if (!color15)       //true
                {
                    if (!alertpresses15) {      //true
                        ToRemind15=true;
                        alert15.setImageResource(R.drawable.alarm_white);
                        alertpresses15=true;
                        tinydb.putBoolean("alertpresses15",alertpresses15);

                        Reminder(getApplicationContext());

                    }
                    else {
                        if (alertpresses15) {

                            ToRemind15=false;
                            alert15.setImageResource(R.drawable.alarm_black1);
                            alertpresses15=false;
                            tinydb.putBoolean("alertpresses15",alertpresses15);

                            Reminder(getApplicationContext());


                        }

                    }
                }
                //CheckRows(getApplicationContext());
            }
        });



      teamlogo.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              NotificationHelper.times.clear();
              NotificationHelper.put(context,NotificationHelper.times);
              AlarmsBigList.clear();
              NotificationHelper.dateandteam = NotificationHelper.loadMap(context, "dateandteam");
              NotificationHelper.dateandalarm = NotificationHelper.loadMap(context, "dateandalarm");
              System.out.println(NotificationHelper.dateandteam.size());
              System.out.println(NotificationHelper.dateandalarm.size());
              NotificationHelper.dateandteam.clear();
              NotificationHelper.dateandalarm.clear();
              System.out.println(NotificationHelper.dateandteam.size());
              System.out.println(NotificationHelper.dateandalarm.size());

              NotificationHelper.saveMap(NotificationHelper.dateandteam, context,"dateandteam");
              NotificationHelper.saveMap(NotificationHelper.dateandalarm, context,"dateandalarm");

              saveBigList(getApplicationContext());

              teamlogo.animate().rotationBy((float) 360).setDuration(1000);
           //   Intent intent = new Intent(MainActivity.this, StandingsActivity.class);
           //   startActivity(intent);
           //   finish();
          }
      });

    }


    private class MyAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationEnd(Animation animation) {
            teamlogo.clearAnimation();
                        ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(teamlogo.getWidth(), teamlogo.getHeight());
            lp.setMargins(500, 300, 200, 100);
            teamlogo.setLayoutParams(lp);

        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }

    }

}
