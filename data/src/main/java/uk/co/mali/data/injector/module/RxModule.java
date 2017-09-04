package uk.co.mali.data.injector.module;

import dagger.Module;
import dagger.Provides;
import uk.co.mali.data.util.rxutil.IRxSchedulers;
import uk.co.mali.data.util.rxutil.RxSchedulers;

/**
 * Created by alig2 on 02/09/2017.
 */

@Module
public class RxModule {

    @Provides
    IRxSchedulers provideIRxSchedulers(){
        return new RxSchedulers();
    }
}
