package com.example.kuanglin.ochatsukierp.Util;

import android.util.Log;

/**
 * Created by KuangLin on 2017/3/21.
 */

public class Print {
    public static void log(Object msg){
//        if(BuildConfig.DEBUG) {
            Log.d("ERPAct", String.valueOf(msg));
//        }
    }
}
