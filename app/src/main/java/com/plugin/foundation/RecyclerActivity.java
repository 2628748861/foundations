package com.plugin.foundation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.plugin.foundation.library.adapter.recyclerview.adapter.BaseRecyclerAdapter;
import com.plugin.foundation.library.mvp.activity.BaseMvpActivity;
import com.plugin.foundation.library.mvp.presenter.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class RecyclerActivity extends BaseMvpActivity
{
    @BindView(R.id.recy)
    RecyclerView recy;

    BaseRecyclerAdapter adapter;
    List<String> mDatas=new ArrayList<>();

    @Override
    public int applyContent() {
        return R.layout.activity_recyactivity;
    }

    @Override
    public MvpPresenter createPresenter() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recy.setLayoutManager(new LinearLayoutManager(mContext));

        for (int i=0;i<30;i++)
        {
            mDatas.add("item:"+i);
        }

        adapter=new MyAdapter3(mContext,R.layout.item_recy,mDatas);
        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                showTip("点击："+position);
            }
        });
        recy.setAdapter(adapter);

    }
}
