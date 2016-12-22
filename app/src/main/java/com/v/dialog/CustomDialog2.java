package com.v.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by enwei.zew on 2015/1/13.
 */
public class CustomDialog2 extends Dialog implements View.OnClickListener{

	//增加一个回调函数,用以从外部接收返回值
    public interface ICustomDialogEventListener {
        public void customDialogEvent(int id);
    }

    private ICustomDialogEventListener mCustomDialogEventListener;
    private Context mContext;
    private String mStr;

    public CustomDialog2(Context context) {
        super(context);
        mContext = context;
    }

    public CustomDialog2(Context context, String str,ICustomDialogEventListener listener,int theme) {
        super(context, theme);
        mContext = context;
        mStr = str;
        mCustomDialogEventListener = listener;
    }
    private void bindImageClickEvent(View layout){
        ImageView img1 = (ImageView)layout.findViewById(R.id.dialog_image1);
        ImageView img2 = (ImageView)layout.findViewById(R.id.dialog_image2);
        ImageView img3 = (ImageView)layout.findViewById(R.id.dialog_image3);
        ImageView img4 = (ImageView)layout.findViewById(R.id.dialog_image4);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_dialog_2, null);

        TextView tv = (TextView)layout.findViewById(R.id.dialog_text);
        tv.setText(mStr);

        bindImageClickEvent(layout);

        this.setContentView(layout);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        int drawableID = -1;
        switch (id){
            case R.id.dialog_image1:
                drawableID = R.drawable.animal1;
                break;
            case R.id.dialog_image2:
                drawableID = R.drawable.animal2;
                break;
            case R.id.dialog_image3:
                drawableID = R.drawable.animal3;
                break;
            case R.id.dialog_image4:
                drawableID = R.drawable.animal4;
                break;
        }
        if (drawableID != -1) {
            mCustomDialogEventListener.customDialogEvent(drawableID);
        }
        dismiss();
    }
}
