package uk.co.mali.data.injector.component;

import android.content.Context;

import dagger.Component;
import uk.co.mali.data.injector.module.NetModule;
import uk.co.mali.data.injector.module.RestApiServiceModule;
import uk.co.mali.data.injector.module.RxModule;
import uk.co.mali.data.injector.scope.AppScope;
import uk.co.mali.data.netservice.restservice.RestApi;
import uk.co.mali.data.repository.DataRepository;
import uk.co.mali.data.util.rxutil.IRxSchedulers;

/**
 * Created by alig2 on 02/09/2017.
 */

@AppScope
@Component(modules = {NetModule.class, RxModule.class, RestApiServiceModule.class})
public interface AppComponent {

    void inject(DataRepository dataRepository);
    Context context();
    IRxSchedulers iRxSchedulers();
    RestApi apiService();


}
