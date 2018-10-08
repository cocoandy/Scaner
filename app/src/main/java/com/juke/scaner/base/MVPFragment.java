package com.juke.scaner.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juke.scaner.view.IHttp;
import com.juke.scaner.view.IMVPView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Fragment 基类
 * Created by Gavin
 * 2018/9/26
 */
public abstract class MVPFragment<p extends Presenter> extends Fragment implements IMVPView , IHttp {
    private Unbinder unbinder;
    public View view;
    public Activity mContext;
    public p presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        initBefor();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(mContext).inflate(initLayout(), container);
        unbinder = ButterKnife.bind(view);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }

        presenter.detattch();
    }

    public abstract void initView();

    public abstract void initData();

    public abstract int initLayout();

    protected abstract p initPresener();

    @Override
    public void initBefor() {
        presenter.addView(this,this);
    }

    @Override
    public void onSuccess(String json) {

    }

    @Override
    public void onFail(Object t) {

    }

    @Override
    public void onCompleted() {

    }
}
