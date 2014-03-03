package com.half.circlegroup;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.half.adapter.AlertScheduleAdapter;
import com.half.domain.AlertAndSchedule;
import com.half.util.AppConstant;
import com.half.util.InitialInfo;
import com.half.util.Keys;


public class AlertScheduleActivity extends Activity implements OnItemClickListener,OnClickListener{
	
	private ArrayList<AlertAndSchedule> alertList;
	private LinearLayout lnAlertScheduleButtons;
	private Button btnSetAlert;
	private Button btnSetSchedule;
    private AlertScheduleAdapter adapter;
	private ListView lvAlert;
	private Context context;
	private Intent intent;
	private String sign;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alert_schedule);
		serverCallForAlertList();
		intialControls();
		context= this;
		
	}

	private void intialControls() {
		lnAlertScheduleButtons = (LinearLayout) findViewById(R.id.lnAlertScheduleButtons);
		btnSetAlert = (Button) findViewById(R.id.btnSetAlert);
		btnSetAlert.setOnClickListener(this);
		btnSetSchedule = (Button) findViewById(R.id.btnSetSchedule);
		btnSetSchedule.setOnClickListener(this);
		lvAlert = (ListView) findViewById(R.id.lvAlert);
		
		sign = getIntent().getStringExtra(Keys.ALERT_SCHEDULE_KEY);	
		adapter = new AlertScheduleAdapter(this, alertList,sign);
		lvAlert.setAdapter(adapter);
		lvAlert.setOnItemClickListener(this);
		
		if(!InitialInfo.getOwn().isAdmin())
		{
			   btnSetAlert.setVisibility(View.GONE);
			   btnSetSchedule.setVisibility(View.GONE);
		}
		
		if(sign.equalsIgnoreCase(AppConstant.INVITATION_VALUE))
		{
    	   btnSetAlert.setVisibility(View.VISIBLE);
		   btnSetAlert.setText("Invite to other");
		   btnSetSchedule.setVisibility(View.GONE);
		}
			
		
	}


	private void serverCallForAlertList() {
		
		alertList = new ArrayList<AlertAndSchedule>();
		
		for(int i=0;i<=100;i++){
			AlertAndSchedule al = new AlertAndSchedule();
			al.setAlert(true);
			al.setAuthor("amir");
			al.setMessage("It is a test message");
			al.setMessageFrom("maruf");
			al.setMessageTo("amir");
			al.setSchedule(false);
			al.setSubject("Subject message");
			
			alertList.add(al);
		}
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		
		AlertAndSchedule as = (AlertAndSchedule)alertList.get(position);
//		Toast toast = Toast.makeText(context, as.getSubject(), Toast.LENGTH_SHORT);
//		toast.show();
		String []value = {as.getMessageFrom(),as.getSubject(),as.getMessage()};
		intent = new Intent(this,AlertSchdulShowActivity.class);
		intent.putExtra(Keys.ALERT_SCHEDULE_KEY, value);
		startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		intent = new Intent(this,AlertSchedulePostActivity.class);
		switch (v.getId()) {
		case R.id.btnSetAlert:
		{
			intent.putExtra(Keys.ALERT_SCHEDULE_KEY, AppConstant.ALERT_VALUE);
			break;
		}
		case R.id.btnSetSchedule:
		{
			intent.putExtra(Keys.ALERT_SCHEDULE_KEY, AppConstant.SCHEDULE_VALUE);
			break;
		}
		default:
			break;
		}
		
		startActivity(intent);
		
	}
	

}
