package com.example.technewtestthreeapplication.view_pager_fragment;

import com.example.technewtestthreeapplication.news_object.DataDTO;

import java.util.ArrayList;

public interface ViewPagerFragmentView {
    void showRecycleView(ArrayList<DataDTO> dataDTOArrayList);
    void intentToDetailActivity(DataDTO dataDTO);
}
