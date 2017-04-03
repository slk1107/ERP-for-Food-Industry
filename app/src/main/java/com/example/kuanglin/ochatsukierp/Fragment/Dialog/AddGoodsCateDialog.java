package com.example.kuanglin.ochatsukierp.Fragment.Dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kuanglin.ochatsukierp.R;
import com.example.kuanglin.ochatsukierp.Util.Tools;

/**
 * Created by KuangLin on 2017/2/27.
 */

public class AddGoodsCateDialog extends DialogFragment{

    public AddGoodsCateDialog(){}
    public static AddGoodsCateDialog newInstance() {
//        Bundle bundle = new Bundle();
//        bundle.putString("title",title);
        return new AddGoodsCateDialog();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_goods_catagory,container,false);
        initView(view);
        return view;
    }

    private void initView(View view){
        Tools.hideKeyboardWhenTouch(view,getActivity());
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }
}
