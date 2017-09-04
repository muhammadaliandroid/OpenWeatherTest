package uk.co.mali.data.injector.module;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.mali.data.injector.scope.AppScope;
import uk.co.mali.data.netservice.constants.Constants;
import uk.co.mali.data.netservice.restservice.RestApi;

/**
 * Created by alig2 on 02/09/2017.
 */

@Module
public class RestApiServiceModule {

    private static final String BASE_URL = Constants.OPEN_WEATHER_BASE_URL;

    @AppScope
    @Provides
    RestApi provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJava2CallAdapterFactory rxAdapter){
        Retrofit retrofit= new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(gson)
                .addCallAdapterFactory(rxAdapter)
                .build();

        return retrofit.create(RestApi.class);
    }

}
