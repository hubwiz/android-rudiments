package com.example.guwei.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by guwei on 16-7-12.
 */
public class Game3 extends Activity{

    private TextView game1;
    private Button yes , no;
    private int sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game3);
        initView();
    }

    private void initView() {
        yes = (Button) findViewById(R.id.game3_yes);
        no = (Button) findViewById(R.id.game3_no);
        game1 = (TextView) findViewById(R.id.game3_text);

        Intent intent = getIntent();
        sum = intent.getIntExtra("sum" , 0);
        Log.i("TAG" , sum+"");
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum = sum+4;
                Intent intent = new Intent(Game3.this , Game4.class);
                intent.putExtra("sum" , sum);
                game1.setText("您选择了： 有 \n result:"+sum);
                startActivity(intent);
                finish();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum = sum+0;
                Intent intent = new Intent(Game3.this , Game4.class);
                intent.putExtra("sum" , sum+0);
                game1.setText("您选择了： 没有 \n result:"+sum);
                startActivity(intent);
                finish();
            }
        });
    }
}
