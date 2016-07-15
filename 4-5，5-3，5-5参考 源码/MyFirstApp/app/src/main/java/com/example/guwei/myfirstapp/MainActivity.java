package com.example.guwei.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends Activity {

    private EditText username , password;
    private TextView regiest;
    private Button login;
    private CheckBox rempass;
    private SharedHelper sh;
    Map<String, String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sh = new SharedHelper(getApplicationContext());
        data = sh.read();
        initView();
    }

    private void initView() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.passwd);
        regiest = (TextView) findViewById(R.id.regiest);
        login = (Button) findViewById(R.id.submit);
        rempass = (CheckBox) findViewById(R.id.rempass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_text = username.getText().toString();
                //String passwd_text = password.getText().toString();
                //判断输入是否为空
                if(username_text.equals("")||(password.getText().toString()).equals("")){
                    Toast.makeText(MainActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    //判断输入信息是否正确
                    String pass_a = data.get("passwd").toString();
                    String pass_b = null;
                    //如果记住密码，被选中，获取到的是加密后的密码。否则要为输入内容加密，与密文对比
                    if(rempass.isChecked()){
                        pass_b = password.getText().toString();
                    }else{
                       pass_b = Md5Util.getMD5(password.getText().toString());
                    }

                    String name_a = data.get("username").toString();

                    if(pass_a.equals(pass_b)&&name_a.equals(username_text)){
                        Intent intent = new Intent(MainActivity.this , FirstPage.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this , "密码不正确" , Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        regiest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , Regiest.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        username.setText(data.get("username"));
        password.setText(data.get("passwd"));
    }
}
