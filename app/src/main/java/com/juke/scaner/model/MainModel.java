package com.juke.scaner.model;

import com.juke.scaner.base.Presenter;
import com.juke.scaner.contract.MainContract;
import com.juke.scaner.retrofit.RetrofitManager;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 主页逻辑层
 * Created by Gavin
 * 2018/9/26
 */
public class MainModel implements MainContract.Model {

    @Override
    public void getMainData(Map<String, String> map, Presenter.RxObserver observer) {
        RetrofitManager
                .getSingleton()
                .RetrofitService()
                .getCinemaList(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
