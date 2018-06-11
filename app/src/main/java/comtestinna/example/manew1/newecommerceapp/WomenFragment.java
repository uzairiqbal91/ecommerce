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

public class WomenFragment extends Fragment {
    public WomenFragment() {
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
        List<Book> lstBook;
        lstBook = new ArrayList<>();

        lstBook.add(new Book("The Vegitarian","$100","Description book",R.drawable.women1));
        lstBook.add(new Book("The Wild Robot","$150","Description book",R.drawable.women2));
        lstBook.add(new Book("Maria Semples","$200","Description book",R.drawable.women3));
        lstBook.add(new Book("The Martian","$130","Description book",R.drawable.women4));
        lstBook.add(new Book("He Died with...","$300","Description book",R.drawable.women5));
        lstBook.add(new Book("The Vegitarian","$100","Description book",R.drawable.women1));
        lstBook.add(new Book("The Wild Robot","$150","Description book",R.drawable.women2));
        lstBook.add(new Book("Maria Semples","$200","Description book",R.drawable.women3));
        lstBook.add(new Book("The Martian","$130","Description book",R.drawable.women4));
        lstBook.add(new Book("He Died with...","$300","Description book",R.drawable.women5));
        lstBook.add(new Book("The Vegitarian","$100","Description book",R.drawable.women1));
        lstBook.add(new Book("The Wild Robot","$150","Description book",R.drawable.women2));
        lstBook.add(new Book("Maria Semples","$200","Description book",R.drawable.women3));
        lstBook.add(new Book("The Martian","$130","Description book",R.drawable.women4));
        lstBook.add(new Book("He Died with...","$300","Description book",R.drawable.women5));
        RecyclerView myrv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);




        MyAdapter myAdapter = new  MyAdapter(getActivity(),lstBook);
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
