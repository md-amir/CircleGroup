package com.half.adapter;

import java.util.ArrayList;


import com.half.adapter.UserAdapter.ViewHolder;
import com.half.circlegroup.R;
import com.half.domain.AlertAndSchedule;
import com.half.domain.User;
import com.half.util.AppConstant;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AlertScheduleAdapter extends BaseAdapter {
	
	private ArrayList<AlertAndSchedule> alertList ;
	private Activity activity;
	private static LayoutInflater inflater1=null;
	private AlertAndSchedule oneAlert;
	private String sign;
	
	public AlertScheduleAdapter(Activity activity, ArrayList list,String sign)
	{
		this.activity =  activity;
		this.alertList = list;
		this.sign = sign;
		inflater1 = ( LayoutInflater )activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return alertList.size();
	}

	@Override
	public Object getItem(int index) {
		// TODO Auto-generated method stub
		return getItem(index);
	}

	@Override
	public long getItemId(int index) {
		// TODO Auto-generated method stub
		return index;
	}
	
	/********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder1{
         
        public TextView txtSubject;
        public ImageView imgSign;
 
    }

	@Override
	public View getView(int index, View view, ViewGroup parent) {

        
        View vi = view;
        ViewHolder1 holder;
         
        if(view==null){
             
            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater1.inflate(R.layout.alert_and_schedule_row, null);
             
            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder1();
            holder.txtSubject = (TextView) vi.findViewById(R.id.txtAlertAndSchedulesSubject);
            holder.imgSign=(ImageView)vi.findViewById(R.id.imgAlertOrScheduleSign);
//            holder.txtDesignation=(TextView)vi.findViewById(R.id.txtd);
//            holder.imgProfilePic=(ImageView)vi.findViewById(R.id.imgProfilePic);
             
           /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else 
            holder=(ViewHolder1)vi.getTag();
         
        if(alertList.size()<=0)
        {
//            holder.txtName.setText("No Data");
             
        }
        else
        {
            /***** Get each Model object from Arraylist ********/
        	oneAlert=null;
        	oneAlert = ( AlertAndSchedule ) alertList.get( index ); 
             
            /************  Set Model values in Holder elements ***********/

             holder.txtSubject.setText( oneAlert.getSubject());
//             holder.imgSign.setImageResourcesetImageResource( res.getIdentifier( "com.half.adapter:drawable/"+temUser.getImage(),null,null)); );
//             holder.txtDesignation.setText( temUser.getDegignation() );
             //holder.imgProfilePic.setImageResource( res.getIdentifier( "com.half.adapter:drawable/"+temUser.getImage(),null,null));
              
             if(sign.equalsIgnoreCase(AppConstant.ALERT_VALUE))
            	 holder.imgSign.setImageResource(R.drawable.orange_circle);
             if(sign.equalsIgnoreCase(AppConstant.SCHEDULE_VALUE))
            	 holder.imgSign.setImageResource(R.drawable.green_circle);
            if(sign.equalsIgnoreCase(AppConstant.INVITATION_VALUE))
            	holder.imgSign.setImageResource(R.drawable.invite);
             
             
             
             
             /******** Set Item Click Listner for LayoutInflater for each row *******/

//             vi.setOnClickListener(new OnItemClickListener( position ));
        }
        return vi;
	}

}
