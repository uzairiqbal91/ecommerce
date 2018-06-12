package comtestinna.example.manew1.newecommerceapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class UserProfileFragment extends Fragment {

    private ArrayList<String> detailTag;
    private ArrayList<Integer> imgSrc;
    public static ProfileDescriptionAdapter myAdapter;
    public static RecyclerView myrv;
    public UserDetail userDetail;
    public CircleImageView circleImageView;
    public UserProfileFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_user_profile, container, false);

circleImageView=rootView.findViewById(R.id.imageView);


        imgSrc=new ArrayList<>();
        detailTag=new ArrayList<>();

        imgSrc.add(R.drawable.user2);
        imgSrc.add(R.drawable.phonecall);
        imgSrc.add(R.drawable.resort);
        imgSrc.add(R.drawable.flag);
        imgSrc.add(R.drawable.street);
        imgSrc.add(R.drawable.accounts);



        userDetail=new UserDetail("Muhammad Uzair","+92-344-1807512","Karachi","Pakinstan" ,R.drawable.phonecall,"42201-9860616-9","block 13-b gulshane - e - iqbal karachi");

        detailTag.add(userDetail.getName());
        detailTag.add(userDetail.getPhoneNum());
        detailTag.add(userDetail.getCity());
        detailTag.add(userDetail.getCountry());
        detailTag.add(userDetail.getStreetAddress());
        detailTag.add(userDetail.getAccountNum());

        circleImageView.setImageResource(R.drawable.phonecall);



        myAdapter=new ProfileDescriptionAdapter(getActivity(),detailTag,imgSrc);


        RecyclerView myrv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view_profile);

        myrv.setLayoutManager(new GridLayoutManager(getActivity(),1));
        myrv.setAdapter(myAdapter);







        return rootView;
    }


}
