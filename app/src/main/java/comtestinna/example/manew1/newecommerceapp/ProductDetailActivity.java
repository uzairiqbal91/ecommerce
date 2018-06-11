package comtestinna.example.manew1.newecommerceapp;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import co.ceryle.segmentedbutton.SegmentedButton;
import co.ceryle.segmentedbutton.SegmentedButtonGroup;

public class ProductDetailActivity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPager viewPager1;
    sliderProductAdapter sliderProductAdapter;
    ImageButton myButton;
    ImageButton myButton1;
    Button buttonaddtocart;
    private int cartProductNumber = 0;
    Button btnsize1;
    Button btnsize2;
    Button btnsize3;
    Button btnsize4;
    Button btnsize5;
    Button btnsize6;

    Button checkButton;

    public static int cart_count=0;
    TextView textViewDescription;
    Button  arrowbtn;

    RelativeLayout relativeLayout;

    View myView;
    View myView1;
    View myview2;
    View addtocartview;

    RadioGroup sizeRadioGroup;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private Gson gson;
     Book singleProduct;
    String jsonProducts;
     static List<Book> addCartProducts= new ArrayList<>();;
    private MySharedPreference sharedPreference;
    List<String> slider;


    TextView title;

   public String size="M";

    TextView price;
    Integer productImage;



    @Override
    protected void onResume() {
        super.onResume();
        cart_count=addCartProducts.size();

        invalidateOptionsMenu();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);


//        working on size buttons


//        sizeRadioGroup=(RadioGroup) findViewById(R.id.sizeradiogroup);

//        sizeRadioGroup.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//
//            public boolean onTouch(View v, MotionEvent event) {
//               if( v.getId()==R.id.sizebtn1)
//               {
//                   Toast.makeText(getApplicationContext(),"touched button 01",Toast.LENGTH_SHORT).show();
//               }
//                if( v.getId()==R.id.sizebtn2)
//                {
//                    Toast.makeText(getApplicationContext(),"touched button 02",Toast.LENGTH_SHORT).show();
//                }
//
//                return false;
//            }
//        });

//        sizeRadioGroup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if( v.getId()==R.id.sizebtn1)
//               {
//                   Toast.makeText(getApplicationContext(),"touched button 01",Toast.LENGTH_SHORT).show();
//               }
//                if( v.getId()==R.id.sizebtn2)
//                {
//                    Toast.makeText(getApplicationContext(),"touched button 02",Toast.LENGTH_SHORT).show();
//                }
//
//
//        }
//        });



        btnsize1=(Button) findViewById(R.id.sizebtn1);
        btnsize2=(Button) findViewById(R.id.sizebtn2);
        btnsize3=(Button) findViewById(R.id.sizebtn3);
        btnsize4=(Button) findViewById(R.id.sizebtn4);
        btnsize5=(Button) findViewById(R.id.sizebtn5);
        btnsize6=(Button) findViewById(R.id.sizebtn6);





//        btnsize1.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                btnsize1.setPressed(true);
//                Toast.makeText(getApplicationContext(),btnsize1.getText(),Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
//        btnsize1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                Toast.makeText(getApplicationContext(),"change",Toast.LENGTH_SHORT).show();
//                if(!hasFocus){
//                    //this if condition is true when edittext lost focus...
//                    //check here for number is larger than 10 or not
//                    btnsize1.setPressed(true);
//                }
//            }
//        });
//
//
//        btnsize2.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                btnsize1.setPressed(false);
//                Toast.makeText(getApplicationContext(),btnsize2.getText(),Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
//
//        btnsize2.setPressed(true);


        title=findViewById(R.id.title);
        price=findViewById(R.id.price);
        productImage=getIntent().getIntExtra("Thumbnail",0);

        title.setText("Men Jacket");
        price.setText("100");










        viewPager = (ViewPager) findViewById(R.id.productViewPager);


        sliderProductAdapter=new sliderProductAdapter(this);

        viewPager.setAdapter(sliderProductAdapter);






//        for suggestion bar
        getData();


        sharedPreference = new MySharedPreference(ProductDetailActivity.this);
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();

        String productInStringFormat = getIntent().getExtras().getString("PRODUCT");
        singleProduct = gson.fromJson(productInStringFormat, Book.class);

        buttonaddtocart=findViewById(R.id.addtocart);


        final SegmentedButtonGroup segmentedButtonGroup=findViewById(R.id.segmentedBtnGrp);

