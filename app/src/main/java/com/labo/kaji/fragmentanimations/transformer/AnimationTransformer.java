package com.labo.kaji.fragmentanimations.transformer;

import android.graphics.Matrix;
import android.view.animation.Transformation;

/**
 * @author kakajika
 * @since 2015/11/30
 */
public interface AnimationTransformer {

    public void onInitialize(int width, int height, int parentWidth, int parentHeight);
    public Matrix getTransformationMatrix(float interpolatedTime);
    public float getTransformationAlpha();

}
