package comtestinna.example.manew1.newecommerceapp;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.chrisbanes.photoview.PhotoView;

import static comtestinna.example.manew1.newecommerceapp.R.layout.product;

public class sliderProductAdapter extends PagerAdapter {

    private int[] image_resources={

      R.drawable.product1,
            R.drawable.product2,
            R.drawable.product3,
            R.drawable.product4,
    };
    
    private Context context;
    private LayoutInflater layoutInflater;

    public sliderProductAdapter(Context context){
        this.context=context;
    }


    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=layoutInflater.inflate(R.layout.product,null);
        final ImageView imageView=(ImageView) itemView.findViewById(R.id.productImageView);
        imageView.setImageResource(image_resources[position]);
        container.addView(itemView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                LayoutInflater layoutInflater1= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View mView = layoutInflater1.inflate(R.layout.dialouguecustomimagelayout, null);
                PhotoView photoView = (PhotoView) mView.findViewById(R.id.imageView);
                photoView.setImageResource(image_resources[position]);
                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();

            }
        });

        return itemView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }
}
