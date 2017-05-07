package com.example.hackeru.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by hackeru on 5/7/2017.
 */

public class CustomDialogFragment extends DialogFragment implements View.OnClickListener {

    private ImageView imageView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.dialog_custom, null, false);

        Button displayImageButton = (Button) view.findViewById(R.id.dialog_display_image_button);

        imageView = (ImageView) view.findViewById(R.id.dialog_image_view);
        Button closeButton = (Button) view.findViewById(R.id.dialog_close_button);

        displayImageButton.setOnClickListener(this);
        closeButton.setOnClickListener(this);

        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(view)
                .create();

        return dialog;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.dialog_display_image_button) {
            imageView.setImageResource(R.mipmap.ic_launcher);
        }else{
            dismiss();
        }
    }
}
