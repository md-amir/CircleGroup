package com.half.circlegroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomePageActivity extends Activity implements OnClickListener {

	private Button btnMember;
	private Button btnMedias;
	private Button btnInvite;
	private Button btnAlertAndSchedule;
	private Intent intent;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		initialControls();
	}

	private void initialControls() {

		btnMember = (Button) findViewById(R.id.btnMembers);
		btnMember.setOnClickListener(this);
		btnMedias = (Button) findViewById(R.id.btnMedia);
		btnMedias.setOnClickListener(this);
		btnInvite = (Button) findViewById(R.id.btnInvite);
		btnInvite.setOnClickListener(this);
		btnAlertAndSchedule = (Button) findViewById(R.id.btnAlertAndSchedule);
		btnAlertAndSchedule.setOnClickListener(this);
		context = this;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnMembers: {
            intent = new Intent(context, MembersGroupActivity.class);
            startActivity(intent);
			break;
		}
		case R.id.btnMedia: {
            intent = new Intent(context, MediasActivity.class);
            startActivity(intent);
			break;
		}
		case R.id.btnInvite: {
//            intent = new Intent(context, InviteActivity.class);
//            startActivity(intent);
			break;
		}
		case R.id.btnAlertAndSchedule: {
//            intent = new Intent(context, ProfileActivity.class);
//            startActivity(intent);
			break;
		}
		default:
			break;
		}

	}

}
