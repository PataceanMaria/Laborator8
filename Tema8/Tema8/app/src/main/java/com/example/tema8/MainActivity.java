package com.example.tema8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kotlin.collections.UArraySortingKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView  data;
    String jsonURL = "https://www.floatrates.com/daily/ron.json";
    double rate;
    EditText number;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = findViewById(R.id.textView3);
        number = findViewById(R.id.sum);
    }

    public void USD(View view){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(jsonURL)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                Toast.makeText(MainActivity.this, "Something went Wrong :(", Toast.LENGTH_LONG).show();
                Log.i(TAG, "onFailure: ");
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String recData = response.body().string();
                JSONObject emp= null;
                try {
                    emp = (new JSONObject(recData)).getJSONObject("usd");
                    Log.i(TAG, "json: "+emp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    rate=emp.getDouble("inverseRate");
                    Log.i(TAG, "rate: "+rate);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                double result = Double.parseDouble(String.valueOf(number.getText()))*rate;
                Log.i(TAG, "result: " +result);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        data.setText(String.valueOf(result));
                    }
                });
            }
        });
    }

    public void EUR(View view){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(jsonURL)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                Toast.makeText(MainActivity.this, "Something went Wrong :(", Toast.LENGTH_LONG).show();
                Log.i(TAG, "onFailure: ");
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String recData = response.body().string();
                JSONObject emp= null;
                try {
                    emp = (new JSONObject(recData)).getJSONObject("eur");
                    Log.i(TAG, "json: "+emp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    rate=emp.getDouble("inverseRate");
                    Log.i(TAG, "rate: "+rate);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                double result = Double.parseDouble(String.valueOf(number.getText()))*rate;
                Log.i(TAG, "result: " +result);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        data.setText(String.valueOf(result));
                    }
                });
            }
        });
    }

    public void GBP(View view){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(jsonURL)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                Toast.makeText(MainActivity.this, "Something went Wrong :(", Toast.LENGTH_LONG).show();
                Log.i(TAG, "onFailure: ");
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String recData = response.body().string();
                JSONObject emp= null;
                try {
                    emp = (new JSONObject(recData)).getJSONObject("gbp");
                    Log.i(TAG, "json: "+emp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    rate=emp.getDouble("inverseRate");
                    Log.i(TAG, "rate: "+rate);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                double result = Double.parseDouble(String.valueOf(number.getText()))*rate;
                Log.i(TAG, "result: " +result);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        data.setText(String.valueOf(result));
                    }
                });
            }
        });
    }

    public void MDL(View view){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(jsonURL)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.i(TAG, "onFailure: ");
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String recData = response.body().string();
                JSONObject emp= null;
                try {
                    emp = (new JSONObject(recData)).getJSONObject("mdl");
                    Log.i(TAG, "json: "+emp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    rate=emp.getDouble("inverseRate");
                    Log.i(TAG, "rate: "+rate);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                double result = Double.parseDouble(String.valueOf(number.getText()))*rate;
                Log.i(TAG, "result: " +result);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        data.setText(String.valueOf(result));
                    }
                });
            }
        });
    }
}