package comtestinna.example.manew1.newecommerceapp;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProfileDescriptionAdapter extends RecyclerView.Adapter<ProfileDescriptionAdapter.MyViewHolder> {
    private Context mContext ;
 private ArrayList<String> detailTag=new ArrayList<>();
 private ArrayList<Integer> imgSrc=new ArrayList<>();
 private
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
    public void onBindViewHolder(@NonNull final ProfileDescriptionAdapter.MyViewHolder holder, final int position) {
        holder.tag.setText(detailTag.get(position));
        holder.img_book_thumbnail.setImageResource(imgSrc.get(position));


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.tag.requestFocus();
                holder.tag.setCursorVisible(true);
                holder.tag.setInputType(InputType.TYPE_CLASS_TEXT);
//
//                MainActivity.dataProccessor.setStr("User_phone",String.valueOf("uzair"));
//                notifyDataSetChanged();












//                MainActivity.dataProccessor.setStr("User_name",String.valueOf(holder.mName.getText()));
//                MainActivity.dataProccessor.setStr("User_phone",String.valueOf(mphone.getText()));
//                MainActivity.dataProccessor.setStr("User_address",String.valueOf(mAddress.getText()));
//                MainActivity.dataProccessor.setStr("User_email",String.valueOf(mEmail.getText()));

//                InputMethodManager imm = (InputMethodManager)
//                        mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.showSoftInput(holder.tag, InputMethodManager.SHOW_IMPLICIT);

//
//
//                Toast.makeText(mContext,holder.tag.getText(),Toast.LENGTH_LONG).show();

//                holder.tag.setFocusableInTouchMode(true);
//                holder.tag.setCursorVisible(true);

//                holder.tag.setFocusableInTouchMode(true);
//                holder.tag.setInputType(InputType.TYPE_CLASS_TEXT);
//                holder.tag.requestFocus(); //to trigger the soft input

            }
        });


        holder.tag.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {




//            detailTag.set(position,s.toString());

               // holder.tag.setVisibility(View.VISIBLE);



            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });






    }

    @Override
    public int getItemCount() {
        return detailTag.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        EditText tag;
        ImageView img_book_thumbnail;
        CardView cardView ;


        public MyViewHolder(View itemView) {
            super(itemView);



            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.description_tag_img_src);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id_profile_description);
            tag=(EditText) itemView.findViewById(R.id.description_tag_name) ;





        }
    }


}
