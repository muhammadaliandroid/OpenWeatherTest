package uk.co.mali.openweathertest.cityweatherforecast.presenter;

import io.reactivex.disposables.Disposable;
import uk.co.mali.openweathertest.cityweatherforecast.base.BasePresenter;

/**
 * Created by alig2 on 03/09/2017.
 */

public interface ContractCityWeatherForecast extends BasePresenter {

    void addDisposable();
    public Disposable getCityWeatherDisposable(String tag);
    public Disposable getClickEventOnList();
}
