package com.example.guwei.myfirstapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by guwei on 16-7-12.
 */
public class Game5 extends Activity{

    private TextView game1;
    private Button yes , no;
    private int sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game5);
        initView();
    }

    private void initView() {
        yes = (Button) findViewById(R.id.game5_yes);
        no = (Button) findViewById(R.id.game5_no);
        game1 = (TextView) findViewById(R.id.game5_text);

        Intent intent = getIntent();
        sum = intent.getIntExtra("sum" , 0);
        Log.i("TAG" , sum+"");
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum = sum+16;
                new AlertDialog.Builder(Game5.this)
                        .setTitle("结果")
                        .setMessage("你心中想的数字是："+sum)
                        .setPositiveButton("好神奇！", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Intent firstpage = new Intent(Game5.this , FirstPage.class);
                                startActivity(firstpage);
                                finish();
                            }
                        })
                        .setNegativeButton("我不服，再来！", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent gogame1 = new Intent(Game5.this , Game1.class);
                                startActivity(gogame1);
                                finish();
                            }
                        }).show();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum = sum+0;
                new AlertDialog.Builder(Game5.this)
                        .setTitle("结果")
                        .setMessage("你心中想的数字是："+sum)
                        .setPositiveButton("好神奇！", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Intent firstpage = new Intent(Game5.this , FirstPage.class);
                                startActivity(firstpage);
                                finish();
                            }
                        })
                        .setNegativeButton("我不服，再来！", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent gogame1 = new Intent(Game5.this , Game1.class);
                                startActivity(gogame1);
                                finish();
                            }
                        }).show();
            }
        });
    }
}
