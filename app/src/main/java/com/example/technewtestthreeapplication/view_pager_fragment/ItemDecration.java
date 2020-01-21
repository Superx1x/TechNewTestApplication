package com.example.technewtestthreeapplication.view_pager_fragment;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDecration extends RecyclerView.ItemDecoration {
    int space;

    public ItemDecration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

        if(parent.getChildAdapterPosition(view) == 0){
            outRect.top = space;
        }
    }
}
