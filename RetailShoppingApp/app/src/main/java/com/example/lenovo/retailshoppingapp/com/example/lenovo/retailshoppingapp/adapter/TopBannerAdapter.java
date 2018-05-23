package com.example.lenovo.retailshoppingapp.com.example.lenovo.retailshoppingapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.retailshoppingapp.model.CardModel;
import com.example.lenovo.retailshoppingapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopBannerAdapter extends PagerAdapter {
    List<CardModel> mCards;
    private Context mContext;

    public TopBannerAdapter(Context context, List<CardModel> cards) {
        mContext = context;
        mCards = cards;
    }

    @Override
    public int getCount() {
        return mCards.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.card_view, null);
        container.addView(v);
        String url = mCards.get(position).getUrl();
        AppCompatImageView imageView = v.findViewById(R.id.img_view);
        Picasso.get().load(url).fit().into(imageView);
        return v;
    }
}
