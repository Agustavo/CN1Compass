package com.codenameone.compass;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.codename1.impl.android.AndroidNativeUtil;
import android.widget.Toast;

public class CompassNativeImpl implements SensorEventListener {
    
    private SensorManager mSensorManager=null;
    
    public void init() {
        if (mSensorManager == null) {
            Activity activity = AndroidNativeUtil.getActivity();
            mSensorManager = (SensorManager) activity.getSystemService(activity.SENSOR_SERVICE);
            mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
        }

    }

    public void end() {
        if (mSensorManager != null) {
            mSensorManager.unregisterListener(this);
            mSensorManager = null;
        }
    }

    public boolean isSupported() {
        return true;
    }
    
    @Override
    public void onSensorChanged(SensorEvent event) {
	 
        // get the angle around the z-axis rotated
        float degree = Math.round(event.values[0]);
 
        System.out.println("Heading: " + Float.toString(degree) + " degrees");
        
        Compass._onHeading(degree);
    }
 
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // not in use
    }

}
