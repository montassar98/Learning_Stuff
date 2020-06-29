package com.mag_solutions.learningstuff.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.mag_solutions.learningstuff.R;

public class AnimationsActivity extends AppCompatActivity implements Animator.AnimatorListener {

    private TextView txtAnimations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);
        txtAnimations = findViewById(R.id.text);
    }

    public void onFadeIn(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.fade_in);
        animator.setTarget(txtAnimations);
        animator.start();
    }

    public void onFadeOut(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.fade_out);
        animator.setTarget(txtAnimations);
        animator.start();
    }

    public void onScaleX(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.scale_x);
        animator.setTarget(txtAnimations);
        animator.start();
    }

    public void onScaleY(View view) {
        /**Animator animator = AnimatorInflater.loadAnimator(this, R.animator.scale_y);
        animator.setTarget(txtAnimations);
        animator.start();*/
        ObjectAnimator scaleYAnim = ObjectAnimator.ofFloat(txtAnimations,"scaleY", 1.0f,2.5f);
        scaleYAnim.setDuration(500);
        scaleYAnim.setRepeatMode(ValueAnimator.REVERSE);
        scaleYAnim.addListener(this);
        scaleYAnim.start();
    }

    public void onRotateX(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.rotate_x);
        animator.setTarget(txtAnimations);
        animator.start();
    }

    public void onRotateY(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.rotate_y);
        animator.setTarget(txtAnimations);
        animator.start();
    }

    public void onTranslateX(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.translate_x);
        animator.setTarget(txtAnimations);
        animator.start();
    }

    public void onTranslateY(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.translate_y);
        animator.setTarget(txtAnimations);
        animator.start();
    }

    @Override
    public void onAnimationStart(Animator animation) {
        Toast.makeText(this, "onAnimationStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        Toast.makeText(this, "onAnimationEnd", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationCancel(Animator animation) {
        Toast.makeText(this, "onAnimationCancel", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationRepeat(Animator animation) {
        Toast.makeText(this, "onAnimationRepeat", Toast.LENGTH_SHORT).show();
    }

    public void withCodeAnimSet(View view) {

        AnimatorSet rootSet = new AnimatorSet();
        AnimatorSet childSet = new AnimatorSet();
        ObjectAnimator rotateX = ObjectAnimator.ofFloat(txtAnimations, "rotationX", 0f,180f);
        rotateX.setDuration(500);
        ObjectAnimator rotateY = ObjectAnimator.ofFloat(txtAnimations, "pivotY", 0f,50f);
        rotateY.setDuration(500);
        rotateY.setInterpolator(new OvershootInterpolator());
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(txtAnimations, "scaleY", 1.0f,2.0f);
        scaleY.setDuration(500);
        scaleY.setInterpolator(new AccelerateDecelerateInterpolator());

        rootSet.play(rotateX).before(childSet);
        childSet.playTogether(scaleY,rotateY);

        rootSet.start();
    }

    public void withXmlAnimSet(View view) {
        Animator setAnim = AnimatorInflater.loadAnimator(this, R.animator.set);
        setAnim.setTarget(txtAnimations);
        setAnim.start();
    }

    public void onViewPropertyAnim(View view) {

        ViewPropertyAnimator vpa = txtAnimations.animate();
        vpa.alphaBy(0.9f);
        vpa.rotationBy(150);
        vpa.setDuration(500);
        vpa.setInterpolator(new OvershootInterpolator());
        vpa.scaleXBy(1.5f);
        vpa.scaleYBy(1.5f);

        vpa.start();
    }

    public void withPropertyValueHolderAnim(View view) {
        PropertyValuesHolder rotX = PropertyValuesHolder.ofFloat("rotationX",0,180);
        PropertyValuesHolder rotY = PropertyValuesHolder.ofFloat("rotationY",0,-180);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY",1,1.5f);
        PropertyValuesHolder pivotY = PropertyValuesHolder.ofFloat("pivotY",1,1.2f);

        ObjectAnimator obj = ObjectAnimator.ofPropertyValuesHolder(txtAnimations, rotX,rotY, scaleY , pivotY);
        obj.setDuration(2000);
        obj.setInterpolator(new OvershootInterpolator());
        obj.start();

    }
}
