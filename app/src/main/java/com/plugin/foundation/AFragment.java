package com.plugin.foundation;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.plugin.foundation.databinding.Fragment01Binding;
import com.plugin.foundation.library.image.CornerTransform;
import com.plugin.foundation.library.image.GlideImageLoaderAPI;
import com.plugin.foundation.library.image.ImageLoaderProxy;
import com.plugin.foundation.library.image.shape.CircleCorner;
import com.plugin.foundation.library.image.shape.RectCorner;
import com.plugin.foundation.library.mvp.activity.BaseBindingMvpActivity;
import com.plugin.foundation.library.mvp.fragment.BaseBingingMvpFragment;
import com.plugin.foundation.library.mvp.fragment.BaseMvpFragment;
import com.plugin.foundation.library.mvp.presenter.MvpPresenter;

import butterknife.BindView;

public class AFragment extends BaseBingingMvpFragment<MyPresenter,Fragment01Binding> {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.image)
    ImageView  image;
    @BindView(R.id.image1)
    ImageView  image1;
    @BindView(R.id.image2)
    ImageView  image2;


//    @Override
//    public int applyContent() {
//        return R.layout.fragment_01;
//    }
//
//    @Override
//    public MvpPresenter createPresenter() {
//        return null;
//    }
//
//    @Override
//    protected void onCreateViewLazy(Bundle savedInstanceState) {
//        super.onCreateViewLazy(savedInstanceState);
//
//        ButterKnife.bind(this.getContentView());
//
//        String str=getArguments().getString("data");
//        tv.setText(str);
//        showContent();
//
//    }


    @Override
    public MyPresenter createPresenter() {
        return null;
    }

    @Override
    public void initViews(View view, Bundle savedInstanceState) {
        super.initViews(view, savedInstanceState);
    }

    @Override
    public void lazyInit(View view, Bundle savedInstanceState) {
        String str=getArguments().getString("data");
        bing.tv.setText(str);

        ImageLoaderProxy.init(new GlideImageLoaderAPI());

        ImageLoaderProxy.getInstance().display(mContext,"https://imgsa.baidu.com/baike/pic/item/bba1cd11728b47107d2e3d94cdcec3fdfc032361.jpg",R.mipmap.ic_launcher,new CircleCorner(),bing.image);
        ImageLoaderProxy.getInstance().display(mContext,"https://imgsa.baidu.com/baike/pic/item/bba1cd11728b47107d2e3d94cdcec3fdfc032361.jpg",R.mipmap.ic_launcher,new RectCorner(mContext,10,false,false,false,false),bing.image1);
        ImageLoaderProxy.getInstance().display(mContext,"https://imgsa.baidu.com/baike/pic/item/bba1cd11728b47107d2e3d94cdcec3fdfc032361.jpg",R.mipmap.ic_launcher,new RectCorner(mContext,10,true,true,false,false),bing.image2);

        showContent();
    }

    @Override
    public int applyContent() {
        return R.layout.fragment_01;
    }
}
