package com.maayanpolitzer.whatsapp.infrastructure;

import android.content.Context;
import android.widget.EditText;

import com.maayanpolitzer.whatsapp.R;

/**
 * Created by maayanpolitzer on 16/05/2017.
 */

public class Validation {

    public static String validateEmail(Context context, EditText et){
        String str = et.getText().toString().trim();
        if (str != null && !str.isEmpty()) {
            return str;
        }
        et.setError(context.getString(R.string.email_error_message));
        return null;
    }

    public static String validatePassword(Context context, EditText et){
        String str = et.getText().toString().trim();
        if (str != null && !str.isEmpty()) {
            return str;
        }
        et.setError(context.getString(R.string.password_error_message));
        return null;
    }



}
