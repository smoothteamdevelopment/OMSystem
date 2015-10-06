package com.smooth.app.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.esri.android.runtime.ArcGISRuntime;
import com.esri.core.runtime.LicenseLevel;
import com.esri.core.runtime.LicenseResult;
import com.smooth.app.R;
import com.smooth.app.fragment.MessageDialogFragment;
import com.smooth.app.interfaces.SysPrefs_;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.res.AnimationRes;
import org.androidannotations.annotations.sharedpreferences.Pref;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.activity
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/26-15:24
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@EActivity(R.layout.activity_welcome)
public class WelcomeActivity extends Activity {
    Context context;
    @ViewById(R.id.iv_welcome)
    ImageView iv_welcome;
    @Pref
    SysPrefs_ sysPrefs;
    @AnimationRes
    Animation login_anim;
    private static final String CLIENT_ID = "fuMPMC61j43x4OMW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @AfterInject
    void afterInject() {
       this.context=this.getApplicationContext();
    }

    @AfterViews
    void initView() {
        iv_welcome.setAnimation(login_anim);
        iv_welcome.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isFirst = sysPrefs.isFirst().get();
                if (isFirst) {
//                    SDManager manager = new SDManager(context);
//                    manager.moveUserIcon();
                    sysPrefs.edit().isFirst().put(false);
                    Intent intent = new Intent(context, LoginActivity_.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(context, LoginActivity_.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);
        licenseResultInit();
    }

    @UiThread
    void licenseResultInit() {
        LicenseResult licenseResult = ArcGISRuntime.setClientId(CLIENT_ID);

        LicenseLevel licenseLevel = ArcGISRuntime.License.getLicenseLevel();

        if (licenseResult == LicenseResult.VALID && licenseLevel == LicenseLevel.BASIC) {
//            MessageDialogFragment.showMessage(getString(R.string.basic_license_succeeded), getFragmentManager());
        } else {
            MessageDialogFragment.showMessage(getString(R.string.valid_client_id_required), getFragmentManager());
        }
    }

}
