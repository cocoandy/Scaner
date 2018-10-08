package com.juke.scaner.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * 带有空视图设置的RecycleAdapter的基类
 * Created by Gavin
 * 2018/7/31.
 */

public abstract class EmptyRecycle<VH extends RecyclerView.ViewHolder> extends RecycleAdapter<VH> {

    //头部Item的总数
    private int headerCount;

    //空视图的类型
    public static final int VIEW_TYPE_EMPTY = -1;

    public EmptyRecycle(Context context) {
        super(context);
    }


    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_EMPTY) {
            return getEmptyHolder(parent);
        }
        return onCreateHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull final VH holder, final int position) {
        //数据为空不做任何操作
        if (getItemViewType(position) != VIEW_TYPE_EMPTY) {
            //父类是点击操作 但是空视图的时候只要有数据才能点击
            super.onBindViewHolder(holder, position);
        }
    }


    /**
     * headerCount = -1 的时候没有空视图
     * headerCount>=0 在主要数据为空的时候显示空视图
     *
     * @return
     */
    @Override
    public int getItemCount() {
        headerCount = getHeaderCount();
        int count = getCount();
        if (headerCount <= count) { //防止设置了头部个数但是数据源是空的导致越界
            if (count == 0 || count - headerCount == 0) {
                return headerCount + 1;
            }
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        int count = getCount();
        if (headerCount >= 0) {//是否是需要显示空视图
            if (count - headerCount == 0 && position == headerCount) {//确定position是否是空视图项
                return VIEW_TYPE_EMPTY;
            }
        }
        return getItemType(position);
    }


    /**
     * 布局管理
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    /**
     * 返回Item的类型
     */
    public int getItemType(int position) {
        return super.getItemViewType(position);
    }


    /**
     * 返回头布局的个数
     */
    public int getHeaderCount() {
        //默认返回0 表示有空视图 但是没有头布局 返回-1 表示没有空视图
        return 0;
    }


    @Override
    public int getItemSpanSize(GridLayoutManager manager, int position) {
        if (getItemViewType(position) == VIEW_TYPE_EMPTY) {
            //空视图时一个占领所有列数
            return manager.getSpanCount();
        }
        return super.getItemSpanSize(manager, position);
    }

    /**
     * 设置空视图布局
     *
     * @param parent
     * @return
     */
    public abstract VH getEmptyHolder(ViewGroup parent);


}
