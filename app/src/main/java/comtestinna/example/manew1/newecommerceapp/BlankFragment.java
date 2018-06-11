package comtestinna.example.manew1.newecommerceapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

;

public class BlankFragment extends Fragment {
    public static  List<Book> lstBook;
    public static MyAdapter myAdapter;
    public static RecyclerView myrv;
    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);



        lstBook = new ArrayList<>();


        lstBook.add(new Book("The Vegitarian","$100","Description book",R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot","$150","Description book",R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples","$200","Description book",R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","$130","Description book",R.drawable.themartian));
        lstBook.add(new Book("He Died with...","$300","Description book",R.drawable.hediedwith));
        lstBook.add(new Book("The Vegitarian","$100","Description book",R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot","$150","Description book",R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples","$200","Description book",R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","$130","Description book",R.drawable.themartian));
        lstBook.add(new Book("He Died with...","$300","Description book",R.drawable.hediedwith));
        lstBook.add(new Book("The Vegitarian","$100","Description book",R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot","$150","Description book",R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples","$200","Description book",R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","$130","Description book",R.drawable.themartian));
        lstBook.add(new Book("He Died with...","$300","Description book",R.drawable.hediedwith));
        RecyclerView myrv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);

         myAdapter = new  MyAdapter(getActivity(),lstBook);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        myrv.setAdapter(myAdapter);






//        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
//        rv.setHasFixedSize(true);
//        MyAdapter adapter = new MyAdapter(new String[]{"Example One", "Example Two", "Example Three", "Example Four", "Example Five" , "Example Six" , "Example Seven"});
//        rv.setAdapter(adapter);
//
//        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
//
//        rv.setLayoutManager(new GridLayoutManager(getActivity(),2));

        return rootView;
    }

}