package uk.co.mali.openweathertest.cityweatherforecast.view;

import android.view.View;

import io.reactivex.Observable;
import uk.co.mali.domain.model.domainpojo.WeatherDomain;
import uk.co.mali.openweathertest.cityweatherforecast.model.WeatherReport;

/**
 * Created by alig2 on 03/09/2017.
 */

public interface ICityWeatherForecastView {

    public void getCityWeatherDomainForecast(WeatherDomain weatherDomain);
    public void startDetailDailyCityWeatherReportActivity(WeatherReport weatherReport);

    public Observable<Integer> itemClicks();
    public View constructView();
    public View getView();

}


