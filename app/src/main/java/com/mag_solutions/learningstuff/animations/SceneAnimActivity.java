package com.mag_solutions.learningstuff.animations;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mag_solutions.learningstuff.R;

public class SceneAnimActivity extends AppCompatActivity {

    private Scene scene1, scene2, currentScene;
    private Transition transition;
    ViewGroup sceneRoot;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_anim);
        sceneRoot = (ViewGroup) findViewById(R.id.rootScene);

        // initiate your scenes
        scene1 = Scene.getSceneForLayout(sceneRoot,R.layout.scene1,this);
        scene2 = Scene.getSceneForLayout(sceneRoot,R.layout.scene2,this);

        //create your transition
        transition = TransitionInflater.from(this).inflateTransition(R.transition.test);


        scene1.enter();
        currentScene = scene1;
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onClick(View view) {

        // call transitionManager.go()

        if (currentScene == scene1) {
            TransitionManager.go(scene2, transition);
            currentScene = scene2;
        }
        else {
            TransitionManager.go(scene1, transition);
            currentScene = scene1;
        }
    }
}
