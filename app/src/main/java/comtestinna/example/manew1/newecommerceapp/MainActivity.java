package comtestinna.example.manew1.newecommerceapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.clemenskeppler.materialsearchview.MaterialSearchView;
import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Button mButton;
    private boolean isFragmentDisplayed = false;
    List<Book> productlists = new ArrayList<>();
    SearchAdapter searchAdapter;
    MaterialSearchView materialSearchView;
    RecyclerView results;
    SearchView searchView;
    ExpandableListView expandableList;
    public static UserDetail userDetail;
    public static Context activityContext;
    public static boolean userCheck=false;
    public static User_SharedPreference dataProccessor;

    String fragmentTg;


    ExpendibleListAdapter mMenuAdapter;
    static FragmentManager  fragmentManager ;

    List<String> listDataHeader;
    DrawerLayout drawer;
    HashMap<String, List<String>> listDataChild;
    static int[] icon = { R.drawable.ic_menu_camera, R.drawable.ic_menu_camera,
            R.drawable.ic_menu_camera, R.drawable.ic_menu_camera,
            R.drawable.ic_menu_camera, R.drawable.ic_menu_camera, R.drawable.ic_menu_camera};

    // Saved instance state key.
    static final String STATE_FRAGMENT = "state_of_fragment";

    View view_Group;
   // public static List<OrderDetail> order;



    List <String> user_data;
    ProfileFragment simpleFragment = new ProfileFragment();

    // Saved instance state key.

    String value;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            expandableList.setIndicatorBounds(expandableList.getRight()- 80, expandableList.getWidth());
        } else {
            expandableList.setIndicatorBoundsRelative(expandableList.getRight()- 80, expandableList.getWidth());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        activityContext=getApplicationContext();

//        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
////
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        expandableList = (ExpandableListView) findViewById(R.id.left_drawer);


        fragmentManager = getSupportFragmentManager();


        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        prepareListData();
        mMenuAdapter = new ExpendibleListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expandableList.setAdapter(mMenuAdapter);

        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView,
                                        View view,
                                        int groupPosition,
                                        int childPosition, long id) {
                //Log.d("DEBUG", "submenu item clicked");
                Toast.makeText(MainActivity.this,
                        "Header: "+String.valueOf(groupPosition) +
                                "\nItem: "+ String.valueOf(childPosition), Toast.LENGTH_SHORT)
                        .show();



                if(childPosition==0)
                {

                    displaySecondFragment();

                }
                view_Group=view;
                view.setSelected(true);
                if (view_Group != null) {
                    view_Group.setBackgroundColor(Color.parseColor("#ffffff"));
                }

                view_Group.setBackgroundColor(Color.parseColor("#DDDDDD"));
                drawer.closeDrawers();

                return false;
            }
        });
        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                //Log.d("DEBUG", "heading clicked");

                Toast.makeText(MainActivity.this,
                        "Clicekd: ", Toast.LENGTH_SHORT)
                        .show();



                return false;
            }
        });


        LinearLayout layout_profile=findViewById(R.id.layout_profile);
        layout_profile.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {

                fragmentTg="MainFragment";
                Toast.makeText(MainActivity.this,
                        "ClicekdHome: ", Toast.LENGTH_SHORT)
                        .show();
                displayProfileFragment();
                drawer.closeDrawers();
                //   Toast.makeText(getApplicationContext(),String.valueOf(getSupportFragmentManager().getFragments().get(0).isMenuVi\sible()),Toast.LENGTH_LONG).show();

            }



        });


        LinearLayout layout_home=findViewById(R.id.layout_home);
        layout_home.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {

                fragmentTg="MainFragment";
                Toast.makeText(MainActivity.this,
                        "ClicekdHome: ", Toast.LENGTH_SHORT)
                        .show();
               displayMainFragment();
                    drawer.closeDrawers();
                 //   Toast.makeText(getApplicationContext(),String.valueOf(getSupportFragmentManager().getFragments().get(0).isMenuVi\sible()),Toast.LENGTH_LONG).show();

                }



        });


        LinearLayout layout_recent=findViewById(R.id.layout_recent);
        layout_recent.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {

               // fragmentTg="MainFragment";
                Toast.makeText(MainActivity.this,
                        "Clicekd recent: ", Toast.LENGTH_SHORT)
                        .show();
                displayRecentListFragment();
                drawer.closeDrawers();
                //   Toast.makeText(getApplicationContext(),String.valueOf(getSupportFragmentManager().getFragments().get(0).isMenuVi\sible()),Toast.LENGTH_LONG).show();

            }



        });

        LinearLayout layout_deals=findViewById(R.id.layout_deals);
        layout_deals.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {

                // fragmentTg="MainFragment";
                Toast.makeText(MainActivity.this,
                        "Clicekd delas: ", Toast.LENGTH_SHORT)
                        .show();
                displayDealListFragment();
                drawer.closeDrawers();
                //   Toast.makeText(getApplicationContext(),String.valueOf(getSupportFragmentManager().getFragments().get(0).isMenuVi\sible()),Toast.LENGTH_LONG).show();

            }



        });

        LinearLayout layout_topseller=findViewById(R.id.layout_topSeller);
        layout_topseller.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {

                // fragmentTg="MainFragment";
                Toast.makeText(MainActivity.this,
                        "Clicekd topsellers: ", Toast.LENGTH_SHORT)
                        .show();
                displayTopSellerListFragment();
                drawer.closeDrawers();
                //   Toast.makeText(getApplicationContext(),String.valueOf(getSupportFragmentManager().getFragments().get(0).isMenuVi\sible()),Toast.LENGTH_LONG).show();

            }



        });















      // accesign navigation view header
        View header = navigationView.getHeaderView(0);

