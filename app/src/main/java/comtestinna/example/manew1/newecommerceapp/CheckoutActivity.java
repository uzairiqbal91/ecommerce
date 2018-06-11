package comtestinna.example.manew1.newecommerceapp;



import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    private static final String TAG = CheckoutActivity.class.getSimpleName();

    private RecyclerView checkRecyclerView;

    Button continueShopping;
    Button checkout;

    public static TextView subTotal;

   public static double mSubTotal = 0;
    Button removeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setTitle("Over Cart");

        subTotal = (TextView )findViewById(R.id.sub_total);

        checkRecyclerView = (RecyclerView)findViewById(R.id.checkout_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CheckoutActivity.this);
        checkRecyclerView.setLayoutManager(linearLayoutManager);
        checkRecyclerView.setHasFixedSize(true);
        checkRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(CheckoutActivity.this));

        removeBtn=findViewById(R.id.removeBtn);







        // get content of cart
//        MySharedPreference mShared = new MySharedPreference(CheckoutActivity.this);
//
//        GsonBuilder builder = new GsonBuilder();
//        Gson gson = builder.create();
//
//        Book[] addCartProducts = gson.fromJson(mShared.retrieveProductFromCart(),Book[].class);
//        List<Book> productList = convertObjectArrayToListObject(addCartProducts);
//





        String productListAsString = getIntent().getStringExtra("productList");
        Type type = new TypeToken<List<Book>>(){}.getType();
        Gson gson = new Gson();
        List<Book> addCartProducts = gson.fromJson(productListAsString,type);
checkout=findViewById(R.id.checkout);

checkout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(CheckoutActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.form, null);
        final EditText mName = (EditText) mView.findViewById(R.id.userNameText);
        final EditText mEmail = (EditText) mView.findViewById(R.id.emailIdText);
        final EditText mphone = (EditText) mView.findViewById(R.id.phoneNoText);
        final EditText mAddress = (EditText) mView.findViewById(R.id.adressText);

        Button mSend = (Button) mView.findViewById(R.id.btn_sendBtn);



        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.getWindow().getAttributes().windowAnimations = R.anim.anim_left;
        dialog.show();

        mSend.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Toast.makeText(CheckoutActivity.this, mName.getText(), Toast.LENGTH_SHORT).show();
dialog.dismiss();




                AlertDialog.Builder mBuilder1 = new AlertDialog.Builder(CheckoutActivity.this);
                View mView1 = getLayoutInflater().inflate(R.layout.paypal_checkout, null);



                mBuilder1.setView(mView1);


                final AlertDialog dialog1 = mBuilder1.create();

                dialog1.getWindow().getAttributes().windowAnimations = R.anim.anim_left;

                dialog1.show();


            }
        });
    }
});









       // List<Book> productList = convertObjectArrayToListObject(addCartProducts);




//
        CheckRecyclerViewAdapter mAdapter = new CheckRecyclerViewAdapter(CheckoutActivity.this, ProductDetailActivity.addCartProducts);
        checkRecyclerView.setAdapter(mAdapter);
//


         mSubTotal = getTotalPrice(ProductDetailActivity.addCartProducts);
         subTotal.setText("Total: " + String.valueOf(mSubTotal) + " $");

         continueShopping=findViewById(R.id.shopping);

         continueShopping.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


finish();
             }
         });
//
//
//        Button shoppingButton = (Button)findViewById(R.id.shopping);
//        assert shoppingButton != null;
//        shoppingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent shoppingIntent = new Intent(CheckoutActivity.this, ShoppingActivity.class);
//                startActivity(shoppingIntent);
//            }
//        });
//
//        Button checkButton = (Button)findViewById(R.id.checkout);
//        assert checkButton != null;
//        checkButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent paymentIntent = new Intent(CheckoutActivity.this, PayPalCheckoutActivity.class);
//                paymentIntent.putExtra("TOTAL_PRICE", mSubTotal);
//                startActivity(paymentIntent);
//            }
//        });
    }
//
//    private List<Book> convertObjectArrayToListObject(Book[] allProducts){
//        List<Book> mProduct = new ArrayList<Book>();
////        Collections.addAll(mProduct, allProducts);
//        return mProduct;
//    }

//    private int returnQuantityByProductName(String productName, List<Book> mProducts){
//        int quantityCount = 0;
//        for(int i = 0; i < mProducts.size(); i++){
//            Book pObject = mProducts.get(i);
//            if(pObject.getTitle().trim().equals(productName.trim())){
//                quantityCount++;
//            }
//        }
//        return quantityCount;
//    }

    public static double  getTotalPrice(List<Book> mProducts){
        double totalCost = 0;

        for(int i = 0; i < mProducts.size(); i++){

            totalCost = totalCost + Double.parseDouble(mProducts.get(i).getPrice());
        }

        return totalCost;
    }
}

