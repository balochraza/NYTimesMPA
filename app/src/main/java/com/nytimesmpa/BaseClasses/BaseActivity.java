package com.nytimesmpa.BaseClasses;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {
    public static final  String articleDetailURL= "DetailURL";
    //Use Context in Child classes
    protected Context context = this;
    //Show Toast in Child Class
    public void makeToast(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }

    //This Method Check Internet Availability
    protected boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
