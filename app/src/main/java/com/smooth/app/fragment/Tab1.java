package com.smooth.app.fragment;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import com.melnykov.fab.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
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

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_2,container,false);
        listView = (ListView) v.findViewById(android.R.id.list);
        final ImageView fabIconNew = new ImageView(this.getActivity());
        fabIconNew.setImageDrawable(this.getActivity().getResources().getDrawable(R.drawable.ic_action_new_light,getContext().getTheme()));
        final com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton rightLowerButton = new com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.Builder(this.getActivity())
                .setContentView(fabIconNew)
                .build();
        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this.getActivity());
        ImageView rlIcon1 = new ImageView(this.getActivity());
        ImageView rlIcon2 = new ImageView(this.getActivity());
        ImageView rlIcon3 = new ImageView(this.getActivity());
        ImageView rlIcon4 = new ImageView(this.getActivity());

        rlIcon1.setImageDrawable(this.getActivity().getResources().getDrawable(R.drawable.ic_action_chat_light,getContext().getTheme()));
        rlIcon2.setImageDrawable(this.getActivity().getResources().getDrawable(R.drawable.ic_action_camera_light,getContext().getTheme()));
        rlIcon3.setImageDrawable(this.getActivity().getResources().getDrawable(R.drawable.ic_action_video_light,getContext().getTheme()));
        rlIcon4.setImageDrawable(this.getActivity().getResources().getDrawable(R.drawable.ic_action_place_light,getContext().getTheme()));
        final FloatingActionMenu rightLowerMenu = new FloatingActionMenu.Builder(this.getActivity())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon1).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon2).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon3).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon4).build())
                .attachTo(rightLowerButton)
                .build();
        rightLowerMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
            @Override
            public void onMenuOpened(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees clockwise
                fabIconNew.setRotation(0);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 45);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconNew, pvhR);
                animation.start();
            }

            @Override
            public void onMenuClosed(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees counter-clockwise
                fabIconNew.setRotation(45);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconNew, pvhR);
                animation.start();
            }
        });
        return v;
    }
}