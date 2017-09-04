package uk.co.mali.openweathertest.cityweatherforecast.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alig2 on 03/09/2017.
 */

public class WeatherReport implements Parcelable {

    private String cityName;
    private String countryName;
    private Double coordlatitude;
    private Double coordlongitude;
    private String date;
    private Double mainTemp;
    private Double mainTempMin;
    private Double mainTempMax;
    private Double mainPressure;
    private Double mainSeaLevel;
    private Double mainGrndLevel;
    private Double mainHumidity;
    private Double windSpeed;


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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getMainTemp() {
        return mainTemp;
    }

    public void setMainTemp(Double mainTemp) {
        this.mainTemp = mainTemp;
    }

    public Double getMainTempMin() {
        return mainTempMin;
    }

    public void setMainTempMin(Double mainTempMin) {
        this.mainTempMin = mainTempMin;
    }

    public Double getMainTempMax() {
        return mainTempMax;
    }

    public void setMainTempMax(Double mainTempMax) {
        this.mainTempMax = mainTempMax;
    }

    public Double getMainPressure() {
        return mainPressure;
    }

    public void setMainPressure(Double mainPressure) {
        this.mainPressure = mainPressure;
    }

    public Double getMainSeaLevel() {
        return mainSeaLevel;
    }

    public void setMainSeaLevel(Double mainSeaLevel) {
        this.mainSeaLevel = mainSeaLevel;
    }

    public Double getMainGrndLevel() {
        return mainGrndLevel;
    }

    public void setMainGrndLevel(Double mainGrndLevel) {
        this.mainGrndLevel = mainGrndLevel;
    }

    public Double getMainHumidity() {
        return mainHumidity;
    }

    public void setMainHumidity(Double mainHumidity) {
        this.mainHumidity = mainHumidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.cityName);
        dest.writeString(this.countryName);
        dest.writeValue(this.coordlatitude);
        dest.writeValue(this.coordlongitude);
        dest.writeString(this.date);
        dest.writeValue(this.mainTemp);
        dest.writeValue(this.mainTempMin);
        dest.writeValue(this.mainTempMax);
        dest.writeValue(this.mainPressure);
        dest.writeValue(this.mainSeaLevel);
        dest.writeValue(this.mainGrndLevel);
        dest.writeValue(this.mainHumidity);
        dest.writeValue(this.windSpeed);
    }

    public WeatherReport() {
    }

    protected WeatherReport(Parcel in) {
        this.cityName = in.readString();
        this.countryName = in.readString();
        this.coordlatitude = (Double) in.readValue(Double.class.getClassLoader());
        this.coordlongitude = (Double) in.readValue(Double.class.getClassLoader());
        this.date = in.readString();
        this.mainTemp = (Double) in.readValue(Double.class.getClassLoader());
        this.mainTempMin = (Double) in.readValue(Double.class.getClassLoader());
        this.mainTempMax = (Double) in.readValue(Double.class.getClassLoader());
        this.mainPressure = (Double) in.readValue(Double.class.getClassLoader());
        this.mainSeaLevel = (Double) in.readValue(Double.class.getClassLoader());
        this.mainGrndLevel = (Double) in.readValue(Double.class.getClassLoader());
        this.mainHumidity = (Double) in.readValue(Integer.class.getClassLoader());
        this.windSpeed = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<WeatherReport> CREATOR = new Parcelable.Creator<WeatherReport>() {
        @Override
        public WeatherReport createFromParcel(Parcel source) {
            return new WeatherReport(source);
        }

        @Override
        public WeatherReport[] newArray(int size) {
            return new WeatherReport[size];
        }
    };
}
