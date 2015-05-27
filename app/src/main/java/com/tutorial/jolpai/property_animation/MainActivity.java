package com.tutorial.jolpai.property_animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {


    private int screenWidth;

    private View windowsTvOne;
    private View windowsTvThree;
    private View windowsTvTwo;
    private View windowsTvFour;
    private AnimatorSet windowsAnimatorSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        windowsTvOne = (View)findViewById(R.id.v1);
        windowsTvTwo=(View)findViewById(R.id.v2);
        windowsTvThree=(View)findViewById(R.id.v3);
    /*    windowsTvFour=(View)findViewById(R.id.v4);*/


        DisplayMetrics displaymetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenWidth = displaymetrics.widthPixels;

        windowsAnimation();

    }

    private void windowsAnimation() {

        final ValueAnimator valueTvOne_x = ObjectAnimator.ofFloat(windowsTvOne,
                "x",
                windowsTvOne.getX() - 40,
                windowsTvOne.getX() - 50,
                windowsTvOne.getX() - 10,
                (screenWidth / 2) + 10f,
                (screenWidth / 2) + 25f,
                (screenWidth / 2) + 50f,
                (screenWidth / 2) + 55f,

                screenWidth * .92f,
                screenWidth + 5);

        valueTvOne_x.setDuration(3500);
        valueTvOne_x.setRepeatCount(0);
        valueTvOne_x.setRepeatMode(ValueAnimator.RESTART);

        valueTvOne_x.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                windowsTvOne.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });

       final ValueAnimator valueTvTwo_x = ObjectAnimator.ofFloat(windowsTvTwo,
               "x",
               windowsTvTwo.getX() - 50,
               (screenWidth / 2.1f) + 10f,
               (screenWidth / 2.1f) + 25f,
               windowsTvTwo.getX() + 100,
               (screenWidth / 2.1f) + 50f//, (screenWidth / 2.1f) +55f//, (screenWidth / 2.1f) +80f//, (screenWidth / 2.1f) +25f,(screenWidth / 2.1f) +30f
               ,screenWidth * .94f,
                screenWidth);

        valueTvTwo_x.setDuration(3000);
        valueTvTwo_x.setRepeatCount(0);
        valueTvTwo_x.setStartDelay(200);
        valueTvTwo_x.setRepeatMode(ValueAnimator.RESTART);

        valueTvTwo_x.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                windowsTvTwo.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });

         final ValueAnimator valueTvThree_x = ObjectAnimator.ofFloat(windowsTvThree,
                 "x",
                 windowsTvThree.getX() - 50,
                 (screenWidth / 2.2f) + 10f,
                 (screenWidth / 2.2f) + 25f,
                 (screenWidth / 2.2f) + 50f//,(screenWidth / 2.2f) +55f//,(screenWidth / 2.2f) +80f//,(screenWidth / 2.2f) +25f,(screenWidth / 2.2f) +30f
                , screenWidth * .94f,
                 windowsTvThree.getX() + 50,
                 windowsTvThree.getX() + 100,
                 windowsTvThree.getX() + 150,
                 screenWidth + 5);




        valueTvThree_x.setDuration(4000);
        valueTvThree_x.setRepeatCount(0);
        valueTvTwo_x.setStartDelay(1000);
        valueTvThree_x.setRepeatMode(ValueAnimator.RESTART);

        valueTvThree_x.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                windowsTvThree.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });

   /*     final ValueAnimator valueTvFour_x = ObjectAnimator.ofFloat(windowsTvFour,
                "x",
                windowsTvFour.getX() - 20,
                windowsTvFour.getX() - 30,
                (screenWidth / 2) + 10f,
                (screenWidth / 2) + 25f,
                (screenWidth / 2) + 50f,
                screenWidth * .5f,
                screenWidth + 1);

        valueTvFour_x.setDuration(5000);
        valueTvFour_x.setRepeatCount(0);
        valueTvFour_x.setRepeatMode(ValueAnimator.REVERSE);

        valueTvFour_x.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                windowsTvOne.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });
*/
        windowsAnimatorSet = new AnimatorSet();
        windowsAnimatorSet.playTogether(valueTvTwo_x,valueTvOne_x,valueTvThree_x);

        windowsAnimatorSet.start();
        windowsAnimatorSet.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                windowsAnimatorSet.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
