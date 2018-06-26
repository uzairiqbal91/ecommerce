package comtestinna.example.manew1.newecommerceapp;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;



import java.util.List;

import static comtestinna.example.manew1.newecommerceapp.CheckoutActivity.mSubTotal;

public class CheckRecyclerViewAdapter extends RecyclerView.Adapter<CheckRecyclerViewHolder> {

    private Context context;

    private List<Book> mProductObject;

    public CheckRecyclerViewAdapter()
    {

    }

    public CheckRecyclerViewAdapter(Context context, List<Book> mProductObject) {
        this.context = context;
        this.mProductObject = mProductObject;
    }

    @Override
    public CheckRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {




        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.check_layout, parent, false);
        CheckRecyclerViewHolder productHolder = new CheckRecyclerViewHolder(layoutView);
        return productHolder;

    }

    @Override
    public void onBindViewHolder(CheckRecyclerViewHolder holder, final int position) {
        //get product quantity
        holder.quantity.setText("1");
        holder.productName.setText(mProductObject.get(position).getTitle());
        holder.productImage.setImageResource(mProductObject.get(position).getThumbnail());
        holder.productPrice.setText(mProductObject.get(position).getPrice());

        holder.productSize.setText(mProductObject.get(position).getSize());
        holder.quantity.setText(mProductObject.get(position).getQty());





        holder.removeProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProductDetailActivity.addCartProducts.remove(position);
                mSubTotal=CheckoutActivity.getTotalPrice(ProductDetailActivity.addCartProducts);

                updateview();



                CheckoutActivity.subTotal.setText("Total: " + String.valueOf(mSubTotal) + " $");



            }
        });



    }



    @Override
    public int getItemCount() {
        return mProductObject.size();
    }



    public void updateview()
    {

        notifyDataSetChanged();

    }


    public void clear() {
        final int size = ProductDetailActivity.addCartProducts.size();
        ProductDetailActivity.addCartProducts.clear();
        notifyItemRangeRemoved(0, size);
        updateview();

    }
}
