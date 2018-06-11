package comtestinna.example.manew1.newecommerceapp;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {
    private final LayoutInflater inflater;
    private List<Book> results;

    private Context mContext ;

    public SearchAdapter(@NonNull Context mContext, @NonNull List<Book> previousResults) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
        results = previousResults;

    }

    @Override public SearchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.custom_search_item, parent, false);
        return new SearchHolder(itemView);
    }

    @Override public void onBindViewHolder(SearchHolder holder,final int position) {
        final String result = results.get(position).getTitle();
        final Integer imgSrc=results.get(position).getThumbnail();
        final String price=results.get(position).getPrice();




        holder.result.setText(result);
        holder.imageView.setImageResource(imgSrc);
        holder.price.setText(price);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,ProductDetailActivity.class);
                intent.putExtra("Title",results.get(position).getTitle());
                intent.putExtra("Description",results.get(position).getDescription());
                intent.putExtra("Thumbnail",results.get(position).getThumbnail());

                Bundle bndlanimation =
                        ActivityOptions.makeCustomAnimation(mContext, R.anim.aniamtion,R.anim.animation1).toBundle();

                mContext.startActivity(intent,bndlanimation);
            }
        });
    }

    @Override public int getItemCount() {
        return results.size();
    }

    public void add(List<Book> listitem) {
        results=new ArrayList<>();
        results.addAll(listitem);
        notifyDataSetChanged();
    }
    public void setfilter(List<Book> listitem)
    {
        results=new ArrayList<>();
        results.addAll(listitem);
        notifyDataSetChanged();
    }


    class SearchHolder extends RecyclerView.ViewHolder {
        TextView result;
        ImageView imageView;
        TextView price;
        RelativeLayout relativeLayout;
        CardView cardView;

        SearchHolder(View itemView) {
            super(itemView);


            result = (TextView) itemView.findViewById(R.id.product_title);
        imageView=(ImageView) itemView.findViewById(R.id.product_image);
        price=(TextView)itemView.findViewById(R.id.product_price);
        relativeLayout=itemView.findViewById(R.id.search_relative_layout);
            cardView = (CardView) itemView.findViewById(R.id.search_card_view);
        }
    }
}