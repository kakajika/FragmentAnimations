package com.labo.kaji.fragmentanimations;

import android.app.Application;

import com.deploygate.sdk.DeployGate;

/**
 * @author kakajika
 * @since 2016/04/20
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DeployGate.install(this);
    }
}
