package com.droid.view;

import android.content.Context;
import android.gesture.GestureOverlayView;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.droid.Utils;

import static android.graphics.Color.LTGRAY;
import static android.graphics.Color.YELLOW;

/**
 * Created by Muran Hu on 2018-11-06.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class SportsView extends View {

  static final float ANGLE = 90;
  static final float RADIUS = Utils.dp2px(150);
  static final float EDGE_WIDTH = Utils.dp2px(20);
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  Rect rect = new Rect();
  Paint.FontMetrics fontMetrics = new Paint.FontMetrics();

  public SportsView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  {
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth(EDGE_WIDTH);

  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    paint.setColor(LTGRAY);
    canvas.drawCircle(getWidth() / 2, getHeight() / 2, RADIUS, paint);

    paint.setColor(YELLOW);
    paint.setStrokeCap(Paint.Cap.ROUND);
    canvas.drawArc(
            getWidth() / 2 - RADIUS,
            getHeight() / 2 - RADIUS,
            getWidth() / 2 + RADIUS,
            getHeight() / 2 + RADIUS,
            -ANGLE,
            225,
            false,
            paint);

    paint.setColor(Color.RED);
    paint.setTextSize(150);
    paint.setTextAlign(Paint.Align.CENTER);
    paint.setStyle(Paint.Style.FILL);
//    paint.getTextBounds("aqgpbh", 0, 6, rect);
//    float offset = (rect.top + rect.bottom) / 2;
    fontMetrics = paint.getFontMetrics();
    float offset = (fontMetrics.ascent + fontMetrics.descent) / 2;
    canvas.drawText("aqgpbh", getWidth() / 2, getHeight() / 2 - offset, paint);

    paint.setTextAlign(Paint.Align.LEFT);
    paint.setTextSize(Utils.dp2px(100));
    paint.getTextBounds("aaaa", 0, 4, rect);
    canvas.drawText("aaaa", - rect.left, 200, paint);
  }
}
