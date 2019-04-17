package com.plugin.foundation;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.plugin.foundation.library.downloader.DownLoadListener;
import com.plugin.foundation.library.downloader.DownloadProxy;
import com.plugin.foundation.library.mvp.activity.BaseMvpActivity;
import com.plugin.foundation.library.mvp.activity.WebActivity;
import com.plugin.foundation.library.mvp.presenter.MvpPresenter;
import com.plugin.foundation.library.util.SdcardUtils;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity {

    @BindView(R.id.title_template)
    TextView title_template;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=new Intent(mContext,WebActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("url","http://webcase.51hitech.com/source/cobuhc9ad7x177hp/?from=singlemessage");
        intent.putExtras(bundle);
        startActivity(intent);

        Log.e("TAG", SdcardUtils.getSDFreeSize()+"");


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
