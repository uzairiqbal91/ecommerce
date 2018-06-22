package comtestinna.example.manew1.newecommerceapp;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.InputType;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   private TableLayout tableLayout;
   private AppBarLayout appBarLayout;
   private ViewPager viewPager;
    public CircleImageView circleImageView;
    public Button editBtn;
    public ImageButton userprofileImageBtn;

    private static final String IMAGE_DIRECTORY = "/demonuts";
    private int GALLERY = 1, CAMERA = 2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onDetach() {
        Toast.makeText(getActivity(),"detach here", Toast.LENGTH_LONG).show();
        super.onDetach();
    }

    @Override
    public void onPause() {
//        Toast.makeText(getActivity(),"detach here", Toast.LENGTH_LONG).show();
        super.onPause();
    }
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        final View rootView = inflater.inflate(R.layout.fragment_profile,
                container, false);
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.profile_viewpagere);

        final ProfileViewPagerAdapter profileViewPagerAdapter=new ProfileViewPagerAdapter(getChildFragmentManager());

        profileViewPagerAdapter.AddFragment(new UserProfileFragment(),"User Profile");
        profileViewPagerAdapter.AddFragment(new UserOrderFragment(),"User Order");

        viewPager.setAdapter(profileViewPagerAdapter);








        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.table_layout_profile);

        tabLayout.setupWithViewPager(viewPager);





        circleImageView=rootView.findViewById(R.id.imageView);
          circleImageView.setImageResource(MainActivity.userDetail.getProifilePic());

//          editBtn=rootView.findViewById(R.id.editprofileBtn);

        final View mView = getLayoutInflater().inflate(R.layout.form, null);
        final EditText mName = (EditText) mView.findViewById(R.id.userNameText);
        final EditText mEmail = (EditText) mView.findViewById(R.id.emailIdText);
        final EditText mphone = (EditText) mView.findViewById(R.id.phoneNoText);
        final EditText mAddress = (EditText) mView.findViewById(R.id.adressText);


        userprofileImageBtn=rootView.findViewById(R.id.user_imageview);
        //imageView=rootView.findViewById(R.id.imageView);

        userprofileImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPictureDialog();
            }
        });









//        editBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity.dataProccessor.setStr("User_name",String.valueOf(mName.getText()));
//                MainActivity.dataProccessor.setStr("User_phone",String.valueOf(mphone.getText()));
//                MainActivity.dataProccessor.setStr("User_address",String.valueOf(mAddress.getText()));
//                MainActivity.dataProccessor.setStr("User_email",String.valueOf(mEmail.getText()));
//                MainActivity.userDetail=new UserDetail(MainActivity.dataProccessor.getStr("User_name"),MainActivity.dataProccessor.getStr("User_phone"),MainActivity.dataProccessor.getStr("User_address"),MainActivity.dataProccessor.getStr("User_email"));
//            }
//        });

//          editBtn.setOnClickListener(new View.OnClickListener() {
//              @Override
//              public void onClick(View v) {
//
//
//
//
//
//
////                  MainActivity.dataProccessor.setStr("User_name",String.valueOf(mName.getText()));
////                  MainActivity.dataProccessor.setStr("User_phone",String.valueOf(mphone.getText()));
////                  MainActivity.dataProccessor.setStr("User_address",String.valueOf(mAddress.getText()));
////                  MainActivity.dataProccessor.setStr("User_email",String.valueOf(mEmail.getText()));
//
//
//
//                  mEmail.setEnabled(true);
//                  mphone.setEnabled(true);
//                  mAddress.setEnabled(true);
//
//
//
//
//
//                  AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
////                  View mView = getLayoutInflater().inflate(R.layout.form, null);
////                  final EditText mName = (EditText) mView.findViewById(R.id.userNameText);
////                  final EditText mEmail = (EditText) mView.findViewById(R.id.emailIdText);
////                  final EditText mphone = (EditText) mView.findViewById(R.id.phoneNoText);
////                  final EditText mAddress = (EditText) mView.findViewById(R.id.adressText);
//
//
//
//                  Button mSend = (Button) mView.findViewById(R.id.btn_sendBtn);
//
//
//
//
//                  mBuilder.setView(mView);
//                  final AlertDialog dialog = mBuilder.create();
//                  dialog.getWindow().getAttributes().windowAnimations = R.anim.anim_left;
//                  dialog.show();
//
//                  mName.setText(MainActivity.dataProccessor.getStr("User_name"));
//                  mEmail.setText(MainActivity.dataProccessor.getStr("User_email"));
//                  mphone.setText(MainActivity.dataProccessor.getStr("User_phone"));
//                  mAddress.setText(MainActivity.dataProccessor.getStr("User_address"));
//
//
//
////                  userDetail=new UserDetail(dataProccessor.getStr("User_name"),dataProccessor.getStr("User_phone"),dataProccessor.getStr("User_address"),dataProccessor.getStr("User_email"));
//
//
//                  mSend.setOnClickListener(new View.OnClickListener() {
//                      @Override
//                      public void onClick(View v) {
//
//
//
//                          MainActivity.dataProccessor.setStr("User_name",String.valueOf(mName.getText()));
//                          MainActivity.dataProccessor.setStr("User_phone",String.valueOf(mphone.getText()));
//                          MainActivity.dataProccessor.setStr("User_address",String.valueOf(mAddress.getText()));
//                          MainActivity.dataProccessor.setStr("User_email",String.valueOf(mEmail.getText()));
//
//
//                          MainActivity.userDetail=new UserDetail(MainActivity.dataProccessor.getStr("User_name"),MainActivity.dataProccessor.getStr("User_phone"),MainActivity.dataProccessor.getStr("User_address"),MainActivity.dataProccessor.getStr("User_email"));
//
//
//
//                          dialog.dismiss();
//
//
//                         // profileViewPagerAdapter.notifyDataSetChanged();
//
//
//
//
//
//
//
//                      }
//                  });
//
//
//
//
//
//
//
//              }
//          });


//        mName.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                Toast.makeText(getActivity(),"changed",Toast.LENGTH_LONG).show();
//
//            }
//
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });









        return rootView;
    }
    private void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(getActivity());
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }
    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), contentURI);
                    String path = saveImage(bitmap);
                    Toast.makeText(getActivity(), "Image Saved", Toast.LENGTH_SHORT).show();
                    userprofileImageBtn.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {


            if (ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {

                Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                circleImageView.setImageBitmap(thumbnail);
                saveImage(thumbnail);
                Toast.makeText(getActivity(), "Image Saved!", Toast.LENGTH_SHORT).show();

            }



        }
    }


    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();

        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(getActivity(),
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }


    // TODO: Rename method, update argument and hook method into UI event





}
