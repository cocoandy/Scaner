package com.juke.scaner.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juke.scaner.listener.OnRecycleItemListener;
import com.juke.scaner.listener.OnRecycleItemLongListener;
import com.juke.scaner.listener.OnViewClickListener;

import butterknife.ButterKnife;

/**
 * 添加Item点击操作
 * Created by 曹小贼 on 2018/9/4.
 */

public abstract class RecycleAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    //上下文
    public Context context;

    //Item的点击事件
    public OnRecycleItemListener onRecycleItemListener;

    //item长按事件
    public OnRecycleItemLongListener onRecycleItemLongListener;

    //控件的点击事件
    public OnViewClickListener onViewClickListener;

    public RecycleAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return onCreateHolder(parent, viewType);
    }

    @Override
    public int getItemCount() {
        return getCount();
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, final int position) {
        initClick(holder, position);
        onBindViewData(holder, position);
    }

    /**
     * 添加item事件 长按和点击
     * @param holder
     * @param position
     */
    public void initClick(VH holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onRecycleItemListener != null) {
                    onRecycleItemListener.OnItemClick(v, position);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onRecycleItemLongListener != null) {
                    return onRecycleItemLongListener.OnItemLongClick(v, position);
                }
                return false;
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        final RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemSpanSize(gridManager, position);
                }
            });


        }
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
     * 数据绑定
     */
    public abstract void onBindViewData(VH holder, int position);

    /**
     * 绑定Item布局
     */
    public abstract VH onCreateHolder(@NonNull ViewGroup parent, int viewType);

    /**
     * 返回数据源的item总数
     */
    public abstract int getCount();

    /**
     * 获取网格布局一个Item占用多少列
     * 默认是一个
     */
    public int getItemSpanSize(GridLayoutManager gridManager, int position) {
        return 1;
    }

    /**
     * 产生ViewHolder的View
     *
     * @param res
     * @return
     */
    public View getItemView(ViewGroup parent, int res) {
        return LayoutInflater.from(context).inflate(res, parent, false);
    }

    /**
     * 产生ViewHolder的View
     *
     * @param res
     * @return
     */
    public View getItemView(ViewGroup parent, int res, boolean attachToRoot) {
        return LayoutInflater.from(context).inflate(res, parent, attachToRoot);
    }


    /**
     * Item点击事件监听
     *
     * @param onRecycleItemListener
     */
    public void setOnRecycleItemListener(OnRecycleItemListener onRecycleItemListener) {
        this.onRecycleItemListener = onRecycleItemListener;
    }

    /**
     * 长按事件监听
     *
     * @param onRecycleItemLongListener
     */
    public void setOnRecycleItemLongListener(OnRecycleItemLongListener onRecycleItemLongListener) {
        this.onRecycleItemLongListener = onRecycleItemLongListener;
    }

    /**
     * Item的View的点击事件监听
     *
     * @param onViewClickListener
     */
    public void setOnViewClickListener(OnViewClickListener onViewClickListener) {
        this.onViewClickListener = onViewClickListener;
    }


}
