package com.half.circlegroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.half.domain.AlertAndSchedule;
import com.half.util.AppConstant;
import com.half.util.Keys;

public class AlertSchedulePostActivity extends Activity implements OnClickListener {
	
	private EditText etAlertSchedulesSubject;
	private EditText etAlertScheduleMessage;
	private Context context;
	private Intent intent;
    private String subject;
    private boolean isAlert;
    private boolean isSchedule;
    private Button btnPost;
    AlertAndSchedule alert;
    AlertAndSchedule schedule;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alert_schedule_post);
		initialControls();
		populateControls();
		
	}

	private void populateControls() {
		if(subject.equalsIgnoreCase(AppConstant.SCHEDULE_VALUE))
		{
			isSchedule =  true;
			isAlert = false;
			etAlertSchedulesSubject.setHint("Schedule Subject");
		}else if(subject.equalsIgnoreCase(AppConstant.ALERT_VALUE))
		{
			isAlert = true;
			isSchedule = false;
			etAlertSchedulesSubject.setHint("Alert Subject");
		}
		
	}

	private void initialControls() {
		etAlertSchedulesSubject = (EditText) findViewById(R.id.etAlertSchedulesSubject);
		etAlertScheduleMessage = (EditText) findViewById(R.id.etAlertScheduleMessage);
		subject = getIntent().getStringExtra(Keys.ALERT_SCHEDULE_KEY);
		context =  this;
		btnPost = (Button) findViewById(R.id.btnPost);
		btnPost.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		if(isAlert)
		{
			alert =  new AlertAndSchedule();
			alert.setAlert(true);
			alert.setAuthor("");
			alert.setMessage(etAlertScheduleMessage.getText().toString());
			alert.setSubject(etAlertSchedulesSubject.getText().toString());
			alert.setMessageFrom("");
			alert.setMessageTo("");
		
			
		}else if(isSchedule)
		{
			schedule =  new AlertAndSchedule();
			
			schedule =  new AlertAndSchedule();
			schedule.setAlert(true);
			schedule.setAuthor("");
			schedule.setMessage(etAlertScheduleMessage.getText().toString());
			schedule.setSubject(etAlertSchedulesSubject.getText().toString());
			schedule.setMessageFrom("");
			schedule.setMessageTo("");
		}
		
	}

}
