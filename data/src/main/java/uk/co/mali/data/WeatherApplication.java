package uk.co.mali.data;

import android.app.Application;

import uk.co.mali.data.injector.component.AppComponent;
import uk.co.mali.data.injector.component.DaggerAppComponent;
import uk.co.mali.data.injector.module.NetModule;
import uk.co.mali.data.injector.module.RestApiServiceModule;
import uk.co.mali.data.injector.module.RxModule;

/**
 * Created by alig2 on 02/09/2017.
 */

public class WeatherApplication extends Application{
    private static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();

    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .netModule(new NetModule(getApplicationContext()))
                .rxModule(new RxModule())
                .restApiServiceModule(new RestApiServiceModule())
                .build();
    }

    public static AppComponent getAppComponent(){
        return appComponent;

    }


}
