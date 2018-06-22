package comtestinna.example.manew1.newecommerceapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class UserOrderAdapter extends RecyclerView.Adapter<UserOrderAdapter.MyViewHolder> {

    private Context mContext ;
    private List<OrderDetail> mData ;
    View view ;


    public UserOrderAdapter(Context mContext, List<OrderDetail> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }





    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_order_description,parent,false);
        return new UserOrderAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.order_id.setText(mData.get(position).getOrderId());
        holder.order_date.setText(mData.get(position).getOrderDate());
        holder.order_price.setText("$"+mData.get(position).getOrderAmount());
        holder.order_qty.setText(mData.get(position).getOrderQty());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView order_id;
        TextView order_date;
        TextView order_qty;
        TextView order_price;

        CardView cardView ;


        public MyViewHolder(View itemView) {
            super(itemView);




            cardView = (CardView) itemView.findViewById(R.id.cardview_id_order_description);
            order_id=(TextView) itemView.findViewById(R.id.order_id) ;
            order_date=(TextView) itemView.findViewById(R.id.order_date) ;
            order_qty=(TextView) itemView.findViewById(R.id.order_qty) ;
            order_price=(TextView) itemView.findViewById(R.id.order_amount) ;






        }
    }

}
