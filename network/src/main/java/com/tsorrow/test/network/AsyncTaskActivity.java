package com.tsorrow.test.network;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.tsorrow.test.network.task.ProgressAsyncTask;

public class AsyncTaskActivity extends AppCompatActivity implements ProgressAsyncTask.OnProgressListener {
    private TextView tv_async;
    public int BAR_HORIZONTAL = 1;
    public int DIALOG_CIRCLE = 2;
    public int DIALOG_HORIZONTAL = 3;
    private String[] bookArray = {"三国演义", "西游记", "红楼梦"};
    private int[] styleArray = {BAR_HORIZONTAL, DIALOG_CIRCLE, DIALOG_HORIZONTAL};
    private ProgressBar pb_async;
    private ProgressDialog mDialog;
    public int mShowMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        pb_async = (ProgressBar)findViewById(R.id.pb_async);
        tv_async = (TextView)findViewById(R.id.tv_async);

        Spinner sp_style = (Spinner)findViewById(R.id.sp_style);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item_select,bookArray);
        sp_style.setPrompt("请选择要加载的小说");
        sp_style.setAdapter(adapter);
        sp_style.setOnItemSelectedListener(new StyleSelectedListener());
        sp_style.setSelection(0);
    }

    @Override
    public void onBegin(String request) {
        tv_async.setText(request+"开始加载");
        if (mDialog == null || mDialog.isShowing() != true){
            if (mShowMode == DIALOG_CIRCLE){
                mDialog = ProgressDialog.show(this,"稍等",request+"页面加载中...");
            } else if(mShowMode == DIALOG_HORIZONTAL){
                mDialog = new ProgressDialog(this);
                mDialog.setTitle("稍等");
                mDialog.setMessage(request+"页面加载中...");
                mDialog.setIcon(R.drawable.ic_search);
                mDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mDialog.show();
            }
        }
    }

    private void closeDialog(){
        if(mDialog != null && mDialog.isShowing() == true){
            mDialog.dismiss();
        }
    }

    @Override
    public void onUpdate(String request, int progress, int sub_progress) {
        String desc = String.format("%s当前加载进度为%d%%", request, progress);
        tv_async.setText(desc);
        if (mShowMode == BAR_HORIZONTAL) {
            pb_async.setProgress(progress);
            pb_async.setSecondaryProgress(sub_progress);
        } else if (mShowMode == DIALOG_HORIZONTAL) {
            mDialog.setProgress(progress);
            mDialog.setSecondaryProgress(sub_progress);
        }
    }

    @Override
    public void onFinish(String result) {
        String desc = String.format("您要阅读的《%s》已经加载完毕", result);
        tv_async.setText(desc);
        closeDialog();
    }

    @Override
    public void onCancel(String result) {
        String desc = String.format("您要阅读的《%s》已经取消加载", result);
        tv_async.setText(desc);
        closeDialog();
    }

    private class StyleSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            startTask(bookArray[position],styleArray[position]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private void startTask(String msg, int mode) {
        mShowMode = mode;
        ProgressAsyncTask asyncTask = new ProgressAsyncTask(msg);
        asyncTask.setOnProgressListener(this);
        asyncTask.execute(msg);
    }
}
