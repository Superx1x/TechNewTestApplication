package com.example.technewtestthreeapplication.detail_activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.technewtestthreeapplication.R;
import com.example.technewtestthreeapplication.news_object.DataDTO;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class DetailActivity extends AppCompatActivity {
    //UI
    private TextView detailTime;
    private TextView datailTitle;
    private TextView detailContent;
    private ImageView detailImage;
    //data
    private DataDTO dataDTO;
    //套件
    private DisplayImageOptions displayImageOptions;
    private ImageLoader imageLoader = ImageLoader.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initBundle();
        initImageLoader();
        initView();
    }

    //接到資料初始化資料
    private void initBundle() {
        Intent it = getIntent();
        dataDTO = (DataDTO) it.getSerializableExtra("data");
    }

    private void initImageLoader() {
        displayImageOptions = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(displayImageOptions).build();
        imageLoader.init(config);
    }

    private void initView() {
        detailTime = findViewById(R.id.tv_detailTime);
        datailTitle = findViewById(R.id.tv_datailTitle);
        detailContent = findViewById(R.id.tv_detailContent);
        detailImage = findViewById(R.id.img_detailImage);

        datailTitle.setText(dataDTO.getTitle());
        detailContent.setText(dataDTO.getContent());
        imageLoader.displayImage(dataDTO.getImageUrl(),detailImage,displayImageOptions);
    }
}
