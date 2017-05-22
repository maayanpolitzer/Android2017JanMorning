package com.maayanpolitzer.whatsapp.main_screen_stuff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maayanpolitzer.whatsapp.R;

/**
 * Created by maayanpolitzer on 20/05/2017.
 */

public class ChatsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("TAG", "ChatsFragment onCreateView()");
        View view = inflater.inflate(R.layout.fragment_chats, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "Chats onResume()");
    }
}
