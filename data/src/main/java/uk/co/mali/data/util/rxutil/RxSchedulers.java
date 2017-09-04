package uk.co.mali.data.util.rxutil;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by alig2 on 01/09/2017.
 */

public class RxSchedulers implements IRxSchedulers{


    public static Executor backgroundExecutor = Executors.newCachedThreadPool();
    public static Scheduler backgroundScheduler = Schedulers.from(backgroundExecutor);
    public static Executor internetExecutor = Executors.newCachedThreadPool();
    public static Scheduler internetScheduler = Schedulers.from(internetExecutor);



    @Override
    public Scheduler runOnBackground() {
        return backgroundScheduler;
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler compute() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler androidThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler internet() {
        return internetScheduler;
    }
}
