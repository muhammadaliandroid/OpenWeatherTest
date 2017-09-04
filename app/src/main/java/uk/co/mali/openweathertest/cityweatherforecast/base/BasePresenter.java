package uk.co.mali.openweathertest.cityweatherforecast.base;

/**
 * Created by alig2 on 03/09/2017.
 */

public interface BasePresenter {

    public void onStop();
    public void onPause();
    public void onDestroy();

    void OnCreate();
}
