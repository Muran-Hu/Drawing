package com.droid.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.droid.R;
import com.droid.Utils;

/**
 * Created by Muran Hu on 2018-11-08.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class MaterialEditText extends AppCompatEditText {

  static final float TEXT_SIZE = Utils.dp2px(18);
  static final float TEXT_MARGIN = Utils.dp2px(2);
  static final float TEXT_VERTICAL_OFFSET = Utils.dp2px(20);
  static final float TEXT_HORIZONTAL_OFFSET = Utils.dp2px(5);
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

  float floatingLabelFraction;

  ObjectAnimator animator;
  boolean floatingLabelShown;

  boolean useFloatingLabel;

  Rect backgroundPadding = new Rect();

  public MaterialEditText(Context context, AttributeSet attrs) {
    super(context, attrs);

    TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaterialEditText);
    this.useFloatingLabel = typedArray.getBoolean(R.styleable.MaterialEditText_use_floating_label, true);

    init();
  }

  private void init() {
    paint.setTextSize(Utils.dp2px(16));
    paint.setColor(Color.LTGRAY);

    onUseFloatingLabelChanged();
    addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (useFloatingLabel) {
          if (!floatingLabelShown && !TextUtils.isEmpty(s)) {
            floatingLabelShown = true;
            getAnimator().start();
          } else if (floatingLabelShown && TextUtils.isEmpty(s)) {
            floatingLabelShown = false;
            getAnimator().reverse();
          }
        }
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });
  }

  private ObjectAnimator getAnimator() {
    if (null == animator) {
      animator = ObjectAnimator.ofFloat(this, "floatingLabelFraction", 0, 1);
    }

    return animator;
  }

  public float getFloatingLabelFraction() {
    return floatingLabelFraction;
  }

  public void setFloatingLabelFraction(float floatingLabelFraction) {
    this.floatingLabelFraction = floatingLabelFraction;
    invalidate();
  }

  public void setUseFloatingLabel(boolean useFloatingLabel) {
    if (this.useFloatingLabel != useFloatingLabel) {
      this.useFloatingLabel = useFloatingLabel;
      onUseFloatingLabelChanged();
    }
  }

  private void onUseFloatingLabelChanged() {
    getBackground().getPadding(backgroundPadding);
    if (this.useFloatingLabel) {
      setPadding(
              getPaddingLeft(),
              (int) (backgroundPadding.top + TEXT_SIZE + TEXT_MARGIN),
              getPaddingRight(),
              getPaddingBottom());
    } else {
      setPadding(
              getPaddingLeft(),
              backgroundPadding.top,
              getPaddingRight(),
              getPaddingBottom());
    }
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    paint.setAlpha((int) (0xff * floatingLabelFraction));
    canvas.drawText(
            getHint().toString(),
            TEXT_HORIZONTAL_OFFSET,
            TEXT_VERTICAL_OFFSET + TEXT_VERTICAL_OFFSET * (1-floatingLabelFraction),
            paint);
  }
}
