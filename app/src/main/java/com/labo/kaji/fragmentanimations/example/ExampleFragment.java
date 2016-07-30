package com.labo.kaji.fragmentanimations.example;

import android.annotation.SuppressLint;
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

import com.labo.kaji.fragmentanimations.CubeAnimation;
import com.labo.kaji.fragmentanimations.FlipAnimation;
import com.labo.kaji.fragmentanimations.MoveAnimation;
import com.labo.kaji.fragmentanimations.PushPullAnimation;
import com.labo.kaji.fragmentanimations.SidesAnimation;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author kakajika
 * @since 2015/11/27
 */
public class ExampleFragment extends Fragment {

    @IntDef({NONE, MOVE, CUBE, FLIP, PUSHPULL, SIDES, CUBEMOVE, MOVECUBE, PUSHMOVE, MOVEPULL, FLIPMOVE, MOVEFLIP, FLIPCUBE, CUBEFLIP})
    public @interface AnimationStyle {}
    public static final int NONE     = 0;
    public static final int MOVE     = 1;
    public static final int CUBE     = 2;
    public static final int FLIP     = 3;
    public static final int PUSHPULL = 4;
    public static final int SIDES    = 5;
    public static final int CUBEMOVE = 6;
    public static final int MOVECUBE = 7;
    public static final int PUSHMOVE = 8;
    public static final int MOVEPULL = 9;
    public static final int FLIPMOVE = 10;
    public static final int MOVEFLIP = 11;
    public static final int FLIPCUBE = 12;
    public static final int CUBEFLIP = 13;

    @IntDef({NODIR, UP, DOWN, LEFT, RIGHT})
    public @interface AnimationDirection {}
    public static final int NODIR = 0;
    public static final int UP    = 1;
    public static final int DOWN  = 2;
    public static final int LEFT  = 3;
    public static final int RIGHT = 4;

    private static final long DURATION = 500;

    @AnimationStyle
    private static int sAnimationStyle = CUBE;

    @Bind(R.id.textAnimationStyle)
    TextView mTextAnimationStyle;

