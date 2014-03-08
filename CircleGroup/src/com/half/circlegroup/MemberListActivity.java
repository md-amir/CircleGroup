package com.half.circlegroup;

import java.util.ArrayList;

import com.half.adapter.UserAdapter;
import com.half.domain.User;
import com.half.util.AppConstant;
import com.half.util.AppHandler;
import com.half.util.InitialInfo;
import com.half.util.Keys;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

public class MemberListActivity extends Activity {

	 public static int PROFILE_PAGE_REQUEST = 100;
	 public  Context context = null;
	 public  ArrayList<User> userList = new ArrayList<User>();
	 private ListView list;
     private UserAdapter adapter;
     private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_member_list);
		context = this;
		
		/******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
        setListData();
         
        Resources resources =getResources();
        list= ( ListView )findViewById( R.id.list );  // List defined in XML 
         
        /**************** Create Custom Adapter *********/
        adapter=new UserAdapter( this, userList,resources );
        list.setAdapter( adapter );
	}

	/****** Function to set data in ArrayList *************/
    public void setListData()
    {    
    	String callForwardTo = AppHandler.getCallForward();
    	if(callForwardTo.equalsIgnoreCase(AppConstant.TO_ORGANIGATION))
    	{
    		userList = AppHandler.getEmployeeCatagoriList(getIntent().getExtras().getString(Keys.ORGANIZATION_KEY));
    	}else if(callForwardTo.equalsIgnoreCase(AppConstant.TO_LOS_TEAM))
    	{
    		userList = AppHandler.getEmployeeLosList(getIntent().getExtras().getString(Keys.LOS_TEAM_KEY));
    	}
                 
    }
    
	
	/***************** This function used by adapter ****************/
	public void onItemClick(int mPosition)
    {
        User user = ( User ) userList.get(mPosition);

        intent = new Intent(MemberListActivity.this,ProfilePageActivity.class);
        Bundle mBundle = new Bundle(); 
        mBundle.putParcelable(Keys.USER, user); 
        intent.putExtras( mBundle);
        startActivity(intent);
    }
}
