package uk.co.mali.openweathertest.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


/**
 * Created by alig2 on 03/09/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class NetworkTest {

    @Mock
    ConnectivityManager connectivityManager;
    @Mock
    NetworkInfo networkInfo;

    @Before
    public void setup(){

        //Mockito.when( connectivityManager.getNetworkInfo( ConnectivityManager.TYPE_WIFI )).thenReturn(Context.CONNECTIVITY_SERVICE);
        Mockito.when( connectivityManager.getActiveNetworkInfo()).thenReturn(networkInfo);
        Mockito.when( networkInfo.getDetailedState()).thenReturn( connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI ).getDetailedState() );
        Mockito.when( networkInfo.isConnected()).thenReturn( true );
    }

    @Test
    public void checkNetworkState(){

        Mockito.verify( networkInfo ).isAvailable();
        Mockito.verify( networkInfo ).isConnected();
    }
}
