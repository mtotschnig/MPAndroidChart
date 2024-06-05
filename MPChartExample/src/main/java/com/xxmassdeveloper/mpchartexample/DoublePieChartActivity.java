
package com.xxmassdeveloper.mpchartexample;

import static com.github.mikephil.charting.charts.PieRadarChartBase.ROTATION_INSIDE_ONLY;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.xxmassdeveloper.mpchartexample.notimportant.DemoBase;

import java.util.ArrayList;

@SuppressWarnings("SameParameterValue")
public class DoublePieChartActivity extends DemoBase {

    PieChart mChartOuter, mChartInner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_piechart_double);

        setTitle("DoublePieChartActivity");


        mChartOuter = findViewById(R.id.mChartOuter);
        mChartInner = findViewById(R.id.mChartInner);

        mChartOuter.getDescription().setEnabled(false);
        mChartInner.getDescription().setEnabled(false);


        mChartOuter.setCenterTextSize(10f);
        mChartInner.setCenterTextSize(10f);

        mChartOuter.setHoleRadius(75f);
        mChartInner.setHoleRadius(75f);

        mChartOuter.setTransparentCircleRadius(50f);
        mChartInner.setTransparentCircleRadius(50f);

        mChartOuter.getLegend().setEnabled(false);
        mChartInner.getLegend().setEnabled(false);

        mChartInner.setRotationEnabled(ROTATION_INSIDE_ONLY);

        setData();

    }

    private void setData() {

        ArrayList<PieEntry> entries = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            entries.add(new PieEntry((float) ((Math.random() * (float) 5) + (float) 5 / 5), i));
        }

        PieDataSet dataSet = getPieDataSet(entries);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        mChartOuter.setData(data);
        mChartInner.setData(data);

        mChartOuter.highlightValues(null);
        mChartInner.highlightValues(null);

        mChartOuter.invalidate();
        mChartInner.invalidate();
    }

    @NonNull
    private static PieDataSet getPieDataSet(ArrayList<PieEntry> entries) {
        PieDataSet dataSet = new PieDataSet(entries, "Election Results");

        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        return dataSet;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.only_github, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.viewGithub: {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/com/xxmassdeveloper/mpchartexample/HalfPieChartActivity.java"));
                startActivity(i);
                break;
            }
        }

        return true;
    }

    @Override
    public void saveToGallery() { /* Intentionally left empty */ }
}
