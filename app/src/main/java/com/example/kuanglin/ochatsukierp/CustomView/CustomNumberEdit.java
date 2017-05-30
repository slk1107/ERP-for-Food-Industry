package com.example.kuanglin.ochatsukierp.CustomView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kuanglin.ochatsukierp.R;

/**
 * Created by KuangLin on 2017/3/17.
 */

public class CustomNumberEdit extends RelativeLayout implements View.OnClickListener {

    TextView mLabel;
    ImageButton mButtonMinus;
    ImageButton mButtonAdd;
    EditText mEditText;


    public CustomNumberEdit(Context context) {
        super(context);
        initView(context);
    }

    public CustomNumberEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CustomNumberEdit(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    /**
     * -----------------------------------------------------------------------------
     * Setup Views
     * -----------------------------------------------------------------------------
     */


    private void initView(Context context) {
        setupLabel(context);
        setupButtonMinus(context);
        setupEditText(context);
        setupButtonAdd(context);
    }

    private void setupLabel(Context context) {
        LayoutParams params = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        params.addRule(RIGHT_OF, mButtonMinus.getId());
        mLabel = new TextView(context);
        mLabel.setId(View.generateViewId());
        mLabel.setPadding(getPx(8), 0, 0, 0);
        mLabel.setText("數量");
        mLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        setMinimumHeight(0);
        mLabel.setGravity(Gravity.BOTTOM);

        addView(mLabel, params);
    }

    private void setupEditText(Context context) {
        LayoutParams params = new LayoutParams(
                getPx(64), ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RIGHT_OF, mButtonMinus.getId());
        mEditText = new EditText(context);
        mEditText.setId(View.generateViewId());
        mEditText.setPadding(getPx(8), 0, getPx(8), 0);
        mEditText.setHint("0");
        mEditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        setMinimumHeight(0);
        Drawable background = ResourcesCompat.getDrawable(getResources(),R.drawable.bottom_line_background_selector,context.getTheme());
        mEditText.setBackground(background);
        mEditText.setGravity(Gravity.RIGHT);
        mEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        addView(mEditText, params);
    }

    private void setupButtonMinus(Context context) {
        LayoutParams params = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RIGHT_OF, mLabel.getId());
        params.addRule(ALIGN_BOTTOM, mLabel.getId());
        params.setMargins(getPx(8),0,getPx(8),0);
        mButtonMinus = new ImageButton(context);
        mButtonMinus.setId(View.generateViewId());
        mButtonMinus.setMinimumWidth(0);
        mButtonMinus.setImageResource(R.drawable.ic_action_minus);
        mButtonMinus.setBackgroundColor(Color.TRANSPARENT);
        mButtonMinus.setOnClickListener(this);

        addView(mButtonMinus, params);
    }

    private void setupButtonAdd(Context context) {
        LayoutParams params = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RIGHT_OF, mEditText.getId());
        params.addRule(ALIGN_BOTTOM, mLabel.getId());
        params.setMargins(getPx(8),0,getPx(8),0);
        mButtonAdd = new ImageButton(context);
        mButtonAdd.setId(View.generateViewId());
        mButtonAdd.setMinimumWidth(0);
        mButtonAdd.setImageResource(R.drawable.ic_action_add);
        mButtonAdd.setBackgroundColor(Color.TRANSPARENT);
        mButtonAdd.setOnClickListener(this);

        addView(mButtonAdd, params);
    }

    /**
     * -----------------------------------------------------------------------------
     * private Methods
     * -----------------------------------------------------------------------------
     */

    private void changeNum(int change) {
        int currentNum = Integer.valueOf(mEditText.getText().toString());
        currentNum = currentNum + change;
        mEditText.setText(String.valueOf(currentNum));
    }

    private int getPx(float dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }

    /**
     * -----------------------------------------------------------------------------
     * public Methods
     * -----------------------------------------------------------------------------
     */

    public void init(int number, String label) {
        mEditText.setText(String.valueOf(number));
        mLabel.setText(label);
    }


    /**
     * -----------------------------------------------------------------------------
     * Listener
     * -----------------------------------------------------------------------------
     */

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == mButtonAdd.getId()) {
            changeNum(1);
        } else if (id == mButtonMinus.getId()) {
            changeNum(-1);
        }
    }
}


