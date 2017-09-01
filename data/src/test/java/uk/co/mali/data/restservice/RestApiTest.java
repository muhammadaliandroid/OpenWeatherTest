package uk.co.mali.data.restservice;

import android.util.LruCache;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.mali.data.model.apipojo.Data;
import uk.co.mali.data.netservice.constants.Constants;
import uk.co.mali.data.netservice.restservice.RestApi;
import uk.co.mali.data.util.rxutil.IRxSchedulers;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by alig2 on 01/09/2017.
 */


@RunWith(MockitoJUnitRunner.class)
public class RestApiTest {

    @Mock
    private LruCache<String, Data> mCache;

    @Mock
    private IRxSchedulers iRxSchedulers;

    RestApi restApi;

    Retrofit retrofit;

    ServiceInteractor serviceInteractor;

    @Before
    public void setup(){
        //Clear Cache
        when(mCache.get(anyString())).thenReturn(new Data());
        restApi = getRestApi();
        serviceInteractor = new ServiceInteractor(restApi, mCache);
    }

    public OkHttpClient getOKHttpClient(){

        OkHttpClient.Builder  builder = new OkHttpClient().newBuilder();
        return builder.build();
    }

    public RestApi getRestApi(){
        retrofit = new Retrofit.Builder()
                .client(getOKHttpClient())
                .baseUrl(Constants.OPEN_WEATHER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.computation())).build();

        return retrofit.create(RestApi.class);

    }


    @Test
    public void  testWeatherRestApiService() {





        TestObserver<Object> testObserver = new TestObserver<>();
        if (testObserver != null) {
            serviceInteractor.processWeatherDataFromService().subscribe(testObserver);

            testObserver.assertNoErrors();
            testObserver.assertSubscribed();
            testObserver.onComplete();
            

        }

    }





    }



