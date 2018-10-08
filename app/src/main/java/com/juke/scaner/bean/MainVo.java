package com.juke.scaner.bean;

import com.google.gson.annotations.SerializedName;
import com.juke.scaner.base.BaseInfo;

/**
 * Created by Gavin
 * 2018/9/29
 */
public class MainVo extends BaseInfo {
    @SerializedName("group_id")
    String groupId;

    public MainVo(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }
}
