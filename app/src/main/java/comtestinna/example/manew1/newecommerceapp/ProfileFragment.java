package comtestinna.example.manew1.newecommerceapp;

import android.app.AlertDialog;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   private TableLayout tableLayout;
   private AppBarLayout appBarLayout;
   private ViewPager viewPager;
    public CircleImageView circleImageView;
    public Button editBtn;



    public ProfileFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        final View rootView = inflater.inflate(R.layout.fragment_profile,
                container, false);


        circleImageView=rootView.findViewById(R.id.imageView);
          circleImageView.setImageResource(MainActivity.userDetail.getProifilePic());

          editBtn=rootView.findViewById(R.id.editprofileBtn);

          editBtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
                  View mView = getLayoutInflater().inflate(R.layout.form, null);
                  final EditText mName = (EditText) mView.findViewById(R.id.userNameText);
                  final EditText mEmail = (EditText) mView.findViewById(R.id.emailIdText);
                  final EditText mphone = (EditText) mView.findViewById(R.id.phoneNoText);
                  final EditText mAddress = (EditText) mView.findViewById(R.id.adressText);



                  Button mSend = (Button) mView.findViewById(R.id.btn_sendBtn);



                  mBuilder.setView(mView);
                  final AlertDialog dialog = mBuilder.create();
                  dialog.getWindow().getAttributes().windowAnimations = R.anim.anim_left;
                  dialog.show();

                  mName.setText(MainActivity.dataProccessor.getStr("User_name"));
                  mEmail.setText(MainActivity.dataProccessor.getStr("User_email"));
                  mphone.setText(MainActivity.dataProccessor.getStr("User_phone"));
                  mAddress.setText(MainActivity.dataProccessor.getStr("User_address"));



//                  userDetail=new UserDetail(dataProccessor.getStr("User_name"),dataProccessor.getStr("User_phone"),dataProccessor.getStr("User_address"),dataProccessor.getStr("User_email"));


                  mSend.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {



                          MainActivity.dataProccessor.setStr("User_name",String.valueOf(mName.getText()));
                          MainActivity.dataProccessor.setStr("User_phone",String.valueOf(mphone.getText()));
                          MainActivity.dataProccessor.setStr("User_address",String.valueOf(mAddress.getText()));
                          MainActivity.dataProccessor.setStr("User_email",String.valueOf(mEmail.getText()));


                          MainActivity.userDetail=new UserDetail(MainActivity.dataProccessor.getStr("User_name"),MainActivity.dataProccessor.getStr("User_phone"),MainActivity.dataProccessor.getStr("User_address"),MainActivity.dataProccessor.getStr("User_email"));

                          dialog.dismiss();





                      }
                  });






              }
          });



        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.profile_viewpagere);

        ProfileViewPagerAdapter profileViewPagerAdapter=new ProfileViewPagerAdapter(getChildFragmentManager());

        profileViewPagerAdapter.AddFragment(new UserProfileFragment(),"User Profile");
        profileViewPagerAdapter.AddFragment(new UserOrderFragment(),"User Order");

        viewPager.setAdapter(profileViewPagerAdapter);






        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.table_layout_profile);

        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event





}
