package com.tsorrow.junior.senior.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tsorrow.junior.senior.R;
import com.tsorrow.junior.senior.bean.Planet;

import java.util.ArrayList;

public class PlanetAdapter extends BaseAdapter implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener{
    private LayoutInflater mInflater;
    private Context mContext;
    private int mLayoutId;
    private ArrayList<Planet> mPlanetList;
    private int mBackground;

    public PlanetAdapter(Context context,int layout_id,ArrayList<Planet> planet_list,int background){
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mLayoutId = layout_id;
        mPlanetList = planet_list;
        mBackground = background;
    }

    @Override
    public int getCount() {
        return mPlanetList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPlanetList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(mLayoutId,null);
            holder.ll_item = convertView.findViewById(R.id.ll_item);
            holder.iv_icon = convertView.findViewById(R.id.iv_icon);
            holder.tv_name = convertView.findViewById(R.id.tv_name);
            holder.tv_desc = convertView.findViewById(R.id.tv_desc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Planet planet = mPlanetList.get(position);
        holder.ll_item.setBackgroundColor(mBackground);
        holder.iv_icon.setImageResource(planet.image);
        holder.tv_name.setText(planet.name);
        holder.tv_desc.setText(planet.desc);
        return convertView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String desc = String.format("您点击了第%d个行星，它的名字是%s", position + 1,
                mPlanetList.get(position).name);
        Toast.makeText(mContext, desc, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String desc = String.format("您长按了第%d个行星，它的名字是%s", position + 1,
                mPlanetList.get(position).name);
        Toast.makeText(mContext, desc, Toast.LENGTH_LONG).show();
        return true;
    }

    private final class ViewHolder{
        private LinearLayout ll_item;
        private ImageView iv_icon;
        private TextView tv_name;
        private TextView tv_desc;
    }


}
