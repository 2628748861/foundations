package com.plugin.foundation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.plugin.foundation.library.mvp.activity.BaseMvpActivity;
import com.plugin.foundation.library.mvp.presenter.MvpPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMvpActivity {

    @BindView(R.id.title_template)
    TextView title_template;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public int applyContent() {
        return R.layout.activity_main;
    }

    @Override
    public MvpPresenter createPresenter() {
        return null;
    }
}
