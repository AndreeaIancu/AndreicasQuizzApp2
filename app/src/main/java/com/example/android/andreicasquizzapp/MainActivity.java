package com.example.android.andreicasquizzapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.andreicasquizzapp.R.string.almost;
import static com.example.android.andreicasquizzapp.R.string.answerQuestion3;
import static com.example.android.andreicasquizzapp.R.string.correct_message;
import static com.example.android.andreicasquizzapp.R.string.incorrect_message;
import static com.example.android.andreicasquizzapp.R.string.partial;
import static com.example.android.andreicasquizzapp.R.string.short_correct_message;
import static com.example.android.andreicasquizzapp.R.string.short_incorrect_message;
import static com.example.android.andreicasquizzapp.R.string.user_name;

public class MainActivity extends AppCompatActivity {

    /**
     * Declare global variables
     */
    int actualScore = 0;
    int maxScore = 5;
    String questionOne;
    String questionTwo;
    String questionThree;
    String questionFive;
    String questionFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**This method evaluates the answer for the first question in the quiz
     * in order to display a short message showing the user whether the selected answer
     * is correct or incorrect. It is activated once a radio button is selected.
     * @param myView - the actual radio button selected by user
     * @param questionOne - string is used to record whether the selected
     *                    answer is correct or incorrect; used in composing a summary
     *                    to be emailed to the user in the getQuizResults method below
     */
    public void evaluateQuestionOne(View myView) {
        /**answer 1b is the correct answer*/
        if (null == myView) return;

        RadioButton myRadioButton = (RadioButton) myView;

        RadioButton answer1aRadioButton = (RadioButton) findViewById(R.id.answer1a);
        RadioButton answer1bRadioButton = (RadioButton) findViewById(R.id.answer1b);
        RadioButton answer1cRadioButton = (RadioButton) findViewById(R.id.answer1c);

        if (myRadioButton.getId() == R.id.answer1b) {
            Toast.makeText(this, correct_message, Toast.LENGTH_SHORT).show();
            questionOne = getText(short_correct_message).toString();
            return;

        } else {
            Toast.makeText(this, incorrect_message, Toast.LENGTH_SHORT).show();
            questionOne = getText(short_incorrect_message).toString();
            return;
        }


    }
    /**This method evaluates the answer for the second question in the quiz
     * in order to display a short message showing the user whether the selected answer
     * is correct or incorrect. It is activated once a checkbox is selected.
     * @param questionTwo - string is used to record whether the selected
     *                    answer is correct or incorrect; used in composing a summary
     *                    to be emailed to the user in the getQuizResults method below
     */
    public void evaluateQuestionTwo(View myView) {
        /** the correct answer is formed of answers 1a and 1d simultaneously */

        CheckBox answer2aCheckBox = (CheckBox) findViewById(R.id.answer2a_checkbox);
        CheckBox answer2bCheckBox = (CheckBox) findViewById(R.id.answer2b_checkbox);
        CheckBox answer2cCheckBox = (CheckBox) findViewById(R.id.answer2c_checkbox);
        CheckBox answer2dCheckBox = (CheckBox) findViewById(R.id.answer2d_checkbox);

        boolean answer2aSelected = answer2aCheckBox.isChecked();
        boolean answer2bSelected = answer2bCheckBox.isChecked();
        boolean answer2cSelected = answer2cCheckBox.isChecked();
        boolean answer2dSelected = answer2dCheckBox.isChecked();

        if (answer2aSelected && !answer2dSelected && !answer2bSelected && !answer2cSelected) {
            Toast.makeText(this, almost, Toast.LENGTH_SHORT).show();
            questionTwo = getText(partial).toString();
            return;
        }

        if (!answer2aSelected && answer2dSelected && !answer2bSelected && !answer2cSelected) {
            Toast.makeText(this, almost, Toast.LENGTH_SHORT).show();
            questionTwo = getText(partial).toString();
            return;
        }

        if (answer2aSelected && answer2dSelected && !answer2bSelected && !answer2cSelected) {
            Toast.makeText(this, correct_message, Toast.LENGTH_SHORT).show();
            questionTwo = getText(short_correct_message).toString();
            return;
        } else {
            Toast.makeText(this, incorrect_message, Toast.LENGTH_SHORT).show();
            questionTwo = getText(short_incorrect_message).toString();
            return;
        }


    }
    /**This method evaluates the answer for the third question in the quiz
     * in order to display a short message showing the user whether the selected answer
     * is correct or incorrect. It is activated when the user finishes typing in the answer
     * and taps the EditText View.
     * @param questionThree - string is used to record whether the selected
     *                    answer is correct or incorrect; used in composing a summary
     *                    to be emailed to the user in the getQuizResults method below
     */
    public void evaluateQuestionThree(View myView) {
        /** correct answer is equal to value saved in string resource */

        EditText questionThreeAnswer = (EditText) findViewById(R.id.answer3_EdtTxt);
        String actualAnswer = questionThreeAnswer.getText().toString();
        if (actualAnswer.equalsIgnoreCase(getText(answerQuestion3).toString())) {
            Toast.makeText(this, correct_message, Toast.LENGTH_SHORT).show();
            questionThree = getText(short_correct_message).toString();
            return;
        } else {
            Toast.makeText(this, incorrect_message, Toast.LENGTH_SHORT).show();
            questionThree = getText(short_incorrect_message).toString();
            return;
        }

    }
    /**This method evaluates the answer for the fourth question in the quiz
     * in order to display a short message showing the user whether the selected answer
     * is correct or incorrect. It is activated once a checkbox is selected.
     * @param questionFour - string is used to record whether the selected
     *                    answer is correct or incorrect; used in composing a summary
     *                    to be emailed to the user in the getQuizResults method below
     */
    public void evaluateQuestionFour(View myView) {
        /**answer 4c is the correct answer*/
        if (null == myView) return;

        RadioButton myRadioButton = (RadioButton) myView;

        RadioButton answer4aRadioButton = (RadioButton) findViewById(R.id.answer4a);
        RadioButton answer4bRadioButton = (RadioButton) findViewById(R.id.answer4b);
        RadioButton answer4cRadioButton = (RadioButton) findViewById(R.id.answer4c);

        if (myRadioButton.getId() == R.id.answer4c) {
            Toast.makeText(this, correct_message, Toast.LENGTH_SHORT).show();
            questionFour = getText(short_correct_message).toString();
            return;

        } else {
            Toast.makeText(this, incorrect_message, Toast.LENGTH_SHORT).show();
            questionFour = getText(short_incorrect_message).toString();
            return;
        }


    }
    /**This method evaluates the answer for the second question in the quiz
     * in order to display a short message showing the user whether the selected answer
     * is correct or incorrect. It is activated once a checkbox is selected.
     * @param questionFive - string is used to record whether the selected
     *                    answer is correct or incorrect; used in composing a summary
     *                    to be emailed to the user in the getQuizResults method below
     */
    public void evaluateQuestionFive(View myView) {
        /**answer 5a is the correct answer*/
        if (null == myView) return;

        RadioButton myRadioButton = (RadioButton) myView;

        RadioButton answer5aRadioButton = (RadioButton) findViewById(R.id.answer5a);
        RadioButton answer5bRadioButton = (RadioButton) findViewById(R.id.answer5b);
        RadioButton answer5cRadioButton = (RadioButton) findViewById(R.id.answer5c);

        if (myRadioButton.getId() == R.id.answer5a) {
            Toast.makeText(this, correct_message, Toast.LENGTH_SHORT).show();
            questionFive = getText(short_correct_message).toString();
            return;

        } else {
            Toast.makeText(this, incorrect_message, Toast.LENGTH_SHORT).show();
            questionFive = getText(short_incorrect_message).toString();
            return;
        }


    }

