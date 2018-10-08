package com.juke.scaner.view;

public interface IMVPView {

    /**
     * 在加载界面之前
     */
    void initBefor();

    /**
     * 初始化UI
     */
    void initView();

    /**
     * 加载数据
     */
    void initData();

    /**
     * 加载布局
     * @return 布局id
     */
    int initLayout();


}
