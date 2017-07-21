package com.sachin.testsolve.interfaces;

import com.sachin.testsolve.home.HomeResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Windows on 19-07-2017.
 */

public interface HomeApi {
/*http://api.themoviedb.org/3/discover/movie? sort_by=popularity.desc?&api_key=ccdecee52ed399fea8315ab40bc781c1*/
    @GET("movie? sort_by=popularity.desc?&api_key=ccdecee52ed399fea8315ab40bc781c1")
    Call<HomeResponse> getHome();
}
