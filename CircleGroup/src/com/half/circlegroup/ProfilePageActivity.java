package com.half.circlegroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.half.domain.User;

public class ProfilePageActivity extends Activity {
	
	private Button btnSms;
	private Button btnCall;
	private Button btnPhoto;
	
	private TextView txtUserName;
	private TextView txtUserDesignation;
	private TextView txtUserMobileNumber;
	private TextView txtRoomNumber;
	private TextView txtTeamName;
	private TextView txtBusNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
		initialControl();
		setvalue();
	}

	

	private void initialControl() {
		txtUserName = (TextView) findViewById(R.id.txtUserName);
		txtUserDesignation = (TextView) findViewById(R.id.txtUserDesignation);
		txtUserMobileNumber = (TextView) findViewById(R.id.txtUserMobileNumber);
		txtRoomNumber = (TextView) findViewById(R.id.txtRoomNumber);
		txtTeamName = (TextView) findViewById(R.id.txtTeamName);
		txtBusNumber = (TextView) findViewById(R.id.txtBusNumber);
		
	}
	
	private void setvalue() {
//		Bundle data = getIntent().getExtras();
//		User user = (User) data.getParcelable("user");
		
		User user = (User)getIntent().getParcelableExtra("user");
		
		txtUserName.setText(user.getName());
		txtUserDesignation.setText(user.getDegignation());
		txtUserMobileNumber.setText(user.getMobileNumber());
		txtRoomNumber.setText("Room Number: "+user.getRoomNumber());
		txtBusNumber.setText("Bus Number: "+user.getBusNumber());
		txtTeamName.setText("Team Name: "+user.getTeamName());
		
	}



	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		
		if(resultCode == RESULT_OK )
		{
			
		}
		
	}

}