package com.example.kuanglin.ochatsukierp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kuanglin.ochatsukierp.R;

/**
 * Created by KuangLin on 2017/2/27.
 */

public class OrderFragment extends Fragment {
    Button mBtAddProduct;


    public static OrderFragment newInstance() {
        OrderFragment orderFragment = new OrderFragment();
        return orderFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getActivity().setTitle("訂單");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order,container,false);
        initView();
        return view;
    }

    private void initView(){

    }
}
