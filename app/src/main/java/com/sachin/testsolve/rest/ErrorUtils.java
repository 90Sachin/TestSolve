package com.sachin.testsolve.rest;

import android.util.Log;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;


/*Us for retrofit*/
public class ErrorUtils
{
    private ErrorUtils(){

    }
    public static APIError parseError(Response<?> response) {
        Converter<ResponseBody, APIError> converter =
                ServiceGenerator.getRetrofit()
                        .responseBodyConverter(APIError.class, new Annotation[0]);

        APIError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            Log.e("ErrorUtils",e.toString());
            return new APIError();
        }

        return error;
    }
}
