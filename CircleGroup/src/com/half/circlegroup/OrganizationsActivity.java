package com.half.circlegroup;

import com.half.util.AppConstant;
import com.half.util.Keys;

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
		intent = new Intent(context,MemberListActivity.class);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnCora:
		{			
			intent.putExtra(Keys.ORGANIZATION_CORA_KEY, AppConstant.ORGANIZATION_CORA_VALUE);
			break;
		}
		case R.id.btnFinance:
		{
			intent.putExtra(Keys.ORGANIZATION_FINANCE_KEY, AppConstant.ORGANIZATION_FINANCE_VALUE);
			break;
		}
		case R.id.btnHr:
		{
			intent.putExtra(Keys.ORGANIZATION_HR_KEY, AppConstant.ORGANIZATION_HR_VALUE);
			break;
		}
		
		case R.id.btnIt:
		{
			intent.putExtra(Keys.ORGANIZATION_IT_KEY, AppConstant.ORGANIZATION_IT_VALUE);
			break;
		}
		case R.id.btnSecurityMembers:
		{
			intent.putExtra(Keys.ORGANIZATION_SECURITY_KEY, AppConstant.ORGANIZATION_SECURITY_VALUE);
			break;
		}
		case R.id.btnLegal:
		{
			intent.putExtra(Keys.ORGANIZATION_LEGAL_KEY, AppConstant.ORGANIZATION_LEGAL_VALUE);
			break;
		}
		default:
			break;
		}
		startActivity(intent);
		
	}



}
