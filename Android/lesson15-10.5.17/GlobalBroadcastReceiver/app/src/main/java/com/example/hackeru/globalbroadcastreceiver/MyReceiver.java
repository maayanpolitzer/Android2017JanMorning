package com.example.hackeru.globalbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by hackeru on 5/10/2017.
 */

public class MyReceiver extends BroadcastReceiver {

    private static boolean listening = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!listening){
            listening = true;
            TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            manager.listen(new MyListener(), PhoneStateListener.LISTEN_CALL_STATE);
        }
    }
}
