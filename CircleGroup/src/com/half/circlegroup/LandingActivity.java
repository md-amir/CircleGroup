package com.half.circlegroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LandingActivity extends Activity implements OnClickListener {

	private Button btnLogin;
	private TextView abc;
	private EditText edtId;
	private Intent intent;
	private Context context;
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        intialControl();
    }


    private void intialControl() {

    	btnLogin =  (Button) findViewById(R.id.btnLogin);
    	btnLogin.setOnClickListener(this);
    	edtId =  (EditText) findViewById(R.id.edtId);
    	context = this;
        
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.landing, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnLogin:
		{
			intent = new Intent(context, HomePageActivity.class);
			startActivity(intent);
			break;
		
		}	

		default:
			break;
		}
		
	}
    
}
