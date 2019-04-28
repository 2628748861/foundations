package com.plugin.foundation.library.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class LazyFragment extends Fragment {
    /**
     * 标记已加载完成，保证懒加载只能加载一次
     */
    private boolean hasLoaded = false;
    /**
     * 标记Fragment是否已经onCreate
     */
    private boolean isCreated = false;
    /**
     * 界面对于用户是否可见
     */
    private boolean isVisibleToUser = false;

    private View contentView;

    public View getContentView() {
        return contentView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return getView(inflater, applyContent(), container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view, savedInstanceState);
    }

    private View getView(LayoutInflater inflater, int layoutId, ViewGroup container) {
        return inflater.inflate(layoutId, container, false);
    }


    private void init(View view, Bundle savedInstanceState) {
        isCreated = true;
        this.contentView = view;
        initViews(this.contentView,savedInstanceState);
        lazyLoad(this.contentView,savedInstanceState);
    }
    /**
     * 监听界面是否展示给用户，实现懒加载
     * 这个方法也是网上的一些方法用的最多的一个，我的思路也是这个，不过把整体思路完善了一下
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.isVisibleToUser = isVisibleToUser;
        lazyLoad(contentView, null);
    }

    /**
     * 懒加载方法，获取数据什么的放到这边来使用，在切换到这个界面时才进行网络请求
     */
    private void lazyLoad(View view, Bundle savedInstanceState) {

        //如果该界面不对用户显示、已经加载、fragment还没有创建，
        //三种情况任意一种，不获取数据
        if (!isVisibleToUser || hasLoaded || !isCreated) {
            return;
        }
        lazyInit(view, savedInstanceState);
        //注：关键步骤，确保数据只加载一次
        hasLoaded = true;
    }

    /**初始化布局时调用
     * @param view
     * @param savedInstanceState
     */
    public abstract void initViews(View view,Bundle savedInstanceState);
    /**
     * 触发懒加载时会调用的方法
     */
    public abstract void lazyInit(View view, Bundle savedInstanceState);

    public abstract int applyContent();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isCreated = false;
        hasLoaded = false;
    }
}
