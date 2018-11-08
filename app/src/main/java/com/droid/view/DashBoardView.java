package com.droid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Muran Hu on 2018-11-05.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class DashBoardView extends View {

  static final int RADIUS = 400;
  static final int ANGLE = 120;
  static final int POINTER_LENGTH = 300;
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

  PathEffect effect;
  PathMeasure measure;

  public DashBoardView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  {
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth(4);

    Path rect = new Path();
    rect.addRect(0, 0, 5, 20, Path.Direction.CW);

    Path arc = new Path();
    arc.addArc(getWidth() / 2 - RADIUS,
            getHeight() / 2 - RADIUS,
            getWidth() / 2 + RADIUS,
            getHeight() / 2 + RADIUS,
            90 + ANGLE / 2,
            360 - ANGLE);
    measure = new PathMeasure(arc, false);

    effect = new PathDashPathEffect(rect, (measure.getLength() - 5) / 20, 0, PathDashPathEffect.Style.ROTATE);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    canvas.drawArc(getWidth() / 2 - RADIUS,
            getHeight() / 2 - RADIUS,
            getWidth() / 2 + RADIUS,
            getHeight() / 2 + RADIUS,
            90 + ANGLE / 2,
            360 - ANGLE,
            false,
            paint);

    paint.setPathEffect(effect);
    canvas.drawArc(getWidth() / 2 - RADIUS,
            getHeight() / 2 - RADIUS,
            getWidth() / 2 + RADIUS,
            getHeight() / 2 + RADIUS,
            90 + ANGLE / 2,
            360 - ANGLE,
            false,
            paint);
    paint.setPathEffect(null);

    canvas.drawLine(
            getWidth() / 2,
            getHeight() / 2,
            (float) Math.cos(Math.toRadians(getAngleFromMark(7))) * POINTER_LENGTH + getWidth() / 2,
            (float) Math.sin(Math.toRadians(getAngleFromMark(7))) * POINTER_LENGTH + getHeight() / 2,
            paint);
  }

  private int getAngleFromMark(int mark) {
    return 90 + ANGLE / 2 + (360 - ANGLE) / 20 * mark;
  }
}
