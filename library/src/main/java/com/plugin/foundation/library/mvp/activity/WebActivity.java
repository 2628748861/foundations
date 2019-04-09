package com.plugin.foundation.library.mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.just.agentweb.AgentWeb;
import com.plugin.foundation.library.R;
import com.plugin.foundation.library.mvp.presenter.MvpPresenter;

import butterknife.BindView;

public class WebActivity<Presenter extends MvpPresenter> extends BaseMvpActivity<Presenter>
{
    private AgentWeb mAgentWeb;
    private String url;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=savedInstanceState==null?getIntent().getExtras():savedInstanceState;
        url=bundle.getString("url");
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent( (ViewGroup) getContentView(), new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(url);
        addBack((ViewGroup) getContentView());


    }

    private void addBack(ViewGroup parent)
    {
        ImageButton imageButton=new ImageButton(mContext);
        imageButton.setPadding(20,60,10,10);
        imageButton.setBackground(null);
        imageButton.setImageResource(R.drawable.ic_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        parent.addView(imageButton);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("url",url);
    }

    @Override
    public int applyContent() {
        return R.layout.default_actiivty_web;
    }

    @Override
    public Presenter createPresenter() {
        return null;
    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }
}
