package com.example.imageviewchangebg;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

	private Button btn;
	private ImageView iv;
	int i = 0;
	int img[] = {R.drawable.page1 , R.drawable.page2 , R.drawable.page3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn = (Button) findViewById(R.id.next);
        iv = (ImageView) findViewById(R.id.bg);
        
        btn.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i = i%3;//0-2ำ๋3ศกำเสý
				iv.setBackgroundResource(img[i]);
				i++;
			}
		});
    }


    
}
