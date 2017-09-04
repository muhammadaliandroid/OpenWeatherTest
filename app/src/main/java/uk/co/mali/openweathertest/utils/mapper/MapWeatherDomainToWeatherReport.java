package uk.co.mali.openweathertest.utils.mapper;

import android.util.Log;

import uk.co.mali.domain.model.domainpojo.WeatherDomain;
import uk.co.mali.openweathertest.cityweatherforecast.model.WeatherReport;

/**
 * Created by alig2 on 04/09/2017.
 */

public class MapWeatherDomainToWeatherReport {
    private static final String TAG = "DOMAIN to REPORT ";


    public static WeatherReport mapWeatherDomainToWeatherReport(WeatherDomain weatherDomain, Integer pos){
        Log.d(TAG,"mapWeatherDomainToWeatherReport ");

        if(weatherDomain!=null){
            Log.d(TAG,"weatherDomain not Null ");

        }
        else
        {
            Log.d(TAG,"weatherDomain Null ");

        }
        int position = pos.intValue();

        Log.d(TAG,"Position Value: "+position);
        WeatherReport report = new WeatherReport();
        report.setCityName(weatherDomain.getCityName());
        report.setCountryName(weatherDomain.getCountryName());
        report.setCoordlatitude(weatherDomain.getCoordlatitude());
        report.setCoordlongitude(weatherDomain.getCoordlongitude());
        report.setDate(weatherDomain.getDailyInfoDomainList().get(position).getDate());
        report.setMainGrndLevel(weatherDomain.getDailyInfoDomainList().get(position).getMainGrndLevel());
        report.setMainHumidity(weatherDomain.getDailyInfoDomainList().get(position).getMainHumidity());
        report.setMainPressure(weatherDomain.getDailyInfoDomainList().get(position).getMainPressure());
        report.setMainTemp(weatherDomain.getDailyInfoDomainList().get(position).getMainTemp()-273.15);
        report.setMainTempMax(weatherDomain.getDailyInfoDomainList().get(position).getMainTempMax()-273.15);
        report.setMainTempMin(weatherDomain.getDailyInfoDomainList().get(position).getMainTempMin()-273.15);
        report.setWindSpeed(weatherDomain.getDailyInfoDomainList().get(position).getWindSpeed());

        return report;
    }
}
