package com.dark.gussestheanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity {
    private TextView mTextViewQuestion;
    private Random mrandom;
    private String[] QUESTIONS ;
    private static final boolean[] ANSWERS = {
            false,
            true,
            true,
            false,
            true,
            false,
            false,
            false,
            false,
            true,
            true,
            false,
            true
    };
    private  String[] ANSWERS_DETAILS ;
    int mRandomQuestionIndex;
    private String mCurrentQuestion,mCurrentAnswerDetail;
    private boolean mCurrentAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewQuestion=findViewById(R.id.view_qustion);
        QUESTIONS =getResources().getStringArray(R.array.questions);
        ANSWERS_DETAILS =getResources().getStringArray(R.array.answers_details);
        mrandom=new Random();
        showNewQuestion();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    private void showNewQuestion(){
        mRandomQuestionIndex =mrandom.nextInt(QUESTIONS.length);
        mCurrentQuestion=QUESTIONS[mRandomQuestionIndex];
        mCurrentAnswer=ANSWERS[mRandomQuestionIndex];
        mCurrentAnswerDetail=ANSWERS_DETAILS[mRandomQuestionIndex];
        mTextViewQuestion.setText(mCurrentQuestion);
    }
    public void onChangeQuestionOnClick(View view){
        showNewQuestion();
    }
    public void onTrueClicked(View view){
        if (mCurrentAnswer==true){
            Toast.makeText(this,"الاجابه صحيحه ",Toast.LENGTH_SHORT).show();
            showNewQuestion();
        }else {
            Toast.makeText(this,"الاجابه خاطئه ",Toast.LENGTH_SHORT).show();
            //to change between activity
            //Intent is used to switch between activities and taking the current activity and switching to the next activity
            Intent intent=new Intent(QuestionActivity.this,AnswerActivity.class);
            //putExtra is used to pass data from one activity to another activity
            intent.putExtra("answer",mCurrentAnswerDetail);
           startActivity(intent);
        }
    }
    public void onFalseClick(View view){
        if (mCurrentAnswer==false){
            Toast.makeText(this,"الاجابه صحيحه ",Toast.LENGTH_SHORT).show();
            showNewQuestion();
        }else {
            Toast.makeText(this,"الاجابه خاطئه ",Toast.LENGTH_SHORT).show();
            //to change between activity
            Intent intent=new Intent(QuestionActivity.this,AnswerActivity.class);
            intent.putExtra("answer",mCurrentAnswerDetail);
            startActivity(intent);
        }
    }
    public void onShareQuestion(View view){
        Intent intent=new Intent(QuestionActivity.this,ShareActivity.class);
        intent.putExtra("answer",mCurrentQuestion);
        startActivity(intent);
    }

}