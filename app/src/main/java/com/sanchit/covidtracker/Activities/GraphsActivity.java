package com.sanchit.covidtracker.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.sanchit.covidtracker.Adapters.DateWiseAdapter;
import com.sanchit.covidtracker.Network.SoleInstance;
import com.sanchit.covidtracker.R;
import com.sanchit.covidtracker.databinding.ActivityGraphsBinding;
import com.sanchit.covidtracker.response.AllData.CasesTimeSeries;
import com.sanchit.covidtracker.response.AllData.DataResponse;
import com.sanchit.covidtracker.response.AllData.Statewise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GraphsActivity extends AppCompatActivity {

    private ActivityGraphsBinding binding;
    private Context context;

    private List<CasesTimeSeries> dateList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_graphs);
        context = this;
        binding.rvDatesList.setLayoutManager(new LinearLayoutManager(this));

        if(getIntent().hasExtra("list"))
        {
            dateList = getIntent().getParcelableArrayListExtra("list");
        }


        DateWiseAdapter dateWiseAdapter = new DateWiseAdapter(dateList, context);
        binding.rvDatesList.setAdapter(dateWiseAdapter);
        binding.rvDatesList.setItemViewCacheSize(dateList.size());

        fetchAllData();



/*

        LineGraphSeries<DataPoint> series;
        series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        binding.lineChart.setCursorMode(true);
        binding.lineChart.setTitle("Dates");
        binding.lineChart.addSeries(series);
*/



