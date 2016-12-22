package com.v.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v date 2015-1-11
 */
public class SingleChoiceAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<String> mList = new ArrayList<String>();
    public SingleChoiceAdapter(Context context,String[] items){
        mInflater = LayoutInflater.from(context);
        if (items == null || items.length<=0){
            return;
        }
        for(String item:items){
            mList.add(item);
        }
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (convertView == null) {

            holder=new ViewHolder();

            convertView = mInflater.inflate(R.layout.single_choice_item, null);
            holder.mName = (TextView)convertView.findViewById(R.id.single_list_item);
            convertView.setTag(holder);

        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.mName.setText(mList.get(position));

        return convertView;
    }

    private class ViewHolder{
        public TextView  mName;
    }
}
