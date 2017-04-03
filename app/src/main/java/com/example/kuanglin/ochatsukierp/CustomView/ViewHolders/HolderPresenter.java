package com.example.kuanglin.ochatsukierp.CustomView.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by KuangLin on 2017/3/26.
 */

public interface HolderPresenter {
    RecyclerView.ViewHolder newHolder(View view);
    void setHolderView(RecyclerView.ViewHolder holder,Object param);
}
