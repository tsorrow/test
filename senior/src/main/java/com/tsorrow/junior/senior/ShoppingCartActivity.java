package com.tsorrow.junior.senior;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ShoppingCartActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener{
    private final static String TAG = "ShoppingCartActivity";
    private ImageView iv_menu;
    private TextView tv_title;
    private TextView tv_count;
    private TextView tv_total_price;
    private LinearLayout ll_content;
    private LinearLayout ll_empty;
    private ListView lv_cart;
    private int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        iv_menu = (ImageView)findViewById(R.id.iv_menu);
        tv_title = (TextView)findViewById(R.id.tv_title);
        tv_count = (TextView)findViewById(R.id.tv_count);
        tv_total_price = (TextView)findViewById(R.id.tv_total_price);
        ll_content = (LinearLayout)findViewById(R.id.ll_content);
        ll_empty = (LinearLayout)findViewById(R.id.ll_empty);
        lv_cart = (ListView)findViewById(R.id.lv_cart);

        iv_menu.setOnClickListener(this);
        findViewById(R.id.btn_settle).setOnClickListener(this);
        findViewById(R.id.btn_shopping_channel).setOnClickListener(this);
        iv_menu.setVisibility(View.VISIBLE);
        tv_title.setText("购物车");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_menu){
            openOptionsMenu();
        }else if (v.getId() == R.id.btn_settle){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("结算商品");
            builder.setMessage("客官抱歉，支付功能尚未开通，请下次再来");
            builder.setPositiveButton("我知道了",null);
            builder.create().show();
        }else if (v.getId() == R.id.btn_shopping_channel){
            Intent intent = new Intent(this,ShoppingChannelActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
}
