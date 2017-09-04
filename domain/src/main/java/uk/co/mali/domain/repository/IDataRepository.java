package uk.co.mali.domain.repository;

import io.reactivex.Observable;
import uk.co.mali.domain.model.domainpojo.WeatherDomain;

/**
 * Created by alig2 on 01/09/2017.
 */

public interface IDataRepository {

    public Observable<WeatherDomain> getWeatherDataFrom (String cityName);

}
