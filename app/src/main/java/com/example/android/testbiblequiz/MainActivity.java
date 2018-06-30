package com.example.android.testbiblequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {



    private Button btnDisplay;
    int scoreTeamB = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        // Figure out if the user picked male
        CheckBox maleCheckBox = (CheckBox) findViewById(R.id.rachel_checkbox);
        boolean maleCheckBoxChecked = maleCheckBox.isChecked();

        // Figure out if the user picked female
        CheckBox femaleCheckBox = (CheckBox) findViewById(R.id.leah_checkbox);
        boolean femaleCheckBoxChecked = femaleCheckBox.isChecked();
        if(maleCheckBoxChecked==true&&femaleCheckBoxChecked==false) {
            scoreTeamB = scoreTeamB + 1;
        }
        // Figure out if the user picked Disciple Peter
        CheckBox peterCheckBox = (CheckBox) findViewById(R.id.peter_checkbox);
        boolean peterCheckBoxChecked = peterCheckBox.isChecked();

        // Figure out if the user picked !Disciple Paul
        CheckBox paulCheckBox = (CheckBox) findViewById(R.id.paul_checkbox);
        boolean paulCheckBoxChecked = paulCheckBox.isChecked();

        // Figure out if the user picked Disciple John
        CheckBox johnCheckBox = (CheckBox) findViewById(R.id.john_checkbox);
        boolean johnCheckBoxChecked = johnCheckBox.isChecked();

        if(peterCheckBoxChecked&&johnCheckBoxChecked&&!paulCheckBoxChecked){
            scoreTeamB=scoreTeamB+1;
        }
        // Get user's answer to meaning of Sarah
        EditText nameField = (EditText) findViewById(R.id.sarah_field);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();
        if(name.equals("princess")){
            scoreTeamB=scoreTeamB+1;
        }
        // Get user's answer to who killed Abel
        EditText killerField = (EditText) findViewById(R.id.sarah_field);
        Editable killerEditable = killerField.getText();
        String killer = killerEditable.toString();
        if(killer.equals("cain")){
            scoreTeamB=scoreTeamB+1;
        }

        //Get answer to the ye no question on animal speaking
        //int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        //View radioButton = radioButtonGroup.findViewById(radioButtonID);
        //int idx = radioButtonGroup.indexOfChild(radioButton);
        //If the RadioGroup contains other Views (like a TextView) then the indexOfChild() x index.
        //
        //to get selected RadioButton Text on RadioGroup
        RadioGroup radioGroup=(RadioGroup)  findViewById(R.id.radio_group);
        // get selected radio button from radioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        int idx = radioGroup.indexOfChild(radioButton);
        RadioButton r = (RadioButton)  radioGroup.getChildAt(idx);
        String selectedtext = r.getText().toString();
        if(selectedtext.equals("YES")){
            scoreTeamB=scoreTeamB+1;
        }


        displayForTeamB(scoreTeamB);
        }

    /**
     * Reset the score for Team B to zero
     */
    public void setToZero(View v) {
     scoreTeamB=0;
     displayForTeamB(scoreTeamB);
    }

//     * Displays the given score .
//     */
        public void displayForTeamB(int score) {
            TextView scoreView = (TextView) findViewById(R.id.team_b_score);
            scoreView.setText(String.valueOf(score));
        }
    }

