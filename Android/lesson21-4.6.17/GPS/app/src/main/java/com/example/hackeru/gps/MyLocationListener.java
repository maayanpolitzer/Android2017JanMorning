package com.example.hackeru.gps;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by hackeru on 6/4/2017.
 */

class MyLocationListener implements LocationListener {

    @Override
    public void onLocationChanged(Location location) {
        Log.d("TAG", location.toString());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
