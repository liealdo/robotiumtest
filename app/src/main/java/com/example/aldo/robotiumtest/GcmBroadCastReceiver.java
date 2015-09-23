package com.example.aldo.robotiumtest;

import android.content.*;
import android.widget.Toast;

/**
 * Created by aldo on 9/18/2015.
 */
public class GcmBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"testing",Toast.LENGTH_LONG).show();
    }
}
