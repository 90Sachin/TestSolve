package com.sachin.testsolve.home;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.sachin.testsolve.R;
import com.sachin.testsolve.image.ImageFragment;
import com.sachin.testsolve.interfaces.CommonResponse;
import com.sachin.testsolve.manager.AppSingleton;
import com.sachin.testsolve.manager.HomeManager;
import com.sachin.testsolve.milestone.MilestoneFragment;
import com.sachin.testsolve.movie.MovieFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.relex.circleindicator.CircleIndicator;


public class HomeFragment extends Fragment implements CommonResponse {
    @BindView(R.id.viewPageLikeFlipper)
    ViewPager viewPageLikeFlipper;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewPagerHome)
    ViewPager viewPagerHome;
    Unbinder unbinder;
    @BindView(R.id.indicator)
    CircleIndicator indicator;
    private Context context;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        tabLayout.setupWithViewPager(viewPagerHome);
        setupViewPager();
        setupTabIcons();
        HomeManager.getInstance().setCallBack(context,this);
        HomeManager.getInstance().callHomeApi();

        return view;
    }

    private void setupViewFlipper() {
        List<Movie> movies =HomeManager.getInstance().getMovies();
        if(movies.size()>5){
               while(movies.size()!=5){
                   movies.remove(5);
             }
        }

        viewPageLikeFlipper.setAdapter(new ViewFliperAdapterHome(context, movies));
        indicator.setViewPager(viewPageLikeFlipper);

    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFrag(new MovieFragment(), getString(R.string.video));
        adapter.addFrag(new ImageFragment(), getString(R.string.image));
        adapter.addFrag(new MilestoneFragment(), getString(R.string.milestone));
        viewPagerHome.setAdapter(adapter);
    }

    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        tabOne.setText(R.string.video);
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_video_icon, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        tabTwo.setText(R.string.image);
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_image_icon, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        tabThree.setText(R.string.milestone);
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_milestone_icon, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(String status, String tag) {
        setupViewFlipper();
        if(AppSingleton.getInstance().getVideoInterface()!=null) {
            AppSingleton.getInstance().getVideoInterface().getData();
        }
        if(AppSingleton.getInstance().getImageInterface()!=null) {
            AppSingleton.getInstance().getImageInterface().getData();
        }
        if(AppSingleton.getInstance().getMilestoneInterface()!=null) {
            AppSingleton.getInstance().getMilestoneInterface().getData();
        }


    }

    @Override
    public void error(String msg, String tag) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
