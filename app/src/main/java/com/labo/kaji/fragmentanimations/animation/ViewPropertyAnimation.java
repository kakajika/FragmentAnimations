package com.labo.kaji.fragmentanimations.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * @author kakajika
 * @since 2015/11/27
 */
public class ViewPropertyAnimation extends Animation {

    protected final Camera mCamera = new Camera();
    protected int mWidth  = 0;
    protected int mHeight = 0;
    protected float mAlpha = 1.0f;
    protected float mPivotX = 0.0f;
    protected float mPivotY = 0.0f;
    protected float mScaleX = 1.0f;
    protected float mScaleY = 1.0f;
    protected float mRotationX = 0.0f;
    protected float mRotationY = 0.0f;
    protected float mRotationZ = 0.0f;
    protected float mTranslationX = 0.0f;
    protected float mTranslationY = 0.0f;

    private float mFromAlpha = -1.0f;
    private float mToAlpha   = -1.0f;

    public ViewPropertyAnimation fading(float fromAlpha, float toAlpha) {
        mFromAlpha = fromAlpha;
        mToAlpha = toAlpha;
        return this;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mWidth = width;
        mHeight = height;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        if (mFromAlpha >= 0 && mToAlpha >= 0) {
            mAlpha = mFromAlpha + (mToAlpha - mFromAlpha) * interpolatedTime;
        }
    }

    protected void applyTransformation(Transformation t) {
        final Matrix m = t.getMatrix();
        final float w = mWidth;
        final float h = mHeight;
        final float pX = mPivotX;
        final float pY = mPivotY;

        final float rX = mRotationX;
        final float rY = mRotationY;
        final float rZ = mRotationZ;
        if ((rX != 0) || (rY != 0) || (rZ != 0)) {
            final Camera camera = mCamera;
            camera.save();
            camera.rotateX(rX);
            camera.rotateY(rY);
            camera.rotateZ(-rZ);
            camera.getMatrix(m);
            camera.restore();
            m.preTranslate(-pX, -pY);
            m.postTranslate(pX, pY);
        }

        final float sX = mScaleX;
        final float sY = mScaleY;
        if ((sX != 1.0f) || (sY != 1.0f)) {
            m.postScale(sX, sY);
            final float sPX = -(pX / w) * ((sX * w) - w);
            final float sPY = -(pY / h) * ((sY * h) - h);
            m.postTranslate(sPX, sPY);
        }

        m.postTranslate(mTranslationX, mTranslationY);

        t.setAlpha(mAlpha);
    }

}
