package com.maayanpolitzer.whatsapp.connections;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.maayanpolitzer.whatsapp.R;
import com.maayanpolitzer.whatsapp.infrastructure.DBOpenHelper;


/**
 * Created by Hackeru on 5/21/2017.
 */

public class UsersAdapter extends CursorAdapter {

    public UsersAdapter(Context context, Cursor cursor){
        super(context, cursor, true);
    }

    private class ViewHolder {
        TextView emailTV;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder();
        holder.emailTV = (TextView) view.findViewById(R.id.list_item_email_text_view);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();
        String email = cursor.getString(cursor.getColumnIndex(DBOpenHelper.UsersTable.COL_EMAIL));
        holder.emailTV.setText(email);
    }

}
