package com.mine.tiku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FenAdapter extends ArrayAdapter {
    private List<FenBean.FenBean2> list;
    private int resourceId;

    public FenAdapter(@NonNull Context context, int resource, List<FenBean.FenBean2> list) {
        super(context, resource);
        resourceId = resource;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();

    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resourceId, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_ti1.setText((position + 1) + "");
        holder.tv_ti2.setText(list.get(position).getFen() + "");
        long time = list.get(position).getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(time);
        String stime = simpleDateFormat.format(date);
        holder.tv_ti3.setText(stime);
        return convertView;
    }

    class ViewHolder {
        TextView tv_ti1;
        TextView tv_ti2;
        TextView tv_ti3;

        public ViewHolder(View v) {
            tv_ti1 = v.findViewById(R.id.tv_ti1);
            tv_ti2 = v.findViewById(R.id.tv_ti2);
            tv_ti3 = v.findViewById(R.id.tv_ti3);
        }
    }
}
