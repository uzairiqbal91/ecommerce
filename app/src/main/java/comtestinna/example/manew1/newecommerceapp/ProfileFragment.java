package comtestinna.example.manew1.newecommerceapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;


public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   private TableLayout tableLayout;
   private AppBarLayout appBarLayout;
   private ViewPager viewPager;




    public ProfileFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        final View rootView = inflater.inflate(R.layout.fragment_profile,
                container, false);

        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.profile_viewpagere);

        ProfileViewPagerAdapter profileViewPagerAdapter=new ProfileViewPagerAdapter(getChildFragmentManager());

        profileViewPagerAdapter.AddFragment(new UserOrderFragment(),"User Profile");
        profileViewPagerAdapter.AddFragment(new UserProfileFragment(),"User Order");

        viewPager.setAdapter(profileViewPagerAdapter);






        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.table_layout_profile);

        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event





}
