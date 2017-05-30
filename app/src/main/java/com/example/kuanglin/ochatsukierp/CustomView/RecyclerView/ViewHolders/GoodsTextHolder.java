package com.example.kuanglin.ochatsukierp.CustomView.RecyclerView.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.kuanglin.ochatsukierp.Items.ProductInfo;
import com.example.kuanglin.ochatsukierp.R;

/**
 * Created by KuangLin on 2017/3/26.
 */

public class GoodsTextHolder extends RecyclerView.ViewHolder {

    private View rootView;
    private TextView mTextName;
    private TextView mTextSpec;
    private TextView mTextAmount;
    private TextView mTextPrice;

    public GoodsTextHolder(View itemView) {
        super(itemView);
        rootView = itemView;
        mTextName = (TextView) rootView.findViewById(R.id.order_product_list_name);
        mTextSpec = (TextView) rootView.findViewById(R.id.order_product_list_Specification);
        mTextAmount = (TextView) rootView.findViewById(R.id.order_product_list_amount);
        mTextPrice = (TextView) rootView.findViewById(R.id.order_product_list_prise);
    }

    public void setView(ProductInfo product, View.OnClickListener onItemClick) {
        rootView.setOnClickListener(onItemClick);
        mTextName.setText(product.getName());
        mTextSpec.setText(product.getSpec().toString());
        mTextAmount.setText(String.valueOf(product.getAmount()));
        mTextPrice.setText(String.valueOf(product.getPrice()));
    }

}
