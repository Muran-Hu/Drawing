package com.droid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Muran Hu on 2018-11-07.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class PointView extends View {

  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  Point point = new Point();

  public PointView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  {
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth(50);
    paint.setStrokeCap(Paint.Cap.ROUND);
  }

  public Point getPoint() {
    return point;
  }

  public void setPoint(Point point) {
    this.point = point;
    invalidate();
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    canvas.drawPoint(point.x, point.y, paint);
  }
}