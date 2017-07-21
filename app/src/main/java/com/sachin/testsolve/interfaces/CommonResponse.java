package com.sachin.testsolve.interfaces;

/**
 * Created by Windows on 19-07-2017.
 */

public interface CommonResponse {
    void success(String status,String tag);
    void error(String msg,String tag);

}
