package uk.co.mali.openweathertest.cityweatherforecast.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import uk.co.mali.domain.model.domainpojo.DailyInfoDomain;
import uk.co.mali.domain.model.domainpojo.WeatherDomain;
import uk.co.mali.openweathertest.R;
import uk.co.mali.openweathertest.cityweatherforecast.model.WeatherReport;
import uk.co.mali.openweathertest.cityweatherforecast.viewholder.WeatherListViewHolder;
import uk.co.mali.openweathertest.utils.mapper.MapWeatherDomainToWeatherReport;

/**
 * Created by alig2 on 03/09/2017.
 */

public class CityWeatherForecastAdapter extends RecyclerView.Adapter<WeatherListViewHolder> {

    public final static String TAG = CityWeatherForecastAdapter.class.getSimpleName();

    private WeatherDomain weatherDomain;
    private ArrayList<DailyInfoDomain> list = new ArrayList<>();
    private Context context;
    PublishSubject<Integer> itemClicks = PublishSubject.create();


    public CityWeatherForecastAdapter(Context context){
        this.context = context;
    }


    public void swapAdapter(WeatherDomain weatherDomain) {
        this.weatherDomain = weatherDomain;
        this.list.clear();
        this.list.addAll(weatherDomain.getDailyInfoDomainList());
        notifyDataSetChanged();
        if (list== null) {

        }
    }

    public Observable<Integer> observeClicks() {
        return itemClicks;
    }


    @Override
    public WeatherListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "OnCreateViewHolder called: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new WeatherListViewHolder(view,itemClicks);
    }

    @Override
    public void onBindViewHolder(WeatherListViewHolder holder, int position) {
        Log.d(TAG, "OnCreateViewHolder called: ");

        WeatherReport report = MapWeatherDomainToWeatherReport.mapWeatherDomainToWeatherReport(weatherDomain,position);
//        report.setCityName(weatherDomain.getCityName());
//        report.setCountryName(weatherDomain.getCountryName());
//        report.setCoordlatitude(weatherDomain.getCoordlatitude());
//        report.setCoordlongitude(weatherDomain.getCoordlongitude());
//        report.setDate(list.get(position).getDate());
//        report.setMainGrndLevel(list.get(position).getMainGrndLevel());
//        report.setMainHumidity(list.get(position).getMainHumidity());
//        report.setMainPressure(list.get(position).getMainPressure());
//        report.setMainTemp(list.get(position).getMainTemp());
//        report.setMainTempMax(list.get(position).getMainTempMax());
//        report.setMainTempMin(list.get(position).getMainTempMin());
//        report.setWindSpeed(list.get(position).getWindSpeed());

        holder.bind(report);
//
//        holder.setOnListItemClicked(new OnListItemClicked() {
//            @Override
//            public void onListItemClicked(View view, int position) {
//                ((FlickrListActivity) context).startFlickrImageActivity(itemEntity);
//            }
//
//        });


    }

    @Override
    public int getItemCount() {
        if (list != null && list.size() > 0) {
            return list.size();
        } else {
            return 0;
        }
    }

}
