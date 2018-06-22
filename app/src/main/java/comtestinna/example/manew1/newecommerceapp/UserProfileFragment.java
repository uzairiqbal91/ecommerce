package comtestinna.example.manew1.newecommerceapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class UserProfileFragment extends Fragment {

    private ArrayList<String> detailTag;
    private ArrayList<Integer> imgSrc;
    public static ProfileDescriptionAdapter myAdapter;
    public static RecyclerView myrv;

    public EditText user_name;
    public EditText user_email;
    public EditText user_phone;
    public EditText user_address;


    public Button editBtn;
    public Button saveBtn;




    // public UserDetail userDetail;

    public UserProfileFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_user_profile_1, container, false);


        imgSrc=new ArrayList<>();
        detailTag=new ArrayList<>();

        imgSrc.add(R.drawable.user2);
        imgSrc.add(R.drawable.envelope);
        imgSrc.add(R.drawable.phonecall);
        imgSrc.add(R.drawable.resort);
        imgSrc.add(R.drawable.flag);
        imgSrc.add(R.drawable.street);
        imgSrc.add(R.drawable.accounts);






        detailTag.add(MainActivity.userDetail.getName());
        detailTag.add(MainActivity.userDetail.getEemail());
        detailTag.add(MainActivity.userDetail.getPhoneNum());
        detailTag.add(MainActivity.userDetail.getCity());
        detailTag.add(MainActivity.userDetail.getCountry());
        detailTag.add(MainActivity.userDetail.getStreetAddress());
        detailTag.add(MainActivity.userDetail.getAccountNum());



        user_name=(EditText)rootView.findViewById(R.id.description_tag_name);
        user_email=(EditText)rootView.findViewById(R.id.description_tag_email);
        user_phone=(EditText)rootView.findViewById(R.id.description_tag_phone);
        user_address=(EditText)rootView.findViewById(R.id.description_tag_address);


        editBtn=(Button) rootView.findViewById(R.id.editBtn);
        saveBtn=(Button) rootView.findViewById(R.id.saveBtn);

        user_name.setText(MainActivity.userDetail.getName());
        user_email.setText(MainActivity.userDetail.getEemail());
        user_phone.setText(MainActivity.userDetail.getPhoneNum());
        user_address.setText(MainActivity.userDetail.getStreetAddress());






//        user_name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//
//
//
//        });



        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UpdateEditText(user_name);
                UpdateEditText(user_email);
                UpdateEditText(user_phone);
                UpdateEditText(user_address);


                editBtn.setVisibility(View.GONE);
                saveBtn.setVisibility(View.VISIBLE);


            }
        });



        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.userDetail.setName(String.valueOf(user_name.getText()));
                MainActivity.userDetail.setEemail(String.valueOf(user_email.getText()));
                MainActivity.userDetail.setPhoneNum(String.valueOf(user_phone.getText()));
                MainActivity.userDetail.setStreetAddress(String.valueOf(user_address.getText()));


                saveBtn.setVisibility(View.GONE);
                editBtn.setVisibility(View.VISIBLE);


                user_name.setEnabled(false);
                user_email.setEnabled(false);
                user_phone.setEnabled(false);
                user_address.setEnabled(false);

                Toast.makeText(getActivity(),MainActivity.userDetail.getName(),Toast.LENGTH_LONG).show();
                Toast.makeText(getActivity(),MainActivity.userDetail.getEemail(),Toast.LENGTH_LONG).show();
                Toast.makeText(getActivity(),MainActivity.userDetail.getPhoneNum(),Toast.LENGTH_LONG).show();
                Toast.makeText(getActivity(),MainActivity.userDetail.getStreetAddress(),Toast.LENGTH_LONG).show();


            }
        });













//        myAdapter=new ProfileDescriptionAdapter(getActivity(),detailTag,imgSrc);
//
//
//
//
//        RecyclerView myrv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view_profile);
//
//        myrv.setLayoutManager(new GridLayoutManager(getActivity(),1));
//        myrv.setAdapter(myAdapter);







        return rootView;
    }

    public void UpdateEditText(EditText edit){

        edit.setEnabled(true);
        edit.requestFocus();
        edit.setCursorVisible(true);
        edit.setInputType(InputType.TYPE_CLASS_TEXT);



    }

}
