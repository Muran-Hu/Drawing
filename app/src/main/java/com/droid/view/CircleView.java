package com.droid.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.droid.Utils;

/**
 * Created by Muran Hu on 2018-11-07.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class CircleView extends View {

  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

  float radius = Utils.dp2px(50);

  public CircleView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  {
    paint.setColor(Color.RED);
  }

  public float getRadius() {
    return radius;
  }

  public void setRadius(float radius) {
    this.radius = radius;
    invalidate();
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);
  }
}
