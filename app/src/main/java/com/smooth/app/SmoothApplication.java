package com.smooth.app;

import android.app.Application;
import com.esri.android.runtime.ArcGISRuntime;
import com.esri.core.runtime.LicenseLevel;
import com.esri.core.runtime.LicenseResult;
import org.androidannotations.annotations.EApplication;

/**
 * 项目名称：OMSystem
 * 包名称：com.smooth.app
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/10/6-13:46
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@EApplication
public class SmoothApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