//        Button editbtn=header.findViewById(R.id.edit_profile_button);
//        editbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"clicked edit",Toast.LENGTH_LONG).show();
//                displayProfileFragment();
//            }
//        });


        //sharedpreference
         dataProccessor = new User_SharedPreference(this);



        CircleImageView circleImageView=header.findViewById(R.id.imageView);

//       circleImageView.setImageResource(userDetail.getProifilePic());

        dataProccessor.setStr("User_count","false");

         value=dataProccessor.getStr("User_count");

       circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View mView = getLayoutInflater().inflate(R.layout.form, null);
                final EditText mName = (EditText) mView.findViewById(R.id.userNameText);
                final EditText mEmail = (EditText) mView.findViewById(R.id.emailIdText);
                final EditText mphone = (EditText) mView.findViewById(R.id.phoneNoText);
                final EditText mAddress = (EditText) mView.findViewById(R.id.adressText);






                if (value.equalsIgnoreCase("true"))
                {

                    displayProfileFragment();
                    drawer.closeDrawer(GravityCompat.START);




                }


                else
                {
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);



                    Button mSend = (Button) mView.findViewById(R.id.btn_sendBtn);



                    mBuilder.setView(mView);
                    final AlertDialog dialog = mBuilder.create();
                    dialog.getWindow().getAttributes().windowAnimations = R.anim.anim_left;
                    dialog.show();







                    mSend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

// saving user data to shared preference





                            dataProccessor.setStr("User_name",String.valueOf(mName.getText()));
                            dataProccessor.setStr("User_phone",String.valueOf(mphone.getText()));
                            dataProccessor.setStr("User_address",String.valueOf(mAddress.getText()));
                            dataProccessor.setStr("User_email",String.valueOf(mEmail.getText()));

                            dataProccessor.setStr("User_count","true");



                            value=dataProccessor.getStr("User_count");
//
//                            user_data.add(String.valueOf(mName.getText()));
//                            user_data.add(String.valueOf(mphone.getText()));
//                            user_data.add(String.valueOf(mAddress.getText()));
//                            user_data.add(String.valueOf(mEmail.getText()));


//                            Set<String> set = new HashSet<String>();
//                            dataProccessor.setArray("user_data",set,user_data);
//
//                            Set<String> getset=dataProccessor.getArray("user_data");
//
//                            Toast.makeText(getApplicationContext(),String.valueOf(getset),Toast.LENGTH_LONG).show();



                            userDetail=new UserDetail(dataProccessor.getStr("User_name"),dataProccessor.getStr("User_phone"),dataProccessor.getStr("User_address"),dataProccessor.getStr("User_email"));

                            //Toast.makeText(getApplicationContext(),prfs.getString("User_name",""),Toast.LENGTH_LONG).show();

                            userDetail.setCheckProfileCreate(true);
                            userCheck=true;

                            dialog.dismiss();



                            displayProfileFragment();


                            drawer.closeDrawer(GravityCompat.START);



                        }
                    });

                }




            }
        });

        // working navigation view with  extendible list view

        ArrayList<Model_country> al_main = new ArrayList<>();
