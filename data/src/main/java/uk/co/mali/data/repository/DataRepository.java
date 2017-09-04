package uk.co.mali.data.repository;

import android.content.Context;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import uk.co.mali.data.WeatherApplication;
import uk.co.mali.data.mapper.MapApiDataToWeatherDomain;
import uk.co.mali.data.model.apipojo.Data;
import uk.co.mali.data.netservice.restservice.RestApi;
import uk.co.mali.data.util.rxutil.IRxSchedulers;
import uk.co.mali.domain.model.domainpojo.WeatherDomain;
import uk.co.mali.domain.repository.IDataRepository;

/**
 * Created by alig2 on 02/09/2017.
 */

public class DataRepository implements IDataRepository{

    @Inject
    RestApi restApi;
    @Inject
    IRxSchedulers iRxSchedulers;
    @Inject
    Context context;

    public DataRepository(){
    init();
    }


    public void init(){
        WeatherApplication.getAppComponent().inject(this);

    }

    @Override
    public Observable<WeatherDomain> getWeatherDataFrom(String cityName) {

   Observable<Data> dataObservable = restApi.getWeatherData(cityName+",UK");

        Observable<WeatherDomain> weatherDomainObservable =
                dataObservable.map(new Function<Data, WeatherDomain>() {
                    @Override
                    public WeatherDomain apply(Data data) throws Exception {
                        return MapApiDataToWeatherDomain.mapToWeatherDomain(data);
                    }
                });

        return weatherDomainObservable;
    }
}
