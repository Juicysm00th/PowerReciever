package com.example.powerreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (intentAction != null) {
            String toastMessage = "unknown intent action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power connected!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power disconnected!";
                    break;
                 case Intent.ACTION_HEADSET_PLUG:
                     int state = intent.getIntExtra("state", -1);
                     if(state == 0){ toastMessage = "Headphones disconnected!"; }
                     if(state == 0){ toastMessage = "Headphones connected!";}
                     break;
                case ACTION_CUSTOM_BROADCAST:
                    int randNum = (int)(Math.random() * 20);
                    int randNumSquared = randNum * randNum;
                    toastMessage = "Random Number Squared " + randNumSquared + " Received";
                    break;
            }

            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}