    /**
     * This method calculates the actual points accumulated by the quiz taker.
     * @param actualScore - integer storing the value of the points accumulated.
     *                    Each question answered correctly adds one point to the
     *                    actual score. There are no points granted for questions
     *                    answered partially or incorrect.
     * @return - returns the final actual score upon completion of the quiz
     */
    private int calculateScore(int actualScore) {
        actualScore = 0;
        RadioButton answer1bRadioButton = (RadioButton) findViewById(R.id.answer1b);

        if (answer1bRadioButton.isChecked()) {
            actualScore += 1;
        }

        CheckBox answer2aCheckBox = (CheckBox) findViewById(R.id.answer2a_checkbox);
        CheckBox answer2dCheckBox = (CheckBox) findViewById(R.id.answer2d_checkbox);

        if (answer2aCheckBox.isChecked() && answer2dCheckBox.isChecked()) {
            actualScore += 1;
        }

        EditText questionThreeAnswer = (EditText) findViewById(R.id.answer3_EdtTxt);
        String actualAnswer = questionThreeAnswer.getText().toString();
        if (actualAnswer.equalsIgnoreCase(getText(answerQuestion3).toString())) {
            actualScore += 1;
        }

        RadioButton answer4cRadioButton = (RadioButton) findViewById(R.id.answer4c);

        if (answer4cRadioButton.isChecked()) {
            actualScore += 1;
        }
        RadioButton answer5aRadioButton = (RadioButton) findViewById(R.id.answer5a);

        if (answer5aRadioButton.isChecked()) {
            actualScore += 1;
        }
        return actualScore;

    }

