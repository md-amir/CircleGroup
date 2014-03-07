package com.half.circlegroup;

import com.half.util.AppConstant;
import com.half.util.AppHandler;
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
	private Button btnWhite;
	private Button btnPurpel;
	private Button btnBlack;
	private Button btnSkyBlue;
	
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
		
		btnSkyBlue = (Button) findViewById(R.id.btnSkyBlue);
		btnSkyBlue.setOnClickListener(this);
		btnBlack = (Button) findViewById(R.id.btnBlack);
		btnBlack.setOnClickListener(this);
		btnPurpel = (Button) findViewById(R.id.btnPurpel);
		btnPurpel.setOnClickListener(this);
		btnWhite = (Button) findViewById(R.id.btnWhite);
		btnWhite.setOnClickListener(this);
			
		context = this;
		intent =  new Intent(this,MemberListActivity.class);
		
	}

	@Override
	public void onClick(View view) {
		AppHandler.setCallForward(AppConstant.TO_LOS_TEAM);
		switch (view.getId()) {
		case R.id.btnGreen:
		{  
			intent.putExtra(Keys.LOS_TEAM_KEY, AppConstant.LOS_GREEN_VALUE);
			break;
		}
		case R.id.btnRed:
		{
			intent.putExtra(Keys.LOS_TEAM_KEY, AppConstant.LOS_RED_VALUE);
			break;
		}
		case R.id.btnYellow:
		{
			intent.putExtra(Keys.LOS_TEAM_KEY, AppConstant.LOS_YELLOW_VALUE);
			break;
		}
		case R.id.btnOrange:
		{
			intent.putExtra(Keys.LOS_TEAM_KEY, AppConstant.LOS_ORANGE_VALUE);
			break;
		}
		case R.id.btnWhite:
		{
			intent.putExtra(Keys.LOS_TEAM_KEY, AppConstant.LOS_WHITE_VALUE);
			break;
		}
		case R.id.btnPurpel:
		{
			intent.putExtra(Keys.LOS_TEAM_KEY, AppConstant.LOS_PURPEL_VALUE);
			break;
		}
		case R.id.btnBlack:
		{
			intent.putExtra(Keys.LOS_TEAM_KEY, AppConstant.LOS_BLACK_VALUE);
			break;
		}
		case R.id.btnSkyBlue:
		{
			intent.putExtra(Keys.LOS_TEAM_KEY, AppConstant.LOS_SKYBLUE_VALUE);
			break;
		}
		default:
			break;
		}
		
		startActivity(intent);
		
	}

	

}
