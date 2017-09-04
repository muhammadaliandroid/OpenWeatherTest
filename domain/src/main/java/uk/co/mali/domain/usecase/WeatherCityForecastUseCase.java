package uk.co.mali.domain.usecase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import uk.co.mali.domain.model.domainpojo.WeatherDomain;
import uk.co.mali.domain.repository.IDataRepository;

public class WeatherCityForecastUseCase {

    private static final String TAG = WeatherCityForecastUseCase.class.getSimpleName();

    public static Executor internetExecutor = Executors.newCachedThreadPool();
    public static Scheduler internetScheduler = Schedulers.from(internetExecutor);

    private IDataRepository respository;

    public WeatherCityForecastUseCase(IDataRepository respository) {
        this.respository=respository;
    }


    public Observable<WeatherDomain> getWeatherCityForecastByCityName(String tag){
        //Logger.getLogger(TAG, "getWeatherCityForecastByCityName: "+tag);


        return respository.getWeatherDataFrom(tag);


    }



}
