package com.juke.scaner.presenter;

import com.juke.scaner.base.Presenter;
import com.juke.scaner.bean.CinemaInfo;
import com.juke.scaner.contract.MainContract;
import com.juke.scaner.model.MainModel;
import com.juke.scaner.view.IMainView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 主页业务层
 * Created by Gavin
 * 2018/9/26
 */
public class MainPresenter extends Presenter<IMainView> implements MainContract.Presenter {
    private MainModel mainModel;
    private String[] groupIds = new String[]{"1", "2"};
    private List<CinemaInfo.ContentBean.CinemasBean> cinemas = new ArrayList();
    private String groupId;
    private CinemaInfo.ContentBean.CinemasBean cinemasBean;

    public MainPresenter() {
        mainModel = new MainModel();
    }

    @Override
    public void getMainData(Map<String, String> map) {
        mainModel.getMainData(map, new RxObserver());
    }

    public String[] getGroupIds() {
        return groupIds;
    }

    public String[] getCinemaList() {
        String[] cinemaNames = new String[cinemas.size()];
        for (int i = 0, len = cinemas.size(); i < len; i++) {
            cinemaNames[i] = cinemas.get(i).getTitle();
        }
        return cinemaNames;
    }

    public String setGroupId(int position) {
        this.groupId = groupIds[position];
        return this.groupId;
    }

    public String setCinemasBean(int position) {
        this.cinemasBean = cinemas.get(position);
        return this.cinemasBean.getTitle();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setCinemas(List<CinemaInfo.ContentBean.CinemasBean> cinemas) {
        if (cinemas != null) {
            this.cinemas = cinemas;
        }
    }
}
