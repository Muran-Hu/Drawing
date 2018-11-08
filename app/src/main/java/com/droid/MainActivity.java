package com.droid;

import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.droid.view.CameraView;
import com.droid.view.MaterialEditText;
import com.droid.view.PointView;

public class MainActivity extends AppCompatActivity {

//    CameraView cameraView;
//    ImageView imageView;
//    PointView pointView;
    MaterialEditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        imageView = findViewById(R.id.imageView);
//        pointView = findViewById(R.id.pointView);
//        cameraView = findViewById(R.id.view);

        editText = findViewById(R.id.edit_text);
//        editText.postDelayed(new Runnable() {
//          @Override
//          public void run() {
//            editText.setUseFloatingLabel(false);
//          }
//        }, 2000);

//
//        ObjectAnimator bottomFlipAnimator = ObjectAnimator.ofFloat(cameraView, "bottomFlip", 45);
//        bottomFlipAnimator.setDuration(1500);
//
//        ObjectAnimator flipRotationAnimator = ObjectAnimator.ofFloat(cameraView, "flipRotation", 270);
//        flipRotationAnimator.setDuration(1500);
//
//        ObjectAnimator topFlipAnimator = ObjectAnimator.ofFloat(cameraView, "topFlip", -45);
//        topFlipAnimator.setDuration(1500);
//
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playSequentially(bottomFlipAnimator, flipRotationAnimator, topFlipAnimator);
//        animatorSet.setStartDelay(1000);
//        animatorSet.start();

//      float length = 600;
//      Keyframe keyframe1 = Keyframe.ofFloat(0, 0);
//      Keyframe keyframe2 = Keyframe.ofFloat(0.2f, 0.4f * length);
//      Keyframe keyframe3 = Keyframe.ofFloat(0.8f, 0.6f * length);
//      Keyframe keyframe4 = Keyframe.ofFloat(1, 1 * length);
//      PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("translationX", keyframe1, keyframe2, keyframe3, keyframe4);
//
//      ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(imageView, holder);
//      animator.setStartDelay(1000);
//      animator.setDuration(2000);
//      animator.start();

//      Point targetPoint = new Point((int) Utils.dp2px(300), (int) Utils.dp2px(400));
//      ObjectAnimator animator = ObjectAnimator.ofObject(pointView, "point", new PointEvaluator(), targetPoint);
//      animator.setStartDelay(1000);
//      animator.setDuration(2000);
//      animator.start();
    }

//    class PointEvaluator implements TypeEvaluator<Point> {
//      @Override
//      public Point evaluate(float fraction, Point startValue, Point endValue) {
//        float x = startValue.x + (endValue.x - startValue.x) * fraction;
//        float y = startValue.y + (endValue.y - startValue.y) * fraction;
//        return new Point((int) x, (int) y);
//      }
//    }
}
