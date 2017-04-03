package com.example.kuanglin.ochatsukierp.CustomView;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

import com.example.kuanglin.ochatsukierp.Util.Print;

/**
 * Created by KuangLin on 2017/3/20.
 */

public class CustomAutoComplete extends android.support.v7.widget.AppCompatAutoCompleteTextView{

    public CustomAutoComplete(Context context) {
        super(context);
        setShowSoftInputOnFocus(false);
    }

    public CustomAutoComplete(Context context, AttributeSet attrs) {
        super(context, attrs);
        setShowSoftInputOnFocus(false);
    }

    public CustomAutoComplete(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setShowSoftInputOnFocus(false);
    }


    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if(focused) {
            showDropDown();
        }else{
            Print.log("loose focus");
        }
    }
}
