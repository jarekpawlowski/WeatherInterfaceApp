package com.example.jarek.weatherapp;

/**
 * Created by jarek on 02.01.2017.
 */

public interface NetworkInterface {
    void getWeather(String city, NetworkInterfaceResult networkInterfaceResult);


    interface NetworkInterfaceResult {
        void onResultReady(Weather weather);
        void onResultError(String msg);
    }
}
