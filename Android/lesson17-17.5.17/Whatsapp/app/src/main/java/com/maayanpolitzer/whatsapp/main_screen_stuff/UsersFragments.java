package com.maayanpolitzer.whatsapp.main_screen_stuff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maayanpolitzer.whatsapp.R;
import com.maayanpolitzer.whatsapp.connections.RequestThread;
import com.maayanpolitzer.whatsapp.infrastructure.BaseActivity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by maayanpolitzer on 20/05/2017.
 */

public class UsersFragments extends Fragment implements RequestThread.Callback {

    private View progressBar;
    private BaseActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users, container, false);

        activity = (BaseActivity) getActivity();

        progressBar = view.findViewById(R.id.fragment_users_progress_bar);

        getUsers();

        return view;
    }

    public void getUsers() {
        JSONObject data = new JSONObject();
        try {
            data.put(activity.USER_ID, activity.settings.getInt(activity.USER_ID, -1));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new RequestThread(
                getActivity(),
                RequestThread.RequestMethod.POST,
                RequestThread.RequestAction.GET_USERS,
                data,
                this
        ).start();
    }

    @Override
    public void onSuccess(JSONObject data) {
        progressBar.setVisibility(View.INVISIBLE);
        Log.d("TAG", data.toString());
    }

    @Override
    public void onFailure(String error) {
        progressBar.setVisibility(View.INVISIBLE);
        Log.d("TAG", error);
    }
}

