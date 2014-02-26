package com.half.circlegroup;

import java.util.ArrayList;

import com.half.adapter.CustomAdapter;
import com.half.domain.User;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

public class MemberListActivity extends Activity {

	 public  MemberListActivity CustomListView = null;
	 public  ArrayList<User> CustomListViewValuesArr = new ArrayList<User>();
	 ListView list;
     CustomAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_member_list);
		CustomListView = this;
		
		/******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
        setListData();
         
        Resources res =getResources();
        list= ( ListView )findViewById( R.id.list );  // List defined in XML ( See Below )
         
        /**************** Create Custom Adapter *********/
        adapter=new CustomAdapter( CustomListView, CustomListViewValuesArr,res );
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
            CustomListViewValuesArr.add( sched );
        }
         
    }
    
	
	/***************** This function used by adapter ****************/
	public void onItemClick(int mPosition)
    {
        User tempValues = ( User ) CustomListViewValuesArr.get(mPosition);


       // SHOW ALERT                  

        Toast.makeText(CustomListView, ""+tempValues.getName() +" Image:"+tempValues.getImage()+" Url:"+tempValues.getUrl(), Toast.LENGTH_LONG)
        .show();
    }
}
