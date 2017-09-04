package uk.co.mali.domain.model.domainpojo;

/**
 * Created by alig2 on 03/09/2017.
 */

public class DailyInfoDomain {

    String date;
    private Double mainTemp;
    private Double mainTempMin;
    private Double mainTempMax;
    private Double mainPressure;
    private Double mainSeaLevel;
    private Double mainGrndLevel;
    private Double mainHumidity;
    private Double windSpeed;


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


}
