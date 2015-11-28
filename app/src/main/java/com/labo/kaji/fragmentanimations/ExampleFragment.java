package com.labo.kaji.fragmentanimations;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import com.labo.kaji.fragmentanimations.animation.CubeAnimation;
import com.labo.kaji.fragmentanimations.animation.FlipAnimation;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author kakajika
 * @since 2015/11/27
 */
public class ExampleFragment extends Fragment {

    @IntDef({NONE, CUBE, FLIP})
    public @interface AnimationMode {}
    public static final int NONE = 0;
    public static final int CUBE = 1;
    public static final int FLIP = 2;

    @IntDef({NODIR, UP, DOWN, LEFT, RIGHT})
    public @interface AnimationDirection {}
    public static final int NODIR = 0;
    public static final int UP    = 1;
    public static final int DOWN  = 2;
    public static final int LEFT  = 3;
    public static final int RIGHT = 4;

    private static final long DURATION = 1000;

    @AnimationMode
    private static int sAnimationMode = CUBE;

    @Bind(R.id.textAnimationMode)
    TextView mTextAnimationMode;

    public static ExampleFragment newInstance(@AnimationDirection int direction) {
        ExampleFragment f = new ExampleFragment();
        f.setArguments(new Bundle());
        f.getArguments().putInt("direction", direction);
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
        setAnimationModeText();
        return view;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        switch (sAnimationMode) {
            case CUBE:
                switch (getArguments().getInt("direction")) {
                    case UP:
                        return CubeAnimation.create(CubeAnimation.UP, enter, DURATION);
                    case DOWN:
                        return CubeAnimation.create(CubeAnimation.DOWN, enter, DURATION);
                    case LEFT:
                        return CubeAnimation.create(CubeAnimation.LEFT, enter, DURATION);
                    case RIGHT:
                        return CubeAnimation.create(CubeAnimation.RIGHT, enter, DURATION);
                }
                break;
            case FLIP:
                switch (getArguments().getInt("direction")) {
                    case UP:
                        return FlipAnimation.create(FlipAnimation.UP, enter, DURATION);
                    case DOWN:
                        return FlipAnimation.create(FlipAnimation.DOWN, enter, DURATION);
                    case LEFT:
                        return FlipAnimation.create(FlipAnimation.LEFT, enter, DURATION);
                    case RIGHT:
                        return FlipAnimation.create(FlipAnimation.RIGHT, enter, DURATION);
                }
                break;
        }
        return null;
    }

    @OnClick(R.id.buttonUp)
    void onButtonUp() {
        getArguments().putInt("direction", UP);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, ExampleFragment.newInstance(UP));
        ft.commit();
    }

    @OnClick(R.id.buttonDown)
    void onButtonDown() {
        getArguments().putInt("direction", DOWN);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, ExampleFragment.newInstance(DOWN));
        ft.commit();
    }

    @OnClick(R.id.buttonLeft)
    void onButtonLeft() {
        getArguments().putInt("direction", LEFT);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, ExampleFragment.newInstance(LEFT));
        ft.commit();
    }

    @OnClick(R.id.buttonRight)
    void onButtonRight() {
        getArguments().putInt("direction", RIGHT);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, ExampleFragment.newInstance(RIGHT));
        ft.commit();
    }

    @OnClick(R.id.textAnimationMode)
    public void switchAnimationMode(View view) {
        switch (sAnimationMode) {
            case CUBE:
                sAnimationMode = FLIP;
                break;
            case FLIP:
            default:
                sAnimationMode = CUBE;
                break;
        }
        setAnimationModeText();
        Snackbar.make(view, "Animation Style is Changed", Snackbar.LENGTH_SHORT).show();
    }

    private void setAnimationModeText() {
        switch (sAnimationMode) {
            case NONE:
                mTextAnimationMode.setText("None");
                break;
            case CUBE:
                mTextAnimationMode.setText("Cube");
                break;
            case FLIP:
                mTextAnimationMode.setText("Flip");
                break;
        }
    }

}
