package com.example.lenovo.retailshoppingapp.com.example.lenovo.retailshoppingapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.retailshoppingapp.model.ProductCategories;
import com.example.lenovo.retailshoppingapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.CategoryViewHolder> {
    private Context mContext;
    private List<ProductCategories> mCategoriesList;

    public ProductCategoryAdapter(Context context, List<ProductCategories> categories) {
        mContext = context;
        mCategoriesList = categories;
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.layout_product_category_items, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        ProductCategories categories = mCategoriesList.get(position);
        holder.updateView(categories);

    }

    @Override
    public int getItemCount() {
        return mCategoriesList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView mTitleTV, mDiscountTV;
        private AppCompatImageView mProductImgView;

        public CategoryViewHolder(View itemview) {
            super(itemview);
            mProductImgView = itemView.findViewById(R.id.imgview_prod_cat_icon);
            mTitleTV = itemview.findViewById(R.id.tv_prod_cat_title);
            mDiscountTV = itemview.findViewById(R.id.tv_prod_cat_discount);
        }

        public void updateView(ProductCategories categories) {
            Picasso.get().load(categories.getUrl()).fit().into(mProductImgView);
            mTitleTV.setText(categories.getTitle());
            mDiscountTV.setText(categories.getDiscount() + "5 off");
        }

    }
}
