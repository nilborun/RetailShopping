package com.example.lenovo.retailshoppingapp.com.example.lenovo.retailshoppingapp.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asksira.loopingviewpager.LoopingPagerAdapter;
import com.example.lenovo.retailshoppingapp.model.CardModel;
import com.example.lenovo.retailshoppingapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

//public class BannerAdapter extends PagerAdapter {
//    List<CardModel> mCards;
//    Context mContext;
//
//    public BannerAdapter(Context context, List<CardModel> cards) {
//        mContext = context;
//        mCards = cards;
//    }
//
//    @Override
//    public int getCount() {
//        return mCards.size();
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//
//        return view == object;
//    }
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//
//        LayoutInflater inflater = LayoutInflater.from(mContext);
//        View v = inflater.inflate(R.layout.banner_view, null);
//        container.addView(v);
//        String url = mCards.get(position).getUrl();
//        Log.e("TAG", url);
//        AppCompatImageView imageView = v.findViewById(R.id.imgview_banner);
//        Picasso.get().load(url).fit().into(imageView);
//        return v;
//    }
//}

public class BannerAdapter extends LoopingPagerAdapter<CardModel> {
    private Context mContext;
    private List<CardModel> mProducts;

    public BannerAdapter(Context context,List<CardModel> models,boolean  isInfinite){
        super(context,models,isInfinite);
        mContext=context;
        mProducts=models;
    }

    @Override
    protected View inflateView(int viewType, ViewGroup container, int listPosition) {
        return LayoutInflater.from(mContext).inflate(R.layout.banner_view,container,false);
    }

    @Override
    protected void bindView(View convertView, int listPosition, int viewType) {
        String url = mProducts.get(listPosition).getUrl();
        AppCompatImageView imageView = convertView.findViewById(R.id.imgview_banner);
        Picasso.get().load(url).fit().into(imageView);

    }
}

