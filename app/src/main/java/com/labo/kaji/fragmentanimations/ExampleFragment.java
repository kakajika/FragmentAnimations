package com.labo.kaji.fragmentanimations;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author kakajika
 * @since 2015/11/27
 */
public class ExampleFragment extends Fragment {

    public enum AnimationType {
        NONE,
        CUBE_UP,
        CUBE_DOWN,
        CUBE_LEFT,
        CUBE_RIGHT,
    }

    public static ExampleFragment newInstance(AnimationType animationType) {
        ExampleFragment f = new ExampleFragment();
        f.setArguments(new Bundle());
        f.getArguments().putSerializable("anim", animationType);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_anim, null);
        int color = Color.rgb((int) Math.floor(Math.random() * 128) + 64,
                              (int) Math.floor(Math.random() * 128) + 64,
                              (int) Math.floor(Math.random() * 128) + 64);
        view.setBackgroundColor(color);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        AnimationType animationType = (AnimationType) getArguments().getSerializable("anim");
        switch (animationType) {
            case NONE:
                return null;
            case CUBE_UP:
                return new VerticalCubeAnimation(VerticalCubeAnimation.Direction.UP, enter, 1000);
            case CUBE_DOWN:
                return new VerticalCubeAnimation(VerticalCubeAnimation.Direction.DOWN, enter, 1000);
            case CUBE_LEFT:
                return new HorizontalCubeAnimation(HorizontalCubeAnimation.Direction.LEFT, enter, 1000);
            case CUBE_RIGHT:
                return new HorizontalCubeAnimation(HorizontalCubeAnimation.Direction.RIGHT, enter, 1000);
        }
        return null;
    }

    @OnClick(R.id.buttonUp)
    void onButtonUp() {
        getArguments().putSerializable("anim", AnimationType.CUBE_UP);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, ExampleFragment.newInstance(AnimationType.CUBE_UP));
        ft.commit();
    }

    @OnClick(R.id.buttonDown)
    void onButtonDown() {
        getArguments().putSerializable("anim", AnimationType.CUBE_DOWN);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, ExampleFragment.newInstance(AnimationType.CUBE_DOWN));
        ft.commit();
    }

    @OnClick(R.id.buttonLeft)
    void onButtonLeft() {
        getArguments().putSerializable("anim", AnimationType.CUBE_LEFT);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, ExampleFragment.newInstance(AnimationType.CUBE_LEFT));
        ft.commit();
    }

    @OnClick(R.id.buttonRight)
    void onButtonRight() {
        getArguments().putSerializable("anim", AnimationType.CUBE_RIGHT);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, ExampleFragment.newInstance(AnimationType.CUBE_RIGHT));
        ft.commit();
    }

}
