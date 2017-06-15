package com.labo.kaji.fragmentanimations;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Transformation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 3D Cube Animation
 * @author kakajika
 * @since 2015/11/28
 */
public class SidesAnimation extends ViewPropertyAnimation {

    @IntDef({UP, DOWN, LEFT, RIGHT})
    @Retention(RetentionPolicy.SOURCE)
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
    public static @NonNull SidesAnimation create(@Direction int direction, boolean enter, long duration) {
        switch (direction) {
            case UP:
            case DOWN:
                return new VerticalCubeAnimation(direction, enter, duration);
            case LEFT:
            case RIGHT:
            default:
                return new HorizontalCubeAnimation(direction, enter, duration);
        }
    }

    private SidesAnimation(@Direction int direction, boolean enter, long duration) {
        mDirection = direction;
        mEnter = enter;
        setDuration(duration);
        setInterpolator(new AccelerateDecelerateInterpolator());
    }

    private static class VerticalCubeAnimation extends SidesAnimation {

        private VerticalCubeAnimation(@Direction int direction, boolean enter, long duration) {
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
            mRotationX = value * 90.0f;
            mAlpha = mEnter ? interpolatedTime : (1.0f - interpolatedTime);
            mTranslationZ = (1.0f - mAlpha) * mWidth;

            super.applyTransformation(interpolatedTime, t);
            applyTransformation(t);
        }

    }

    private static class HorizontalCubeAnimation extends SidesAnimation {

        private HorizontalCubeAnimation(@Direction int direction, boolean enter, long duration) {
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
            mRotationY = -value * 90.0f;
            mAlpha = mEnter ? interpolatedTime : (1.0f - interpolatedTime);
            mTranslationZ = (1.0f - mAlpha) * mHeight;

            super.applyTransformation(interpolatedTime, t);
            applyTransformation(t);
        }

    }

}
