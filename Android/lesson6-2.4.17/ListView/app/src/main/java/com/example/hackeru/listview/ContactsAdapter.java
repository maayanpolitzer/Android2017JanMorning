package com.example.hackeru.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hackeru on 4/2/2017.
 */

class ContactsAdapter extends ArrayAdapter<Contact>{

    private Context context;
    private Contact[] contacts;

    public ContactsAdapter(Context context, Contact[] contacts){
        super(context, R.layout.list_item, contacts);
        this.context = context;
        this.contacts = contacts;
    }

    private class ViewHolder {
        TextView nameTV;
        TextView phoneTV;
        ImageView iconIV;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder.nameTV = (TextView) convertView.findViewById(R.id.list_item_name_text_view);
            viewHolder.phoneTV = (TextView) convertView.findViewById(R.id.list_item_phone_text_view);
            viewHolder.iconIV = (ImageView) convertView.findViewById(R.id.list_item_image_view);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.nameTV.setText(contacts[position].getName());
        viewHolder.phoneTV.setText(contacts[position].getPhone());
        viewHolder.iconIV.setImageResource(contacts[position].getImage());
        if (contacts[position].isWhiteBackgound()){
            // change background to white...
        }else{
            // change background to blue...
        }
        return convertView;
    }
}
