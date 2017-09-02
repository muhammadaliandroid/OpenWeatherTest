package uk.co.mali.data.restservice;

import android.util.LruCache;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import uk.co.mali.data.model.apipojo.Data;
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

    public static Executor internetExecutor = Executors.newCachedThreadPool();
    public static Scheduler internetScheduler = Schedulers.from(internetExecutor);

    RestApi restApi;

    ServiceInteractor serviceInteractor;

    @Before
    public void setup(){
        when(mCache.get(anyString())).thenReturn(new Data());
        restApi = RestServiceGenerator.getService().getRestApi();
        serviceInteractor = new ServiceInteractor(restApi, mCache);
    }


    @Test
    public void  testWeatherRestApiService() {
        TestObserver<Object> testObserver = new TestObserver<>();
        if (testObserver != null) {
            serviceInteractor.processWeatherDataFromService().subscribe(testObserver);
            testObserver.assertNoErrors();
            testObserver.onComplete();
        }
    }




    @Test
    public void testWeatherObservableData(){

        DisposableObserver<Data> observer = new DisposableObserver<Data>() {
           @Override
           public void onNext(Data value) {
               Assert.assertNotNull(value);
               Assert.assertTrue("List In Data Object is not 0",returnSize(value));
               Assert.assertNotNull(value.getCity());
               Assert.assertNotNull(value.getMessage());
               Assert.assertNotNull(value.getList());
               Assert.assertEquals("london",value.getCity().getName());
           }
           @Override
           public void onError(Throwable e) {

               Assert.fail(e.getMessage());
           }

           @Override
           public void onComplete() {
               Assert.assertTrue(true);

           }
       };

        Observable<Data> dataObservable=restApi.getWeatherData("london, UK");

                dataObservable
                .subscribeOn(Schedulers.computation())
                .unsubscribeOn(internetScheduler)
                .subscribe(observer);



    }

    private boolean returnSize(Data mData) {
        return mData.getList().size()>0;
    }


}
