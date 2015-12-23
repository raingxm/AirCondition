package com.example.xuzhang.aircondition;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.xuzhang.aircondition.domain.PM25;
import com.example.xuzhang.aircondition.service.AirServiceClient;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";

    private EditText cityEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        cityEditText = (EditText) findViewById(R.id.edit_message);

        findViewById(R.id.query_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryPM25Data();
            }
        });
    }

    private void queryPM25Data() {
        final String cityName = cityEditText.getText().toString();

        if(!TextUtils.isEmpty(cityName)) {
            AirServiceClient.getInstance().queryAirConditionData(new Callback<List<PM25>>() {
                @Override
                public void onResponse(Response<List<PM25>> response, Retrofit retrofit) {
                    Log.i(TAG, "i am comming");
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.i(TAG, "i am lost");
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
