package com.codenameone.compass;

import java.util.Random;


public class CompassNativeImpl implements com.codenameone.compass.CompassNative {
    boolean terminado = false;
    public void init() {
        terminado = false;
        new Thread() {
            @Override
            public void run() {
                while (!terminado) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                       
                    }
                    Random rand = new Random();
                    //float f = ((float)rand.nextInt(360));
                    int f = rand.nextInt(360);
                    System.out.println(f);
                    Compass._onHeading(f);
                }
            }
        }.start();
    }

    public void end() {
    }

    public boolean isSupported() {
        return true;
    }

}
