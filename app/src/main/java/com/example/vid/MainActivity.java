package com.example.vid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.MediaActionSound;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity{
    ListView listView;
    TextView textView;
    SeekBar seekBar;
    ArrayList<Integer> arrayList, basicList;
    ArrayAdapter<Integer> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView);

        arrayList = new ArrayList<>(asList(1,2,3,4,5,6,7,8,9));
        basicList = new ArrayList<>(asList(1,2,3,4,5,6,7,8,9));

        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);



        textView.setText(Integer.toString(seekBar.getProgress()));

        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText(Integer.toString(i));
                // set ArrayList values
                for (int s=0; s < arrayList.size() ; s++ ) {
                    arrayList.set(s, i * basicList.get(s));
                    listView.setAdapter(arrayAdapter);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }}