package com.example.guwei.myfirstapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Map;

/**
 * Created by guwei on 16-7-11.
 */
public class FirstPage extends Activity{

    private Button start;
    private Button about;
    AlertDialog dialog = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);

        initView();

    }

    private void initView() {

        start = (Button) findViewById(R.id.start_game);
        about = (Button) findViewById(R.id.about_me);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new AlertDialog.Builder(FirstPage.this)
                        .setTitle("猜数字")
                        .setMessage("游戏开始啦！现在在心里想一个1-31的整数吧！")
                        .setPositiveButton("我想好啦！", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(FirstPage.this , Game1.class);
                                startActivity(intent);
                                finish();
                            }
                        }).show();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            Map<String , String> data = new SharedHelper(FirstPage.this).read();
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(FirstPage.this)
                        .setTitle("你的注册信息")
                        .setMessage("用户名："+data.get("username")+"\n"+"密码（加密后）："+data.get("passwd"))
                        .setPositiveButton("关闭", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
            }
        });
    }


}
