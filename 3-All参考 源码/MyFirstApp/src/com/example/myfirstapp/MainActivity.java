package com.example.myfirstapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

	private Button btn, btn1, btn2, btn3, btn4, btn5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}

	// 统一绑定，保持onCreate干净清爽
	private void initView() {
		// TODO Auto-generated method stub
		btn = (Button) findViewById(R.id.btn);
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		btn5 = (Button) findViewById(R.id.btn5);

		btn.setOnClickListener(this);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		// 普通对话框
		case R.id.btn:
			new AlertDialog.Builder(MainActivity.this).setTitle("普通对话框")
					.setMessage("简单消息框")
					.setPositiveButton("确定", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					}).show();
			break;
		// 输入对话框 (坚挺方法参见教程)
		case R.id.btn1:
			EditText et = new EditText(MainActivity.this);
			new AlertDialog.Builder(MainActivity.this).setTitle("输入对话框")
					.setView(et).setPositiveButton("确定", null)
					.setNegativeButton("取消", null).show();
			break;

		// 带单选按钮
		case R.id.btn2:
			new AlertDialog.Builder(MainActivity.this)
					.setTitle("带单选按钮")
					.setIcon(android.R.drawable.ic_dialog_info)
					.setSingleChoiceItems(
							new String[] { "选项1", "选项2", "选项3", "选项4", "选项5",
									"选项6" }, 0,
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// 选中后实现的操作
									Toast.makeText(MainActivity.this,
											"您选中的是第" + which + "项",
											Toast.LENGTH_SHORT).show();

								}
							}).show();
			break;
		// 带复选框的
		case R.id.btn3:
			new AlertDialog.Builder(MainActivity.this)
					.setTitle("带复选框")
					.setIcon(android.R.drawable.ic_dialog_info)
					.setMultiChoiceItems(
							new String[] { "选项1", "选项2", "选项3", "选项4", "选项5",
									"选项6" }, null,
							new DialogInterface.OnMultiChoiceClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which, boolean isChecked) {
									// TODO Auto-generated method stub
									Toast.makeText(MainActivity.this,
											"您选中的第" + which + "项",
											Toast.LENGTH_SHORT).show();
								}
							}).show();
			break;
		// 带列表的
		case R.id.btn4:
			new AlertDialog.Builder(MainActivity.this)
					.setTitle("列表框")
					.setIcon(android.R.drawable.ic_dialog_info)
					.setItems(new String[] { "列表项1", "列表项2", "列表项3" },
							new OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									Toast.makeText(MainActivity.this,
											"您选中的第" + which + "项",
											Toast.LENGTH_SHORT).show();
								}
							}).show();
			break;
		// 有图片的
		case R.id.btn5:
			ImageView iv = new ImageView(MainActivity.this);
			iv.setBackgroundResource(R.drawable.ic_launcher);
			new AlertDialog.Builder(MainActivity.this).setTitle("有图片的")
					.setView(iv).setPositiveButton("确定", null).show();
			break;

		default:
			break;
		}
	}
}
