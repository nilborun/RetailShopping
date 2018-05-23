package com.example.lenovo.retailshoppingapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lib.Deck;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ThirdFragment extends Fragment {

    Deck mDeckpager;

    List<CardModel> models = new ArrayList<CardModel>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CardModel c1 = new CardModel("https://i.imgur.com/b4mJrHr.jpg", "Image 1");
        CardModel c2 = new CardModel("https://i.imgur.com/DA7LGKW.jpg", "Image 2");
        CardModel c3 = new CardModel("https://i.imgur.com/XyiD2t3.jpg", "Image 3");
        CardModel c4 = new CardModel("https://i.imgur.com/qr1hglb.jpg", "Image 4");
        CardModel c5 = new CardModel("https://i.imgur.com/XIIFsKa.jpg", "Image 5");

        models.add(c1);
        models.add(c2);
        models.add(c3);
        models.add(c4);
        models.add(c5);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_third, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDeckpager = view.findViewById(R.id.deck_pager);
        mDeckpager.setOffscreenPageLimit(5);
        mDeckpager.setClipToPadding(false);
        int dpValue = 30; // margin in dips
        float d = getResources().getDisplayMetrics().density;
        int margin = (int)(dpValue * d);
        mDeckpager.setPadding(margin,0,margin,0);
        DeckAdapter adapter = new DeckAdapter(models);
        mDeckpager.setAdapter(adapter);
    }

    class DeckAdapter extends PagerAdapter {
        List<CardModel> mCards;

        public DeckAdapter(List<CardModel> cards) {
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

            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View v = inflater.inflate(R.layout.card_view, null);
            container.addView(v);
            String url = mCards.get(position).getUrl();
            Log.e("TAG", url);
            AppCompatImageView imageView = v.findViewById(R.id.img_view);
            Picasso.get().load(url).fit().into(imageView);
            return v;
        }
    }
}
