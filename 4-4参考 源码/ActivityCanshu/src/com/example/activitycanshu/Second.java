package com.example.activitycanshu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends Activity{
	
	private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		tv = (TextView) findViewById(R.id.tv);
		
		Intent intent = getIntent();
		String data = intent.getStringExtra("value");
		tv.setText(data);
	}

}