//        al_main.add(new Model_country("hii"));
        CategoryAdapter obj_adapter;
        obj_adapter = new CategoryAdapter(MainActivity.this, al_main);



//        ev_list = (ExpandableListView) findViewById(R.id.left_drawer);
//
//
//
//        ev_list.setAdapter(obj_adapter);

        // working for searching

       productlists.add(new Book("The Vegitarian","$100","Description book",R.drawable.thevigitarian));
        productlists.add(new Book("The Wild Robot","$150","Description book",R.drawable.thewildrobot));

        materialSearchView = findViewById(R.id.materialSearchView);
        searchView = materialSearchView.getSearchView();
        results = materialSearchView.getSearchResults();
        searchAdapter = new SearchAdapter(this,  productlists);
        results.setAdapter(searchAdapter);
        results.setLayoutManager(new LinearLayoutManager(this));
//
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String query) {

                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
//                myActionMenuItem.collapseActionView();
                return false;
//                searchAdapter.add(query);
//                return true;
            }


            @Override public boolean onQueryTextChange(String newText) {


                final  List<Book> filtermodelist=filter(productlists,newText);
                searchAdapter.setfilter(filtermodelist);
                return true;
            }
        });




            // If returning from a configuration change, get the
        // fragment state and set the button text.
//        if (savedInstanceState != null) {
//            isFragmentDisplayed = savedInstanceState.getBoolean(STATE_FRAGMENT);
//            if (isFragmentDisplayed) {
//                // If the fragment is displayed, change button to "close".
//                mButton.setText(R.string.close);
//            }
//        }
        displayFragment();






        //////////////////////////////////////////////////////////////
//        android.widget.Button btn=(android.widget.Button)findViewById(R.id.mainBtn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                android.app.FragmentManager fragmentManager=getFragmentManager();
////                android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
////
////
////                FragmentOne fragmentone=new FragmentOne();
////                fragmentManager.beginTransaction().replace(R.id.mainactivty).commit();
////                fragmentTransaction.add(R.id.mainactivty,fragmentone);
////                fragmentTransaction.commit();
//
//
//            }
//        });


