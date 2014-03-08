package com.half.circlegroup;

import com.half.util.AppConstant;
import com.half.util.AppHandler;
import com.half.util.Keys;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ScheduleDetailsActivity extends Activity {

	private TextView txtScheduleSubject;
	private TextView txtScheduleDate;
	private TextView txtScheduleDateValue;
	private TextView txtScheduleFrom;
	private TextView txtScheduleFromValue;
	private TextView txtScheduleTo;
	private TextView txtScheduleToValue;
	private TextView txtScheduleVenue;
	private TextView txtScheduleVenueValue;
	private TextView txtScheduleMessgeValue;

	private EditText etScheduleSubjcte;
	private EditText etScheduleDate;
	private EditText etScheduleFrom;
	private EditText etScheduleTo;
	private EditText etScheduleVenue;
	private EditText etScheduleMessage;

	private String operation;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_schedule_details);
		initialControls();
		setUi();

	}

	private void initialControls() {
		txtScheduleDate = (TextView) findViewById(R.id.txtScheduleDate);
		txtScheduleFrom = (TextView) findViewById(R.id.txtScheduleFrom);
		txtScheduleTo = (TextView) findViewById(R.id.txtScheduleTo);
		txtScheduleVenue = (TextView) findViewById(R.id.txtScheduleVenue);

		txtScheduleSubject = (TextView) findViewById(R.id.txtScheduleSubject);
		txtScheduleDateValue = (TextView) findViewById(R.id.txtScheduleDateValue);
		txtScheduleFromValue = (TextView) findViewById(R.id.txtScheduleFromValue);
		txtScheduleToValue = (TextView) findViewById(R.id.txtScheduleToValue);
		txtScheduleVenueValue = (TextView) findViewById(R.id.txtScheduleVenueValue);
		txtScheduleMessgeValue = (TextView) findViewById(R.id.txtScheduleMessgeValue);


		etScheduleSubjcte = (EditText) findViewById(R.id.etScheduleSubjcte);
		etScheduleDate = (EditText) findViewById(R.id.etScheduleDate);
		etScheduleFrom = (EditText) findViewById(R.id.etScheduleFrom);
		etScheduleTo = (EditText) findViewById(R.id.etScheduleTo);
		etScheduleVenue = (EditText) findViewById(R.id.etScheduleVenue);
		etScheduleMessage = (EditText) findViewById(R.id.etScheduleMessage);
	
		operation = AppHandler.getScheduleOperation();
	}
	
	private void setUi() {
		if(operation.equalsIgnoreCase(AppConstant.POST))
    	{
			txtScheduleDateValue.setVisibility(View.GONE);
			txtScheduleFromValue.setVisibility(View.GONE);
			txtScheduleToValue.setVisibility(View.GONE);
			txtScheduleVenueValue.setVisibility(View.GONE);
			txtScheduleMessgeValue.setVisibility(View.GONE);
    	}else if(operation.equalsIgnoreCase(AppConstant.SHOW))
    	{
    		etScheduleSubjcte.setVisibility(View.GONE);
    		etScheduleDate.setVisibility(View.GONE);
    		etScheduleFrom.setVisibility(View.GONE);
    		etScheduleTo.setVisibility(View.GONE);
    		etScheduleVenue.setVisibility(View.GONE);
    		etScheduleMessage.setVisibility(View.GONE);
    	}
		
	}

}
