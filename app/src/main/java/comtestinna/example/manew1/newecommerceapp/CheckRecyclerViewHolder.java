package comtestinna.example.manew1.newecommerceapp;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckRecyclerViewHolder extends RecyclerView.ViewHolder{

    public TextView quantity, productName, productPrice,productSize;
    public Button  removeProduct;

   public ImageView productImage;

    public CheckRecyclerViewHolder(View itemView) {
        super(itemView);

        quantity = (TextView)itemView.findViewById(R.id.product_qty);
        productName =(TextView)itemView.findViewById(R.id.product_name);
        productPrice = (TextView)itemView.findViewById(R.id.product_price);
        removeProduct = (Button) itemView.findViewById(R.id.removeBtn);
        productImage=itemView.findViewById(R.id.product_image);
        productSize=itemView.findViewById(R.id.product_size);

    }
}
