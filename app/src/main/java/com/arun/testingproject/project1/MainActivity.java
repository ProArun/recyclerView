package com.arun.testingproject.project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.arun.testingproject.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "Arun";
    ArrayList<CarsModel> carsModels = new ArrayList<>();
    private CarsAdapter carsAdapter;
    private RecyclerView cars_recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cars_recyclerview = (RecyclerView)findViewById(R.id.cars_recycelview);
        cars_recyclerview.setLayoutManager(new LinearLayoutManager(this));

        getCarsResponse();

    }

    private void getCarsResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://navneet7k.github.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<List<CarsModel>> call = requestInterface.getCarsJson();

        call.enqueue(new Callback<List<CarsModel>>() {
            @Override
            public void onResponse(Call<List<CarsModel>> call, Response<List<CarsModel>> response) {
                carsModels = new ArrayList<>(response.body());

                carsAdapter = new CarsAdapter(MainActivity.this,carsModels);

                cars_recyclerview.setAdapter(carsAdapter);
               // cars_recyclerview.setLayoutManager(LinearLayoutManager);

                Toast.makeText(MainActivity.this, "sucess", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse: sucess");
            }

            @Override
            public void onFailure(Call<List<CarsModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                Log.d(TAG, "onFailure:failure ");
            }

        });

    }

}