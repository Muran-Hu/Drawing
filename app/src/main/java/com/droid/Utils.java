package com.droid;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;

/**
 * Created by Muran Hu on 2018-11-06.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class Utils {
  public static float dp2px(float dp) {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
  }

  public static Bitmap getAvatar(Resources res, int width) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(res, R.mipmap.head_bg_0, options);
    options.inJustDecodeBounds = false;
    options.inDensity = options.outWidth;
    options.inTargetDensity = width;
    return BitmapFactory.decodeResource(res, R.mipmap.head_bg_0, options);
  }

  public static float getZForCamera() {
    return -6 * Resources.getSystem().getDisplayMetrics().density;
  }
}
