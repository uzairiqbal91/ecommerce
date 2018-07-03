package comtestinna.example.manew1.newecommerceapp;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private ViewPagerAdapter viewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private Button btnSkip, btnNext;
    public static int  count=0;
    int tempInt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
//
        CheckConnectivity check = new CheckConnectivity();
        Boolean conn = check.isNetworkAvailable(this.getApplicationContext());

        //run your normal code path here
        // MainActivity m = new MainActivity();
        SharedPreferences settings = getSharedPreferences("prefs", 0);
        boolean firstRun = settings.getBoolean("firstRun", true);
        //m.initializeConnection();

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnNext = (Button) findViewById(R.id.btn_next);

        layouts = new int[]{
                R.layout.slide1_layout,
                R.layout.slide2_layout,
                R.layout.slide3_layout,
                R.layout.fragment_login

        };

        // adding bottom dots
        addBottomDots(0);

        viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        //when splash screen is on only first time


        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        CheckConnectivity receiver = new CheckConnectivity();
        registerReceiver(receiver, filter);

        if ( firstRun ) {




            viewPager = (ViewPager) findViewById(R.id.view_pager);
            dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
            btnSkip = (Button) findViewById(R.id.btn_skip);
            btnNext = (Button) findViewById(R.id.btn_next);

            layouts = new int[]{
                    R.layout.slide1_layout,
                    R.layout.slide2_layout,
                    R.layout.slide3_layout,
                    R.layout.fragment_login};

            // adding bottom dots
            addBottomDots(0);

            viewPagerAdapter = new ViewPagerAdapter();
            viewPager.setAdapter(viewPagerAdapter);
            viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        }


        else
        {

            Intent intent = new Intent();
            //intent.setClass(MainActivity.this, TemporaryActivity.class);
            startActivity(new Intent(this, MainActivity.class));
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            finish();
        }





        //when not connection available

        //Send a warning message to the user









    }

    public int readSharedPreferenceInt(String spName,String key){
        SharedPreferences sharedPreferences = getSharedPreferences(spName, Context.MODE_PRIVATE);
        return tempInt = sharedPreferences.getInt(key, 0);
    }

    //write shared preferences in integer
    public void writeSharedPreference(int ammount,String spName,String key ){

        SharedPreferences sharedPreferences = getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(key, ammount);
        editor.commit();
    }
    public  void btnSkipClick(View v)
    {
        launchHomeScreen();
    }

    public  void btnNextClick(View v)
    {
        // checking for last page
        // if last page home screen will be launched
        int current = getItem(1);
        if (current < layouts.length) {
            // move to next screen
            viewPager.setCurrentItem(current);
        } else {
            launchHomeScreen();
        }
    }




    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                btnNext.setText(getString(R.string.next));
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };



    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.dot_inactive));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(getResources().getColor(R.color.dot_active));
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }


    private void launchHomeScreen() {

        //   startActivity(new Intent(this, com.example.mohsinhussain.allinoneapp.BottomNavigtionViewActivity.class));
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

        SharedPreferences settings = getSharedPreferences("prefs", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("firstRun", false);
        editor.commit();
        count++;
        finish();




    }


    public class ViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;



        public ViewPagerAdapter() {

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }




    }




}