/*

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(44f,0));
        barEntries.add(new BarEntry(24f,1));
        barEntries.add(new BarEntry(55f,2));
        barEntries.add(new BarEntry(39f,3));
        barEntries.add(new BarEntry(88f,4));
        barEntries.add(new BarEntry(11f,5));
        barEntries.add(new BarEntry(67f,6));

        BarDataSet dataSet = new BarDataSet(barEntries,"Dates");




        ArrayList<String> theaDates = new ArrayList<>();
        theaDates.add("Jan");
        theaDates.add("Feb");
        theaDates.add("Mar");
        theaDates.add("Apr");
        theaDates.add("May");
        theaDates.add("Jun");
        theaDates.add("Jul");


        BarData theData = new BarData(theaDates,dataSet);
        binding.brChart.setData(theData);
        binding.brChart.setTouchEnabled(true);
        binding.brChart.setDragEnabled(true);
        binding.brChart.setScaleEnabled(true);





        ArrayList<Entry> lineEntries = new ArrayList<>();

        lineEntries.add(new Entry(33f,0));
        lineEntries.add(new Entry(66f,1));
        lineEntries.add(new Entry(76f,2));
        lineEntries.add(new Entry(26f,3));
        lineEntries.add(new Entry(94f,4));


        LineDataSet dataSet1 = new LineDataSet(lineEntries,"Dates");

        LineData lineData = new LineData(theaDates,dataSet1);
        binding.lineChart.setData(lineData);
        binding.lineChart.setTouchEnabled(true);
        binding.lineChart.setDragEnabled(true);
        binding.lineChart.setScaleEnabled(true);
*/


    }

    private void fetchAllData() {
        Call<DataResponse> call = SoleInstance.getApiServiceInstance().getAllData();

        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {

                List<CasesTimeSeries> graphlist;
             //   List<CasesTimeSeries> dateList;
                if (response != null) {
                    if (response.body() != null) {


                    //    statewiseList = response.body().getStatewise();
                      /*  dateList = response.body().getCasesTimeSeries();
                        DateWiseAdapter dateWiseAdapter = new DateWiseAdapter(dateList, context);
                        binding.rvDatesList.setAdapter(dateWiseAdapter);
                        binding.rvDatesList.setItemViewCacheSize(dateList.size());*/


                        graphlist = response.body().getCasesTimeSeries();



                        for(int i=0; i<graphlist.size();i++)
                        {

                                if(graphlist.size()!=7)
                                {
                                    graphlist.remove(i);
                                    i--;
                                }

                        }
                     //   statewiseList.remove(0);



                        prepareList(graphlist);


                    } else {
                        Toast.makeText(GraphsActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(GraphsActivity.this, "No response", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void prepareList(List<CasesTimeSeries> dateList) {
        List<String> dates = new ArrayList<>();
        List<Float> dateValues = new ArrayList<>();



        for(int i= 0; i<dateList.size(); i++)
        {
            dates.add(dateList.get(i).getDate());
            dateValues.add(Float.parseFloat(dateList.get(i).getDailyconfirmed()));
        }


  /*      for(int i = 0; i<statewiseList.size(); i++)
        {
            states.add(statewiseList.get(i).getState());
            stateValues.add(Float.parseFloat(statewiseList.get(i).getConfirmed()));
        }*/

        setDataToGraph(dates,dateValues);
     //   setDataToPie();

    }

    /*private void setDataToPie() {




        ArrayList<BarEntry> barEntries = new ArrayList<>();


        ArrayList<Entry> pieEntries = new ArrayList<>();

        for(int i = 0; i<stateValues.size(); i++)
        {
            pieEntries.add(new Entry(stateValues.get(i),i));
            barEntries.add(new BarEntry(stateValues.get(i),i));
        }

        BarDataSet dataSet = new BarDataSet(barEntries,"States");

        BarData barData = new BarData(states,dataSet);
        binding.brChart.setData(barData);
        binding.brChart.setMinimumWidth(10);
        binding.brChart.setTouchEnabled(true);
        binding.brChart.setDragEnabled(true);
        binding.brChart.setScaleEnabled(true);
        binding.brChart.animateX(1000);



        PieDataSet set = new PieDataSet(pieEntries, "States" );

        PieData pieData = new PieData(states,set);
        binding.pieChart.setData(pieData);
        binding.pieChart.setTouchEnabled(true);
        binding.pieChart.animateX(1000);

    }*/

    private void setDataToGraph(List<String> dates, List<Float> dateValues) {

        ArrayList<BarEntry> barEntries = new ArrayList<>();
   //     ArrayList<Entry> lineEntry = new ArrayList<>();


        for(int i = 0; i<dateValues.size(); i++)
        {
            if(dateValues.get(i)!=0.0)
            {
                barEntries.add(new BarEntry(dateValues.get(i),i));
                //     lineEntry.add(new Entry(dateValues.get(i),i));
            }

        }

      /*  ArrayList<Entry> lineEntries = new ArrayList<>();

        lineEntries.add(new Entry(33f,0));
        lineEntries.add(new Entry(66f,1));
        lineEntries.add(new Entry(76f,2));
        lineEntries.add(new Entry(26f,3));
        lineEntries.add(new Entry(94f,4));*/






        BarDataSet dataSet1 = new BarDataSet(barEntries,"Dates");
     //   LineDataSet dataSet2 = new LineDataSet(lineEntry,"Dates");

        BarData barData = new BarData(dates,dataSet1);
     //   LineData lineData = new LineData(dates,dataSet2);

        binding.barGraph.setVisibleXRangeMaximum(10);
        binding.barGraph.moveViewToX(30);
        binding.barGraph.setData(barData);
        binding.barGraph.invalidate();
        binding.barGraph.setMinimumWidth(5000);
        binding.barGraph.setTouchEnabled(true);
        binding.barGraph.setDragEnabled(true);
        binding.barGraph.requestFocus();
        binding.barGraph.animateX(1000);
        binding.barGraph.setDescription("");

      /*  binding.lineGraph.setVisibleXRangeMaximum(10);
        binding.lineGraph.moveViewToX(30);
        binding.lineGraph.setData(lineData);
        binding.lineGraph.invalidate();
        binding.lineGraph.setMinimumWidth(5000);
        binding.lineGraph.setTouchEnabled(true);
        binding.lineGraph.setDragEnabled(true);
        binding.lineGraph.requestFocus();
        binding.lineGraph.animateX(1000);
        binding.lineGraph.setDescription("");*/

/*

        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();
        lineDataSets.add(dataSet1);
*/
/*
        ViewPortHandler viewPortHandler = binding.lineChart.getViewPortHandler();
        float scaleX = viewPortHandler.getScaleX();
        float scaleY = viewPortHandler.getScaleY();
        LineData lineData = new LineData(dates,dataSet1);
        binding.lineChart.setVisibleXRangeMaximum(10);
        binding.lineChart.moveViewToX(30);
        binding.lineChart.invalidate();
        binding.lineChart.setData(lineData);
        binding.lineChart.setMinimumWidth(5000);
        binding.lineChart.setTouchEnabled(true);
        binding.lineChart.setDragEnabled(true);
        binding.lineChart.requestFocus();
        binding.lineChart.animateX(1000);*/

    }


}
