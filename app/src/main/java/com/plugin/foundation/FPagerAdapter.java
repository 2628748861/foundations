package com.plugin.foundation;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

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
