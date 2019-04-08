package com.plugin.foundation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.plugin.foundation.library.app.GreenDaoDelegate;
import com.plugin.foundation.library.db.IDbAPI;
import com.plugin.foundation.library.mvp.activity.BaseMvpActivity;
import com.plugin.foundation.library.mvp.presenter.MvpPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMvpActivity {

    @BindView(R.id.title_template)
    TextView title_template;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new GreenDaoDelegate(getApplication(),MyApi.class);
    }

    @Override
    public int applyContent() {
        return R.layout.activity_main;
    }

    @Override
    public MvpPresenter createPresenter() {
        return null;
    }
    class MyApi implements IDbAPI
    {

        @Override
        public String getDbName() {
            return null;
        }

        @Override
        public long insert(Object t) {
            return 0;
        }

        @Override
        public long insertOrUpdate(Object t) {
            return 0;
        }

        @Override
        public void insertOrReplaceTx(Object... s) {

        }

        @Override
        public void delete(Object t) {

        }

        @Override
        public void deleteAll(Class<?> t) {

        }

        @Override
        public void update(Object t) {

        }

        @Override
        public <T> T loadById(Class<T> claz, Long id) {
            return null;
        }

        @Override
        public <T> List<T> loadAll(Class<T> t) {
            return null;
        }

        @Override
        public <T> T loadFirst(Class<T> t) {
            return null;
        }

        @Override
        public long size(Class<Object> t) {
            return 0;
        }

        @Override
        public <T> List<T> customQuery(Class<T> t, String where, String... selectionArg) {
            return null;
        }
    }
}
