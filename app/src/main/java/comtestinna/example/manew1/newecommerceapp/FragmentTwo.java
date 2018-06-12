package comtestinna.example.manew1.newecommerceapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


public class FragmentTwo extends Fragment {


    ViewPager viewPager1;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    ViewPagerAdapter viewPagerAdapter;
    Map<String, Integer[]> map;
    PagerAdapter pagerAdapter;

    public Activity mActivity;
    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootView = inflater.inflate(R.layout.fragment_two,
                container, false);



         List<Fragment> mFragmentList = new ArrayList<>();
         mFragmentList.add(new BlankFragment());
        mFragmentList.add(new WomenFragment());


         List<String> mFragmentTitleList=  new ArrayList<>();
        mFragmentTitleList.add("Men");
        mFragmentTitleList.add("Women");


        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);

         pagerAdapter = new PagerAdapter(getChildFragmentManager(), rootView.getContext(),mFragmentList,mFragmentTitleList);
       viewPager.setAdapter(pagerAdapter);


        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));
        }
//
        //for slider
        viewPager1 = (ViewPager) rootView.findViewById(R.id.viewPager1);


        Integer[] images_men = {R.drawable.menslider01, R.drawable.menslider02, R.drawable.menslider03};
        Integer[] images_women = {R.drawable.slider0, R.drawable.slider01, R.drawable.slider02};


        map = new HashMap<String, Integer[]>();
        map.put("Men", images_men);
        map.put("Women", images_women);


        sliderDotspanel = (LinearLayout) rootView.findViewById(R.id.SliderDots);
        viewPagerAdapter = new ViewPagerAdapter(rootView.getContext(), map.get("Men"));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),String.valueOf(pagerAdapter.getPageTitle(position)),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageSelected(int position) {

//                viewPagerAdapter = new ViewPagerAdapter(rootView.getContext(), map.get(String.valueOf(pagerAdapter.getPageTitle(position))));
//                viewPager1.setAdapter(viewPagerAdapter);


                viewPagerAdapter = new ViewPagerAdapter(rootView.getContext(),map.get(String.valueOf(pagerAdapter.getPageTitle(position))));
                viewPager1.setAdapter(viewPagerAdapter);


            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();

            }
        });
////
       viewPager1.setAdapter(viewPagerAdapter);
////
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(rootView.getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(rootView.getContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(rootView.getContext(), R.drawable.active_dot));

        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(rootView.getContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(rootView.getContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);


        return rootView;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (viewPager1.getCurrentItem() == 0) {
                        viewPager1.setCurrentItem(1);
                    } else if (viewPager1.getCurrentItem() == 1) {
                        viewPager1.setCurrentItem(2);

                    } else {
                        viewPager1.setCurrentItem(0);
                    }

                }
            });
        }
    }

    class PagerAdapter extends FragmentPagerAdapter {


       List<Fragment>mfragmentList;
        List<String>mfragmentListName;

        Context context;

        public PagerAdapter(FragmentManager fm, Context context, List<Fragment>mfragmentList,List<String>mfragmentListName) {
            super(fm);
            this.context = context;
            this.mfragmentList=mfragmentList;
            this.mfragmentListName=mfragmentListName;




        }


        @Override
        public int getCount() {
            return mfragmentList.size();
        }

        @Override
        public Fragment getItem(int position) {

            return mfragmentList.get(position);
        }
        @Override
        public CharSequence getPageTitle(int position){
            return (CharSequence) mfragmentListName.get(position);
        }
        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        public View getTabView(int position){
            View tab = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
            TextView tv = (TextView) tab.findViewById(R.id.custom_text);
            tv.setText((CharSequence) mfragmentListName.get(position));
            return tab;
        }
    }


}
