package com.v.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v date 2015-1-11
 *
 */
public class ListItemAdapter extends BaseAdapter {
    private List<DataHolder> mDataList = new ArrayList<DataHolder>();
    private LayoutInflater mInflater;
    public ListItemAdapter(Context context,ArrayList<DataHolder> datalist){
        if (datalist != null && datalist.size()>0){
            mDataList.addAll(datalist);
        }
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
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

            convertView = mInflater.inflate(R.layout.list_item, null);
            holder.mTvTitle = (TextView)convertView.findViewById(R.id.item_text);
            holder.mImageView = (ImageView)convertView.findViewById(R.id.item_image_view);
            convertView.setTag(holder);

        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.mImageView.setImageResource(mDataList.get(position).ImageID);
        holder.mTvTitle.setText(mDataList.get(position).title);

        return convertView;
    }

    private class ViewHolder{
        public TextView mTvTitle;
        public ImageView mImageView;
    }
    public static class DataHolder{
        public String title;
        public int ImageID;
        public DataHolder(String title,int imageID){
            this.title = title;
            this.ImageID = imageID;
        }
    }
}
