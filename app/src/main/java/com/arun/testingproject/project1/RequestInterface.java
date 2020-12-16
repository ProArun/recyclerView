package com.arun.testingproject.project1;

import com.arun.testingproject.project1.CarsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface RequestInterface {

    @GET("cars_list.json")
    public Call<List<CarsModel>> getCarsJson();

}
