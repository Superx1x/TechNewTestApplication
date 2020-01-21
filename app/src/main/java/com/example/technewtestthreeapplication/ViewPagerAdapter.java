package com.example.technewtestthreeapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.technewtestthreeapplication.news_object.DataDTO;
import com.example.technewtestthreeapplication.news_object.RatherNews;
import com.example.technewtestthreeapplication.view_pager_fragment.ViewPagerFragment;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private RatherNews ratherNews;

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    //position 使你的切畫面的位置 並且切換到Fragment 也傳值給它
    @NonNull
    @Override
    public Fragment getItem(int position) {
        ArrayList<DataDTO> dataDTOArrayList;
        if(position == 0){
            dataDTOArrayList = new ArrayList<>();
            for(int i=0 ; i<4 ; i++){
                DataDTO dataDTO = new DataDTO();
                dataDTO.setTitle(ratherNews.getTitle().get(i));
                dataDTO.setContent(ratherNews.getContent().get(i));
                dataDTO.setImageUrl(ratherNews.getImageUrl().get(i));
                dataDTOArrayList.add(dataDTO);
            }
            return ViewPagerFragment.newInstance(dataDTOArrayList);
        }
        if(position == 1){
            dataDTOArrayList = new ArrayList<>();
            for(int i=4 ; i<8 ; i++){
                DataDTO dataDTO = new DataDTO();
                dataDTO.setTitle(ratherNews.getTitle().get(i));
                dataDTO.setContent(ratherNews.getContent().get(i));
                dataDTO.setImageUrl(ratherNews.getImageUrl().get(i));
                dataDTOArrayList.add(dataDTO);
            }
            return ViewPagerFragment.newInstance(dataDTOArrayList);
        }
        if(position == 2){
            dataDTOArrayList = new ArrayList<>();
            for(int i=8 ; i<12 ; i++){
                DataDTO dataDTO = new DataDTO();
                dataDTO.setTitle(ratherNews.getTitle().get(i));
                dataDTO.setContent(ratherNews.getContent().get(i));
                dataDTO.setImageUrl(ratherNews.getImageUrl().get(i));
                dataDTOArrayList.add(dataDTO);
            }
            return ViewPagerFragment.newInstance(dataDTOArrayList);
        }
        if(position == 3){
            dataDTOArrayList = new ArrayList<>();
            for(int i=0 ; i<4 ; i++){
                DataDTO dataDTO = new DataDTO();
                dataDTO.setTitle(ratherNews.getTitle().get(i));
                dataDTO.setContent(ratherNews.getContent().get(i));
                dataDTO.setImageUrl(ratherNews.getImageUrl().get(i));
                dataDTOArrayList.add(dataDTO);
            }
            return ViewPagerFragment.newInstance(dataDTOArrayList);
        }
        if(position == 4){
            dataDTOArrayList = new ArrayList<>();
            for(int i=4 ; i<8 ; i++){
                DataDTO dataDTO = new DataDTO();
                dataDTO.setTitle(ratherNews.getTitle().get(i));
                dataDTO.setContent(ratherNews.getContent().get(i));
                dataDTO.setImageUrl(ratherNews.getImageUrl().get(i));
                dataDTOArrayList.add(dataDTO);
            }
            return ViewPagerFragment.newInstance(dataDTOArrayList);
        }
        if(position == 5){
            dataDTOArrayList = new ArrayList<>();
            for(int i=8 ; i<12 ; i++){
                DataDTO dataDTO = new DataDTO();
                dataDTO.setTitle(ratherNews.getTitle().get(i));
                dataDTO.setContent(ratherNews.getContent().get(i));
                dataDTO.setImageUrl(ratherNews.getImageUrl().get(i));
                dataDTOArrayList.add(dataDTO);
            }
            return ViewPagerFragment.newInstance(dataDTOArrayList);
        }
        return null;
    }

    @Override
    public int getCount() {
        return 6;
    }

    public void setData(RatherNews ratherNews) {
        this.ratherNews = ratherNews;
    }
}
