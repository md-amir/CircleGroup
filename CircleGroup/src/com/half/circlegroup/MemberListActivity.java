package com.half.circlegroup;

import java.util.ArrayList;

import com.half.adapter.UserAdapter;
import com.half.domain.User;
import com.half.util.InitialInfo;

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
    	
    	userList = InitialInfo.getMemberList();
         
//        for (int i = 0; i < 11; i++) {
             
//            final User user = new User();
//                 
//              /******* Firstly take data in model object ******/
//               user.setName("Md Amir Hossain ");
////               sched.setImage("image"+i);
//               user.setMobileNumber("01718738124");
//               user.setDegignation("Software Engineer");
//               user.setTeamName("Rose");
//               user.setBusNumber("2");
//               user.setEmail("amir.ict.engg@gmail.com");
//               user.setRoomNumber("5");
//               user.setUniqueNumber("123456789");
//               user.setUrl("http:\\www."+i+".com");
//                
//            /******** Take Model Object in ArrayList **********/
//            userList.add( user );
//        }
         
    }
    
	
	/***************** This function used by adapter ****************/
	public void onItemClick(int mPosition)
    {
        User user = ( User ) userList.get(mPosition);

        intent = new Intent(MemberListActivity.this,ProfilePageActivity.class);
        Bundle mBundle = new Bundle(); 
        mBundle.putParcelable("user", user); 
        intent.putExtras( mBundle);
        startActivity(intent);
    }
}
