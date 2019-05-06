package com.plugin.foundation;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.plugin.foundation.databinding.Fragment01Binding;
import com.plugin.foundation.library.image.args.Args;
import com.plugin.foundation.library.image.glide.GlideArgsBuilder;
import com.plugin.foundation.library.image.glide.GlideImageLoaderAPI;
import com.plugin.foundation.library.image.ImageLoaderProxy;
import com.plugin.foundation.library.image.shape.RectCorner;
import com.plugin.foundation.library.mvp.fragment.BaseBingingMvpFragment;
import com.plugin.foundation.library.util.LogUtils;

import java.io.File;

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

        Args args=new GlideArgsBuilder()
                .uri(Uri.parse("https://imgsa.baidu.com/baike/pic/item/bba1cd11728b47107d2e3d94cdcec3fdfc032361.jpg"))
                .placeHolder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_back)
                .shape(new RectCorner(getActivity(),5,false,false,true,false))
                .transaction(BitmapTransitionOptions.withCrossFade())
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }
                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        LogUtils.e("onResourceReady:"+model);
                        return false;
                    }
                })
                .build();

//        //drawable 图片drawable
//        Resources r =mContext.getResources();
//        Uri uri =  Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
//                + r.getResourcePackageName(R.drawable.ic_placeholder) + "/"
//                + r.getResourceTypeName(R.drawable.ic_placeholder) + "/"
//                + r.getResourceEntryName(R.drawable.ic_placeholder));
//
//        uri=Uri.parse("https://imgsa.baidu.com/baike/pic/item/bba1cd11728b47107d2e3d94cdcec3fdfc032361.jpg"); //网络图片
//        uri=Uri.fromFile(new File(Environment.getExternalStorageDirectory().getPath()+"/tencent/MicroMsg/WeiXin/mmexport1557043511894.jpg")); //本地图片
//        uri=Uri.parse("file:///android_asset/ic_placeholder.png");//assets图片



//        Glide.with(mContext).load(uri)
//                .override(400,400)
//                .listener(new RequestListener<Drawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//
//                        int w=resource.getIntrinsicWidth();
//                        int h=resource.getIntrinsicHeight();
//                        LogUtils.e("图片大小:"+w+","+h);
//                        return false;
//                    }
//                })
//                .into(bing.image);

        //ImageLoaderProxy.getInstance().display(mContext,"https://imgsa.baidu.com/baike/pic/item/bba1cd11728b47107d2e3d94cdcec3fdfc032361.jpg",R.drawable.ic_placeholder,null,bing.image);

        ImageLoaderProxy.getInstance().display(mContext,new GlideArgsBuilder().uri(Uri.parse("file:///android_asset/ic_placeholder.png")).placeHolder(R.drawable.ic_placeholder).error(R.drawable.ic_placeholder).build(),bing.image);
        ImageLoaderProxy.getInstance().display(mContext,args,bing.image1);
        ImageLoaderProxy.getInstance().display(mContext,new GlideArgsBuilder().uri(Uri.parse("https://fc-feed.cdn.bcebos.com/0/pic/fcdb8ef09079db6ac531a811c43558e4.png")).override(200,200)
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        LogUtils.e("大小:"+resource.getWidth()+","+resource.getHeight());
                        return false;
                    }
                })
                .build(),bing.image2);
        LogUtils.e("缓存大小:"+mContext.getCacheDir());

        showContent();
    }

    @Override
    public int applyContent() {
        return R.layout.fragment_01;
    }
}
