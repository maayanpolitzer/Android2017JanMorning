package com.example.hackeru.fragment2;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hackeru on 5/7/2017.
 */

public class MyFragment extends Fragment implements View.OnClickListener {

    private UpdateTextListener listener;
    private TextView nameTV;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        listener = (UpdateTextListener) getActivity();

        Bundle args = getArguments();
        String name = args.getString("NAME");

        nameTV = (TextView) view.findViewById(R.id.fragment_my_text_view);
        nameTV.setText(name);

        nameTV.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        listener.updateText("Moshe");
    }

    public void update(String text) {
        nameTV.setText(text);
    }


}
