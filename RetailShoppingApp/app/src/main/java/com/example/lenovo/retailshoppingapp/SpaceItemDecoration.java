package com.example.lenovo.retailshoppingapp;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int verticalSpaceHeight;
    private final int bottomSpaceheight;

    public SpaceItemDecoration(int verticalSpaceHeight, int bottomSpaceheight) {
        this.verticalSpaceHeight = verticalSpaceHeight;
        this.bottomSpaceheight = bottomSpaceheight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.right = verticalSpaceHeight;
        if (this.bottomSpaceheight > 0) {
            outRect.bottom = bottomSpaceheight;
        }
//        if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1) {
//            outRect.right = verticalSpaceHeight;
//        }
    }
}
