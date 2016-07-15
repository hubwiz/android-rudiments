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

	// ͳһ�󶨣�����onCreate�ɾ���ˬ
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
		// ��ͨ�Ի���
		case R.id.btn:
			new AlertDialog.Builder(MainActivity.this).setTitle("��ͨ�Ի���")
					.setMessage("����Ϣ��")
					.setPositiveButton("ȷ��", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					}).show();
			break;
		// ����Ի��� (��ͦ�����μ��̳�)
		case R.id.btn1:
			EditText et = new EditText(MainActivity.this);
			new AlertDialog.Builder(MainActivity.this).setTitle("����Ի���")
					.setView(et).setPositiveButton("ȷ��", null)
					.setNegativeButton("ȡ��", null).show();
			break;

		// ����ѡ��ť
		case R.id.btn2:
			new AlertDialog.Builder(MainActivity.this)
					.setTitle("����ѡ��ť")
					.setIcon(android.R.drawable.ic_dialog_info)
					.setSingleChoiceItems(
							new String[] { "ѡ��1", "ѡ��2", "ѡ��3", "ѡ��4", "ѡ��5",
									"ѡ��6" }, 0,
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// ѡ�к�ʵ�ֵĲ���
									Toast.makeText(MainActivity.this,
											"��ѡ�е��ǵ�" + which + "��",
											Toast.LENGTH_SHORT).show();

								}
							}).show();
			break;
		// ����ѡ���
		case R.id.btn3:
			new AlertDialog.Builder(MainActivity.this)
					.setTitle("����ѡ��")
					.setIcon(android.R.drawable.ic_dialog_info)
					.setMultiChoiceItems(
							new String[] { "ѡ��1", "ѡ��2", "ѡ��3", "ѡ��4", "ѡ��5",
									"ѡ��6" }, null,
							new DialogInterface.OnMultiChoiceClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which, boolean isChecked) {
									// TODO Auto-generated method stub
									Toast.makeText(MainActivity.this,
											"��ѡ�еĵ�" + which + "��",
											Toast.LENGTH_SHORT).show();
								}
							}).show();
			break;
		// ���б��
		case R.id.btn4:
			new AlertDialog.Builder(MainActivity.this)
					.setTitle("�б��")
					.setIcon(android.R.drawable.ic_dialog_info)
					.setItems(new String[] { "�б���1", "�б���2", "�б���3" },
							new OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									Toast.makeText(MainActivity.this,
											"��ѡ�еĵ�" + which + "��",
											Toast.LENGTH_SHORT).show();
								}
							}).show();
			break;
		// ��ͼƬ��
		case R.id.btn5:
			ImageView iv = new ImageView(MainActivity.this);
			iv.setBackgroundResource(R.drawable.ic_launcher);
			new AlertDialog.Builder(MainActivity.this).setTitle("��ͼƬ��")
					.setView(iv).setPositiveButton("ȷ��", null).show();
			break;

		default:
			break;
		}
	}
}
