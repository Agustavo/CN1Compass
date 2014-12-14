/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codenameone.compass;

import com.codename1.system.NativeLookup;
import com.codename1.ui.Dialog;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author asuarez
 */
public class Compass {
    private static Compass compass = new Compass();
    private static List<CompassListener> listeners = new LinkedList<CompassListener>();
    private static CompassNative compassNative;
    
    private Compass() {   
        compassNative = (CompassNative)NativeLookup.create(CompassNative.class);
        if (compassNative!=null && compassNative.isSupported()) {
            System.out.println("Plataforma soportada");
            Dialog.show("OK", "Plataforma soportada", "OK", "Cancel");
        } else {
            if (compassNative==null)
                Dialog.show("OK", "Plataforma NO soportada (NULL)", "OK", "Cancel");
            else
                Dialog.show("Error", "Plataforma NO soportada", "OK", "Cancel");
            
            compassNative = null;
            System.out.println("Plataforma no soportada");   
        }
    }
    
    public static Compass getInstance() {
        return compass;
    }
    
    public static void _onHeading(float heading) {
        for (CompassListener ln : compass.listeners) {
            ln.onHeading(heading);
        }
    }
    public static void addCompassListener(CompassListener listener) {
        if (listeners.isEmpty()) {
            if (compassNative!=null){
                compassNative.init();
            }
        }
        listeners.add(listener);
        
    }
    
    public static void removeListener(CompassListener listener) {
        listeners.remove(listener);
        if (listeners.isEmpty()) {
            if (compassNative!=null) {
                compassNative.end();
            }
        }
    }
}
