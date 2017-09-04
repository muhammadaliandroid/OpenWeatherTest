package uk.co.mali.openweathertest.utils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import io.reactivex.Observable;

/**
 * Created by alig2 on 03/09/2017.
 */

public class NetworkUtils {

    private static boolean isNetworkAvailable(Context context){
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }


    public static Observable<Boolean> isNetworkAvailableObservable(Context context){
        return Observable.just(NetworkUtils.isNetworkAvailable(context));
    }
}
