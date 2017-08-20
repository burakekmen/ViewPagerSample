package com.androidedu.kodluyoruzviewpagersample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/******************************
 * Created by Gökhan ÖZTÜRK   |
 * 20.08.2017                 |
 * GokhanOzturk@AndroidEdu.IO |
 *****************************/
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> tabLayoutTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment addedFragment, String tabLayoutTitle) {

        fragmentList.add(addedFragment);
        tabLayoutTitleList.add(tabLayoutTitle);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabLayoutTitleList.get(position);
    }
}
