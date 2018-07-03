package comtestinna.example.manew1.newecommerceapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class CheckConnectivity extends BroadcastReceiver {



    private static final String LOG_TAG = "CheckNetworkStatus";
    private boolean isConnected = false;
    ConnectivityManager connectivityManager;
    NetworkInfo wifiInfo, mobileInfo;

    @Override
    public void onReceive(final Context context, final Intent intent) {

        Log.v(LOG_TAG, "Receieved notification about network status");
        isNetworkAvailable(context);

    }


    boolean isNetworkAvailable(Context con) {

        try{
            connectivityManager = (ConnectivityManager) con.getSystemService(Context.CONNECTIVITY_SERVICE);
            wifiInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            mobileInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if(wifiInfo.isConnected() || mobileInfo.isConnected())
            {
                return true;
            }
        }
        catch(Exception e){
            System.out.println("CheckConnectivity Exception: " + e.getMessage());
        }

        return false;
    }

    public void connectivityMessage(String msg,Context context){

        final Toast toast = Toast.makeText(context, "", Toast.LENGTH_LONG);
        // toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setText(msg);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                toast.show();

            }
        }, 2000);

        //((Activity)context).finish();

        // System.exit(0);
    }
}
