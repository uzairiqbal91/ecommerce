package comtestinna.example.manew1.newecommerceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

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
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

import de.clemenskeppler.materialsearchview.MaterialSearchView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Button mButton;
    private boolean isFragmentDisplayed = false;
    List<Book> productlists = new ArrayList<>();
    SearchAdapter searchAdapter;
    MaterialSearchView materialSearchView;
    RecyclerView results;
    SearchView searchView;
    ExpandableListView ev_list;

    // Saved instance state key.
    static final String STATE_FRAGMENT = "state_of_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        // working navigation view with  extendible list view

        ArrayList<Model_country> al_main = new ArrayList<>();
//        al_main.add(new Model_country("hii"));
        CategoryAdapter obj_adapter;
        obj_adapter = new CategoryAdapter(MainActivity.this, al_main);


        ev_list = (ExpandableListView) findViewById(R.id.left_drawer);



        ev_list.setAdapter(obj_adapter);

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
        FragmentOne simpleFragment = new FragmentOne();
        // Get the FragmentManager and start a transaction.
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        // Add the SimpleFragment.
        fragmentTransaction.add(R.id.fragment_container,
                simpleFragment).addToBackStack(null).commit();

        // Update the Button text.

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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
