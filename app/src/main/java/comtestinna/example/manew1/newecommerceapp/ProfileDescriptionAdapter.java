package comtestinna.example.manew1.newecommerceapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProfileDescriptionAdapter extends RecyclerView.Adapter<ProfileDescriptionAdapter.MyViewHolder> {

    private Context mContext ;
 private ArrayList<String> detailTag=new ArrayList<>();
 private ArrayList<Integer> imgSrc=new ArrayList<>();
    View view ;


    public ProfileDescriptionAdapter(Context mContext, ArrayList<String> detailTag,ArrayList<Integer> imgSrc) {
        this.mContext = mContext;
        this.detailTag=detailTag;
        this.imgSrc=imgSrc;
    }

    @NonNull
    @Override


    public ProfileDescriptionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_profile_description,parent,false);
        return new ProfileDescriptionAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileDescriptionAdapter.MyViewHolder holder, int position) {
        holder.tag.setText(detailTag.get(position));
        holder.img_book_thumbnail.setImageResource(imgSrc.get(position));
    }

    @Override
    public int getItemCount() {
        return detailTag.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tag;
        ImageView img_book_thumbnail;
        CardView cardView ;


        public MyViewHolder(View itemView) {
            super(itemView);


            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.description_tag_img_src);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id_profile_description);
            tag=(TextView) itemView.findViewById(R.id.description_tag_name) ;


        }
    }
}
