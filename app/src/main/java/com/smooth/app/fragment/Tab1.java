package com.smooth.app.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_1,container,false);
        return v;
    }
}