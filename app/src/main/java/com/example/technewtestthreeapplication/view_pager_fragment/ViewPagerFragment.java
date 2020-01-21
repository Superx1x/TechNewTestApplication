package com.example.technewtestthreeapplication.view_pager_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.technewtestthreeapplication.R;
import com.example.technewtestthreeapplication.detail_activity.DetailActivity;
import com.example.technewtestthreeapplication.news_object.DataDTO;

import java.util.ArrayList;

public class ViewPagerFragment extends Fragment implements ViewPagerFragmentView {
    private ViewPagerFragmentPresenter viewPagerFragmentPresenter;
    private ArrayList<DataDTO> dataDTOArrayList;
    private RecyclerView recyclerView;

    private ViewPagerFragmentRecyclerViewAdapter viewPagerFragmentRecyclerViewAdapter;

    public ViewPagerFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBundle();
        initPresenter();
    }
    //接值
    private void initBundle() {
        //從ViewPagerAdapter的方法public Fragment getItem(int position),
        if(getArguments() != null){
            dataDTOArrayList = (ArrayList<DataDTO>) getArguments().getSerializable("dataDTOArrayList");
        }
    }

    //initBundle()接值,傳給自己
    public static ViewPagerFragment newInstance(ArrayList<DataDTO> dataDTOArrayList) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("dataDTOArrayList",dataDTOArrayList);
        fragment.setArguments(bundle);
        return fragment;
    }

    private void initPresenter() {
        viewPagerFragmentPresenter = new ViewPagerFragmentPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager,container,false);
        initView(view);
        return view;
    }
    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPagerFragmentPresenter.onPrepareData(dataDTOArrayList);
    }

    @Override
    public void showRecycleView(ArrayList<DataDTO> dataDTOArrayList) {
        viewPagerFragmentRecyclerViewAdapter = new ViewPagerFragmentRecyclerViewAdapter(dataDTOArrayList,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new ItemDecration(20));
        recyclerView.setAdapter(viewPagerFragmentRecyclerViewAdapter);
        //點擊後的流程
        viewPagerFragmentRecyclerViewAdapter.SetOnItemClickListener(new ViewPagerFragmentRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(DataDTO dataDTO) {
                viewPagerFragmentPresenter.onItemClickListener(dataDTO);
            }
        });
    }

    //傳送資料到DetailActivity
    @Override
    public void intentToDetailActivity(DataDTO dataDTO) {
        Intent it = new Intent(getActivity(), DetailActivity.class);
        it.putExtra("data",dataDTO);
        if(getActivity() != null){
            getActivity().startActivity(it);
        }
    }
}