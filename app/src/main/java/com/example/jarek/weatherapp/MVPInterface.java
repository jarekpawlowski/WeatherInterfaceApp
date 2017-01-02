package com.example.jarek.weatherapp;

import android.content.res.Resources;
import android.os.Bundle;

/**
 * Created by jarek on 02.01.2017.
 */

public interface MVPInterface {

    interface ViewOperations{
        void showMainMenu();
        void showProgressBar();
        void hideProgressBar();
        void showListView();
        void hideListView();

        Resources getViewResources();
        void loadResultFragment(Weather weather);
        void makeToast(String text);
    }

    interface PresenterOperations {
        void onStartup(Bundle savedInstanceState);
        void onCitySelected(int id);
    }

    interface PresenterToModel {
        void downloadWeatherData(String city, Model.ModelResult callBack);
    }
}
