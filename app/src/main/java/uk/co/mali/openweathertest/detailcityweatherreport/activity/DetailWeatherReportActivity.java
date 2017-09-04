package uk.co.mali.openweathertest.detailcityweatherreport.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.mali.openweathertest.R;
import uk.co.mali.openweathertest.cityweatherforecast.model.WeatherReport;

public class DetailWeatherReportActivity extends AppCompatActivity {

    @BindView(R.id.tv__DetailDate)
    TextView mDetailTvDate;
    @BindView(R.id.tv__DetailCity)
    TextView mDetailTvCity;
    @BindView(R.id.tv__DetailCountry)
    TextView mDetailTvCountry;
    @BindView(R.id.tv__DetailTemperature)
    TextView mDetailTvTemperature;
    @BindView(R.id.tv__DetailTemperatureMax)
    TextView mDetailTvTemperatureMax;
    @BindView(R.id.tv__DetailTemperatureMin)
    TextView mDetailTvTemperatureMin;

    @BindView(R.id.tv__DetailGroundLevel)
    TextView mDetailTvGroundSlevel;
    @BindView(R.id.tv__DetailSeaLevel)
    TextView mDetailTvSeaSlevel;
    @BindView(R.id.tv__DetailWindSpeed)
    TextView mDetailTvWindSpeed;
    @BindView(R.id.tv__DetailCoordLat)
    TextView mDetailTvCoordLat;
    @BindView(R.id.tv__DetailCoordLong)
    TextView mDetailTvCoordLong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_weather_report);

        ButterKnife.bind(this);
        WeatherReport report = (WeatherReport) getIntent().getExtras().get("weatherreport");

        setup(report);
    }


    public void setup(WeatherReport report) {
        mDetailTvDate.setText("Date: " + report.getDate());
        mDetailTvCity.setText("City: " + report.getCityName());
        mDetailTvCountry.setText("Country: " + report.getCountryName());
        mDetailTvTemperature.setText("Temperature: " + report.getMainTemp() + " C");
        mDetailTvTemperatureMax.setText("Max Temperature: " + report.getMainTempMax() + " C");
        mDetailTvTemperatureMin.setText("Min Temperature: " + report.getMainTempMin() + " C");
        mDetailTvGroundSlevel.setText("Ground Level: " + report.getMainGrndLevel());
        mDetailTvSeaSlevel.setText("Sea Level: " + report.getMainSeaLevel());
        mDetailTvWindSpeed.setText("Wind Speed: " + report.getWindSpeed());
        mDetailTvCoordLat.setText("Latitude: " + report.getCoordlatitude());
        mDetailTvCoordLong.setText("Longitude:" + report.getCoordlongitude());

    }
}
