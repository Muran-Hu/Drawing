package com.droid.view;

import android.content.Context;
import android.graphics.Canvas;
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
public class Zuobiaoxi extends View {

  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

  public Zuobiaoxi(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    canvas.rotate(45, 300 + 400 / 2, 400 / 2);
    canvas.translate(300, 0);

    canvas.drawBitmap(Utils.getAvatar(getResources(), 400), 0, 0, paint);
  }
}
