package uk.co.mali.openweathertest.cityweatherforecast.presenter;

import android.content.Context;
import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import uk.co.mali.data.repository.DataRepository;
import uk.co.mali.domain.model.domainpojo.WeatherDomain;
import uk.co.mali.domain.usecase.WeatherCityForecastUseCase;
import uk.co.mali.openweathertest.cityweatherforecast.view.ICityWeatherForecastView;
import uk.co.mali.openweathertest.utils.mapper.MapWeatherDomainToWeatherReport;
import uk.co.mali.openweathertest.utils.network.NetworkUtils;
import uk.co.mali.openweathertest.utils.ui.UiUtils;

/**
 * Created by alig2 on 03/09/2017.
 */
public class CityWeatherForecastPresenter implements ContractCityWeatherForecast {
    public static Executor internetExecutor = Executors.newCachedThreadPool();
    public static Scheduler internetScheduler = Schedulers.from(internetExecutor);

    public static Executor backgroundExecutor = Executors.newCachedThreadPool();
    public static Scheduler backgroundScheduler = Schedulers.from(backgroundExecutor);

    private static final String TAG = CityWeatherForecastPresenter.class.getSimpleName();
    private ICityWeatherForecastView iView;
    private String cityTag;
    private Context mContext;
    private WeatherCityForecastUseCase useCase;
    private CompositeDisposable compositeDisposable;
    private WeatherDomain domain;

    public CityWeatherForecastPresenter(Context mContext, ICityWeatherForecastView iView) {
        this.iView = iView;
        this.mContext = mContext;
        this.useCase = new WeatherCityForecastUseCase(new DataRepository());
    }

    @Override
    public void OnCreate() {
        Log.d(TAG, "OnCreate");
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            compositeDisposable = new CompositeDisposable();
        }
    }

    public void initialize() {
        Log.d(TAG, "initialize");

        addDisposable();
    }

    public void onResume() {
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            useCase = new WeatherCityForecastUseCase(new DataRepository());
            compositeDisposable = new CompositeDisposable();
            addDisposable();
        }

    }

    public void setCityTag(String cityTag) {
        Log.d(TAG, "setCityTag");

        this.cityTag = cityTag;
    }

    public String getCityTag() {
        Log.d(TAG, "getCityTag");

        return cityTag;
    }

    @Override
    public void addDisposable() {

        Log.d(TAG, "addDisposable");
        compositeDisposable.add(getCityWeatherDisposable(getCityTag()));
        compositeDisposable.add(getClickEventOnList());
    }

    @Override
    public Disposable getCityWeatherDisposable(String tag) {
        Log.d(TAG, "getCityWeatherDisposable");
        return NetworkUtils
                .isNetworkAvailableObservable(context())
                .doOnNext(networkAvailable -> {
                    if (!networkAvailable) {
                        UiUtils.showSnackBar(iView.getView(), "Internet Network not available!");
                    }

                })
                .filter(isNetworkAvailable -> true)
                .flatMap(isAvailable -> useCase.getWeatherCityForecastByCityName(tag))

                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                            Log.d(TAG, "From: Subcribe of Data");
                            iView.getCityWeatherDomainForecast(data);
                            setWeatherDomain(data);

                        }, throwable -> {
                            UiUtils.handleThrowable(throwable);
                        }
                );

    }


    @Override
    public Disposable getClickEventOnList() {
        Log.d(TAG, "getClickEventOnList");

        return   iView
                .itemClicks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {

                        Log.d(TAG, "getClickEventOnList() accept: position: " + integer.toString());
                       iView.startDetailDailyCityWeatherReportActivity(MapWeatherDomainToWeatherReport.mapWeatherDomainToWeatherReport(getWeatherDomain(), integer));
                    }
                });
    }

    public WeatherDomain getWeatherDomain() {
        return domain;
    }

    public void setWeatherDomain(WeatherDomain domain) {
        this.domain = domain;
    }

    @Override
    public void onStop() {
        rxDisposableDispose();
    }

    @Override
    public void onPause() {
        rxDisposableDispose();
    }

    @Override
    public void onDestroy() {
        rxDisposableDispose();
    }


    public void rxDisposableDispose() {
        Log.d(TAG, "rxDisposableDispose");

        if (compositeDisposable != null && !compositeDisposable.isDisposed())
            compositeDisposable.dispose();
    }


    ICityWeatherForecastView getiView() {
        return iView;
    }

    public Context context() {
        return mContext;
    }

}
