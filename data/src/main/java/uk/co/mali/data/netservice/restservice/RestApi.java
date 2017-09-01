package uk.co.mali.data.netservice.restservice;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import uk.co.mali.data.model.apipojo.Data;
import uk.co.mali.data.netservice.constants.Constants;

/**
 * Created by alig2 on 01/09/2017.
 */

public interface RestApi {
    @GET(Constants.CITY_FORECAST)
    Observable<Data> getWeatherData(@Query("q") String cityId);
}
