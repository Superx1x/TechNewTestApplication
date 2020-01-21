package com.example.technewtestthreeapplication;

import com.example.technewtestthreeapplication.news_object.RatherNews;

import java.util.ArrayList;

public class MainActivityPresenterImpl implements MainActivityPresenter {
    MainActivityView mainActivityView;

    public MainActivityPresenterImpl(MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
    }

    @Override
    public void onPrepareData() {
        ArrayList<String> tabTitle = new ArrayList<>();
        tabTitle.add("最新動態");
        tabTitle.add("3C新報");
        tabTitle.add("財經新報");
        tabTitle.add("編輯精選");
        tabTitle.add("行動裝置");
        tabTitle.add("其他項目");
        mainActivityView.showTabLayout(tabTitle);
    }

    @Override
    public void onPrepareViewPagerData() {
        RatherNews ratherNews = new RatherNews();
        mainActivityView.showViewPager(ratherNews);
    }
}
