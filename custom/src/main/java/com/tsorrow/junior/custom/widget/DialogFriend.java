package com.tsorrow.junior.custom.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.tsorrow.junior.custom.R;
import com.tsorrow.junior.custom.adapter.FriendAdapter;
import com.tsorrow.junior.custom.bean.Friend;

import java.util.List;

public class DialogFriend implements View.OnClickListener, FriendAdapter.OnDeleteListener {
    private Context mContext;
    private Dialog dialog;
    private View view;
    private TextView tv_title;
    private ListView lv_friend;
    private List<Friend> mFriendList;
    private FriendAdapter friendAdapter;

    public DialogFriend(Context context,List<Friend> friendList,OnAddFriendListener listener){
        mContext = context;
        view = LayoutInflater.from(context).inflate(R.layout.dialog_friend,null);
        dialog = new Dialog(context,R.style.dialog_layout_bottom);
        tv_title = (TextView)view.findViewById(R.id.tv_title);
        lv_friend = (ListView)view.findViewById(R.id.lv_friend);
        view.findViewById(R.id.tv_ok).setOnClickListener(this);
        mOnAddFriendListener = listener;
        mFriendList = friendList;
        friendAdapter = new FriendAdapter(mContext,mFriendList,this);
        lv_friend.setAdapter(friendAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_ok){
            if (mOnAddFriendListener != null){
                mOnAddFriendListener.addFriend(friendAdapter.getFriends());
                dialog.dismiss();
            }
        }
    }

    @Override
    public void onDeleteClick(int position) {
        mFriendList.remove(position);
        friendAdapter.notifyDataSetChanged();
    }

    private OnAddFriendListener mOnAddFriendListener;
    public interface OnAddFriendListener{
        public void addFriend(List<Friend> friendList);
    }

    public void show() {
        dialog.setCancelable(true);
        dialog.show();
        dialog.getWindow().setContentView(view);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    public void dismiss() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public boolean isShowing() {
        if (dialog != null)
            return dialog.isShowing();
        return false;
    }

    public void setCancelable(boolean flag) {
        dialog.setCancelable(flag);
    }

    public void setCancelableOnTouchOutside(boolean flag) {
        dialog.setCanceledOnTouchOutside(flag);
    }

    public void setTitle(String title) {
        tv_title.setText(title);
    }
}
