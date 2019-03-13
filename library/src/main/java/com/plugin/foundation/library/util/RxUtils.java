package com.plugin.foundation.library.util;



import com.plugin.foundation.mvp.view.MvpView;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by REN.BIN on 2018/8/22.
 */
public class RxUtils {
    public static <T> ObservableTransformer<T, T> scheduler(final CompositeDisposable compositeDisposable) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                compositeDisposable.add(disposable);
                            }
                        });
            }
        };
    }

    public static <T> ObservableTransformer<T, T> schedulerWithPanel(final CompositeDisposable compositeDisposable,final MvpView mvpView) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                compositeDisposable.add(disposable);
                                mvpView.showLoading();
                            }
                        });
            }
        };
    }


    public static <T> ObservableTransformer<T, T> schedulerWithDialog(final CompositeDisposable compositeDisposable,final MvpView mvpView) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                compositeDisposable.add(disposable);
                                mvpView.showCommiting();
                            }
                        })
                        .doFinally(new Action() {
                            @Override
                            public void run() throws Exception {
                                mvpView.dissmissCommiting();
                            }
                        });
            }
        };
    }
}
