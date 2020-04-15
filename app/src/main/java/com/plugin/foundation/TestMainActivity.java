//package com.plugin.foundation;
//
//import android.os.Bundle;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.viewpager.widget.ViewPager;
//import android.view.View;
//import android.widget.LinearLayout;
//
//import com.plugin.foundation.library.mvp.presenter.MvpPresenter;
//import com.plugin.foundation.library.util.LogUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class TestMainActivity extends BaseMvpActivity
//{
//    @BindView(R.id.vp)
//    ViewPager vp;
//
//    @Override
//    public int applyContent() {
//        return R.layout.activity_test_01;
//    }
//
//    @Override
//    public MvpPresenter createPresenter() {
//        return null;
//    }
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        LogUtils.setDebug("TEST",true);
//        List<Fragment> fragments=new ArrayList<>();
//        for (int i=0;i<3;i++)
//        {
//            Fragment fragment=new AFragment();
//            switch (i)
//            {
//                case 0:
//                    fragment=new AFragment();
//                    break;
//                case 1:
//                    fragment=new BFragment();
//                    break;
//                case 2:
//                    fragment=new CFragment();
//                    break;
//            }
//            Bundle bundle=new Bundle();
//            bundle.putString("data","数据:"+i);
//            fragment.setArguments(bundle);
//            fragments.add(fragment);
//        }
//        FPagerAdapter adapter=new FPagerAdapter(getSupportFragmentManager(),fragments);
//        vp.setAdapter(adapter);
//
//
//    }
//
//    public void getValue(View view)
//    {
//        LinearLayout layout=new LinearLayout(mContext);
//
//        ButterKnife.bind(this,layout);
//
//
//    }
//
//}
