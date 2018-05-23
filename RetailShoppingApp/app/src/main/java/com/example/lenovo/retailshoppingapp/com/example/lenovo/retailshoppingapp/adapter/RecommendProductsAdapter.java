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

import com.example.lenovo.retailshoppingapp.R;
import com.example.lenovo.retailshoppingapp.model.RecommendProduct;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecommendProductsAdapter extends RecyclerView.Adapter<RecommendProductsAdapter.RecommendPrdViewHolder> {
    private Context mContext;
    private List<RecommendProduct> mProducts;

    public RecommendProductsAdapter(Context context, List<RecommendProduct> products) {
        this.mContext = context;
        this.mProducts = products;
    }


    @NonNull
    @Override
    public RecommendPrdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.layout_recommended_product_item, parent, false);
        return new RecommendPrdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendPrdViewHolder holder, int position) {
        RecommendProduct product = mProducts.get(position);
        holder.setUpView(product);

    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    class RecommendPrdViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView mPrducTmgView;
        private AppCompatTextView mTitleTv, mPriceTv;
        private AppCompatRatingBar mRatingbar;

        public RecommendPrdViewHolder(View itemView) {
            super(itemView);
            mPrducTmgView = itemView.findViewById(R.id.imgbiew_recommend_prod_icon);
            mTitleTv = itemView.findViewById(R.id.tv_recommend_prdoucts_title);
            mPriceTv = itemView.findViewById(R.id.tv_recommend_prdoucts_price);
            mRatingbar = itemView.findViewById(R.id.ratingbar_recommend_product);
        }

        public void setUpView(RecommendProduct product) {
            Picasso.get().load(product.getImageUrl()).fit().into(mPrducTmgView);
            mTitleTv.setText(product.getProductTitle());
            mPriceTv.setText(mContext.getString(R.string.bdt_price_tag) + " " + product.getPrice());
            mRatingbar.setRating(product.getProductRating());
        }
    }
}

