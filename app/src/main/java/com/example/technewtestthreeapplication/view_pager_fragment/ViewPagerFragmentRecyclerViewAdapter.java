package com.example.technewtestthreeapplication.view_pager_fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.technewtestthreeapplication.R;
import com.example.technewtestthreeapplication.news_object.DataDTO;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

public class ViewPagerFragmentRecyclerViewAdapter extends RecyclerView.Adapter<ViewPagerFragmentRecyclerViewAdapter.ViewHolder> {
    private ArrayList<DataDTO> dataDTOArrayList;
    private Context context;

    private DisplayImageOptions displayImageOptions;
    private ImageLoader imageLoader = ImageLoader.getInstance();

    private OnItemClickListener listener;

    public void SetOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public ViewPagerFragmentRecyclerViewAdapter(ArrayList<DataDTO> dataDTOArrayList, Context context) {
        this.dataDTOArrayList = dataDTOArrayList;
        this.context = context;
        initImageLoader();
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
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(displayImageOptions).build();
        imageLoader.init(config);
    }

    //改寫成下方
//    @NonNull
//    @Override
//    public ViewPagerFragmentRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false));
    }

    //改寫成下方
//    @Override
//    public void onBindViewHolder(@NonNull ViewPagerFragmentRecyclerViewAdapter.ViewHolder holder, int position) {
//
//    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataDTO dataDTO = dataDTOArrayList.get(position);//有加final
        holder.textView.setText(dataDTO.getTitle());
        imageLoader.displayImage(dataDTO.getImageUrl(),holder.imageView,displayImageOptions);
        holder.clickArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(dataDTO);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataDTOArrayList.size();
    }

    //自建ViewHolder類別
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ConstraintLayout clickArea;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_item);
            clickArea = itemView.findViewById(R.id.click_Area);
            imageView = itemView.findViewById(R.id.item_Image);
        }
    }

    //自建點擊事件的Listener
    public interface OnItemClickListener{
        void onClick(DataDTO dataDTO);
    }
}
