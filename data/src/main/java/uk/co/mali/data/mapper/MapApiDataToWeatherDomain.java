package uk.co.mali.data.mapper;

import android.util.Log;

import java.util.ArrayList;

import uk.co.mali.data.model.apipojo.Data;
import uk.co.mali.domain.model.domainpojo.DailyInfoDomain;
import uk.co.mali.domain.model.domainpojo.WeatherDomain;

/**
 * Created by alig2 on 03/09/2017.
 */

public class MapApiDataToWeatherDomain {
    private static final String TAG = "DATA to DOMAIN MAPPING";

    public static WeatherDomain mapToWeatherDomain(Data data) {

        Log.d(TAG, "mapToWeatherDomain():");
        WeatherDomain weatherDomain = new WeatherDomain();

        if (data!= null){
            Log.d(TAG, "mapToWeatherDomain(): Data Not Null");


           weatherDomain.setCityName(data.getCity().getName());
           weatherDomain.setCountryName(data.getCity().getCountry());
           weatherDomain.setCoordlatitude(data.getCity().getCoord().getLat());
           weatherDomain.setCoordlongitude(data.getCity().getCoord().getLon());
           weatherDomain.setDailyInfoDomainList(mapToDailyInfoDomainList(data.getList()));

        }
        else {
            Log.d(TAG, "mapToWeatherDomain(): Data  Null");

        }

        return weatherDomain;
   }

    public static ArrayList<DailyInfoDomain> mapToDailyInfoDomainList(java.util.List<uk.co.mali.data.model.apipojo.List> listForecast){

        Log.d(TAG, "mapToDailyInfoDomainList():");

        ArrayList<DailyInfoDomain> dailyInfoDomainList = new ArrayList<DailyInfoDomain>();

        if(listForecast!=null){

            Log.d(TAG, "mapToDailyInfoDomainList(): List Forecast Not Null");


            for(int i=0; i<listForecast.size();i++){
                dailyInfoDomainList.add(i,mapGetListItem(listForecast.get(i)));
            }
        }

        else
        {
            Log.d(TAG, "mapToDailyInfoDomainList(): List Forecast Null");

        }

      return dailyInfoDomainList;
    }

    private static DailyInfoDomain mapGetListItem(uk.co.mali.data.model.apipojo.List listForecast) {

        DailyInfoDomain dailyInfoDomain = new DailyInfoDomain();
        if(listForecast!=null){

            Log.d(TAG, "mapGetListItem(): List Forecast Not Null");

            dailyInfoDomain.setDate(listForecast.getDtTxt());
            dailyInfoDomain.setMainGrndLevel(listForecast.getMain().getGrndLevel());
            dailyInfoDomain.setMainHumidity(listForecast.getMain().getHumidity());
            dailyInfoDomain.setMainPressure(listForecast.getMain().getPressure());
            dailyInfoDomain.setMainSeaLevel(listForecast.getMain().getSeaLevel());
            dailyInfoDomain.setMainTemp(listForecast.getMain().getTemp());
            dailyInfoDomain.setMainTempMin(listForecast.getMain().getTempMin());
            dailyInfoDomain.setMainTempMax(listForecast.getMain().getTempMax());
            dailyInfoDomain.setWindSpeed(listForecast.getWind().getSpeed());

        }

        else {
            Log.d(TAG, "mapGetListItem(): List Forecast Null");

        }

        return dailyInfoDomain;
    }
}
