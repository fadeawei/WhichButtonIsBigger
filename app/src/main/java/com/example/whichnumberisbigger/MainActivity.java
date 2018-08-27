package com.example.whichnumberisbigger;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonLeft;
    private Button buttonRight;
    private TextView textViewScore;
    private int score;
    private int rightnum;
    private int leftnum;

    public static final int MAX_NUM = 1000;
    public static final int MIN_NUM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        randomizeandupdate();
    }

    @SuppressLint("SetTextI18n")
    private void randomizeandupdate() {
        //TODO set the score
        textViewScore.setText((String) getResources().getText(R.string.main_score) + score);
        //TODO randomize numbers
        randomizenumbers();
        //TODO set the button value
        buttonLeft.setText(String.valueOf(leftnum));
        buttonRight.setText(String.valueOf(rightnum));

    }

    private void randomizenumbers() {
        int range = MAX_NUM - MIN_NUM;
        leftnum = (int) (Math.random() * range) + MIN_NUM;
        rightnum = (int) (Math.random() * range) + MIN_NUM;
        while (leftnum == rightnum) {
            rightnum = (int) (Math.random() * range) + MIN_NUM;
        }
    }

    private void wireWidgets() {
        buttonLeft = findViewById(R.id.button_main_left);
        buttonRight = findViewById(R.id.button_main_right);
        textViewScore = findViewById(R.id.textView_main_score);
    }

    public void onRightClick(View view) {
        checkanswer(false);
    }

    private void checkanswer(boolean leftpressed) {
        String message;
        if ((leftnum > rightnum && leftpressed) || (leftnum < rightnum && !leftpressed)) {
            score++;
            message = "correct";
        } else {
            score--;
            message = "Less correct";
        }
        randomizeandupdate();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onLeftClick(View view) {
        checkanswer(true);
    }


}


