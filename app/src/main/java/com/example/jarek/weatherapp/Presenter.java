package com.example.jarek.weatherapp;

import android.os.Bundle;
import android.os.Handler;

import java.lang.ref.WeakReference;
import com.example.jarek.weatherapp.OkHttpImpl;

/**
 * Created by jarek on 02.01.2017.
 */

public class Presenter implements MVPInterface.PresenterOperations, Model.ModelResult {

    // View reference. We use as a WeakReference
    // because the Activity could be destroyed at any time
    // and we don't want to create a memory leak
    private WeakReference<MVPInterface.ViewOperations> mView;
    // Model reference
    private MVPInterface.PresenterToModel mModel;

    private Handler handler;

    /**
     * Presenter Constructor
     * @param view  MainActivity
     */
    public Presenter(MVPInterface.ViewOperations view) {
        mView = new WeakReference<>(view);
        handler = new Handler();
        mModel = new Model(new OkHttpImpl());
    }


    private MVPInterface.ViewOperations  getView() throws NullPointerException{
        if ( mView != null )
            return mView.get();
        else
            throw new NullPointerException("View is unavailable");
    }

    @Override
    public void onStartup(Bundle savedInstanceState) {
        if(savedInstanceState == null) {
            getView().showMainMenu();
        }

    }

    @Override
    public void onCitySelected(final int id) {
        getView().showProgressBar();
        getView().hideListView();

        String cityName= getView().getViewResources().getStringArray(R.array.cityName)[id];
        mModel.downloadWeatherData(cityName, this);
    }

    private void handleWeatherResult(Weather weather) {
        getView().hideProgressBar();
        getView().loadResultFragment(weather);
    }

    @Override
    public void onwWeatherReady(final Weather weather) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                handleWeatherResult(weather);
            }
        });
    }

    @Override
    public void onDownloadError(String msg) {
    }
}
