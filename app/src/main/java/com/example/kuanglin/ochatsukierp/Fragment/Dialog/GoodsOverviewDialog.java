package com.example.kuanglin.ochatsukierp.Fragment.Dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.kuanglin.ochatsukierp.Adapter.OchaPagerAdapter;
import com.example.kuanglin.ochatsukierp.CustomView.CustomAutoComplete;
import com.example.kuanglin.ochatsukierp.Fragment.GoodsListFragment;
import com.example.kuanglin.ochatsukierp.Items.ProductInfo;
import com.example.kuanglin.ochatsukierp.Items.Specification;
import com.example.kuanglin.ochatsukierp.R;
import com.example.kuanglin.ochatsukierp.Util.Tools;

import java.util.ArrayList;

/**
 * Created by KuangLin on 2017/3/29.
 */

public class GoodsOverviewDialog extends DialogFragment implements View.OnClickListener,View.OnLongClickListener{

    Button mBtAddProduct;
    EditText mEdTProductName;
    CustomAutoComplete mAutoTxtSpec;
    AutoCompleteTextView mAutoTxtAmount, mAutoTxtPrice;

    ArrayList<Specification> specList = new ArrayList<>();
    ArrayList<Integer> amountList = new ArrayList<>();
    ArrayList<Integer> priceList = new ArrayList<>();

    ArrayList<Fragment> goodsListFragments = new ArrayList<>();

    public static GoodsOverviewDialog newInstance(){
        return new GoodsOverviewDialog();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAutoCompleteList();
        goodsListFragments.addAll(getList());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_goods_overview,container,false);

        initView(view);


        return view;
    }

    private void initView(View view){

        mBtAddProduct = (Button) view.findViewById(R.id.order_button_add_product);
        mEdTProductName = (EditText) view.findViewById(R.id.order_textview_input_product_name);
        mAutoTxtSpec = (CustomAutoComplete) view.findViewById(R.id.order_auto_textview_input_product_Specification);
        mAutoTxtAmount = (AutoCompleteTextView) view.findViewById(R.id.order_auto_textview_input_product_amount);
        mAutoTxtPrice = (CustomAutoComplete) view.findViewById(R.id.order_auto_textview_input_product_price);

        mAutoTxtSpec.setOnLongClickListener(this);

        mAutoTxtSpec.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, specList));
        mAutoTxtAmount.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, amountList));
        mAutoTxtPrice.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, priceList));
        mBtAddProduct.setOnClickListener(this);

        if (goodsListFragments.size() > 0) {
            ViewPager mViewPager = (ViewPager) view.findViewById(R.id.view_pager_test);
            OchaPagerAdapter pagerAdapter = new OchaPagerAdapter(
                    getChildFragmentManager(), goodsListFragments);
//                    getActivity().getSupportFragmentManager(), goodsListFragments);
            mViewPager.setAdapter(pagerAdapter);
            TabLayout tabLayout = (TabLayout) view.findViewById(R.id.pager_tab_test);
            tabLayout.setupWithViewPager(mViewPager);
        }
    }

    private ArrayList<Fragment> getList(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String title = "產品" + i;
            Fragment goodsFragment = GoodsListFragment.newInstance();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            goodsFragment.setArguments(bundle);
            fragments.add(goodsFragment);
        }
        Fragment addFragment = AddGoodsCateDialog.newInstance();
        Bundle bundle = new Bundle();
        bundle.putString("title", "＋");
        addFragment.setArguments(bundle);
        fragments.add(addFragment);

        return fragments;
    }

    private void getAutoCompleteList() {

        specList.add(new Specification("6粒", "盒"));
        specList.add(new Specification("400g", "盒"));
        amountList.add(12);
        amountList.add(5);
        priceList.add(65);
        priceList.add(35);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.order_button_add_product:
                ProductInfo addProduct = new ProductInfo();
                addProduct.setValue(
                        mEdTProductName.getText().toString(),
                        Specification.parseSpecFromString(mAutoTxtSpec.getText().toString()),
                        Integer.valueOf(mAutoTxtAmount.getText().toString()),
                        Integer.valueOf(mAutoTxtPrice.getText().toString())
                );
                break;
        }
    }

    @Override
    public boolean onLongClick(View view) {
        Tools.showSoftKeyboard(getContext());
        return false;
    }
}
