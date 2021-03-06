package com.droid.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.net.wifi.aware.WifiAwareManager;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.droid.R;
import com.droid.Utils;

/**
 * Created by Muran Hu on 2018-11-06.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class RoundImageView extends View {

  static final float WIDTH = Utils.dp2px(300);
  static final float PADDING = Utils.dp2px(50);
  static final float EDGE_WIDTH = Utils.dp2px(5);
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  Bitmap bitmap;
  RectF rectF = new RectF();
  Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);

  public RoundImageView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  {
    bitmap = getAvatar((int) WIDTH);
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);

    rectF.set(PADDING, PADDING, PADDING + WIDTH, PADDING + WIDTH);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    canvas.drawOval(rectF, paint);
    int layer = canvas.saveLayer(rectF, paint);
    canvas.drawOval(
            PADDING + EDGE_WIDTH,
            PADDING + EDGE_WIDTH,
            PADDING + WIDTH - EDGE_WIDTH,
            PADDING + WIDTH - EDGE_WIDTH,
            paint);
    paint.setXfermode(xfermode);
    canvas.drawBitmap(bitmap, PADDING, PADDING, paint);
    paint.setXfermode(null);
    canvas.restoreToCount(layer);
  }

  Bitmap getAvatar(int width) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(getResources(), R.mipmap.head_bg_0, options);
    options.inJustDecodeBounds = false;
    options.inDensity = options.outWidth;
    options.inTargetDensity = width;
    return BitmapFactory.decodeResource(getResources(), R.mipmap.head_bg_0, options);
  }

}
