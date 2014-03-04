package com.half.circlegroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.half.domain.User;

public class ProfilePageActivity extends Activity implements OnClickListener {
	
	private Button btnSms;
	private Button btnCall;
	private Button btnPhoto;
	
	private TextView txtUserName;
	private TextView txtUserDesignation;
	private TextView txtUserMobileNumber;
	private TextView txtRoomNumber;
	private TextView txtTeamName;
	private TextView txtBusNumber;
	private User user;

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
		
		btnCall =  (Button) findViewById(R.id.btnCall);
		btnCall.setOnClickListener(this);
		btnSms =  (Button) findViewById(R.id.btnSms);
		btnSms.setOnClickListener(this);
		btnPhoto =  (Button) findViewById(R.id.btnPhoto);
		btnPhoto.setOnClickListener(this);
		
	}
	
	private void setvalue() {
//		Bundle data = getIntent().getExtras();
//		User user = (User) data.getParcelable("user");
		
		user = (User)getIntent().getParcelableExtra("user");
		
		txtUserName.setText(user.getName());
		txtUserDesignation.setText(user.getDegignation());
		txtUserMobileNumber.setText(user.getMobileNumber());
		txtRoomNumber.setText("Room Number: "+user.getRoomNumber());
		txtBusNumber.setText("Bus Number: "+user.getBusNumber());
		txtTeamName.setText("Team Name: "+user.getTeamName());
		
		
		// add PhoneStateListener
//				PhoneCallListener phoneListener = new PhoneCallListener();
//				TelephonyManager telephonyManager = (TelephonyManager) this
//					.getSystemService(Context.TELEPHONY_SERVICE);
//				telephonyManager.listen(phoneListener,PhoneStateListener.LISTEN_CALL_STATE);
		
	}



	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		
		if(resultCode == RESULT_OK )
		{
			
		}
		
	}



	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnCall:
		{
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:"+user.getMobileNumber()));
			startActivity(callIntent);
			
			break;
		}
		case R.id.btnSms:
		{
			break;
		}
		case R.id.btnPhoto:
		{
			break;
		}
		default:
			break;
		}
		
	}

}
