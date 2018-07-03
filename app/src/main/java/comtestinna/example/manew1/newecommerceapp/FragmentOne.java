package comtestinna.example.manew1.newecommerceapp;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link FragmentOne.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link FragmentOne#newInstance} factory method to
// * create an instance of this fragment.
// */
public class FragmentOne extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private int dotscount;
    private ImageView[] dots;
    LinearLayout sliderDotspanel;
    ViewPager viewPager1;
    ImageButton menImageBtn;
    public Activity mActivity;




    // TODO: Rename and change types and number of parameters
//    public static FragmentOne newInstance(String param1, String param2) {
//        FragmentOne fragment = new FragmentOne();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
    public FragmentOne() {
        // Required empty public constructor
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_fragment_one,
                container, false);

        Integer[] images_men= {R.drawable.menslider01,R.drawable.menslider02,R.drawable.menslider03};
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity().getApplicationContext(),images_men);
        viewPager1 = (ViewPager) rootView.findViewById(R.id.viewPager1);
        viewPager1.setAdapter(viewPagerAdapter);
        sliderDotspanel = (LinearLayout) rootView.findViewById(R.id.SliderDots1);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];


        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(rootView.getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(rootView.getContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);
            dots[0].setImageDrawable(ContextCompat.getDrawable(rootView.getContext(), R.drawable.active_dot));

        }

        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i< dotscount; i++){
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



        menImageBtn=rootView.findViewById(R.id.menimagebtn);
        menImageBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

swapFragment();

            }
        });




        getData(rootView);
        getData1(rootView);

        return rootView;

    }

//    @Override
//    public void onBackPressed() {
//
//            getFragmentManager().popBackStack();
//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.setCustomAnimations(R.anim.aniamtion, R.anim.animation1);
//
//
//
//    }

    private void swapFragment() {

        FragmentTwo newGamefragment = new FragmentTwo();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
       fragmentTransaction.setCustomAnimations(R.anim.aniamtion, R.anim.animation1);
        fragmentTransaction.replace(R.id.fragment_container, newGamefragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void onPause() {
        super.onPause();

        Toast.makeText(getActivity().getApplicationContext(),"f1 paused",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity().getApplicationContext(),"f1 resumed ",Toast.LENGTH_SHORT).show();
    }

    private void getData(View rootView){




        mImageUrls.add(R.drawable.women1);
        mNames.add("The Vegitarian");
        mPrice.add("$100");

        mImageUrls.add(R.drawable.women2);
        mNames.add("The Vegitarian");
        mPrice.add("$100");

        mImageUrls.add(R.drawable.women3);
        mNames.add("The Vegitarian");
        mPrice.add("$100");

        mImageUrls.add(R.drawable.women4);
        mNames.add("The Vegitarian");
        mPrice.add("$100");
        mImageUrls.add(R.drawable.women5);
        mNames.add("The Vegitarian");
        mPrice.add("$100");
        mImageUrls.add(R.drawable.women6);
        mNames.add("The Vegitarian");
        mPrice.add("$100");
        mImageUrls.add(R.drawable.product1);
        mNames.add("The Vegitarian");
        mPrice.add("$100");
        mImageUrls.add(R.drawable.product2);
        mNames.add("The Vegitarian");
        mPrice.add("$100");




        initRecyclerView(rootView);


    }
    private void getData1(View rootView){




        mImageUrls.add(R.drawable.product2);
        mNames.add("The Vegitarian");
        mPrice.add("$100");

        mImageUrls.add(R.drawable.product3);
        mNames.add("The Vegitarian");
        mPrice.add("$100");

        mImageUrls.add(R.drawable.product4);
        mNames.add("The Vegitarian");
        mPrice.add("$100");

        mImageUrls.add(R.drawable.women2);
        mNames.add("The Vegitarian");
        mPrice.add("$100");
        mImageUrls.add(R.drawable.women6);
        mNames.add("The Vegitarian");
        mPrice.add("$100");
        mImageUrls.add(R.drawable.women5);
        mNames.add("The Vegitarian");
        mPrice.add("$100");
        mImageUrls.add(R.drawable.product1);
        mNames.add("The Vegitarian");
        mPrice.add("$100");
        mImageUrls.add(R.drawable.product2);
        mNames.add("The Vegitarian");
        mPrice.add("$100");



       initRecyclerView1(rootView);


    }
    private void initRecyclerView1(View rootView){


        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewPopular);
        recyclerView.setLayoutManager(layoutManager);
        SuggestionSliderAdapter adapter = new SuggestionSliderAdapter(rootView.getContext(), mNames,mPrice, mImageUrls);
        recyclerView.setAdapter(adapter);
    }

    private void initRecyclerView(View rootView){


        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewRecent);
        recyclerView.setLayoutManager(layoutManager);
        SuggestionSliderAdapter adapter = new SuggestionSliderAdapter(rootView.getContext(), mNames,mPrice, mImageUrls);
        recyclerView.setAdapter(adapter);
//        SuggestionSliderAdapter adapter = new SuggestionSliderAdapter(getActivity(), mNames,mPrice, mImageUrls);
//        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }
    @Override
    public void onDetach() {
        super.onDetach();
      //  mActivity = null;
    }
    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {

            mActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager1.getCurrentItem() == 0){
                        viewPager1.setCurrentItem(1);
                    } else if(viewPager1.getCurrentItem() == 1){
                        viewPager1.setCurrentItem(2);

                    }
                    else {
                        viewPager1.setCurrentItem(0);
                    }

                }
            });
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
