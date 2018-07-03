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


public class RecentFragment extends Fragment {

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();

    public RecentFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootView = inflater.inflate(R.layout.fragment_recent, container, false);





        mImageUrls.add(R.drawable.women3);
        mNames.add("The Vegitarian");
        mPrice.add("$100");

        mImageUrls.add(R.drawable.women4);
        mNames.add("The Vegitarian");
        mPrice.add("$100");
        mImageUrls.add(R.drawable.women5);
        mNames.add("The Vegitarian");
        mPrice.add("$100");


        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewRecent);
        recyclerView.setLayoutManager(layoutManager);
        SuggestionSliderAdapter adapter = new SuggestionSliderAdapter(rootView.getContext(), mNames,mPrice, mImageUrls);
        recyclerView.setAdapter(adapter);







        return rootView;
    }



}
