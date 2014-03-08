package com.half.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.half.circlegroup.R;
import com.half.domain.User;
import com.half.util.ImageDownloaderTask;



/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class UserAdapter extends BaseAdapter {
          
         /*********** Declare Used Variables *********/
         private Context context;
         private ArrayList<User> userList;
         private static LayoutInflater inflater=null;
         public Resources res;
         User temUser=null;
         private ViewHolder holder;
         int i=0;
          
         /*************  UserAdapter Constructor *****************/
         public UserAdapter(Context context, ArrayList<User> userList,Resources resLocal) {
              
                /********** Take passed values **********/
                 this.context = context;
                 this.userList=userList;
                 res = resLocal;
              
                 /***********  Layout inflator to call external xml layout () ***********/
                  inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //LayoutInflater.from(this.context);
              
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
              
             if(convertView==null){
                 vi = inflater.inflate(R.layout.row, null);
                 holder = new ViewHolder();
                 holder.txtName = (TextView) vi.findViewById(R.id.txtName);
                 holder.txtMobileNumber=(TextView)vi.findViewById(R.id.txtMobileNumber);
                 holder.imgProfilePic=(ImageView)vi.findViewById(R.id.imgProfilePic);
                 vi.setTag( holder );
             }
             else 
                 holder=(ViewHolder)vi.getTag();
              
             if(userList.size()<=0)
             {
                
             }
             else
             {                
                 temUser=null;
                 temUser = userList.get( position ); 
                 holder.txtName.setText( temUser.getName());
                 holder.txtMobileNumber.setText( temUser.getMobileNumber() );
                 
//               if(temUser.getUrl() !=null && temUser.getUrl() !="")
//                  {
//                  String url_val="http://marufnafi.byethost4.com/"+temUser.getUrl();//This is the Url you are getting from JSON parsing
//                  Log.v("image url","image-url"+url_val);
//                  new DownloadImageTask(holder.imgProfilePic).execute(url_val);
//                  }
            if (holder.imgProfilePic != null && temUser.getUrl() !=null && temUser.getUrl() !="") {
            	
            	String url_val="http://marufnafi.byethost4.com/"+temUser.getUrl();//This is the Url you are getting from JSON parsing
                 Log.v("image url", "image-url"+url_val);
            	url_val = url_val.replace("%20", " ");
            	Log.v("url_val","url_val"+url_val);
            	new ImageDownloaderTask(holder.imgProfilePic).execute("http://lh5.ggpht.com/_hepKlJWopDg/TB-_WXikaYI/AAAAAAAAElI/715k4NvBM4w/s144-c/IMG_0075.JPG");
//            	new ImageDownloaderTask(holder.imgProfilePic).execute(url_val);
            	           	
       		   } 
                  }
             return vi;
             }          
                    
            }