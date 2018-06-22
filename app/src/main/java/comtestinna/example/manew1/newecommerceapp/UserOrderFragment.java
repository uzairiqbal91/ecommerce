package comtestinna.example.manew1.newecommerceapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class UserOrderFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //public static List<OrderDetail> order;
    public static UserOrderAdapter myAdapter;
    public static RecyclerView myrv;

    public UserOrderFragment()
    {

    }










    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_user_order, container, false);
//        order = new ArrayList<>();




        RecyclerView myrv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view_order);



        myAdapter = new  UserOrderAdapter(getActivity(),CheckoutActivity.order);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),1));
        myrv.setAdapter(myAdapter);


        return rootView;
    }





}
