package com.wingsofts.sorttabviewdemo;

import android.view.animation.Interpolator;

/**
 * Created by wing on 16/8/18.
 */
public class MyInterpolator implements Interpolator {
  @Override
  //返回为float值 也就是实时的值
  public float getInterpolation(float input) {
    float factor = 0.4f;

    return (float) (Math.pow(2, -10 * input) * Math.sin((input - factor / 4) * (2 * Math.PI) / factor) + 1);
  }

  float bounce(float t) {
    return t * t * 8;
  }


}