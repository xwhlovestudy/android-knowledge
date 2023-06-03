package com.mine.tiku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class LvAdapter extends ArrayAdapter {
    private List<TiBean> list;
    private int resourceId;

    public LvAdapter(@NonNull Context context, int resource, List<TiBean> list) {
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
        holder.tvTitle.setText(list.get(position).getTi());
        return convertView;
    }

    class ViewHolder {
        TextView tvTitle;

        public ViewHolder(View v) {
            tvTitle = v.findViewById(R.id.tv_ti);
        }
    }
}
