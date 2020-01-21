package com.example.technewtestthreeapplication;

import com.example.technewtestthreeapplication.news_object.RatherNews;

import java.util.ArrayList;

public interface MainActivityView {
    void showTabLayout(ArrayList<String> tabTitle);
    void showViewPager(RatherNews ratherNews);
}
