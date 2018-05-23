package com.example.lenovo.retailshoppingapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.asksira.loopingviewpager.LoopingViewPager;
import com.example.lib.Deck;
import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.widget.IconButton;
import com.rd.PageIndicatorView;


import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private NavigationView mNavView;

    private ActionBarDrawerToggle mToggle;
    private RecyclerView mTopCatoriesRecylerview, mFeatureProductsRecyclerView;
    private LoopingViewPager mBannerPager;


    private static final int SAMPLE2_ID = 34535;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mToolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(mToolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavView = findViewById(R.id.nav_view);
        mToggle = setUpDrawerToggle();
        mTopCatoriesRecylerview = findViewById(R.id.rcv_top_categories_items);
        mFeatureProductsRecyclerView = findViewById(R.id.rcv_featured_categories);
        mBannerPager = findViewById(R.id.viewpager_banner);


        setUpDrawerContent(mNavView);
        mDrawerLayout.addDrawerListener(mToggle);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToggle.syncState();

        showLatestProductInSlider();
        showTopCategories();
        showFeatureProducts();
        showBanner();
    }

    private ActionBarDrawerToggle setUpDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
    }


    private void setUpDrawerContent(NavigationView navView) {

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectDrawItem(item);
                return true;
            }
        });
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        mToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        mToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);

        MenuItem item = menu.findItem(R.id.cart_home);
        Toast.makeText(HomeActivity.this, "" + item.getActionView() + " " + item.toString(), Toast.LENGTH_LONG).show();

//        RelativeLayout badgeLayout = (RelativeLayout) item.getActionView();
//        TextView itemMessagesBadgeTextView = (TextView) badgeLayout.findViewById(R.id.badge_textView);
//        itemMessagesBadgeTextView.setVisibility(View.GONE); // initially hidden
//
//        IconButton iconButtonMessages = (IconButton) badgeLayout.findViewById(R.id.badge_icon_button);
//        iconButtonMessages.setText("{fa-envelope}");
//        iconButtonMessages.setTextColor(getResources().getColor(R.color.red));
//
//        iconButtonMessages.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(HomeActivity.this,"Badge COunt",Toast.LENGTH_LONG).show();
//            }
//        });


        return super.onCreateOptionsMenu(menu);
    }


    private void showLatestProductInSlider() {
        Fragment fragment = null;
        Class FragmentClass = ThirdFragment.class;

        try {
            fragment = (Fragment) FragmentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fContainer, fragment).commit();
    }

    private void showTopCategories() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mTopCatoriesRecylerview.setLayoutManager(layoutManager);
        SpaceItemDecoration itemDecoration = new SpaceItemDecoration(30, 0);
        mTopCatoriesRecylerview.addItemDecoration(itemDecoration);


        TopCategoryModel model1 = new TopCategoryModel("https://i.imgur.com/znkG7n8.jpg", "Gadget & Gear", 145);
        TopCategoryModel model2 = new TopCategoryModel("https://i.imgur.com/qvTrTWd.jpg", "Gens Clothes", 100);
        TopCategoryModel model3 = new TopCategoryModel("https://i.imgur.com/Yfcc8hl.jpg", "Ladies Clothes", 125);
        TopCategoryModel model4 = new TopCategoryModel("https://i.imgur.com/6QvWA8v.jpg", "Camera & Video", 10);
        TopCategoryModel model5 = new TopCategoryModel("https://i.imgur.com/AQUFdyS.jpg", "Mobile & Tablet", 200);
        TopCategoryModel model6 = new TopCategoryModel("https://i.imgur.com/6QvWA8v.jpg", "Computer & parts", 145);

        List<TopCategoryModel> mLists = new ArrayList<>();
        mLists.add(model1);
        mLists.add(model2);
        mLists.add(model3);
        mLists.add(model4);
        mLists.add(model5);
        mLists.add(model6);

        TopCategoriesRecyclerAdapter adapter = new TopCategoriesRecyclerAdapter(this, mLists);
        mTopCatoriesRecylerview.setAdapter(adapter);


    }

    private void showFeatureProducts() {

        FeatureProduct product1 = new FeatureProduct("https://i.imgur.com/xgIhhHH.jpg", "Men Jeans Pant", 1450, 3.5f);
        FeatureProduct product2 = new FeatureProduct("https://i.imgur.com/93PqquW.jpg", "Men Full Shirt", 1550, 2.5f);
        FeatureProduct product3 = new FeatureProduct("https://i.imgur.com/GXRykZl.jpg", "Samsung Phones", 1450, 4.5f);
        FeatureProduct product4 = new FeatureProduct("https://i.imgur.com/PlyjrVn.jpg", "iPhone", 1420, 5.0f);
        FeatureProduct product5 = new FeatureProduct("https://i.imgur.com/xgIhhHH.jpg", "Men Jeans Pant", 1050, 1.5f);
        FeatureProduct product6 = new FeatureProduct("https://i.imgur.com/xgIhhHH.jpg", "Men Jeans Pant", 1450, 4.0f);

        List<FeatureProduct> mProducts = new ArrayList<>();
        mProducts.add(product1);
        mProducts.add(product2);
        mProducts.add(product3);
        mProducts.add(product4);
        mProducts.add(product5);
        mProducts.add(product6);

        LinearLayoutManager layoutManager = new GridLayoutManager(this, 3);
        mFeatureProductsRecyclerView.setLayoutManager(layoutManager);

        SpaceItemDecoration itemDecoration = new SpaceItemDecoration(30, 20);
        mFeatureProductsRecyclerView.addItemDecoration(itemDecoration);

        FeatureProductsAdapter adapter = new FeatureProductsAdapter(this, mProducts);
        mFeatureProductsRecyclerView.setAdapter(adapter);


    }

    private void showBanner() {
        PageIndicatorView pageIndicatorView = findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setCount(10); // specify total count of indicators
        pageIndicatorView.setSelection(1);

        CardModel banner1 = new CardModel("https://i.imgur.com/C3l2hcf.png", "banner 1");
        CardModel banner2 = new CardModel("https://i.imgur.com/tk4yzBw.jpg", "banner 2");
        CardModel banner3 = new CardModel("https://i.imgur.com/3u3W9O4.jpg", "banner 3");
        CardModel banner4 = new CardModel("https://i.imgur.com/jYWtkiR.jpg", "banner 4");
        CardModel banner5 = new CardModel("https://i.imgur.com/I4U5D3y.jpg", "banner 5");
        List<CardModel> banners = new ArrayList<>();
        banners.add(banner1);
        banners.add(banner2);
        banners.add(banner3);
        banners.add(banner4);
        banners.add(banner5);


        BannerAdapter adapter = new BannerAdapter(this, banners, true);
        mBannerPager.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        mBannerPager.resumeAutoScroll();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBannerPager.pauseAutoScroll();
    }

    private void selectDrawItem(MenuItem item) {
//        Fragment fragment = null;
//        Class FragmentClass;
//        switch (item.getItemId()) {
//            case R.id.nav_new_profile:
//                FragmentClass = ThirdFragment.class;
//                break;
//            default:
//                FragmentClass = LoginFragment.class;
//                break;
//        }
//
//        try {
//            fragment = (Fragment) FragmentClass.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.fContainer, fragment).commit();
//        item.setChecked(true);
//        setTitle(item.getTitle());
//        mDrawerLayout.closeDrawers();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.cart_home:
                Toast.makeText(this, "I am Menu Card", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_myaccount:
                Intent intent = new Intent(HomeActivity.this, UserAccountActivity.class);
                startActivity(intent);
                return true;
        }
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
