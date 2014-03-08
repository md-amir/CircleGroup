package com.half.circlegroup;

import java.util.ArrayList;
import java.util.Hashtable;

import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.half.domain.User;
import com.half.util.AppConstant;
import com.half.util.InitialInfo;
import com.half.util.Keys;
import com.half.util.Response;
import com.half.util.ServerResponseListener;
import com.half.util.Serverconnector;


public class HomePageActivity extends Activity implements OnClickListener,ServerResponseListener {

	private Button btnOnganizations;
	private Button btnLosTeam;
	private Button btnMedias;
	private Button btnInvite;
	private Button btnAlert;
	private Button btnSchedule;
	private Button btnVanue;
	private Button btnSos;
	private Button btnBack;
	
	private Intent intent;
	private Context context;
	private ProgressDialog ringProgressDialog;
	
	

	private ArrayList<User> allUserList;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		initialControls();
		
		if(allUserList.size()==0)
		{		
		launchRingDialog();	    
		}
		}

	private void initialControls() {

		btnOnganizations = (Button) findViewById(R.id.btnOnganizations);
		btnOnganizations.setOnClickListener(this);
		btnLosTeam = (Button) findViewById(R.id.btnLosTeam);
		btnLosTeam.setOnClickListener(this);
		btnMedias = (Button) findViewById(R.id.btnMedia);
		btnMedias.setOnClickListener(this);
		btnInvite = (Button) findViewById(R.id.btnInvite);
		btnInvite.setOnClickListener(this);
		btnAlert = (Button) findViewById(R.id.btnAlert);
		btnAlert.setOnClickListener(this);
		btnSchedule = (Button) findViewById(R.id.btnSchedule);
		btnSchedule.setOnClickListener(this);
		btnVanue = (Button) findViewById(R.id.btnVenue);
		btnVanue.setOnClickListener(this);
		btnSos = (Button) findViewById(R.id.btnSos);
		btnSos.setOnClickListener(this);
		View included =  findViewById(R.id.header);
		btnBack = (Button) included.findViewById(R.id.btnBack);
		btnBack.setOnClickListener(this);
		context = this;
		
		allUserList = new ArrayList<User>();
	
		
		User own = new User();
		own.setName("Wahid");
		own.setAdmin(true);
		own.setBusNumber("1");
		own.setDegignation("Doctor");
		own.setMobileNumber("01717236444");
		own.setEmail("drmdWahid@gmail.com");
		own.setLosTeamName("Green");
		own.setOrganization("Finance");
		own.setRoomNumber("106");
		own.setTeamName("Rose");
		own.setUniqueNumber("abc123456");
		own.setUrl("");
		
		InitialInfo.setOwn(own);
		
	}
	
	public void launchRingDialog() {
		
		        final ProgressDialog ringProgressDialog = ProgressDialog.show(context, "Please wait ...", "Downloading data ...", true);
				        ringProgressDialog.setCancelable(true);
				        serverReqestForAllMembers(); 
				        new Thread(new Runnable() {
		
		            @Override
				            public void run() {
				                try {
//				                	serverReqestForAllMembers();  
				                	Thread.sleep(25000);
//				                	ringProgressDialog.dismiss();

				                } catch (Exception e) {
				                }
				                ringProgressDialog.dismiss();
				            }
				        }).start();
				    }

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnOnganizations: {
            intent = new Intent(context, OrganizationsActivity.class);
            startActivity(intent);
			break;
		}
		case R.id.btnMedia: {
            intent = new Intent(context, MediasActivity.class);
            startActivity(intent);
			break;
		}
		case R.id.btnLosTeam: {
            intent = new Intent(context, LosTeamsActivity.class);
            startActivity(intent);
			break;
		}
		case R.id.btnAlert: {
			 intent = new Intent(context, AlertScheduleInvitationListActivity.class);
			 intent.putExtra(Keys.ALERT_SCHEDULE_KEY, AppConstant.ALERT_VALUE);
	         startActivity(intent);
			 break;
		}
		case R.id.btnSchedule: {
            intent = new Intent(context, AlertScheduleInvitationListActivity.class);
            intent.putExtra(Keys.ALERT_SCHEDULE_KEY, AppConstant.SCHEDULE_VALUE);
            startActivity(intent);
			break;
		}
		case R.id.btnVenue: {
            intent = new Intent(context, VanueActivity.class);
            startActivity(intent);
			break;
		}
		case R.id.btnInvite: {
			intent = new Intent(context, AlertScheduleInvitationListActivity.class);
			intent.putExtra(Keys.ALERT_SCHEDULE_KEY, AppConstant.INVITATION_VALUE);
			startActivity(intent);
			break;
		}
		case R.id.btnSos: {
//            intent = new Intent(context, VanueActivity.class);
//            startActivity(intent);
//			break;
		}
		case R.id.btnBack: {
            finish();
            break;
		}
		default:
			break;
		}

	}

	 private void serverReqestForAllMembers()
	 {
      Hashtable<String, String> paramList = new Hashtable<String, String>();
	 
	  paramList.put("version", "");
	  
	  new Serverconnector(this, this, AppConstant.SERVER_ADDRESS_FOR_ALL_MEMBERS, paramList, AppConstant.ALL_MEMBER_CALL, Serverconnector.HTTP_STRING).start();
	 }
	
	
	@Override
	public void serverResponse(Response response) {
		String data = (String) response.getData();
		System.out.println("Road Response: " + data);
		Log.v("","response"+data);
		
		if(response.getRequetType() == AppConstant.ALL_MEMBER_CALL)
		{
			if(response.getStatus())
			{
				try
				{
					allUserList = User.parse(response.getData().toString());
					InitialInfo.setMemberList(allUserList);
					ringProgressDialog.dismiss();
					
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
	}

}
