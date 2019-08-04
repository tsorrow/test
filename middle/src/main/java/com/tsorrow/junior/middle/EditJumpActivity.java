package com.tsorrow.junior.middle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditJumpActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_username;
    private EditText et_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_jump);

        et_username = (EditText)findViewById(R.id.et_username);
        et_password = (EditText)findViewById(R.id.et_password);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        et_username.addTextChangedListener(new JumpTextWatcher(et_username,et_password));
        et_password.addTextChangedListener(new JumpTextWatcher(et_password,btn_login));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login){
            Toast.makeText(this,"这个登录按钮啥事也没做",Toast.LENGTH_SHORT).show();
        }
    }


    private class JumpTextWatcher implements TextWatcher {
        private EditText mThisView = null;
        private View mNextView = null;

        public JumpTextWatcher(EditText vThis, View vNext) {
            super();
            mThisView = vThis;
            mNextView = vNext;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String str = s.toString();
            if (str.indexOf("\r") >= 0 || str.indexOf("\n") >= 0){
                mThisView.setText(str.replace("\r","").replace("\n",""));
                if (mNextView != null){
                    mNextView.requestFocus();
                    if (mNextView instanceof EditText){
                        EditText editText = (EditText)mNextView;
                        //方式一 接调用EditText的setSelection方法
                        editText.setSelection(editText.getText().length());
                        //方式二 调用Selection类的setSelection方法
                        //Editable edit = editText.getText();
                        //Selection.setSelection(edit,edit.length());
                    }
                }
            }
        }
    }
}
