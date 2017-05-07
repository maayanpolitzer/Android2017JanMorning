package com.example.hackeru.dialogfragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void btnClick(View view) {
        CustomDialogFragment dialog = new CustomDialogFragment();
        dialog.show(getFragmentManager(), null);

        /*
        new AlertDialog.Builder(this)
                .setTitle("This is my title!!!")
                .setIcon(android.R.drawable.ic_lock_idle_alarm)
                .setMessage("Are you sure?\nthis cannot be undone...")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNeutralButton("What???", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(false)
                .show();
                */
    }
}
