package com.example.activitycanshu;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private EditText et;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et = (EditText) findViewById(R.id.et);
		btn = (Button) findViewById(R.id.btn);

		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(et.getText().toString().equals("")){
					Toast.makeText(MainActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
				}else{
					String data = et.getText().toString();
					Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(MainActivity.this , Second.class);
					intent.putExtra("value", data);
					startActivity(intent);
				}
			}
		});
	}

}
