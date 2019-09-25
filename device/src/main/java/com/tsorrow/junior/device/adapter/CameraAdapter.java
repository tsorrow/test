package com.tsorrow.junior.device.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tsorrow.junior.device.R;
import com.tsorrow.junior.device.bean.CameraInfo;

import java.util.ArrayList;

public class CameraAdapter extends BaseAdapter {
    private ArrayList<CameraInfo> mCameraList;
    private LayoutInflater mInflater;
    private Context mContext;

    public CameraAdapter(Context context,ArrayList<CameraInfo> cameraList){
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mCameraList = cameraList;
    }

    @Override
    public int getCount() {
        return mCameraList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCameraList.get(position);
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
            convertView = mInflater.inflate(R.layout.item_camera,null);
            holder.tv_camera_type = (TextView) convertView.findViewById(R.id.tv_camera_type);
            holder.tv_flash_mode = (TextView) convertView.findViewById(R.id.tv_flash_mode);
            holder.tv_focus_mode = (TextView) convertView.findViewById(R.id.tv_focus_mode);
            holder.tv_scene_mode = (TextView) convertView.findViewById(R.id.tv_scene_mode);
            holder.tv_color_effect = (TextView) convertView.findViewById(R.id.tv_color_effect);
            holder.tv_white_balance = (TextView) convertView.findViewById(R.id.tv_white_balance);
            holder.tv_max_zoom = (TextView) convertView.findViewById(R.id.tv_max_zoom);
            holder.tv_zoom = (TextView) convertView.findViewById(R.id.tv_zoom);
            holder.tv_resolution = (TextView) convertView.findViewById(R.id.tv_resolution);
            holder.tv_resolution_list = (TextView) convertView.findViewById(R.id.tv_resolution_list);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        CameraInfo item = mCameraList.get(position);
        holder.tv_camera_type.setText(""+item.camera_type);
        holder.tv_flash_mode.setText(item.flash_mode);
        holder.tv_focus_mode.setText(item.focus_mode);
        holder.tv_scene_mode.setText(item.scene_mode);
        holder.tv_color_effect.setText(item.color_effect);
        holder.tv_white_balance.setText(item.white_balance);
        holder.tv_max_zoom.setText(item.max_zoom);
        holder.tv_zoom.setText(item.zoom);

        return null;
    }

    public final class ViewHolder{
        public TextView tv_camera_type;
        public TextView tv_flash_mode;
        public TextView tv_focus_mode;
        public TextView tv_scene_mode;
        public TextView tv_color_effect;
        public TextView tv_white_balance;
        public TextView tv_max_zoom;
        public TextView tv_zoom;
        public TextView tv_resolution;
        public TextView tv_resolution_list;
    }
}
