package com.example.hackeru.globalbroadcastreceiver;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by hackeru on 5/10/2017.
 */

public class MyListener extends PhoneStateListener {

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        switch (state) {
            case TelephonyManager.CALL_STATE_RINGING:
                Log.d("TAG", "ringing...");
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                Log.d("TAG", "call started!");
                break;
            case TelephonyManager.CALL_STATE_IDLE:
                Log.d("TAG", "call ended!");
                break;
        }
    }
}
