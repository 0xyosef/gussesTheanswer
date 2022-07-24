package com.dark.gussestheanswer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    private TextView mTextViewAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ansewr);
        mTextViewAnswer = findViewById(R.id.view_answer);
        // to read the question from the intent and view answer
        String answer = getIntent().getStringExtra("answer");
        if (answer != null){
            mTextViewAnswer.setText(answer);
        }
}
    public void returnButton(View view) {
        finish();
    }
}