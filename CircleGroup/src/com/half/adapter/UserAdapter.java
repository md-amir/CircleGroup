package com.half.adapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.half.circlegroup.MemberListActivity;
import com.half.circlegroup.R;
import com.half.domain.User;

/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class UserAdapter extends BaseAdapter   implements OnClickListener {
          
         /*********** Declare Used Variables *********/
         private Activity activity;
         private ArrayList userList;
         private static LayoutInflater inflater=null;
         public Resources res;
         User temUser=null;
         int i=0;
          
         /*************  UserAdapter Constructor *****************/
         public UserAdapter(Activity activity, ArrayList userList,Resources resLocal) {
              
                /********** Take passed values **********/
                 this.activity = activity;
                 this.userList=userList;
                 res = resLocal;
              
                 /***********  Layout inflator to call external xml layout () ***********/
                  inflater = ( LayoutInflater )activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
              
         }
      
         /******** What is the size of Passed Arraylist Size ************/
         public int getCount() {
              
             if(userList.size()<=0)
                 return 1;
             return userList.size();
         }
      
         public Object getItem(int position) {
             return position;
         }
      
         public long getItemId(int position) {
             return position;
         }
          
         /********* Create a holder Class to contain inflated xml file elements *********/
         public static class ViewHolder{
              
             public TextView txtName;
             public TextView txtMobileNumber;
             public TextView txtDesignation;
             public TextView textWide;
             public ImageView imgProfilePic;
      
         }
      
         /****** Depends upon userList size called for each row , Create each ListView row *****/
         public View getView(int position, View convertView, ViewGroup parent) {
              
             View vi = convertView;
             ViewHolder holder;
              
             if(convertView==null){
                  
                 /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                 vi = inflater.inflate(R.layout.row, null);
                  
                 /****** View Holder Object to contain tabitem.xml file elements ******/
 
                 holder = new ViewHolder();
                 holder.txtName = (TextView) vi.findViewById(R.id.txtName);
                 holder.txtMobileNumber=(TextView)vi.findViewById(R.id.txtMobileNumber);
//                 holder.txtDesignation=(TextView)vi.findViewById(R.id.txtd);
                 holder.imgProfilePic=(ImageView)vi.findViewById(R.id.imgProfilePic);
                  
                /************  Set holder with LayoutInflater ************/
                 vi.setTag( holder );
             }
             else 
                 holder=(ViewHolder)vi.getTag();
              
             if(userList.size()<=0)
             {
                 holder.txtName.setText("No Data");
                  
             }
             else
             {
                 /***** Get each Model object from Arraylist ********/
                 temUser=null;
                 temUser = ( User ) userList.get( position ); 
                  
                 /************  Set Model values in Holder elements ***********/
 
                  holder.txtName.setText( temUser.getName());
                  holder.txtMobileNumber.setText( temUser.getMobileNumber() );
//                holder.txtDesignation.setText( temUser.getDegignation() );
//                  holder.imgProfilePic.setImageResource( res.getIdentifier( "com.half.adapter:drawable/"+temUser.getImage(),null,null));
                  
//                  try {
//                	  
//                	  Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL("https://www.facebook.com/photo.php?fbid=1132819179145&set=a.1280951842369.36264.1787275162&type=1&theater").getContent());
//                	  holder.imgProfilePic.setImageBitmap(bitmap); 
//                	} catch (MalformedURLException e) {
//                	  e.printStackTrace();
//                	} catch (IOException e) {
//                	  e.printStackTrace();
//                	}
//                    /******** Set Item Click Listner for LayoutInflater for each row *******/
 
                  vi.setOnClickListener(new OnItemClickListener( position ));
             }
             return vi;
         }
          
         @Override
         public void onClick(View v) {
                 Log.v("UserAdapter", "=====Row button clicked=====");
         }
          
         /********* Called when Item click in ListView ************/
         private class OnItemClickListener  implements OnClickListener{           
             private int mPosition;
              
             OnItemClickListener(int position){
                  mPosition = position;
             }
              
             @Override
             public void onClick(View arg0) {
 
        
               MemberListActivity sct = (MemberListActivity)activity;
 
              /****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/
 
                 sct.onItemClick(mPosition);
             }               
         }   
     }