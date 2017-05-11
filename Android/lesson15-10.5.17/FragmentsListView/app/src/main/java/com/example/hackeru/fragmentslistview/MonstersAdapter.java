package com.example.hackeru.fragmentslistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hackeru on 5/10/2017.
 */

public class MonstersAdapter extends ArrayAdapter<Monster> {

    private Context context;
    private Monster[] monsters;

    public MonstersAdapter(Context context, Monster[] monsters){
        super(context, R.layout.list_item, monsters);
        this.context = context;
        this.monsters = monsters;
    }
    

    private class ViewHolder {
        TextView nameTV;
        ImageView imageView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.nameTV = (TextView) convertView.findViewById(R.id.list_item_name_text_view);
            holder.imageView = (ImageView) convertView.findViewById(R.id.list_item_image_view);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.nameTV.setText(monsters[position].getName());
        holder.imageView.setImageResource(monsters[position].getImage());
        return convertView;
    }
}
