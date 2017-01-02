package com.example.jarek.weatherapp;


import com.example.jarek.weatherapp.MVPInterface;
import com.example.jarek.weatherapp.Weather;




/**
 * Created by jarek on 02.01.2017.
 */

public class Model implements MVPInterface.PresenterToModel{
    NetworkInterface nNetworkImpl;

    public Model(NetworkInterface networkImpl) {
        this.nNetworkImpl = networkImpl;
    }

    @Override
    public void downloadWeatherData(String city, final ModelResult callBack) {
        nNetworkImpl.getWeather(city, new NetworkInterface.NetworkInterfaceResult() {
            @Override
            public void onResultReady(Weather weather) {
                callBack.onwWeatherReady(weather);
            }

            @Override
            public void onResultError(String msg) {
                callBack.onDownloadError(msg);
            }
        });
    }

    public interface ModelResult{
        void onwWeatherReady(Weather weather);
        void onDownloadError(String msg);
    }

}