    /**
     * This method is called when the SUBMIT button is pressed.
     * It obtains the score and puts together a summary of the quiz results
     * in order for the user to send this information via e-mail.
     */
    public void getQuizResults(View view) {
        EditText quizTakerEdtTxt = (EditText) findViewById(R.id.name_field);
        String quizTakerName = quizTakerEdtTxt.getText().toString();
        String emailSubjectLine = "Quiz Results For  " + quizTakerName;

        actualScore = calculateScore(actualScore);

        String quizResults = "Dear " + quizTakerName + "," + "\nThank you for taking this quiz. \nYour quiz results are below:";
        quizResults += "\nYou answered " + actualScore + " questions out of " + maxScore + " correctly";
        quizResults += "\nPlease find a summary of your answers below:";
        quizResults += "\nQuestion 1: " + questionOne;
        quizResults += "\nQuestion 2: " + questionTwo;
        quizResults += "\nQuestion 3: " + questionThree;
        quizResults += "\nQuestion 4: " + questionFour;
        quizResults += "\nQuestion 5: " + questionFive;

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubjectLine);
        intent.putExtra(Intent.EXTRA_TEXT, quizResults);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /**
     * This method is called when the RESET button is pressed.
     * It resets the actual score to zero and sets all the RadioButtons, Checkboxes
     * and EditText views to be unchecked and blank, respectively.
     */
    public void reset(View view) {
        actualScore = 0;

        EditText quizTakerEdtTxt = (EditText) findViewById(R.id.name_field);
        quizTakerEdtTxt.setText(user_name);

        RadioButton answer1aRadioButton = (RadioButton) findViewById(R.id.answer1a);
        answer1aRadioButton.setChecked(false);
        RadioButton answer1bRadioButton = (RadioButton) findViewById(R.id.answer1b);
        answer1bRadioButton.setChecked(false);
        RadioButton answer1cRadioButton = (RadioButton) findViewById(R.id.answer1c);
        answer1cRadioButton.setChecked(false);

        CheckBox answer2aCheckBox = (CheckBox) findViewById(R.id.answer2a_checkbox);
        answer2aCheckBox.setChecked(false);
        CheckBox answer2bCheckBox = (CheckBox) findViewById(R.id.answer2b_checkbox);
        answer2bCheckBox.setChecked(false);
        CheckBox answer2cCheckBox = (CheckBox) findViewById(R.id.answer2c_checkbox);
        answer2cCheckBox.setChecked(false);
        CheckBox answer2dCheckBox = (CheckBox) findViewById(R.id.answer2d_checkbox);
        answer2dCheckBox.setChecked(false);

        EditText questionThreeAnswer = (EditText) findViewById(R.id.answer3_EdtTxt);
        questionThreeAnswer.setText("");

        RadioButton answer4aRadioButton = (RadioButton) findViewById(R.id.answer4a);
        answer4aRadioButton.setChecked(false);
        RadioButton answer4bRadioButton = (RadioButton) findViewById(R.id.answer4b);
        answer4bRadioButton.setChecked(false);
        RadioButton answer4cRadioButton = (RadioButton) findViewById(R.id.answer4c);
        answer4cRadioButton.setChecked(false);

        RadioButton answer5aRadioButton = (RadioButton) findViewById(R.id.answer5a);
        answer5aRadioButton.setChecked(false);
        RadioButton answer5bRadioButton = (RadioButton) findViewById(R.id.answer5b);
        answer5bRadioButton.setChecked(false);
        RadioButton answer5cRadioButton = (RadioButton) findViewById(R.id.answer5c);
        answer5cRadioButton.setChecked(false);

        questionOne = null;
        questionTwo = null;
        questionThree = null;
        questionFour = null;
        questionFive = null;
    }
}
