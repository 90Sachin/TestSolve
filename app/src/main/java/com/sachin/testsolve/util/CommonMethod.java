package com.sachin.testsolve.util;

import android.content.Context;
import android.widget.ImageView;

import com.sachin.testsolve.rest.ServiceGenerator;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Windows on 19-07-2017.
 */

public class CommonMethod {
    public static void ShowImagePicasso(Context context, String imageURL, int defaultImage, ImageView imageView) {
        try {
            if ("".equals(imageURL) || "image.jpeg".equals(imageURL)) {
                imageView.setImageResource(defaultImage);
            } else {
                Picasso.with(context).load( imageURL).placeholder(defaultImage).into(imageView);
            }
        } catch (Exception err) {
            throw new RuntimeException(err);
        }

    }

    public static Date convertDate(String strDate){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date=simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();

        }
        return date;

    }
}