segmentedButtonGroup.setOnClickedButtonPosition(new SegmentedButtonGroup.OnClickedButtonPosition() {
    @Override
    public void onClickedButtonPosition(int position) {

        switch (position){
            case 0 :

            size="M";
            break;


            case 1 :

                size="L";
                break;

            case 2 :

                size="XL";
                break;

            case 3 :

                size="2-XL";
                break;
            case 4 :

                size="3-XL";
                break;
            case 5 :

                size="XS";
                break;

                default:
                    size="M";
                    break;





        }


    }
});





        buttonaddtocart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),size,Toast.LENGTH_LONG).show();

                addCartProducts.add(new Book(String.valueOf(title.getText()),String.valueOf(price.getText()),"Description book",productImage,size));
                cart_count=addCartProducts.size();

                invalidateOptionsMenu();













//                String productsFromCart = sharedPreference.retrieveProductFromCart();
//                if(productsFromCart.equals("")){
//                    List<Book> cartProductList = new ArrayList<Book>();
//                    cartProductList.add(singleProduct);
//                    String cartValue = gson.toJson(cartProductList);
//                    sharedPreference.addProductToTheCart(cartValue);
//                    cartProductNumber = cartProductList.size();
//                }
//                else{
//                    String productsInCart = sharedPreference.retrieveProductFromCart();
//                    Book[] storedProducts = gson.fromJson(productsInCart, Book[].class);
//
//                    List<Book> allNewProduct = convertObjectArrayToListObject(storedProducts);
//                    allNewProduct.add(singleProduct);
//                    String addAndStoreNewProduct = gson.toJson(allNewProduct);
//                    sharedPreference.addProductToTheCart(addAndStoreNewProduct);
//                    cartProductNumber = allNewProduct.size();
//                }
//                sharedPreference.addProductCount(cartProductNumber);
//                invalidateOptionsMenu();



            }
        });













        Gson gson = new Gson();

         jsonProducts = gson.toJson(addCartProducts);




    }
    private List<Book> convertObjectArrayToListObject(Book[] allProducts){
        List<Book> mProduct = new ArrayList<Book>();
        Collections.addAll(mProduct, allProducts);
        return mProduct;
    }
    private void getData(){




        mImageUrls.add(R.drawable.women1);
        mNames.add("The Vegitarian");
        mPrice.add("$100");

        mImageUrls.add(R.drawable.women1);
        mNames.add("The Vegitarian");
        mPrice.add("$100");

        mImageUrls.add(R.drawable.women1);
        mNames.add("The Vegitarian");
        mPrice.add("$100");

        mImageUrls.add(R.drawable.women1);
        mNames.add("The Vegitarian");
        mPrice.add("$100");
        mImageUrls.add(R.drawable.women1);
        mNames.add("The Vegitarian");
        mPrice.add("$100");
        mImageUrls.add(R.drawable.women1);
        mNames.add("The Vegitarian");
        mPrice.add("$100");
        mImageUrls.add(R.drawable.women1);
        mNames.add("The Vegitarian");
        mPrice.add("$100");
        mImageUrls.add(R.drawable.women1);
        mNames.add("The Vegitarian");
        mPrice.add("$100");
        mImageUrls.add(R.drawable.women1);
        mNames.add("The Vegitarian");
        mPrice.add("$100");
        mImageUrls.add(R.drawable.women1);
        mNames.add("The Vegitarian");
        mPrice.add("$100");



        initRecyclerView();

    }
    private void initRecyclerView(){


        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        SuggestionSliderAdapter adapter = new SuggestionSliderAdapter(this, mNames,mPrice, mImageUrls);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main1, menu);
        MenuItem menuItem = menu.findItem(R.id.cart_action);

        menuItem.setIcon(Converter.convertLayoutToImage(ProductDetailActivity.this,cart_count,R.drawable.ic_chopping_black));
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.cart_action) {
            Intent checkoutIntent = new Intent(ProductDetailActivity.this, CheckoutActivity.class);


            checkoutIntent.putExtra("productList",jsonProducts);

            startActivity(checkoutIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("ResourceAsColor")
//    public void ButtonFocus(View view) {
//
//
//
//        switch (view.getId()){
//            case R.id.sizebtn1 :
//
//
//
//                btnsize1.setPressed(true);
//                btnsize1.setClickable(true);
//
//
//
//                break;
//
//            case R.id.sizebtn2 :
//
//
//                btnsize2.setPressed(true);
//
//                break;
//
//        }
//    }

    private void setFocus(Button btn_unfocus, Button btn_focus){
        btn_unfocus.setTextColor(Color.rgb(49, 50, 51));
        btn_unfocus.setBackgroundColor(Color.rgb(207, 207, 207));
        btn_focus.setTextColor(Color.rgb(255, 255, 255));
        btn_focus.setBackgroundColor(Color.rgb(3, 106, 150));
//        this.btn_unfocus = btn_focus;
    }

}

