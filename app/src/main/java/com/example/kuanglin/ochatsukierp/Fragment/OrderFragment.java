package com.example.kuanglin.ochatsukierp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kuanglin.ochatsukierp.CustomView.RecyclerView.OrderItemRecyclerAdapter;
import com.example.kuanglin.ochatsukierp.CustomView.RecyclerView.ViewHolders.GoodsTextHolder;
import com.example.kuanglin.ochatsukierp.CustomView.RecyclerView.ViewHolders.HolderPresenter;
import com.example.kuanglin.ochatsukierp.Fragment.Dialog.EditGoodDialog;
import com.example.kuanglin.ochatsukierp.Fragment.Dialog.GoodsOverviewDialog;
import com.example.kuanglin.ochatsukierp.Items.ProductInfo;
import com.example.kuanglin.ochatsukierp.R;
import com.example.kuanglin.ochatsukierp.Util.Tools;

/**
 * Created by KuangLin on 2017/2/27.
 */

public class OrderFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener, HolderPresenter {


    public static OrderFragment newInstance() {
        return new OrderFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getActivity().setTitle("訂單");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.order_product_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new OrderItemRecyclerAdapter(R.layout.viewholder_goods_text, this));
        Button mBtPopOverView = (Button) view.findViewById(R.id.button_pop_overview);
        mBtPopOverView.setOnClickListener(this);

        Tools.hideKeyboardWhenTouch(view, getActivity());
    }


    @Override
    public void onClick(View view) {
        DialogFragment overviewFragment = GoodsOverviewDialog.newInstance();
        overviewFragment.show(getActivity().getSupportFragmentManager(), "overview");
    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }

    @Override
    public RecyclerView.ViewHolder newHolder(View view) {
        return new GoodsTextHolder(view);
    }

    @Override
    public void setHolderView(RecyclerView.ViewHolder holder, Object param) {
        final ProductInfo selectProduct = (ProductInfo) param;

        View.OnClickListener onItemClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment editGood = EditGoodDialog.newInstance(selectProduct);
                editGood.setTargetFragment(OrderFragment.this, 0);
                editGood.show(getActivity().getSupportFragmentManager(), "editGood");
            }
        };
        ((GoodsTextHolder) holder).setView(selectProduct, onItemClick);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            ProductInfo editProduct = (ProductInfo) data.getSerializableExtra(
                    "editProduct");

        }
    }
}
