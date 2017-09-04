package uk.co.mali.data.injector.module;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.mali.data.injector.scope.AppScope;
import uk.co.mali.data.util.rxutil.IRxSchedulers;

/**
 * Created by alig2 on 02/09/2017.
 */

@Module
public class NetModule {

    Context context;

    public NetModule(Context context){
    this.context = context;
    }


    @AppScope
    @Provides
    Context provideContext(){
        return context;
    }

    @AppScope
    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor logger, Cache cache){

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.addInterceptor(logger);
        builder.cache(cache);
        return builder.build();

    }
    @AppScope
    @Provides
    HttpLoggingInterceptor provideInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @AppScope
    @Provides
    Cache provideCache(File file){
        return new Cache(file, 10 *10* 1024);
    }

    @AppScope
    @Provides
    File providesCacheFile(Context context){
        return context.getFilesDir();
    }

    @AppScope
    @Provides
    RxJava2CallAdapterFactory providesRxAdapter(IRxSchedulers iRxSchedulers){
        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io());
    }

    @Provides
    GsonConverterFactory provideGsonClient(){
        return GsonConverterFactory.create();
    }

}
