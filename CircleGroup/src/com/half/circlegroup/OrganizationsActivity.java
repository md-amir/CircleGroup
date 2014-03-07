package com.half.circlegroup;

import com.half.util.AppConstant;
import com.half.util.AppHandler;
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
    private Button btnGeneral;
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
		btnGeneral = (Button) findViewById(R.id.btnGeneral);
		btnGeneral.setOnClickListener(this);
		context = this;
		intent = new Intent(context,MemberListActivity.class);
	}
	
	@Override
	public void onClick(View v) {
		AppHandler.setCallForward(AppConstant.TO_ORGANIGATION);
		switch (v.getId()) {
		case R.id.btnCora:
		{			
			intent.putExtra(Keys.ORGANIZATION_KEY, AppConstant.ORGANIZATION_CORA_VALUE);
			break;
		}
		case R.id.btnFinance:
		{
			intent.putExtra(Keys.ORGANIZATION_KEY, AppConstant.ORGANIZATION_FINANCE_VALUE);
			break;
		}
		case R.id.btnHr:
		{
			intent.putExtra(Keys.ORGANIZATION_KEY, AppConstant.ORGANIZATION_HR_VALUE);
			break;
		}
		
		case R.id.btnIt:
		{
			intent.putExtra(Keys.ORGANIZATION_KEY, AppConstant.ORGANIZATION_IT_VALUE);
			break;
		}
		case R.id.btnGeneral:
		{
			intent.putExtra(Keys.ORGANIZATION_KEY, AppConstant.ORGANIZATION_GENERAL_VALUE);
			break;
		}
		case R.id.btnLegal:
		{
			intent.putExtra(Keys.ORGANIZATION_KEY, AppConstant.ORGANIZATION_LEGAL_VALUE);
			break;
		}
		default:
			break;
		}
		startActivity(intent);
		
	}



}
