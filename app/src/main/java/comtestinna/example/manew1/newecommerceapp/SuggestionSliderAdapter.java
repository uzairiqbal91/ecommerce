package comtestinna.example.manew1.newecommerceapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SuggestionSliderAdapter extends RecyclerView.Adapter<SuggestionSliderAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    private Context mContext;

    public SuggestionSliderAdapter(Context context, ArrayList<String> names, ArrayList<String> price, ArrayList<Integer> imageUrls) {
        mNames = names;
        mImageUrls = imageUrls;
        mContext = context;
        mPrice = price;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.suggestionlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.image.setImageResource(mImageUrls.get(position));
        holder.name.setText(mNames.get(position));
        holder.price.setText(mPrice.get(position));

//        holder.image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onClick: clicked on an image: " + mNames.get(position));
//                Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });

    }



    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.book_img_id);
            name = (TextView) itemView.findViewById(R.id.book_title_id);
            price = (TextView) itemView.findViewById(R.id.book_price_id);
        }
    }
}
