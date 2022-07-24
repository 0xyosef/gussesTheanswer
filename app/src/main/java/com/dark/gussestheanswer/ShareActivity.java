package com.dark.gussestheanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ShareActivity extends AppCompatActivity {
    private String mQuestionText;
    private EditText mEditTextShareTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        mEditTextShareTitle = findViewById(R.id.edit_text_share_title);
        // to read the question from the intent and view answer
        mQuestionText = getIntent().getStringExtra("question text extra");
        SharedPreferences sharedPreferences = getSharedPreferences("app pref", MODE_PRIVATE);
        String questionTitle = sharedPreferences.getString("share title", "");
        mEditTextShareTitle.setText(questionTitle);

    }
    public void onShareButton(View view) {
        String questionTitle = mEditTextShareTitle.getText().toString();
        String shareBody = mQuestionText;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, questionTitle);
        intent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(intent);

        SharedPreferences sharedPreferences = getSharedPreferences("app pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("share title", questionTitle);
        editor.apply();
    }
}