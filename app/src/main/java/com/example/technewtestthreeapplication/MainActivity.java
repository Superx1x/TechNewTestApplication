package com.example.technewtestthreeapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.technewtestthreeapplication.news_object.RatherNews;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private FragmentManager fragmentManager;
    private MainActivityPresenter mainActivityPresenter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        initMainActivityPresenter();
        initView();
        initToolBar();
        mainActivityPresenter.onPrepareData();
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void initMainActivityPresenter() {
        mainActivityPresenter = new MainActivityPresenterImpl(this);
    }

    private void initView() {
        tabLayout = findViewById(R.id.tab_Layout);
        viewPager = findViewById(R.id.view_Pager);
    }

    private void initToolBar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    @Override
    public void showTabLayout(ArrayList<String> tabTitle) {
        for(String tabtitleFromMAPImpl : tabTitle){
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setCustomView(prepareTabView(tabtitleFromMAPImpl));
            tab.setTag(tabtitleFromMAPImpl);
            tabLayout.addTab(tab);
        }
        mainActivityPresenter.onPrepareViewPagerData();
    }

    @Override
    public void showViewPager(RatherNews ratherNews) {
        viewPagerAdapter = new ViewPagerAdapter(fragmentManager);
        viewPagerAdapter.setData(ratherNews);
        viewPager.setAdapter(viewPagerAdapter);
    }

    private View prepareTabView(String tabtitleFromMAPImpl) {
        View view = View.inflate(this,R.layout.custom_view,null);
        TextView tabTitle = view.findViewById(R.id.text_tabTitle);
        tabTitle.setText(tabtitleFromMAPImpl);
        return view;
    }
}
