package com.tsorrow.junior.custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tsorrow.junior.custom.bean.Friend;
import com.tsorrow.junior.custom.widget.DialogFriend;

import java.util.ArrayList;
import java.util.List;

public class DialogMultiActivity extends AppCompatActivity implements View.OnClickListener,DialogFriend.OnAddFriendListener {
    private TextView tv_origin;
    private TextView tv_result;
    private String[] phoneArray = {"15960238696", "15805910591", "18905710571"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_multi);

        tv_origin = (TextView)findViewById(R.id.tv_origin);
        tv_result = (TextView)findViewById(R.id.tv_result);
        findViewById(R.id.btn_friend).setOnClickListener(this);
        findViewById(R.id.btn_friend).setOnClickListener(this);
        String origin = "";
        for (int i=0; i<phoneArray.length; i++) {
            origin = String.format("%s  %s", origin, phoneArray[i]);
        }
        tv_origin.setText(origin);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_friend){
            ArrayList<Friend> friendList = new ArrayList<Friend>();
            for (int i=0;i<phoneArray.length;i++){
                friendList.add(new Friend(phoneArray[i]));
            }
            DialogFriend dialog = new DialogFriend(this,friendList,this);
            dialog.show();
        }
    }

    @Override
    public void addFriend(List<Friend> friendList) {
        String result = "添加的好友信息如下：";
        for (int i=0; i<friendList.size(); i++) {
            Friend item = friendList.get(i);
            result = String.format("%s\n号码%s，关系是%s，%s访问朋友圈", result,
                    item.phone, item.relation, (item.admit_circle)?"允许":"禁止");
        }
        tv_result.setText(result);
    }
}