//        FragmentOne fragmentone=new FragmentOne();
//        this.getSupportFragmentManager().beginTransaction()
//                            .add(R.id.fragment_frame, new FragmentOne(), "createPost").addToBackStack(null).commit();
//         getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.mainactivty, fragmentone, fragmentone.getClass().getSimpleName()).addToBackStack(null).commit();



    }

    public void displaySecondFragment() {
        // Instantiate the fragment.
        fragmentTg="SecondActivity";

        try {
            FragmentTwo simpleFragment = new FragmentTwo();

            // Get the FragmentManager and start a transaction.
            FragmentManager  fragmentManager ;
            FragmentTransaction fragmentTransaction ;
           fragmentManager = getSupportFragmentManager();
              fragmentTransaction = fragmentManager
                    .beginTransaction();

            // Add the SimpleFragment.
            fragmentTransaction.replace(R.id.fragment_container, simpleFragment);
            fragmentTransaction.addToBackStack(null).commit();

        } catch (Exception e) {
            e.printStackTrace();
        }


        // Update the Button text.

    }

    public static void displayRecentListFragment() {
        // Instantiate the fragment.


        try {
            FragmentListRecent simpleFragment = new FragmentListRecent();

            // Get the FragmentManager and start a transaction.
            FragmentTransaction fragmentTransaction ;

            fragmentTransaction = fragmentManager
                    .beginTransaction();

            // Add the SimpleFragment.
            fragmentTransaction.replace(R.id.fragment_container, simpleFragment);
            fragmentTransaction.addToBackStack(null).commit();


        } catch (Exception e) {
            e.printStackTrace();
        }


        // Update the Button text.

    }

    public static void displayDealListFragment() {
        // Instantiate the fragment.

        try {
            FragmentDealsList simpleFragment = new FragmentDealsList();

            // Get the FragmentManager and start a transaction.
            FragmentTransaction fragmentTransaction ;

            fragmentTransaction = fragmentManager
                    .beginTransaction();

            // Add the SimpleFragment.
            fragmentTransaction.replace(R.id.fragment_container, simpleFragment);
            fragmentTransaction.addToBackStack(null).commit();


        } catch (Exception e) {
            e.printStackTrace();
        }


        // Update the Button text.

    }

    public  static  void displayTopSellerListFragment() {
        // Instantiate the fragment.


        try {
            FragmentTopSellerList simpleFragment = new FragmentTopSellerList();

            // Get the FragmentManager and start a transaction.



            FragmentTransaction fragmentTransaction ;

            fragmentTransaction = fragmentManager
                    .beginTransaction();

            // Add the SimpleFragment.
            fragmentTransaction.replace(R.id.fragment_container, simpleFragment);
            fragmentTransaction.addToBackStack(null).commit();

        } catch (Exception e) {
            e.printStackTrace();
        }


        // Update the Button text.

    }



    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding data header
        listDataHeader.add("Categories");


        // Adding child data
        List<String> heading1 = new ArrayList<String>();
        heading1.add("Women");
        heading1.add("Men");
        heading1.add("Movies");
        heading1.add("Tv Series");
        heading1.add("Models");
        heading1.add("Games");





        listDataChild.put(listDataHeader.get(0), heading1);// Header, Child data


    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawer.closeDrawers();
                        return true;
                    }
                });
    }

    private List<Book> filter(List<Book> pl,String query)
    {
        query=query.toLowerCase();
        final List<Book> filteredModeList=new ArrayList<>();
        for (Book model:pl)
        {
            final String text=model.getTitle().toLowerCase();
            if (text.startsWith(query))
            {
                filteredModeList.add(model);
            }


        }
        return filteredModeList;
    }

    public void displayFragment() {
        // Instantiate the fragment.

//        FragmentOne simpleFragment = new FragmentOne();
        fragmentTg="MainFragment";

        try {
            main_fragment simpleFragment = new main_fragment();
            // Get the FragmentManager and start a transaction.
            FragmentManager  fragmentManager ;
            FragmentTransaction fragmentTransaction ;
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager
                    .beginTransaction();

            // Add the SimpleFragment.
            fragmentTransaction.add(R.id.fragment_container,
                    simpleFragment).addToBackStack(null).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Update the Button text.

    }

    public void displayProfileFragment() {
        // Instantiate the fragment.

        // Get the FragmentManager and start a transaction.
        fragmentTg="ProfileFragment";

        try {
            ProfileFragment simpleFragment = new ProfileFragment();
            FragmentManager  fragmentManager ;
            FragmentTransaction fragmentTransaction ;
             fragmentManager = getSupportFragmentManager();
              fragmentTransaction = fragmentManager
                    .beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, simpleFragment);
            fragmentTransaction.addToBackStack(null).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Add the SimpleFragment.


        // Update the Button text.

    }

    public void displayMainFragment()
    {
        try {
            main_fragment simpleFragment = new main_fragment();
            // Get the FragmentManager and start a transaction.
            FragmentManager  fragmentManager ;
            FragmentTransaction fragmentTransaction ;
            fragmentManager = getSupportFragmentManager();
           fragmentTransaction = fragmentManager
                    .beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, simpleFragment);
            fragmentTransaction.addToBackStack(null).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//    public void closeFragment() {
//        // Get the FragmentManager.
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        // Check to see if the fragment is already showing.
//        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager
//                .findFragmentById(R.id.fragment_container);
//        if (simpleFragment != null) {
//            // Create and commit the transaction to remove the fragment.
//            FragmentTransaction fragmentTransaction =
//                    fragmentManager.beginTransaction();
//            fragmentTransaction.remove(simpleFragment).commit();
//        }
//        // Update the Button text.
//        mButton.setText(R.string.open);
//        // Set boolean flag to indicate fragment is closed.
//        isFragmentDisplayed = false;
//    }

//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        // Save the state of the fragment (true=open, false=closed).
//        savedInstanceState.putBoolean(STATE_FRAGMENT, isFragmentDisplayed);
//        super.onSaveInstanceState(savedInstanceState);
//    }


    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_drawer_shopping);

        menuItem.setIcon(Converter1.convertLayoutToImage(MainActivity.this,ProductDetailActivity.cart_count,R.drawable.ic_shopping_cart_black_24dp));
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (item.getItemId() == R.id.action_drawer_search) {
            materialSearchView.show();
        }

        if (id == R.id.action_drawer_shopping) {
            Intent checkoutIntent = new Intent(MainActivity.this, CheckoutActivity.class);


           // checkoutIntent.putExtra("productList",jsonProducts);

            startActivity(checkoutIntent);
            return true;
        }



        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
        super.onResume();



        invalidateOptionsMenu();

    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
