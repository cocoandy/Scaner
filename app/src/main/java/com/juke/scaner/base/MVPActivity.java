package com.juke.scaner.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.juke.scaner.tool.Tool;
import com.juke.scaner.view.IHttp;
import com.juke.scaner.view.IMVPView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Activity 基类
 * Created by Gavin
 * 2018/9/26
 */
public abstract class MVPActivity<p extends Presenter> extends AppCompatActivity implements IMVPView, IHttp {
    public Context mContext;
    private Unbinder unbinder;
    public p presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBefor();
        setContentView(initLayout());
        mContext = this;
        unbinder = ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {//解绑
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
        presenter = initPresener();
        presenter.addView(this, this);
    }

    @Override
    public void onSuccess(String json) {
        Log.e("TAG_OO", json);
    }

    @Override
    public void onFail(Object t) {
        Log.e("TAG_OO", Tool.beanToString(t));
    }

    public void onCompleted() {
        Log.e("TAG_OO", "OVER>>>>>>>");
    }
}
