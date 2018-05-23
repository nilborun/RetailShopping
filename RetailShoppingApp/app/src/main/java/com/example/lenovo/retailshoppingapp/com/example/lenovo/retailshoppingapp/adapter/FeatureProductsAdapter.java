package com.example.lenovo.retailshoppingapp.com.example.lenovo.retailshoppingapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.retailshoppingapp.model.FeatureProduct;
import com.example.lenovo.retailshoppingapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FeatureProductsAdapter extends RecyclerView.Adapter<FeatureProductsAdapter.FeaturePrdViewHolder> {
    private Context mContext;
    private List<FeatureProduct> mProducts;

    public FeatureProductsAdapter(Context context, List<FeatureProduct> products) {
        this.mContext = context;
        this.mProducts = products;
    }


    @NonNull
    @Override
    public FeaturePrdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.layout_feature_product_item, parent, false);
        return new FeaturePrdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturePrdViewHolder holder, int position) {
        FeatureProduct product = mProducts.get(position);
        holder.setUpView(product);

    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    class FeaturePrdViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView mPrducTmgView;
        private AppCompatTextView mTitleTv, mPriceTv;
        private AppCompatRatingBar mRatingbar;

        public FeaturePrdViewHolder(View itemView) {
            super(itemView);
            mPrducTmgView = itemView.findViewById(R.id.imgbiew_feature_icon);
            mTitleTv = itemView.findViewById(R.id.tv_feature_prdoucts_title);
            mPriceTv = itemView.findViewById(R.id.tv_feature_prdoucts_price);
            mRatingbar = itemView.findViewById(R.id.ratingbar_fdeature_product);
        }

        public void setUpView(FeatureProduct product) {
            Picasso.get().load(product.getImageUrl()).fit().into(mPrducTmgView);
            mTitleTv.setText(product.getProductTitle());
            mPriceTv.setText(mContext.getString(R.string.bdt_price_tag) + " " + product.getPrice());
            mRatingbar.setRating(product.getProductRating());
        }
    }
}

