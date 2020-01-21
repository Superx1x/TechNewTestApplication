package com.example.technewtestthreeapplication.view_pager_fragment;

import com.example.technewtestthreeapplication.news_object.DataDTO;

import java.util.ArrayList;

public class ViewPagerFragmentPresenterImpl implements ViewPagerFragmentPresenter {
    private ViewPagerFragmentView viewPagerFragmentView;

    public ViewPagerFragmentPresenterImpl(ViewPagerFragmentView viewPagerFragmentView) {
        this.viewPagerFragmentView = viewPagerFragmentView;
    }

    @Override
    public void onPrepareData(ArrayList<DataDTO> dataDTOArrayList) {
        viewPagerFragmentView.showRecycleView(dataDTOArrayList);
    }

    @Override
    public void onItemClickListener(DataDTO dataDTO) {
        viewPagerFragmentView.intentToDetailActivity(dataDTO);
    }
}
