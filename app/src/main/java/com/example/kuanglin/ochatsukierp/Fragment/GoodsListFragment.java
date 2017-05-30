package com.example.kuanglin.ochatsukierp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kuanglin.ochatsukierp.CustomView.RecyclerView.OrderItemRecyclerAdapter;
import com.example.kuanglin.ochatsukierp.CustomView.RecyclerView.ViewHolders.GoodsEditHolder;
import com.example.kuanglin.ochatsukierp.CustomView.RecyclerView.ViewHolders.HolderPresenter;
import com.example.kuanglin.ochatsukierp.Items.ProductInfo;
import com.example.kuanglin.ochatsukierp.R;
import com.example.kuanglin.ochatsukierp.Util.Tools;

/**
 * Created by KuangLin on 2017/2/27.
 */

public class GoodsListFragment extends Fragment implements HolderPresenter{
    String title = "";

    public GoodsListFragment(){}
    public static GoodsListFragment newInstance() {
        return new GoodsListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        title = bundle.getString("title");

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.goods_list,container,false);
        initView(view);
        return view;
    }

    private void initView(View view){
        RecyclerView goodsList = (RecyclerView)view.findViewById(R.id.recycler_goods_list);
        goodsList.setLayoutManager(new LinearLayoutManager(getContext()));
        goodsList.setAdapter(new OrderItemRecyclerAdapter(R.layout.viewholder_goods_edit,this));
        Tools.hideKeyboardWhenTouch(view,getActivity());
    }

    @Override
    public RecyclerView.ViewHolder newHolder(View view) {
        return new GoodsEditHolder(view);
    }

    @Override
    public void setHolderView(RecyclerView.ViewHolder holder, Object param) {
        ((GoodsEditHolder) holder).setView((ProductInfo) param);
    }

}
