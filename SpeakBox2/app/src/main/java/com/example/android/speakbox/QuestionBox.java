package com.example.android.speakbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class QuestionBox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_box);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question_box, menu);
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
    // REQUIRES: A radio button is checked and submit button pressed
    // EFFECT: Creates a point (date and number) that is used for the graph
    public Integer submitAnswer(View view) {
        //Is the 1 button pressed?
        RadioButton rdio1 = (RadioButton) findViewById(R.id.radioButton1);

        RadioButton rdio2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton rdio3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton rdio4 = (RadioButton) findViewById(R.id.radioButton4);
        RadioButton rdio5 = (RadioButton) findViewById(R.id.radioButton5);
        if (rdio1.isChecked()) {
            makeGraphInput(1);
            //TODO: add it to a list of question answers
        } else if (rdio2.isChecked()) {
            makeGraphInput(2);
            //TODO: add it to a list of question answers
        } else if (rdio3.isChecked()) {
            makeGraphInput(3);
            //TODO: add it to a list of question answers
        } else if (rdio4.isChecked()) {
            makeGraphInput(4);
            //TODO: add it to a list of question answers
        } else {
            makeGraphInput(5);
        }
        return 0;
    }

    //REQUIRES: A integer from the radio button that is checked
    //MODIFIES:none
    //EFFECTS:Makes a list of the input chosen and then current time it was chosen.[time, button number]
    public List<Long> makeGraphInput(Integer i){
        List<Long> input = new LinkedList<>();
        Date currentDate = new Date();
        Long currentTime = currentDate.getTime();
        Long newI = i.longValue();
        input.add(newI);
        input.add(currentTime);
        return input;
    }
    
}
