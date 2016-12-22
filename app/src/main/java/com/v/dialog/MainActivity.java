package com.v.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity
        implements View.OnClickListener, DialogInterface.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowAlert = (Button) findViewById(R.id.btn_show_alert);
        btnShowAlert.setOnClickListener(this);

        Button btnSetViewDynamic = (Button) findViewById(R.id.btn_set_view_dynamic);
        btnSetViewDynamic.setOnClickListener(this);

        Button btnStyleOne = (Button) findViewById(R.id.btn_style_1);
        btnStyleOne.setOnClickListener(this);

        Button btnStyleTwo = (Button) findViewById(R.id.btn_style_2);
        btnStyleTwo.setOnClickListener(this);

        Button btnStyleThree = (Button) findViewById(R.id.btn_style_3);
        btnStyleThree.setOnClickListener(this);

        Button btnStyleFour = (Button) findViewById(R.id.btn_style_4);
        btnStyleFour.setOnClickListener(this);

        Button btnStyleFive = (Button) findViewById(R.id.btn_style_5);
        btnStyleFive.setOnClickListener(this);

        Button btnStyleSix = (Button) findViewById(R.id.btn_style_6);
        btnStyleSix.setOnClickListener(this);

        Button btn = (Button)findViewById(R.id.btn_pop_dialog);
        btn.setOnClickListener(this);

        Button btn1 = (Button)findViewById(R.id.btn_pop_dialog_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog2 dialog = new  CustomDialog2(MainActivity.this,"From btn 1",new CustomDialog2.ICustomDialogEventListener() {
                    @Override
                    public void customDialogEvent(int id) {
                        ImageView imageView = (ImageView)findViewById(R.id.main_image);
                        imageView.setImageDrawable(getResources().getDrawable(id));
                    }
                },R.style.dialog);
                dialog.show();
            }
        });

        Button btn2 = (Button)findViewById(R.id.btn_pop_dialog_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog2 dialog = new  CustomDialog2(MainActivity.this,"From btn 2",new CustomDialog2.ICustomDialogEventListener() {
                    @Override
                    public void customDialogEvent(int id) {
                        ImageView imageView = (ImageView)findViewById(R.id.main_image);
                        imageView.setImageDrawable(getResources().getDrawable(id));
                    }
                },R.style.dialog);
                dialog.show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_show_alert) {
            showAlert();
        } else if (v.getId() == R.id.btn_set_view_dynamic) {
            setViewDynamic();
        } else if (v.getId() == R.id.btn_style_1) {
            showStyleOne();
        } else if (v.getId() == R.id.btn_style_2) {
            showStyleTwo();
        } else if (v.getId() == R.id.btn_style_3) {
            showSingleChoiceItems();
        } else if (v.getId() == R.id.btn_style_4) {
            showMultiChoiceItems();
        } else if (v.getId() == R.id.btn_style_5) {
            createCustomList();
        } else if (v.getId() == R.id.btn_style_6) {
            createSingleCustom();
        } else if (v.getId() == R.id.btn_pop_dialog) {
            CustomDialog1 dialog = new CustomDialog1(MainActivity.this);
            dialog.show();
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE: {
                Toast.makeText(MainActivity.this,"ok click", Toast.LENGTH_SHORT).show();
            }
            break;
            case DialogInterface.BUTTON_NEGATIVE: {
                Toast.makeText(MainActivity.this,"cancel click", Toast.LENGTH_SHORT).show();
            }
            break;
            default:
                break;
        }
    }

    private void showAlert() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.ic_launcher); //添加ICON
        builder.setTitle("退出");                 //添加标题
        builder.setMessage("你确定要离开吗？");     //添加MSG

        builder.setPositiveButton("确定", this);

        builder.setNegativeButton("取消", this);

        builder.setNeutralButton("中间BTN",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int whichButton) {
                Toast.makeText(MainActivity.this,"center click", Toast.LENGTH_SHORT).show();
            }
        });

        //添加自定义View
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.alert_custom_view, null);
        builder.setView(view);

        builder.create();
        builder.show();

    }

    private void setViewDynamic() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.ic_launcher); //添加ICON
        builder.setTitle("退出");                 //添加标题
        builder.setMessage("你确定要离开吗？");     //添加MSG

        LinearLayout root_lin=new LinearLayout(MainActivity.this);
        root_lin.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams LP_FW = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        root_lin.setLayoutParams(LP_FW);

        ImageView imageView = new ImageView(MainActivity.this);
        imageView.setImageResource(R.drawable.ic_launcher);
        imageView.setLayoutParams(LP_FW);
        root_lin.addView(imageView);

        TextView tv = new TextView(MainActivity.this);
        tv.setText("机器人");
        tv.setTextSize(20);
        tv.setLayoutParams(LP_FW);
        root_lin.addView(tv);

        builder.setView(root_lin);
        builder.create();
        builder.show();
    }

    private void showStyleOne() {
        String[] mItems = {"item0", "item1", "item2", "item3", "item4", "item5", "item6"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("使用列表字符串");
        builder.setItems(mItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "clicked:" + which, Toast.LENGTH_SHORT).show();
            }
        });
        builder.create();
        builder.show();
    }

    private void showStyleTwo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("使用Resource ID");
        builder.setItems(R.array.dialog_items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "clicked:" + which, Toast.LENGTH_SHORT).show();
            }
        });
        builder.create();
        builder.show();
    }

    private void showSingleChoiceItems() {
        String[] mItems = {"攻", "受", "全能型", "不告诉你"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("你懂的");
        builder.setSingleChoiceItems(mItems, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "clicked:" + which, Toast.LENGTH_SHORT).show();
            }
        });
        builder.create();
        builder.show();
    }

    private void showMultiChoiceItems() {
        String[] mItems = {"经常犯二", "傻叉一枚", "逗逼", "小清纯", "沉稳大叔", "有时可爱"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("性格类型");
        builder.setMultiChoiceItems(mItems,
                new boolean[]{false, false, false, false, false, false, false},
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(MainActivity.this, "clicked:" + which, Toast.LENGTH_SHORT).show();
                    }
                }
        );
        builder.show();
    }


    private ArrayList<ListItemAdapter.DataHolder> initDataHolder(){
        ArrayList<ListItemAdapter.DataHolder> datalist = new ArrayList<>();
        ListItemAdapter.DataHolder data_1 = new ListItemAdapter.DataHolder("可爱萌宠1", R.drawable.animal1);
        ListItemAdapter.DataHolder data_2 = new ListItemAdapter.DataHolder("可爱萌宠2", R.drawable.animal2);
        ListItemAdapter.DataHolder data_3 = new ListItemAdapter.DataHolder("可爱萌宠3", R.drawable.animal3);
        ListItemAdapter.DataHolder data_4 = new ListItemAdapter.DataHolder("可爱萌宠4", R.drawable.animal4);
        datalist.add(data_1);
        datalist.add(data_2);
        datalist.add(data_3);
        datalist.add(data_4);
        return datalist;
    }

    private void createCustomList() {
        ArrayList<ListItemAdapter.DataHolder> dataHolders = initDataHolder();
        ListItemAdapter adapter = new ListItemAdapter(MainActivity.this, dataHolders);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("可爱萌宠");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(MainActivity.this, "clicked:" + which, Toast.LENGTH_SHORT).show();
            }
        });
        builder.create();
        builder.show();
    }

    private void createSingleCustom(){
        String[] mItems = {"攻", "受", "全能型", "不告诉你"};
        SingleChoiceAdapter adapter = new SingleChoiceAdapter(MainActivity.this,mItems);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("可爱萌宠");
        builder.setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(MainActivity.this, "clicked:" + which, Toast.LENGTH_SHORT).show();
            }
        });
        builder.create();
        builder.show();
    }

}
