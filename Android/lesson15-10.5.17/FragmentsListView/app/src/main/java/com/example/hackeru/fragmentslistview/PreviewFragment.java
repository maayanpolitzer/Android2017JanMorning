package com.example.hackeru.fragmentslistview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hackeru on 5/10/2017.
 */

public class PreviewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preview, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.fragment_preview_image_view);
        TextView textView = (TextView) view.findViewById(R.id.fragment_preview_text_view);

        Bundle args = getArguments();

        imageView.setImageResource(args.getInt("IMAGE"));
        textView.setText(args.getString("NAME"));

        return view;
    }
}
