package com.labo.kaji.fragmentanimations.animation;

import android.support.annotation.IntDef;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Transformation;

/**
 * @author kakajika
 * @since 2015/11/27
 */
public class VerticalCubeAnimation extends ViewPropertyAnimation {

    @IntDef({UP, DOWN})
    @interface Direction {}
    public static final int UP   = 1;
    public static final int DOWN = 2;

    private final @Direction int mDirection;
    private final boolean mEnter;

    public VerticalCubeAnimation(@Direction int direction, boolean enter, long duration) {
        mDirection = direction;
        mEnter = enter;
        setDuration(duration);
        setInterpolator(new AccelerateDecelerateInterpolator());
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mPivotX = width * 0.5f;
        mPivotY = (mEnter == (mDirection == UP)) ? 0.0f : height;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float value = mEnter ? (interpolatedTime - 1.0f) : interpolatedTime;
        if (mDirection == DOWN) value *= -1.0f;
        mRotationX = value * 90.0f;
        mTranslationY = -value * mHeight;

        transformMatrix(t.getMatrix());
    }

}
