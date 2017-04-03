package com.example.kuanglin.ochatsukierp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kuanglin.ochatsukierp.CustomView.ViewHolders.HolderPresenter;
import com.example.kuanglin.ochatsukierp.Items.ProductInfo;
import com.example.kuanglin.ochatsukierp.Items.Specification;

import java.util.ArrayList;

/**
 * Created by KuangLin on 2017/3/19.
 */

public class OrderItemRecyclerAdapter extends RecyclerView.Adapter {

    private ArrayList<ProductInfo> productList = new ArrayList<>();
    private int holderId = 0;
    private HolderPresenter hp;


    public OrderItemRecyclerAdapter(int holderId, HolderPresenter hp ){

        this.holderId = holderId;
        this.hp = hp;

        for(int i=0;i<10;i++){
            ProductInfo product = new ProductInfo();
            product.setValue(
                    "有機豆漿"+i,
                    new Specification(i*300+"ml","瓶"),
                    2*i,
                    20*i);
            productList.add(product);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view ;

        view = inflater.inflate(holderId,parent,false);

        return hp.newHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        hp.setHolderView(holder, productList.get(position));
    }

    @Override
    public int getItemCount() {

        return productList.size();
    }



}
