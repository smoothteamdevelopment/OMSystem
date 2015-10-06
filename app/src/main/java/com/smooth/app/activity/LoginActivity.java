package com.smooth.app.activity;

/**
 * 项目名称：OMSystem
 * 包名称：com.smooth.app.activity
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/10/6-13:49
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.smooth.app.activity.MainActivity;
import com.smooth.app.R;
import com.smooth.app.bean.*;
import com.smooth.app.event.HttpRestClientErrorHandling;
import com.smooth.app.service.UserService;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.res.*;
import org.androidannotations.annotations.rest.*;


/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.activity
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/26-16:53
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@EActivity(R.layout.activity_login)
public class LoginActivity extends Activity {
    @ViewById(R.id.rl_user)
    RelativeLayout rl_user;
    @Bean
    UserLoginInfoUI userLoginInfoUI;
    @Bean
    HttpRestClientErrorHandling httpRestClientErrorHandling;
    @RestService
    UserService userService;
    @AnimationRes(R.anim.login_anim)
    XmlResourceParser xmlResAnim;

    @AnimationRes
    Animation login_anim;

    @Click(R.id.login)
    void button() {
        douserLoginPost();
    }

    @Background
    void douserLoginPost() {
        WebResult webResult = userService.doUserLogin(userLoginInfoUI.getUserName().getText().toString(), userLoginInfoUI.getUserPass().getText().toString());
        showToast(webResult.getMessage());
        if (webResult.getCode().equals("0001")) {
            loginSueccess();
            userService.setHttpBasicAuth(userLoginInfoUI.getUserName().getText().toString(), userLoginInfoUI.getUserPass().getText().toString());
        }
    }

    @UiThread
    void loginSueccess() {
        Intent intent = new Intent(this.getApplicationContext(), MainActivity_.class);
        startActivity(intent);
        finish();
    }

    /**
     * 利用UI线程显示一个Toast
     *
     * @param content
     */
    @UiThread
    void showToast(String content) {
        Toast.makeText(this.getApplicationContext(), content, Toast.LENGTH_SHORT).show();
    }

    /**
     * 延时显示
     *
     * @param content
     */
    @UiThread(delay = 1000)
    void showToastDelay(String content) {
        Toast.makeText(this.getApplicationContext(), content, Toast.LENGTH_SHORT).show();
    }

    @AfterViews
    void afterViews() {
        rl_user.startAnimation(login_anim);
    }
}