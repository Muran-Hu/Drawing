package com.droid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Muran Hu on 2018-11-05.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class TestView extends View {
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  Path path = new Path();
  PathMeasure pathMeasure;

  public TestView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  {
    paint.setColor(Color.BLACK);
    path.setFillType(Path.FillType.EVEN_ODD);
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    path.addCircle(getWidth() / 2, getHeight() / 2, 200, Path.Direction.CCW);
    path.addCircle(getWidth() / 2, getHeight() / 2 + 150, 200, Path.Direction.CW);
    pathMeasure = new PathMeasure(path, false);
    System.out.println(pathMeasure.getLength());

    canvas.drawPath(path, paint);
  }

}
