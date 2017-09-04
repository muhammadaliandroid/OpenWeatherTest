package uk.co.mali.openweathertest.cityweatherforecast.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;
import uk.co.mali.openweathertest.R;
import uk.co.mali.openweathertest.cityweatherforecast.model.WeatherReport;

/**
 * Created by alig2 on 03/09/2017.
 */

public class WeatherListViewHolder extends RecyclerView.ViewHolder  {

    @BindView(R.id.tv_Date)
    TextView mTvDate;
    @BindView(R.id.tv_City)
    TextView mTvCity;
    @BindView(R.id.tv_Country)
    TextView mTvCountry;
    @BindView(R.id.tv_Temperature)
    TextView mTvTemperature;
    @BindView(R.id.tv_TemperatureMax)
    TextView mTvTemperatureMax;
    @BindView(R.id.tv_TemperatureMin)
    TextView mTvTemperatureMin;

    @BindView(R.id.tv_GroundLevel)
    TextView mTvGroundSlevel;
    @BindView(R.id.tv_SeaLevel)
    TextView mTvSeaSlevel;
    @BindView(R.id.tv_WindSpeed)
    TextView mTvWindSpeed;
    @BindView(R.id.tv_CoordLat)
    TextView mTvCoordLat;
    @BindView(R.id.tv_CoordLong)
    TextView mTvCoordLong;



    public WeatherListViewHolder(View view,  PublishSubject<Integer> clickSubject) {
        super(view);
        ButterKnife.bind(this,view);
        view.setOnClickListener(v -> clickSubject.onNext(getAdapterPosition())
        );
    }

    public void bind(WeatherReport report) {

        mTvDate.setText("Date: "+report.getDate());
        mTvCity.setText("City: "+report.getCityName());
        mTvCountry.setText("Country: "+report.getCountryName());
        mTvTemperature.setText("Temperature: "+report.getMainTemp()+" C");
        mTvTemperatureMax.setText("Max Temperature: "+report.getMainTempMax()+" C");
        mTvTemperatureMin.setText("Min Temperature: "+report.getMainTempMin()+" C");
        mTvGroundSlevel.setText("Ground Level: "+report.getMainGrndLevel());
        mTvSeaSlevel.setText("Sea Level: "+report.getMainSeaLevel());
        mTvWindSpeed.setText("Wind Speed: "+report.getWindSpeed());
        mTvCoordLat.setText("Latitude: "+ report.getCoordlatitude());
        mTvCoordLong.setText("Longitude:"+ report.getCoordlongitude());

    }
}
