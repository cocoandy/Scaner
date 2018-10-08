package com.juke.scaner.contract;

import com.juke.scaner.base.Presenter.RxObserver;

import java.util.Map;

/**
 * 首页接口管理
 * Created by Gavin
 * 2018/9/26
 */
public interface MainContract {
    interface Model {
        /**
         * 获取主页数据
         *
         * @param observer
         */
        void getMainData(Map<String, String> map, RxObserver observer);
    }

    interface View {
    }

    interface Presenter {
        /**
         * 请求数据
         * @param map
         */
        void getMainData(Map<String, String> map);
    }
}
