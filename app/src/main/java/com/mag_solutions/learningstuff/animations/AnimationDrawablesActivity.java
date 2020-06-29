package com.mag_solutions.learningstuff.animations;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mag_solutions.learningstuff.R;

public class AnimationDrawablesActivity extends AppCompatActivity {

    ImageView imgAddToCheck;
    boolean isChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_drawables);
        imgAddToCheck = (ImageView) findViewById(R.id.imageView);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void switchAnim(View view) {
        if (isChecked) {
            addToCheck();
        } else {
            checkToAdd();
        }
        isChecked = !isChecked;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void addToCheck(){
        imgAddToCheck.setImageResource(R.drawable.avd_add_to_check);
        AnimatedVectorDrawable avd = (AnimatedVectorDrawable) imgAddToCheck.getDrawable();
        avd.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void checkToAdd(){
        imgAddToCheck.setImageResource(R.drawable.avd_check_to_add);
        AnimatedVectorDrawable avd = (AnimatedVectorDrawable) imgAddToCheck.getDrawable();
        avd.start();
    }

}
