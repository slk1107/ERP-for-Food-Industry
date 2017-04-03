package com.example.kuanglin.ochatsukierp.CustomView;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kuanglin.ochatsukierp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by KuangLin on 2017/3/17.
 */

public class CustomDatePicker extends RelativeLayout implements View.OnClickListener{

    TextView mTextDate;
    ImageButton mButtonMinus;
    ImageButton mButtonAdd;
    Calendar todayDate = Calendar.getInstance();
    String changedDate;
    private String date = "106/12/31";


    public CustomDatePicker(Context context) {
        super(context);
        init(context);
    }

    public CustomDatePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomDatePicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    /**
     * -----------------------------------------------------------------------------
     * Setup Views
     * -----------------------------------------------------------------------------
     */

    private void init(Context context){
        getDate();
        setupButtonMinus(context);
        setupTextDate(context);
        setupButtonAdd(context);
    }

    private void setupButtonMinus(Context context){
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);

         mButtonMinus = new ImageButton(context);
        mButtonMinus.setId(View.generateViewId());
        mButtonMinus.setPadding(8, 8, 8, 8);
        mButtonMinus.setMinimumWidth(0);
        mButtonMinus.setImageResource(R.drawable.ic_down_arrow_selector);
        mButtonMinus.setBackgroundColor(Color.TRANSPARENT);
        mButtonMinus.setOnClickListener(this);

        addView(mButtonMinus, params);
    }

    private void setupTextDate(Context context){
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RIGHT_OF,mButtonMinus.getId());
        mTextDate = new TextView(context);
        mTextDate.setId(View.generateViewId());
        mTextDate.setPadding(8, 8, 8, 8);
        mTextDate.setText(date);
        mTextDate.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        setMinimumHeight(0);
        Drawable background = ResourcesCompat.getDrawable(getResources(),R.drawable.bottom_line_background_selector,context.getTheme());
        mTextDate.setBackground(background);
        mTextDate.setGravity(Gravity.BOTTOM);

        addView(mTextDate, params);

        mTextDate.setOnClickListener(this);
    }

    private void setupButtonAdd(Context context){
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.addRule(RIGHT_OF,mTextDate.getId());
        mButtonAdd = new ImageButton(context);
        mButtonAdd.setId(View.generateViewId());
        mButtonAdd.setPadding(8, 8, 8, 8);
        mButtonAdd.setMinimumWidth(0);
        mButtonAdd.setImageResource(R.drawable.ic_up_arrow_selector);
        mButtonAdd.setBackgroundColor(Color.TRANSPARENT);
        mButtonAdd.setOnClickListener(this);

        addView(mButtonAdd, params);
    }


    /**
     * -----------------------------------------------------------------------------
     * private Methods
     * -----------------------------------------------------------------------------
     */
    private void getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.TAIWAN);
        date = sdf.format(todayDate.getTime());
    }

    private void changeDate(int change){
        todayDate.add(Calendar.DATE, change);

    }

    private void updateDateText(){
        Date tdt = todayDate.getTime();//取得加減過後的Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.TAIWAN);
        changedDate = sdf.format(tdt);
        mTextDate.setText(changedDate);
    }

    /**
     * -----------------------------------------------------------------------------
     * Listener
     * -----------------------------------------------------------------------------
     */

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id==mButtonAdd.getId()) {
            changeDate(1);
            updateDateText();
        }
        else if (id == mButtonMinus.getId()) {
            changeDate(-1);
            updateDateText();
        }
        else if( id == mTextDate.getId()) {
            new DatePickerDialog(view.getContext(), dateSetListener, todayDate
                    .get(Calendar.YEAR), todayDate.get(Calendar.MONTH),
                    todayDate.get(Calendar.DAY_OF_MONTH)).show();
        }
    }


    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            todayDate.set(Calendar.YEAR, year);
            todayDate.set(Calendar.MONTH, monthOfYear);
            todayDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateDateText();
        }
    };


}


