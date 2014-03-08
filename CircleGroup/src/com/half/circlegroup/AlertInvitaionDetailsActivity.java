package com.half.circlegroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.half.domain.Alert;
import com.half.domain.Invitation;
import com.half.util.AppConstant;
import com.half.util.AppHandler;
import com.half.util.Keys;

public class AlertInvitaionDetailsActivity extends Activity {
	
	private TextView txtAlertInvitaionFrom;
	private TextView txtAlertInvitationDetails;
	private TextView txtAlertInvitaionSubjectShow;
	private Intent intent;
	private String  value;
	private String tag;
	private Invitation invitaion;
	private Alert alert;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alert_schdul_show);
		initalControl();
		setContent();
	}

	

	private void initalControl() {
	
		txtAlertInvitaionFrom = (TextView) findViewById(R.id.txtAlertSchedulFrom);
		txtAlertInvitationDetails = (TextView) findViewById(R.id.txtAlertSchedulDetails);
		txtAlertInvitaionSubjectShow = (TextView) findViewById(R.id.txtAlertSchedulSubjectShow);
		intent = getIntent();
		tag=AppHandler.getCallForward();
			
	}
	
	private void setContent() {
		
		if(tag.equalsIgnoreCase(AppConstant.ALERT_VALUE))
		{
			alert = (Alert)intent.getParcelableExtra(Keys.ALERT_INVITAION_SCHEDULE_PARCELABLE_KEY);	
//			txtAlertInvitaionFrom.setText(alert.getAlertSubject());
			txtAlertInvitaionSubjectShow.setText(alert.getAlertSubject());
			txtAlertInvitationDetails.setText(alert.getAlertMessage());
		}
		else if(tag.equalsIgnoreCase(AppConstant.INVITATION_VALUE))
		{
			invitaion = (Invitation)intent.getParcelableExtra(Keys.ALERT_INVITAION_SCHEDULE_PARCELABLE_KEY);
			txtAlertInvitaionFrom.setText("From:"+invitaion.getInvitationFrom());
			txtAlertInvitaionSubjectShow.setText(invitaion.getInvitationDateTime());
			txtAlertInvitationDetails.setText(invitaion.getInvitationMessage());
		}	
					
	}

}
