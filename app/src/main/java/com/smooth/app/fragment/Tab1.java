package com.smooth.app.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.melnykov.fab.FloatingActionButton;
import com.smooth.app.R;

/**
 * 项目名称：OMSystem
 * 包名称：com.smooth.app.fragment
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/10/5-14:48
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */


public class Tab1 extends Fragment {
    ListView listView;
    FloatingActionButton fab;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_2,container,false);
        listView = (ListView) v.findViewById(android.R.id.list);
        fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.attachToListView(listView);
        fab.setType(FloatingActionButton.TYPE_MINI);
        return v;
    }
}