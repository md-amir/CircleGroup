package com.half.circlegroup;

import com.half.util.AppConstant;
import com.half.util.Keys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LosTeamsActivity extends Activity implements OnClickListener {
	
	private Button btnGreen;
	private Button btnRed;
	private Button btnYellow;
	private Button btnOrange;
	private Context context;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_los_teams);
		
		initialControls();
	}

	private void initialControls() {
		
		btnGreen = (Button) findViewById(R.id.btnGreen);
		btnGreen.setOnClickListener(this);
		btnOrange = (Button) findViewById(R.id.btnOrange);
		btnOrange.setOnClickListener(this);
		btnRed = (Button) findViewById(R.id.btnRed);
		btnRed.setOnClickListener(this);
		btnYellow = (Button) findViewById(R.id.btnYellow);
		btnYellow.setOnClickListener(this);
		context = this;
		intent =  new Intent(this,MemberListActivity.class);
		
	}

	@Override
	public void onClick(View view) {
		
		switch (view.getId()) {
		case R.id.btnGreen:
		{  
			intent.putExtra(Keys.LOS_TEAM_GREEN_KEY, AppConstant.LOS_GREEN_VALUE);
			break;
		}
		case R.id.btnRed:
		{
			intent.putExtra(Keys.LOS_TEAM_RED_KEY, AppConstant.LOS_RED_VALUE);
			break;
		}
		case R.id.btnYellow:
		{
			intent.putExtra(Keys.LOS_TEAM_YELLOW_KEY, AppConstant.LOS_YELLOW_VALUE);
			break;
		}
		case R.id.btnOrange:
		{
			intent.putExtra(Keys.LOS_TEAM_ORANGE_KEY, AppConstant.LOS_ORANGE_VALUE);
			break;
		}
		default:
			break;
		}
		
		startActivity(intent);
		
	}

	

}
