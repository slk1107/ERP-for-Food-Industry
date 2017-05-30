package com.example.kuanglin.ochatsukierp.Fragment.Dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.kuanglin.ochatsukierp.CustomView.CustomNumberEdit;
import com.example.kuanglin.ochatsukierp.Items.ProductInfo;
import com.example.kuanglin.ochatsukierp.R;
import com.example.kuanglin.ochatsukierp.Util.Tools;

/**
 * Created by KuangLin on 2017/3/29.
 */

public class EditGoodDialog extends DialogFragment implements View.OnClickListener {

    ProductInfo product;


    public static EditGoodDialog newInstance(ProductInfo product) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("product", product);
        EditGoodDialog dialog = new EditGoodDialog();
        dialog.setArguments(bundle);
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        product = (ProductInfo) bundle.getSerializable("product");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_edit_good, container, false);

        initView(view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    private void initView(View view) {
        TextView mTxtProductName = (TextView) view.findViewById(R.id.text_dialog_edit_good_product_name);
        TextView mTxtSpec = (TextView) view.findViewById(R.id.text_dialog_edit_good_spec);
        CustomNumberEdit mNumAmount = (CustomNumberEdit) view.findViewById(R.id.number_dialog_edit_good_amount);
        CustomNumberEdit mNumPrice = (CustomNumberEdit) view.findViewById(R.id.number_dialog_edit_good_price);
        Button mBtOk = (Button) view.findViewById(R.id.button_dialog_edit_done);
        Button mBtCancel = (Button) view.findViewById(R.id.button_dialog_edit_cancel);
        mTxtProductName.setText(product.getName());
        mTxtSpec.setText(product.getSpec().toString());
        mNumAmount.init(product.getAmount(), "數量");
        mNumPrice.init(product.getPrice(), "價格");
        mBtOk.setOnClickListener(this);
        mBtCancel.setOnClickListener(this);
        Tools.hideKeyboardWhenTouch(view, getActivity());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_dialog_edit_done:
                sendResult(0, product);
                break;
            case R.id.button_dialog_edit_cancel:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
        }

    }

    private void sendResult(int REQUEST_CODE, ProductInfo sentProduct) {
        Intent intent = new Intent();
        intent.putExtra("editProduct", sentProduct);
        getTargetFragment().onActivityResult(
                getTargetRequestCode(), REQUEST_CODE, intent);
    }
}
