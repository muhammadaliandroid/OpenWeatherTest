package uk.co.mali.openweathertest.cityweatherforecast.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import uk.co.mali.domain.model.domainpojo.WeatherDomain;
import uk.co.mali.openweathertest.R;
import uk.co.mali.openweathertest.cityweatherforecast.adapter.CityWeatherForecastAdapter;
import uk.co.mali.openweathertest.cityweatherforecast.model.WeatherReport;
import uk.co.mali.openweathertest.cityweatherforecast.presenter.CityWeatherForecastPresenter;
import uk.co.mali.openweathertest.cityweatherforecast.view.ICityWeatherForecastView;
import uk.co.mali.openweathertest.detailcityweatherreport.activity.DetailWeatherReportActivity;

/**
 * Created by alig2 on 03/09/2017.
 */

public class CityWeatherForecastActivity extends AppCompatActivity implements ICityWeatherForecastView {

    private static final String TAG = CityWeatherForecastActivity.class.getSimpleName();

    @BindView(R.id.btn_Search)
    Button mBtnSearch;
    @BindView(R.id.et_Search)
    EditText mETSearch;
    @BindView(R.id.rv_ListWeatherForecast)
    RecyclerView recyclerView;
    private View view;

    CityWeatherForecastAdapter adapter;
    ICityWeatherForecastView iView = this;
    CityWeatherForecastPresenter presenter = new CityWeatherForecastPresenter(context(),iView);


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");

        setContentView(constructView());
        ButterKnife.bind(this);
        adapter = new CityWeatherForecastAdapter(context());
        recyclerView.setLayoutManager(new LinearLayoutManager(context()));
        presenter.OnCreate();

    }

    @OnClick(R.id.btn_Search)
    public void onClickSearch(View view)

    {
        Log.d(TAG,"onClickSearch");

        presenter.setCityTag(mETSearch.getText().toString());
        presenter.initialize();

    }

     public Context context() {
        return this;
    }


    @Override
    public Observable<Integer> itemClicks(){
            return adapter.observeClicks();
    }


    @Override
    public void getCityWeatherDomainForecast(WeatherDomain weatherDomain) {
        Log.d(TAG,"getCityWeatherDomainForecast() Weather Domain for City:"+weatherDomain.getCityName());
        adapter.swapAdapter(weatherDomain);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void startDetailDailyCityWeatherReportActivity(WeatherReport weatherReport) {
        Log.d(TAG,"startDetailDailyCityWeatherReportActivity() Weather Report for City:"+weatherReport.getCityName());
        Intent intent = new Intent(context(), DetailWeatherReportActivity.class);
        intent.putExtra("weatherreport", weatherReport);
        startActivity(intent);
    }


    public View inflateView() {
        Log.d(TAG,"inflateView");
        FrameLayout parent = new FrameLayout(this);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        this.view = LayoutInflater.from(context()).inflate(R.layout.activity_weather_forecast, parent, true);
        return view;
    }

    @Override
    public View constructView() {
        Log.d(TAG,"constructView");
        return inflateView();

    }

    @Override
    public View getView() {
        Log.d(TAG,"getView");
        return view;
    }


    @Override
    protected void onStop() {
        Log.d(TAG,"onStop");

        super.onStop();
        if (presenter != null) {
            presenter.onStop();
        }
    }

    @Override
    protected void onResume() {
        Log.d(TAG,"onResume");
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG,"onPause");

        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy");
        super.onDestroy();
        if (presenter != null) {
            presenter.onDestroy();
        }
    }


}
