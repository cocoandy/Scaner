package com.juke.scaner.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

import com.juke.scaner.R;
import com.juke.scaner.base.MVPActivity;
import com.juke.scaner.bean.MainVo;
import com.juke.scaner.presenter.MainPresenter;
import com.juke.scaner.tool.Tool;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Gavin
 * 2018/9/26
 */
public class MainActivity extends MVPActivity<MainPresenter> {
    @BindView(R.id.tv_group)
    TextView mTvGroupId;
    @BindView(R.id.tv_cinema)
    TextView mTvCinema;


    @OnClick({R.id.tv_cinema, R.id.tv_group, R.id.btn_scan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_group:
                showList(presenter.getGroupIds(), "选择影院组ID");
                break;
            case R.id.tv_cinema:
                showList(presenter.getCinemaList(), "选择影院");
                break;
            case R.id.btn_scan:
                break;
        }
    }


    public void showList(String[] items, final String title) {
        AlertDialog alertDialog3 = new AlertDialog.Builder(this)
                .setTitle(title)
                .setItems(items, new DialogInterface.OnClickListener() {//添加列表
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if ("选择影院组ID".equals(title)) {
                            mTvGroupId.setText(presenter.setGroupId(i));
                        } else {
                            mTvCinema.setText(presenter.setCinemasBean(i));
                        }
                    }
                })
                .create();
        alertDialog3.show();
    }


    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        presenter.getMainData(Tool.toMap(new MainVo(presenter.getGroupId())));
    }

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter initPresener() {
        return new MainPresenter();
    }

    @Override
    public void onSuccess(String json) {
        super.onSuccess(json);
        //请求成功
    }
    //失败呀，完成呀自己看IHttp这个接口吧
}
