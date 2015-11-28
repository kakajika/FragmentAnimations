package com.labo.kaji.fragmentanimations.animation;

import android.support.annotation.IntDef;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Transformation;

/**
 * 3D Flip Animation
 * @author kakajika
 * @since 2015/11/28
 */
public class FlipAnimation extends ViewPropertyAnimation {

    @IntDef({UP, DOWN, LEFT, RIGHT})
    @interface Direction {}
    public static final int UP    = 1;
    public static final int DOWN  = 2;
    public static final int LEFT  = 3;
    public static final int RIGHT = 4;

    protected final @Direction int mDirection;
    protected final boolean mEnter;

    /**
     * Create new Animation.
     * @param direction Direction of animation
     * @param enter true for Enter / false for Exit
     * @param duration Duration of Animation
     * @return
     */
    public static FlipAnimation create(@Direction int direction, boolean enter, long duration) {
        switch (direction) {
            case UP:
            case DOWN:
                return new VerticalFlipAnimation(direction, enter, duration);
            case LEFT:
            case RIGHT:
                return new HorizontalFlipAnimation(direction, enter, duration);
        }
        return null;
    }

    private FlipAnimation(@Direction int direction, boolean enter, long duration) {
        mDirection = direction;
        mEnter = enter;
        setDuration(duration);
        setInterpolator(new AccelerateDecelerateInterpolator());
    }

    private static class VerticalFlipAnimation extends FlipAnimation {

        public VerticalFlipAnimation(@Direction int direction, boolean enter, long duration) {
            super(direction, enter, duration);
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
            mRotationX = value * 180.0f;
            mTranslationY = -value * mHeight;

            transformMatrix(t.getMatrix());

            // Hide exiting view after half point.
            if (interpolatedTime >= 0.5f && !mEnter) {
                t.setAlpha(0.0f);
            }
        }

    }

    private static class HorizontalFlipAnimation extends FlipAnimation {

        public HorizontalFlipAnimation(@Direction int direction, boolean enter, long duration) {
            super(direction, enter, duration);
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
            mRotationY = -value * 180.0f;
            mTranslationX = -value * mWidth;

            transformMatrix(t.getMatrix());

            // Hide exiting view after half point.
            if (interpolatedTime >= 0.5f && !mEnter) {
                t.setAlpha(0.0f);
            }
        }

    }

}
