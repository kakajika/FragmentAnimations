package com.labo.kaji.fragmentanimations.animation;

import android.support.annotation.IntDef;
import android.view.animation.Transformation;

/**
 * @author kakajika
 * @since 2015/11/27
 */
public class HorizontalCubeAnimation extends ViewPropertyAnimation {

    @IntDef({LEFT, RIGHT})
    @interface Direction {}
    public static final int LEFT  = 1;
    public static final int RIGHT = 2;

    private final @Direction int mDirection;
    private final boolean mEnter;

    public HorizontalCubeAnimation(@Direction int direction, boolean enter, long duration) {
        mDirection = direction;
        mEnter = enter;
        setDuration(duration);
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mPivotX = (mEnter == (mDirection == LEFT)) ? 0.0f : width;
        mPivotY = height * 0.5f;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float value = mEnter ? (interpolatedTime - 1.0f) : interpolatedTime;
        if (mDirection == RIGHT) value *= -1.0f;
        mRotationY = -value * 90.0f;
        mTranslationX = -value * mWidth;

        transformMatrix(t.getMatrix());
    }

}