    public static ExampleFragment newInstance(@AnimationDirection int direction) {
        ExampleFragment f = new ExampleFragment();
        f.setArguments(new Bundle());
        f.getArguments().putInt("direction", direction);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_anim, container, false);
        int color = Color.rgb((int) Math.floor(Math.random() * 128) + 64,
                              (int) Math.floor(Math.random() * 128) + 64,
                              (int) Math.floor(Math.random() * 128) + 64);
        view.setBackgroundColor(color);
        ButterKnife.bind(this, view);
        setAnimationStyleText();
        return view;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        switch (sAnimationStyle) {
            case MOVE:
                switch (getArguments().getInt("direction")) {
                    case UP:
                        return MoveAnimation.create(MoveAnimation.UP, enter, DURATION);
                    case DOWN:
                        return MoveAnimation.create(MoveAnimation.DOWN, enter, DURATION);
                    case LEFT:
                        return MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION);
                    case RIGHT:
                        return MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION);
                }
                break;
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
            case PUSHPULL:
                switch (getArguments().getInt("direction")) {
                    case UP:
                        return PushPullAnimation.create(PushPullAnimation.UP, enter, DURATION);
                    case DOWN:
                        return PushPullAnimation.create(PushPullAnimation.DOWN, enter, DURATION);
                    case LEFT:
                        return PushPullAnimation.create(PushPullAnimation.LEFT, enter, DURATION);
                    case RIGHT:
                        return PushPullAnimation.create(PushPullAnimation.RIGHT, enter, DURATION);
                }
                break;
            case SIDES:
                switch (getArguments().getInt("direction")) {
                    case UP:
                        return SidesAnimation.create(SidesAnimation.UP, enter, DURATION);
                    case DOWN:
                        return SidesAnimation.create(SidesAnimation.DOWN, enter, DURATION);
                    case LEFT:
                        return SidesAnimation.create(SidesAnimation.LEFT, enter, DURATION);
                    case RIGHT:
                        return SidesAnimation.create(SidesAnimation.RIGHT, enter, DURATION);
                }
                break;
            case CUBEMOVE:
                switch (getArguments().getInt("direction")) {
                    case UP:
                        return enter ? MoveAnimation.create(MoveAnimation.UP, enter, DURATION).fading(0.3f, 1.0f) :
                                CubeAnimation.create(CubeAnimation.UP, enter, DURATION).fading(1.0f, 0.3f);
                    case DOWN:
                        return enter ? MoveAnimation.create(MoveAnimation.DOWN, enter, DURATION).fading(0.3f, 1.0f) :
                                CubeAnimation.create(CubeAnimation.DOWN, enter, DURATION).fading(1.0f, 0.3f);
                    case LEFT:
                        return enter ? MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION).fading(0.3f, 1.0f) :
                                CubeAnimation.create(CubeAnimation.LEFT, enter, DURATION).fading(1.0f, 0.3f);
                    case RIGHT:
                        return enter ? MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION).fading(0.3f, 1.0f) :
                                CubeAnimation.create(CubeAnimation.RIGHT, enter, DURATION).fading(1.0f, 0.3f);
                }
                break;
            case MOVECUBE:
                switch (getArguments().getInt("direction")) {
                    case UP:
                        return enter ? CubeAnimation.create(CubeAnimation.UP, enter, DURATION).fading(0.3f, 1.0f) :
                                MoveAnimation.create(MoveAnimation.UP, enter, DURATION).fading(1.0f, 0.3f);
                    case DOWN:
                        return enter ? CubeAnimation.create(CubeAnimation.DOWN, enter, DURATION).fading(0.3f, 1.0f) :
                                MoveAnimation.create(MoveAnimation.DOWN, enter, DURATION).fading(1.0f, 0.3f);
                    case LEFT:
                        return enter ? CubeAnimation.create(CubeAnimation.LEFT, enter, DURATION).fading(0.3f, 1.0f) :
                                MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION).fading(1.0f, 0.3f);
                    case RIGHT:
                        return enter ? CubeAnimation.create(CubeAnimation.RIGHT, enter, DURATION).fading(0.3f, 1.0f) :
                                MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION).fading(1.0f, 0.3f);
                }
                break;
            case PUSHMOVE:
                switch (getArguments().getInt("direction")) {
                    case UP:
                        return enter ? MoveAnimation.create(MoveAnimation.UP, enter, DURATION) :
                                PushPullAnimation.create(PushPullAnimation.UP, enter, DURATION);
                    case DOWN:
                        return enter ? MoveAnimation.create(MoveAnimation.DOWN, enter, DURATION) :
                                PushPullAnimation.create(PushPullAnimation.DOWN, enter, DURATION);
                    case LEFT:
                        return enter ? MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION) :
                                PushPullAnimation.create(PushPullAnimation.LEFT, enter, DURATION);
                    case RIGHT:
                        return enter ? MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION) :
                                PushPullAnimation.create(PushPullAnimation.RIGHT, enter, DURATION);
                }
                break;
            case MOVEPULL:
                switch (getArguments().getInt("direction")) {
                    case UP:
                        return enter ? PushPullAnimation.create(PushPullAnimation.UP, enter, DURATION) :
                                MoveAnimation.create(MoveAnimation.UP, enter, DURATION).fading(1.0f, 0.3f);
                    case DOWN:
                        return enter ? PushPullAnimation.create(PushPullAnimation.DOWN, enter, DURATION) :
                                MoveAnimation.create(MoveAnimation.DOWN, enter, DURATION).fading(1.0f, 0.3f);
                    case LEFT:
                        return enter ? PushPullAnimation.create(PushPullAnimation.LEFT, enter, DURATION) :
                                MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION).fading(1.0f, 0.3f);
                    case RIGHT:
                        return enter ? PushPullAnimation.create(PushPullAnimation.RIGHT, enter, DURATION) :
                                MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION).fading(1.0f, 0.3f);
                }
                break;
            case FLIPMOVE:
                switch (getArguments().getInt("direction")) {
                    case UP:
                        return enter ? MoveAnimation.create(MoveAnimation.UP, enter, DURATION) :
                                FlipAnimation.create(FlipAnimation.UP, enter, DURATION);
                    case DOWN:
                        return enter ? MoveAnimation.create(MoveAnimation.DOWN, enter, DURATION) :
                                FlipAnimation.create(FlipAnimation.DOWN, enter, DURATION);
                    case LEFT:
                        return enter ? MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION) :
                                FlipAnimation.create(FlipAnimation.LEFT, enter, DURATION);
                    case RIGHT:
                        return enter ? MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION) :
                                FlipAnimation.create(FlipAnimation.RIGHT, enter, DURATION);
                }
                break;
            case MOVEFLIP:
                switch (getArguments().getInt("direction")) {
                    case UP:
                        return enter ? FlipAnimation.create(FlipAnimation.UP, enter, DURATION) :
                                MoveAnimation.create(MoveAnimation.UP, enter, DURATION).fading(1.0f, 0.3f);
                    case DOWN:
                        return enter ? FlipAnimation.create(FlipAnimation.DOWN, enter, DURATION) :
                                MoveAnimation.create(MoveAnimation.DOWN, enter, DURATION).fading(1.0f, 0.3f);
                    case LEFT:
                        return enter ? FlipAnimation.create(FlipAnimation.LEFT, enter, DURATION) :
                                MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION).fading(1.0f, 0.3f);
                    case RIGHT:
                        return enter ? FlipAnimation.create(FlipAnimation.RIGHT, enter, DURATION) :
                                MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION).fading(1.0f, 0.3f);
                }
                break;
            case FLIPCUBE:
                switch (getArguments().getInt("direction")) {
                    case UP:
                        return enter ? CubeAnimation.create(CubeAnimation.UP, enter, DURATION) :
                                FlipAnimation.create(FlipAnimation.UP, enter, DURATION);
                    case DOWN:
                        return enter ? CubeAnimation.create(CubeAnimation.DOWN, enter, DURATION) :
                                FlipAnimation.create(FlipAnimation.DOWN, enter, DURATION);
                    case LEFT:
                        return enter ? CubeAnimation.create(CubeAnimation.LEFT, enter, DURATION) :
                                FlipAnimation.create(FlipAnimation.LEFT, enter, DURATION);
                    case RIGHT:
                        return enter ? CubeAnimation.create(CubeAnimation.RIGHT, enter, DURATION) :
                                FlipAnimation.create(FlipAnimation.RIGHT, enter, DURATION);
                }
                break;
            case CUBEFLIP:
                switch (getArguments().getInt("direction")) {
                    case UP:
                        return enter ? FlipAnimation.create(FlipAnimation.UP, enter, DURATION) :
                                CubeAnimation.create(CubeAnimation.UP, enter, DURATION).fading(1.0f, 0.3f);
                    case DOWN:
                        return enter ? FlipAnimation.create(FlipAnimation.DOWN, enter, DURATION) :
                                CubeAnimation.create(CubeAnimation.DOWN, enter, DURATION).fading(1.0f, 0.3f);
                    case LEFT:
                        return enter ? FlipAnimation.create(FlipAnimation.LEFT, enter, DURATION) :
                                CubeAnimation.create(CubeAnimation.LEFT, enter, DURATION).fading(1.0f, 0.3f);
                    case RIGHT:
                        return enter ? FlipAnimation.create(FlipAnimation.RIGHT, enter, DURATION) :
                                CubeAnimation.create(CubeAnimation.RIGHT, enter, DURATION).fading(1.0f, 0.3f);
                }
                break;
            case NONE:
                break;
        }
        return null;
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.buttonUp)
    void onButtonUp() {
        getArguments().putInt("direction", UP);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, ExampleFragment.newInstance(UP));
        ft.commit();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.buttonDown)
    void onButtonDown() {
        getArguments().putInt("direction", DOWN);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, ExampleFragment.newInstance(DOWN));
        ft.commit();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.buttonLeft)
    void onButtonLeft() {
        getArguments().putInt("direction", LEFT);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, ExampleFragment.newInstance(LEFT));
        ft.commit();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.buttonRight)
    void onButtonRight() {
        getArguments().putInt("direction", RIGHT);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, ExampleFragment.newInstance(RIGHT));
        ft.commit();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.textAnimationStyle)
    public void switchAnimationStyle(View view) {
        @AnimationStyle int[] styles;
        styles = new int[]{MOVE, CUBE, FLIP, PUSHPULL, SIDES, CUBEMOVE, MOVECUBE, PUSHMOVE, MOVEPULL, FLIPMOVE, MOVEFLIP, FLIPCUBE, CUBEFLIP};
        for (int i = 0; i<styles.length-1; ++i) {
            if (styles[i] == sAnimationStyle) {
                setAnimationStyle(styles[i+1]);
                return;
            }
        }
        setAnimationStyle(MOVE);
    }

    public void setAnimationStyle(@AnimationStyle int style) {
        if (sAnimationStyle != style) {
            sAnimationStyle = style;
            setAnimationStyleText();
            Snackbar.make(getView(), "Animation Style is Changed", Snackbar.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("SetTextI18n")
    private void setAnimationStyleText() {
        switch (sAnimationStyle) {
            case NONE:
                mTextAnimationStyle.setText("None");
                break;
            case MOVE:
                mTextAnimationStyle.setText("Move");
                break;
            case CUBE:
                mTextAnimationStyle.setText("Cube");
                break;
            case FLIP:
                mTextAnimationStyle.setText("Flip");
                break;
            case PUSHPULL:
                mTextAnimationStyle.setText("Push/Pull");
                break;
            case SIDES:
                mTextAnimationStyle.setText("Sides");
                break;
            case CUBEMOVE:
                mTextAnimationStyle.setText("Cube/Move");
                break;
            case MOVECUBE:
                mTextAnimationStyle.setText("Move/Cube");
                break;
            case PUSHMOVE:
                mTextAnimationStyle.setText("Push/Move");
                break;
            case MOVEPULL:
                mTextAnimationStyle.setText("Move/Pull");
                break;
            case FLIPMOVE:
                mTextAnimationStyle.setText("Flip/Move");
                break;
            case MOVEFLIP:
                mTextAnimationStyle.setText("Move/Flip");
                break;
            case FLIPCUBE:
                mTextAnimationStyle.setText("Flip/Cube");
                break;
            case CUBEFLIP:
                mTextAnimationStyle.setText("Cube/Flip");
                break;
        }
    }

}
