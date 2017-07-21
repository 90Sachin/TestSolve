package com.sachin.testsolve.manager;

import android.content.Context;

import com.sachin.testsolve.home.HomeResponse;
import com.sachin.testsolve.home.Movie;
import com.sachin.testsolve.interfaces.CommonResponse;
import com.sachin.testsolve.interfaces.HomeApi;
import com.sachin.testsolve.rest.ServiceGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Windows on 19-07-2017.
 */

public class HomeManager {
    private static final HomeManager ourInstance = new HomeManager();
    private CommonResponse commonResponse;
    private Context context;
    private List<Movie> movies =new ArrayList<>();


    public static HomeManager getInstance() {
        return ourInstance;
    }
        public void setCallBack(Context context,CommonResponse commonResponse){
            this.context =context;
            this.commonResponse=commonResponse;
        }

    private HomeManager() {
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void callHomeApi()
    {

        HomeApi homeApi= ServiceGenerator.createService(HomeApi.class);

        Call<HomeResponse> listAreaCall=homeApi.getHome();
        listAreaCall.enqueue(new Callback<HomeResponse>() {

            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                if(response.isSuccessful())
                {
                     setMovies(response.body().getVideoLists());
                    commonResponse.success("Succese","");
                }
                else
                {
                    commonResponse.error("Error","");
                }
            }

            @Override
            public void onFailure(Call<HomeResponse> call, Throwable t) {

                if (t instanceof IOException)
                {
                    commonResponse.error("No Internet Connection","");
                }

            }
        });


    }


}
