package com.sachin.testsolve.milestone;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sachin.testsolve.home.HomeRecyclerViewAdapter;
import com.sachin.testsolve.R;
import com.sachin.testsolve.home.Movie;
import com.sachin.testsolve.interfaces.MilestoneInterface;
import com.sachin.testsolve.manager.AppSingleton;
import com.sachin.testsolve.manager.HomeManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MilestoneFragment extends Fragment implements HomeRecyclerViewAdapter.OnItemClickListener,MilestoneInterface {

    @BindView(R.id.recyclerViewHome)
    RecyclerView recyclerViewHome;
    Unbinder unbinder;
    private Context context;
    private HomeRecyclerViewAdapter homeRecyclerViewAdapter;
    private List<Movie> dataModels=new ArrayList<>();


    public MilestoneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        AppSingleton.getInstance().setMilestoneInterface(this);
        setAdapter();
        return view;
    }

    private void setAdapter() {
        dataModels= HomeManager.getInstance().getMovies();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        homeRecyclerViewAdapter=new HomeRecyclerViewAdapter(context,dataModels,this);
        recyclerViewHome.setAdapter(homeRecyclerViewAdapter);
        recyclerViewHome.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
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
    public void onItemClick(int position) {

    }

    @Override
    public void getData() {
        setAdapter();
    }
}
