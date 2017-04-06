package com.example.hackeru.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hackeru on 4/5/2017.
 */

public class NamesAdapter extends ArrayAdapter<Person> {

    private Context context;
    private ArrayList<Person> people;

    public NamesAdapter(Context context, ArrayList<Person> people){
        super(context, R.layout.list_item, people);
        this.context = context;
        this.people = people;
    }

    private class ViewHolder {
        TextView nameTV;
        TextView ageTV;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.nameTV = (TextView) convertView.findViewById(R.id.list_item_name_text_view);
            viewHolder.ageTV = (TextView) convertView.findViewById(R.id.list_item_age_text_view);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.nameTV.setText(people.get(position).getName());
        viewHolder.ageTV.setText(people.get(position).getAge() + "");

        return convertView;
    }
}
