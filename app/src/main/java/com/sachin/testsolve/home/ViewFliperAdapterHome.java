package com.sachin.testsolve.home;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.sachin.testsolve.R;
import com.sachin.testsolve.util.CommonMethod;

import java.util.List;


public class ViewFliperAdapterHome extends PagerAdapter {
    private Context context;
    private List<Movie> listBanner;
    private LayoutInflater inflater;

    public ViewFliperAdapterHome(Context context,List<Movie> listBanner) {
        this.context = context;
        this.listBanner = listBanner;
    }

    @Override
    public int getCount() {
        return listBanner.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        ImageView ivBannerImage;
        ImageView ivShadowImage;
        TextView textMovieName,textMovieInfo;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_adapter_home, container, false);
        ivBannerImage = (ImageView) itemView.findViewById(R.id.ivBannerImage);
        ivShadowImage = (ImageView) itemView.findViewById(R.id.ivShadowImage);
        textMovieName = (TextView) itemView.findViewById(R.id.textMovieName);
        textMovieInfo = (TextView) itemView.findViewById(R.id.textMovieInfo);
        final Movie banner=listBanner.get(position);
        CommonMethod.ShowImagePicasso(context,"https://image.tmdb.org/t/p/w640"+banner.getBackdropPath(),R.drawable.loading,ivBannerImage);
        textMovieName.setText(banner.getTitle());
        textMovieInfo.setText(banner.getOverview());
        ivShadowImage.setImageResource(R.drawable.view_pager_shadow);
        ((ViewPager) container).addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
    }

}
