package com.v.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by v on 2015/1/13.
 */
public class CustomDialog1 extends Dialog {
    Context mContext;
    public CustomDialog1(Context context){
        super(context);
        mContext = context;
    }
    public CustomDialog1(Context context, int theme) {
        super(context, theme);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_dialog_1, null);
        this.setContentView(layout);
    }
}
