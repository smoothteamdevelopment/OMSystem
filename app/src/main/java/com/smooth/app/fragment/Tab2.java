package com.smooth.app.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;
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


public class Tab2 extends Fragment {
    MapView mMapView;
    FloatingActionButton fab;
//    private final String mTiledServiceUrl = "http://192.168.10.206:6080/arcgis/rest/services/yjcmap/MapServer";
    private final String mTiledServiceUrl = "http://map.ncgl.tk/arcgis/rest/services/yjcmap/MapServer";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_1,container,false);
        mMapView=(MapView)v.findViewById(R.id.map);
        mMapView.addLayer(new ArcGISTiledMapServiceLayer(mTiledServiceUrl));
        fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setType(FloatingActionButton.TYPE_MINI);
        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mMapView != null)
        {
            mMapView.pause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mMapView != null)
        {
            mMapView.unpause();
        }
    }
}