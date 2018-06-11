package comtestinna.example.manew1.newecommerceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryAdapter extends BaseExpandableListAdapter {
    Context context;
    ArrayList<Model_country> al_country;

    public CategoryAdapter(Context context, ArrayList<Model_country> al_country) {
        this.context = context;
        this.al_country = al_country;
    }

    @Override
    public int getGroupCount() {
        return al_country.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return al_country.get(i).getAl_state().size();
    }

    @Override
    public Object getGroup(int i) {
        return al_country.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return al_country.get(i).getAl_state().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if (view==null){

            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.adapter_header, null);
        }
        TextView tv_state = (TextView)view.findViewById(R.id.tv_name);
        tv_state.setText(al_country.get(i).getStr_country());
        return view;
    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        if (view==null){

            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.adapter_childview, null);
        }

        TextView tv_state = (TextView)view.findViewById(R.id.tv_name);

        tv_state.setText(al_country.get(i).getAl_state().get(i1).getStr_name());
//        tv_state.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((MainActivity)context).fn_selectedPosition(i,i1);
//            }
//        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
