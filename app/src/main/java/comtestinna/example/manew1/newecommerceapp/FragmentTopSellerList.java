package comtestinna.example.manew1.newecommerceapp;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class FragmentTopSellerList extends Fragment {

    ViewPager viewPager1;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    ViewPagerAdapter viewPagerAdapter;
    Map<String, Integer[]> map;
    public static List<Book> lstBook;
    public static MyAdapter myAdapter;



    public Activity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview=inflater.inflate(R.layout.fragment_fragment_top_seller_list, container, false);

        lstBook = new ArrayList<>();


        lstBook.add(new Book("The Vegitarian","$100","Description book",R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot","$150","Description book",R.drawable.thewildrobot));


        final RecyclerView rv = (RecyclerView) rootview.findViewById(R.id.list);
        myAdapter = new  MyAdapter(getActivity(),lstBook);
        rv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        rv.setAdapter(myAdapter);


        return rootview;
    }


}
