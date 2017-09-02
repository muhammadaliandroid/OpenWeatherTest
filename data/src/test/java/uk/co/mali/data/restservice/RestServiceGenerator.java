package uk.co.mali.data.restservice;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.mali.data.netservice.constants.Constants;
import uk.co.mali.data.netservice.restservice.RestApi;

/**
 * Created by alig2 on 02/09/2017.
 */

public class RestServiceGenerator {

    static RestServiceGenerator service = new RestServiceGenerator();

    public static RestServiceGenerator getService() {
        return service;
    }

    public OkHttpClient getOKHttpClient(){

        OkHttpClient.Builder  builder = new OkHttpClient().newBuilder();
        return builder.build();
    }

    public RestApi getRestApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .client(getOKHttpClient())
                .baseUrl(Constants.OPEN_WEATHER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.computation())).build();

        return retrofit.create(RestApi.class);

    }
}

