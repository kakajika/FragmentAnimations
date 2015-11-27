package com.labo.kaji.fragmentanimations;

import android.view.animation.Transformation;

/**
 * @author kakajika
 * @since 2015/11/27
 */
public class HorizontalCubeAnimation extends ViewPropertyAnimation {

    public enum Direction {
        LEFT,
        RIGHT,
    }

    private final Direction mDirection;
    private final boolean mEnter;

    public HorizontalCubeAnimation(Direction direction, boolean enter, long duration) {
        mDirection = direction;
        mEnter = enter;
        setDuration(duration);
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mPivotX = (mEnter == (mDirection == Direction.LEFT)) ? 0.0f : width;
        mPivotY = height * 0.5f;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float value = mEnter ? (interpolatedTime - 1.0f) : interpolatedTime;
        if (mDirection == Direction.RIGHT) value *= -1.0f;
        mRotationY = -value * 90.0f;
        mTranslationX = -value * mWidth;

        transformMatrix(t.getMatrix());
    }

}
