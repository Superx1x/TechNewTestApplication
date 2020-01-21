package com.example.technewtestthreeapplication.view_pager_fragment;

import com.example.technewtestthreeapplication.news_object.DataDTO;

import java.util.ArrayList;

public interface ViewPagerFragmentPresenter {
    void onPrepareData(ArrayList<DataDTO> dataDTOArrayList);
    void onItemClickListener(DataDTO dataDTO);
}

