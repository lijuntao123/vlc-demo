package com.eastsoft.vlc.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eastsoft.vlc.R;

/**
 * MainActivity
 * 
 * @author ljt
 * @date 2014-9-24 11:21:09
 *
 */
public class MainActivity extends Activity {

	private EditText urlEt;
	private EditText usernameEt;
	private EditText passwordEt;
	private Button sureBtn;
	private Button cancelBtn;

	private String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();

	}

	private void initView() {
		urlEt = (EditText) findViewById(R.id.url_et);
		usernameEt = (EditText) findViewById(R.id.username_et);
		passwordEt = (EditText) findViewById(R.id.password_et);
		sureBtn = (Button) findViewById(R.id.sure_btn);
		cancelBtn = (Button) findViewById(R.id.cancel_btn);

		sureBtn.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				if (urlEt.getText() != null
						&& !"".equals(urlEt.getText().toString())) {
					url = urlEt.getText().toString();
				}else{
					Toast.makeText(MainActivity.this, "url 不可为空！", Toast.LENGTH_SHORT).show();
				}
				if(usernameEt.getText()!=null && !"".equals(usernameEt.getText().toString())
						&& passwordEt.getText()!=null && !"".equals(passwordEt.getText().toString())){
					url=usernameEt.getText().toString()+":"+passwordEt.getText().toString()+"@"+url;
				}
				
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, VlcVideoActivity.class);
				intent.putExtra("url", url);
				MainActivity.this.startActivity(intent);
			}
		});

	}

}
