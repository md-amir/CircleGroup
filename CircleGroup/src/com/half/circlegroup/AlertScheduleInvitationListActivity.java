package com.half.circlegroup;

import java.util.ArrayList;
import java.util.Hashtable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.half.adapter.AlertAdapter;
import com.half.adapter.InvitationAdapter;
import com.half.adapter.ScheduleAdapter;
import com.half.domain.Alert;
import com.half.domain.AlertAndSchedule;
import com.half.domain.Invitation;
import com.half.domain.Schedule;
import com.half.domain.User;
import com.half.util.AppConstant;
import com.half.util.AppHandler;
import com.half.util.InitialInfo;
import com.half.util.Keys;
import com.half.util.Response;
import com.half.util.ServerResponseListener;
import com.half.util.Serverconnector;


public class AlertScheduleInvitationListActivity extends Activity implements OnItemClickListener,OnClickListener,ServerResponseListener{
	
	private ArrayList<Alert> alertList;
	private ArrayList<Schedule> scheduleList;
	private ArrayList<Invitation> invitationList;
	private LinearLayout lnAlertScheduleButtons;
	private Button btnSetAlert;
	private Button btnSetSchedule;
    private AlertAdapter alertAdapter;
    private ScheduleAdapter scheduleAdapter;
    private InvitationAdapter invitaionAdapter;
	private ListView lvAIS;
	private Context context;
	private Intent intent;
	private String sign;
	private Bundle bundle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alert_schedule);
		sign = getIntent().getStringExtra(Keys.ALERT_SCHEDULE_KEY);	
		
		if(sign.equalsIgnoreCase(AppConstant.ALERT_VALUE))
			{
			serverCallForAlertList();
			}
	    if(sign.equalsIgnoreCase(AppConstant.SCHEDULE_VALUE))
	        {
	    	  serverCallForScheduleList();
	        }
	   if(sign.equalsIgnoreCase(AppConstant.INVITATION_VALUE))
	   {		   
		   serverCallForInvitation();
	   }	
	}



	private void serverCallForInvitation() {
		  invitationList = new ArrayList<Invitation>();
		  Hashtable<String, String> paramList = new Hashtable<String, String>();		 
		  paramList.put("version", "");		  
		  new Serverconnector(this, this, AppConstant.SERVER_ADDRESS_FOR_INVITATION_LIST, paramList, AppConstant.INVITATION_LIST_CALL, Serverconnector.HTTP_STRING).start();
		
	}

	private void intialControls() {
		lnAlertScheduleButtons = (LinearLayout) findViewById(R.id.lnAlertScheduleButtons);
		btnSetAlert = (Button) findViewById(R.id.btnSetAlert);
		btnSetAlert.setOnClickListener(this);
		btnSetSchedule = (Button) findViewById(R.id.btnSetSchedule);
		btnSetSchedule.setOnClickListener(this);
		lvAIS = (ListView) findViewById(R.id.lvAlert);
		context= this;
		
		if(!InitialInfo.getOwn().isAdmin())
		{
			   btnSetAlert.setVisibility(View.GONE);
			   btnSetSchedule.setVisibility(View.GONE);
		}
		
		if(sign.equalsIgnoreCase(AppConstant.INVITATION_VALUE))
		   {
    	   btnSetAlert.setVisibility(View.VISIBLE);
		   btnSetAlert.setText("Invite to other");//work as invitation button
		   btnSetSchedule.setVisibility(View.GONE);
		  }
		else if(sign.equalsIgnoreCase(AppConstant.SCHEDULE_VALUE))
		    {
	    	   btnSetAlert.setVisibility(View.GONE);
			   btnSetSchedule.setVisibility(View.VISIBLE);
			   
			}
		else if(sign.equalsIgnoreCase(AppConstant.ALERT_VALUE))
			     {
		    	   btnSetAlert.setVisibility(View.VISIBLE);
				   btnSetSchedule.setVisibility(View.GONE);
				 }		
		
	}


	private void serverCallForAlertList() {
			alertList = new ArrayList<Alert>();
		    Hashtable<String, String> paramList = new Hashtable<String, String>();		 
	        paramList.put("version", "");		  
		    new Serverconnector(this, this, AppConstant.SERVER_ADDRESS_FOR_ALERT_LIST, paramList, AppConstant.ALERT_LIST_CALL, Serverconnector.HTTP_STRING).start();
			
	}
	
	private void serverCallForScheduleList() {
		  scheduleList = new ArrayList<Schedule>();
		  Hashtable<String, String> paramList = new Hashtable<String, String>();		 
		  paramList.put("version", "");		  
		  new Serverconnector(this, this, AppConstant.SERVER_ADDRESS_FOR_SCHEDULE_LIST, paramList, AppConstant.SCHEDULE_LIST_CALL, Serverconnector.HTTP_STRING).start();
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		Bundle bundle = new Bundle();
		
		if(sign.equalsIgnoreCase(AppConstant.INVITATION_VALUE))
		     {
			Invitation invitation = (Invitation)invitationList.get(position);
			bundle.putParcelable(Keys.ALERT_INVITAION_SCHEDULE_PARCELABLE_KEY, invitation);
			AppHandler.setCallForward(AppConstant.INVITATION_VALUE);
			intent = new Intent(this,AlertInvitaionDetailsActivity.class);
 	        }
		else if(sign.equalsIgnoreCase(AppConstant.SCHEDULE_VALUE))
		       {
			Schedule schedule = (Schedule)scheduleList.get(position);
			bundle.putParcelable(Keys.ALERT_INVITAION_SCHEDULE_PARCELABLE_KEY,schedule);
			intent = new Intent(this,ScheduleDetailsActivity.class);
            AppHandler.setScheduleOperation(AppConstant.SHOW);
			   
			   }
		else if(sign.equalsIgnoreCase(AppConstant.ALERT_VALUE))
			     {
			Alert as = (Alert)alertList.get(position);
			bundle.putParcelable(Keys.ALERT_INVITAION_SCHEDULE_PARCELABLE_KEY, as);
			AppHandler.setCallForward(AppConstant.ALERT_VALUE);
			intent = new Intent(this,AlertInvitaionDetailsActivity.class);

				 }		
        intent.putExtras(bundle);
		startActivity(intent);		
		
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btnSetAlert:
		{
			intent = new Intent(this,AlertSchedulePostActivity.class);
			intent.putExtra(Keys.ALERT_SCHEDULE_KEY, AppConstant.ALERT_VALUE);
			break;
		}
		case R.id.btnSetSchedule:
		{
			intent = new Intent(this,ScheduleDetailsActivity.class);
			intent.putExtra(Keys.ALERT_SCHEDULE_KEY, AppConstant.SCHEDULE_VALUE);
			AppHandler.setScheduleOperation(AppConstant.POST);
			break;
		}
		default:
			break;
		}
		
		startActivity(intent);
		
	}

	@Override
	public void serverResponse(Response response) {
		String data = (String) response.getData();
		System.out.println("Alert list Response: " + data);
		Log.v("","response"+data);
		
		if(response.getRequetType() == AppConstant.ALERT_LIST_CALL)
		{
			if(response.getStatus())
			{
				try
				{
					alertList = Alert.parse(response.getData().toString());
					alertAdapter = new AlertAdapter(this, alertList,sign);
					intialControls();
					lvAIS.setAdapter(alertAdapter);
					
					
				}
				catch (Exception e)
				{
					e.printStackTrace();
					
				}
			}
			else
			{
			
			}
		}else if(response.getRequetType() == AppConstant.SCHEDULE_LIST_CALL)
		{
			if(response.getStatus())
			{
				try
				{
					scheduleList = Schedule.parse(response.getData().toString());
					scheduleAdapter = new ScheduleAdapter(this, scheduleList,sign);
					intialControls();
					lvAIS.setAdapter(scheduleAdapter);
					
					
				}
				catch (Exception e)
				{
					e.printStackTrace();
					
				}
			}
			else
			{
			
			}
		}else if(response.getRequetType() == AppConstant.INVITATION_LIST_CALL)
		{
			if(response.getStatus())
			{
				try
				{
					invitationList = Invitation.parse(response.getData().toString());
					invitaionAdapter = new InvitationAdapter(this, invitationList,sign);
					intialControls();
					lvAIS.setAdapter(invitaionAdapter);
					
					
				}
				catch (Exception e)
				{
					e.printStackTrace();
					
				}
			}
			else
			{
			
			}
		}
		lvAIS.setOnItemClickListener(this);
	}
	
}
