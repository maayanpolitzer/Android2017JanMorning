package com.example.hackeru.fragmentslistview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by hackeru on 5/10/2017.
 */

public class MainFragment extends Fragment implements AdapterView.OnItemClickListener {

    private Monster[] monsters = {
            new Monster("Almog", R.drawable.one),
            new Monster("Liad", R.drawable.two),
            new Monster("Leah", R.drawable.three),
            new Monster("Muhamad", R.drawable.four),
            new Monster("Matan", R.drawable.five),
            new Monster("Elhanan", R.drawable.six),
            new Monster("Boris", R.drawable.seven),
            new Monster("Orlane", R.drawable.eight),
            new Monster("Sapir", R.drawable.nine),
            new Monster("Valeri", R.drawable.ten),
            new Monster("Tomer", R.drawable.eleven),
            new Monster("Maayan", R.drawable.twelve)
    };
    private View layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        setContentView(R.layout.fragment_main);
        ListView listView = (ListView) findViewById(R.id.main_fragment_list_view);
        MonstersAdapter adapter = new MonstersAdapter(getActivity(), monsters);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        return layout;
    }

    private void setContentView(@LayoutRes int layoutResID){
        layout = LayoutInflater.from(getActivity()).inflate(layoutResID, null);
    }

    private View findViewById(@IdRes int id){
        return layout.findViewById(id);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putInt("IMAGE", monsters[position].getImage());
        bundle.putString("NAME", monsters[position].getName());
        ((UpdateViewListener) getActivity()).changeDisplay(bundle);
    }
}
