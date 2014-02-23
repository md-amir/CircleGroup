package com.half.circlegroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MembersGroupActivity extends Activity implements OnClickListener{

	private Button btnAllMembers;
    private Button btnDepartments;
    private Button btnTeams;
    private Button btnMyTeam;
	private Intent intent;
	private Context context;
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_members_group);
		initialControls();
	}
	private void initialControls() {
		btnAllMembers = (Button) findViewById(R.id.btnAllMembers);
		btnAllMembers.setOnClickListener(this);
		btnDepartments = (Button) findViewById(R.id.btnDepartments);
		btnDepartments.setOnClickListener(this);
		btnTeams = (Button) findViewById(R.id.btnTeams);
		btnTeams.setOnClickListener(this);
		btnMyTeam = (Button) findViewById(R.id.btnMyTeam);
		btnMyTeam.setOnClickListener(this);
	    context = this;
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnAllMembers:
		{
			intent = new Intent(context,AllMembersActivity.class);
			startActivity(intent);
			break;
		}
		case R.id.btnDepartments:
		{
			intent = new Intent(context,DepartMentsActivity.class);
			startActivity(intent);
			break;
		}
		case R.id.btnTeams:
		{
			intent = new Intent(context,TeamsActivity.class);
			startActivity(intent);
			break;
		}
		case R.id.btnMyTeam:
		{
//			intent = new Intent(context,AllMembersActivity.class);
//			startActivity(intent);
			break;
		}
		default:
			break;
		}
		
	}



}
