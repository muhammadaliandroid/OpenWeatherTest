package uk.co.mali.data.restservice;

import android.util.LruCache;

import io.reactivex.Observable;
import uk.co.mali.data.model.apipojo.Data;
import uk.co.mali.data.netservice.restservice.RestApi;

/**
 * Created by alig2 on 01/09/2017.
 */

public class ServiceInteractor {
    private LruCache<String, Data> cache;
    private RestApi service;

    public ServiceInteractor(RestApi service, LruCache<String, Data> cache) {
        this.cache = cache;
        this.service = service;
    }

    public LruCache<String, Data> getCache() {
        return cache;
    }

    public Observable<Data> processWeatherDataFromService() {

        Observable<Data> dataObservableNetwork = networkResult();
        Observable<Data> dataObservableCache = cachedResult();

        return Observable.concat(dataObservableCache,dataObservableNetwork);
    }


    private Observable<Data> cachedResult() {
        return  Observable.just(cache.get("query"))
                .filter((Data result) ->
                        result != null
                );

    }

    private Observable<Data> networkResult() {
        return service.getWeatherData("London, UK").
                doOnNext((result) -> cache.put("query", result));

    }



}
