package com.example.kuanglin.ochatsukierp.CustomView.ViewHolders;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kuanglin.ochatsukierp.Items.ProductInfo;
import com.example.kuanglin.ochatsukierp.R;

/**
 * Created by KuangLin on 2017/3/26.
 */

public class GoodsEditHolder extends RecyclerView.ViewHolder {

    private TextView mTextName;
    private TextView mTextSpec;
    private EditText mTextAmount;
    private TextView mTextPrice;

    public GoodsEditHolder(View itemView) {
        super(itemView);
        mTextName = (TextView) itemView.findViewById(R.id.goods_edit_name);
        mTextSpec = (TextView) itemView.findViewById(R.id.goods_edit_spec);
        mTextAmount = (EditText) itemView.findViewById(R.id.goods_edit_amount);
        mTextPrice = (TextView) itemView.findViewById(R.id.goods_edit_price);
        final View rootView = itemView.findViewById(R.id.goods_edit_group);

        mTextAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                rootView.setBackgroundColor(Color.parseColor("#FF00FFFF"));
            }
        });
    }

    public void setView(ProductInfo product) {
        mTextName.setText(product.getName());
        mTextSpec.setText(product.getSpec().toString());
        mTextPrice.setText(String.valueOf(product.getPrice()));
    }

}
