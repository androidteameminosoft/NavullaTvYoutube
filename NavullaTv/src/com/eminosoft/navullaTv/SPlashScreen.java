package com.eminosoft.navullaTv;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.widget.TextView;

public class SPlashScreen extends Activity {

	TextView tvNetInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		tvNetInfo = (TextView) findViewById(R.id.textInfoNet);
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				if (CheckNetConnection.isNetAvilable(SPlashScreen.this)) {
					Intent in = new Intent(SPlashScreen.this,
							MainActivity.class);
					startActivity(in);
					finish();

				} else {
					tvNetInfo.setText("Net Connection not available");
					tvNetInfo.setTextColor(Color.RED);

				}

			}
		}, 3000);
	}

}
