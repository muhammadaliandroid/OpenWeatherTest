package uk.co.mali.data.util.rxutil;


import io.reactivex.Scheduler;

/**
 * Created by alig2 on 01/09/2017.
 */

public interface IRxSchedulers {

    Scheduler runOnBackground();
    Scheduler io();
    Scheduler compute();
    Scheduler androidThread();
    Scheduler internet();

}
