package com.example.hafizhamza.timetable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ListView listView;

public void generate(ArrayList<String> arrayList)
{
    ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
    listView.setAdapter(adapter);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar=(SeekBar)findViewById(R.id.MyseekBar);
        seekBar.setProgress(10);
        seekBar.setMax(20);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int tableNo;
                if (i<min)
                {
                    tableNo=min;
                    seekBar.setProgress(min);

                }
                else
                {
                    tableNo=i;
                }
                listView=(ListView)findViewById(R.id.MylistView);
                ArrayList<String> arrayList=new ArrayList<String>();
                for(int j=1;j<=10;j++) {
                    arrayList.add(Integer.toString(j*tableNo));
                }
                generate(arrayList);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
