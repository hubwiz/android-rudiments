package com.example.guwei.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by guwei on 16-7-12.
 */
public class Regiest extends Activity{

    private EditText username , pass1 , pass2;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regiest);

        initView();
    }

    private void initView() {
        username = (EditText) findViewById(R.id.username1);
        pass1 = (EditText) findViewById(R.id.passwd1);
        pass2 = (EditText) findViewById(R.id.passwd2);
        submit = (Button) findViewById(R.id.submit1);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_text = username.getText().toString();
                String passwd_text = pass1.getText().toString();
                String passwd2_text = pass2.getText().toString();
                if(username_text.equals("")||passwd_text.equals("")||passwd2_text.equals("")){
                    Toast.makeText(Regiest.this , "用户名密码不能为空" , Toast.LENGTH_SHORT).show();
                }else {
                    if(passwd_text.equals(passwd2_text)){
                        SharedHelper sh = new SharedHelper(Regiest.this);
                        passwd_text = Md5Util.getMD5(passwd_text);
                        sh.save(username_text , passwd_text);

                        Intent intent = new Intent(Regiest.this , FirstPage.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });

    }
}
