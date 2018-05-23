package com.example.lenovo.retailshoppingapp.UI.activity;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.lenovo.retailshoppingapp.R;
import com.example.lenovo.retailshoppingapp.UI.fragment.AccountOpenFragment;
import com.example.lenovo.retailshoppingapp.UI.fragment.LoginFragment;

import java.util.ArrayList;
import java.util.List;


public class UserAccountActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mViewpager = findViewById(R.id.viewpager);
        setUpViewPager(mViewpager);

        mTabLayout = findViewById(R.id.tabs);

        mTabLayout.setupWithViewPager(mViewpager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void setUpViewPager(ViewPager mViewpager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginFragment(), getResources().getString(R.string.title_logintab));
        adapter.addFragment(new AccountOpenFragment(), getResources().getString(R.string.title_registration_tab));
        mViewpager.setAdapter(adapter);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> mFragments = new ArrayList<>();
        List<String> mTitles = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);

        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mTitles.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
    }
}
