package com.labo.kaji.fragmentanimations;

import android.view.animation.Transformation;

/**
 * @author kakajika
 * @since 2015/11/27
 */
public class VerticalCubeAnimation extends ViewPropertyAnimation {

    public enum Direction {
        UP,
        DOWN,
    }

    private final Direction mDirection;
    private final boolean mEnter;

    public VerticalCubeAnimation(Direction direction, boolean enter, long duration) {
        mDirection = direction;
        mEnter = enter;
        setDuration(duration);
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mPivotX = width * 0.5f;
        mPivotY = (mEnter == (mDirection == Direction.UP)) ? 0.0f : height;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float value = mEnter ? (interpolatedTime - 1.0f) : interpolatedTime;
        if (mDirection == Direction.DOWN) value *= -1.0f;
        mRotationX = value * 90.0f;
        mTranslationY = -value * mHeight;

        transformMatrix(t.getMatrix());
    }

}
