package uk.co.mali.openweathertest.utils.ui;

import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

/**
 * Created by alig2 on 03/09/2017.
 */

public class UiUtils {

    private static final String TAG= UiUtils.class.getSimpleName();

    public static void showSnackBar(View view, String message){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction("Action", null).show();

    }

    public static void handleThrowable(Throwable throwable) {
        Log.e(TAG, " Error Message: " + throwable.getMessage());
    }
}
