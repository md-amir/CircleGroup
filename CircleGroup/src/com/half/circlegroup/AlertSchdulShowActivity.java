package com.half.circlegroup;

import com.half.util.Keys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AlertSchdulShowActivity extends Activity {
	
	private TextView txtAlertSchedulFrom;
	private TextView txtAlertSchedulDetails;
	private TextView txtAlertSchedulSubjectShow;
	private Intent intent;
	private String [] value;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alert_schdul_show);
		initalControl();
		setContent();
	}

	

	private void initalControl() {
	
		txtAlertSchedulFrom = (TextView) findViewById(R.id.txtAlertSchedulFrom);
		txtAlertSchedulDetails = (TextView) findViewById(R.id.txtAlertSchedulDetails);
		txtAlertSchedulSubjectShow = (TextView) findViewById(R.id.txtAlertSchedulSubjectShow);
		intent = getIntent();
		value = intent.getStringArrayExtra(Keys.ALERT_SCHEDULE_KEY);
		
		
	}
	
	private void setContent() {
		txtAlertSchedulFrom.setText("From:"+value[0]);
		txtAlertSchedulSubjectShow.setText(value[1]);
		txtAlertSchedulDetails.setText(value[2]);		
	}

	

}
