package uk.co.mali.domain.model.domainpojo;

import java.util.ArrayList;

/**
 * Created by alig2 on 02/09/2017.
 */

public class WeatherDomain {



    private String cityName;
    private String countryName;
    private Double coordlatitude;
    private Double coordlongitude;

    private ArrayList<DailyInfoDomain> dailyInfoDomainList;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Double getCoordlatitude() {
        return coordlatitude;
    }

    public void setCoordlatitude(Double coordlatitude) {
        this.coordlatitude = coordlatitude;
    }

    public Double getCoordlongitude() {
        return coordlongitude;
    }

    public void setCoordlongitude(Double coordlongitude) {
        this.coordlongitude = coordlongitude;
    }

    public ArrayList<DailyInfoDomain> getDailyInfoDomainList() {
        return dailyInfoDomainList;
    }

    public void setDailyInfoDomainList(ArrayList<DailyInfoDomain> dailyInfoDomainList) {
        this.dailyInfoDomainList = dailyInfoDomainList;
    }
}
