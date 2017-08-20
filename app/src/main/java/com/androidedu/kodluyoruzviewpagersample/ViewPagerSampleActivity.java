package com.androidedu.kodluyoruzviewpagersample;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ViewPagerSampleActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener,
        TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private SwipeRefreshLayout swipeRefreshLayout = null;
    private TabLayout tabLayout = null;
    private ViewPager vpFragments = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_sample);

        initView();
    }

    private void initView() {

        swipeRefreshLayout = findViewById(R.id.activity_view_pager_sample_swipeRefreshLayout);
        tabLayout = findViewById(R.id.activity_view_pager_sample_tablayout);
        vpFragments = findViewById(R.id.activity_view_pager_sample_vpFragments);

        initEvent();
    }

    private void initEvent() {

        swipeRefreshLayout.setOnRefreshListener(this);

        tabLayout.setupWithViewPager(vpFragments);
        tabLayout.addOnTabSelectedListener(this);

        ViewPagerAdapter viewpagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        ContactListFragment contactListFragment = new ContactListFragment();
        AddContactFragment addContactFragment = new AddContactFragment();

        viewpagerAdapter.addFragment(contactListFragment, "ContactList");
        viewpagerAdapter.addFragment(addContactFragment, "Add Contact");

        vpFragments.setAdapter(viewpagerAdapter);
        vpFragments.addOnPageChangeListener(this);
        vpFragments.setCurrentItem(19);
    }

    @Override
    public void onRefresh() {


        new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                Toast.makeText(ViewPagerSampleActivity.this, "Kalan Süre" + millisUntilFinished, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                swipeRefreshLayout.setRefreshing(false);
            }

        }.start();

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        Toast.makeText(this, "İlk kez seçilen tab " + tab.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

        Toast.makeText(this, "Seçimi kaldırılan tab : " + tab.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

        Toast.makeText(this, "Yeniden Seçilen Tab" + tab.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Toast.makeText(this, "Fragment Scrolled", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this, "Fragment Selected", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Toast.makeText(this, "Fragment onPageScrollStateChanged", Toast.LENGTH_SHORT).show();
    }
}
