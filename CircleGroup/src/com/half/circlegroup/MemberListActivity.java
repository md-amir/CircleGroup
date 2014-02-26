package com.half.circlegroup;

import java.util.ArrayList;

import com.half.adapter.UserAdapter;
import com.half.domain.User;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

public class MemberListActivity extends Activity {

	 public  Context context = null;
	 public  ArrayList<User> userList = new ArrayList<User>();
	 ListView list;
     UserAdapter adapter;
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
         
        for (int i = 0; i < 11; i++) {
             
            final User sched = new User();
                 
              /******* Firstly take data in model object ******/
               sched.setName("Company "+i);
               sched.setImage("image"+i);
               sched.setUrl("http:\\www."+i+".com");
                
            /******** Take Model Object in ArrayList **********/
            userList.add( sched );
        }
         
    }
    
	
	/***************** This function used by adapter ****************/
	public void onItemClick(int mPosition)
    {
        User tempValues = ( User ) userList.get(mPosition);


       // SHOW ALERT                  

        Toast.makeText(context, ""+tempValues.getName() +" Image:"+tempValues.getImage()+" Url:"+tempValues.getUrl(), Toast.LENGTH_LONG)
        .show();
    }
}
