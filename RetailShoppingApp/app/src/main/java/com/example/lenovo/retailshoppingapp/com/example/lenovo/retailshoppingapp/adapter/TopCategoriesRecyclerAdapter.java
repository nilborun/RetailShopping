package com.example.lenovo.retailshoppingapp.com.example.lenovo.retailshoppingapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.retailshoppingapp.R;
import com.example.lenovo.retailshoppingapp.model.TopCategoryModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopCategoriesRecyclerAdapter extends RecyclerView.Adapter<TopCategoriesRecyclerAdapter.TopCategoyViewHolder> {
    private List<TopCategoryModel> mItems;
    private Context mContext;

    public TopCategoriesRecyclerAdapter(Context context, List<TopCategoryModel> categories) {
        mContext = context;
        mItems = categories;
    }

    @NonNull
    @Override
    public TopCategoyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.layout_top_categories_item, parent, false);
        return new TopCategoyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopCategoyViewHolder holder, int position) {
        TopCategoryModel model = mItems.get(position);
        holder.setUpHolder(model, position);

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class TopCategoyViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView titleTextView, totalCountTextView;
        private AppCompatImageView gadgetIconImgView, gadgerLayerImgView;

        public TopCategoyViewHolder(View item) {
            super(item);
            titleTextView = item.findViewById(R.id.tv_gadget_title);
            totalCountTextView = itemView.findViewById(R.id.tv_gadget_count);
            gadgetIconImgView = itemView.findViewById(R.id.imgview_gadget_icon);
            gadgerLayerImgView = itemView.findViewById(R.id.imgview_layer_icon);

        }

        public void setUpHolder(TopCategoryModel topCategoryModel, int position) {
            int reminder = position % 3;
            if (reminder == 0) {
                gadgerLayerImgView.setBackgroundDrawable(mContext.getDrawable(R.drawable.image_background));
            }
            if (reminder == 1) {
                gadgerLayerImgView.setBackgroundDrawable(mContext.getDrawable(R.drawable.image_background2));
            }
            if (reminder == 2) {
                gadgerLayerImgView.setBackgroundDrawable(mContext.getDrawable(R.drawable.image_background3));
            }
            Picasso.get().load(topCategoryModel.getUrl()).fit().into(gadgetIconImgView);
            titleTextView.setText(topCategoryModel.getTitle());
            totalCountTextView.setText(topCategoryModel.getTotal() + " items");
        }

    }
}
