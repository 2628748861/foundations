package com.plugin.foundation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class FPagerAdapter extends FragmentPagerAdapter
{

    private List<Fragment> datas;
    public FPagerAdapter(FragmentManager fm, List<Fragment> datas) {
        super(fm);
        this.datas=datas;
    }

    @Override
    public Fragment getItem(int i) {
        return datas.get(i);
    }

    @Override
    public int getCount() {
        return datas.size();
    }
}
