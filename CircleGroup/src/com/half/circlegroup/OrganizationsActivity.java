package com.half.circlegroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OrganizationsActivity extends Activity implements OnClickListener{

//	private Button btnAllMembers;
    private Button btnCora;
    private Button btnHr;
    private Button btnFinance;
    private Button btnIt;
    private Button btnSecurityMembers;
    private Button btnLegal;
	private Intent intent;
	private Context context;
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_organization);
		initialControls();
	}
	private void initialControls() {

		btnCora = (Button) findViewById(R.id.btnCora);
		btnCora.setOnClickListener(this);
		btnHr = (Button) findViewById(R.id.btnHr);
		btnHr.setOnClickListener(this);
		btnFinance = (Button) findViewById(R.id.btnFinance);
		btnFinance.setOnClickListener(this);
		btnIt = (Button) findViewById(R.id.btnIt);
		btnIt.setOnClickListener(this);
		btnLegal = (Button) findViewById(R.id.btnLegal);
		btnLegal.setOnClickListener(this);
		btnSecurityMembers = (Button) findViewById(R.id.btnSecurityMembers);
		btnSecurityMembers.setOnClickListener(this);
		context = this;
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnCora:
		{
			intent = new Intent(context,MemberListActivity.class);
			startActivity(intent);
			break;
		}
		case 1:
		{
			intent = new Intent(context,DepartMentsActivity.class);
			startActivity(intent);
			break;
		}
		case 2:
		{
			intent = new Intent(context,TeamsActivity.class);
			startActivity(intent);
			break;
		}
		case 3:
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
