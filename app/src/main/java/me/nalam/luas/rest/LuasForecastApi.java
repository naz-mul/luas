package me.nalam.luas.rest;

import androidx.lifecycle.LiveData;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LuasForecastApi {

  @GET("get.ashx?action=forecast&encrypt=false")
  LiveData<ApiResponse<ForecastResponse>> getLuasForecasts(@Query("stop") String stop);
}
