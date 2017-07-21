
package com.sachin.testsolve.home;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class HomeResponse {

    @SerializedName("page")
    private Long mPage;
    @SerializedName("results")
    private List<Movie> mMovies;
    @SerializedName("total_pages")
    private Long mTotalPages;
    @SerializedName("total_VideoLists")
    private Long mTotalVideoLists;

    public Long getPage() {
        return mPage;
    }

    public void setPage(Long page) {
        mPage = page;
    }

    public List<Movie> getVideoLists() {
        return mMovies;
    }

    public void setVideoLists(List<Movie> movies) {
        mMovies = movies;
    }

    public Long getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(Long totalPages) {
        mTotalPages = totalPages;
    }

    public Long getTotalVideoLists() {
        return mTotalVideoLists;
    }

    public void setTotalVideoLists(Long totalVideoLists) {
        mTotalVideoLists = totalVideoLists;
    }

}
