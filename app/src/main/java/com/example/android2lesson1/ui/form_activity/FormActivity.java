package com.example.android2lesson1.ui.form_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android2lesson1.R;

public class FormActivity extends AppCompatActivity {
    private EditText editText;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        editText = findViewById(R.id.edit_desk);
        save = findViewById(R.id.btn_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                    editText.setError("Заполните поле!");
                    return;
                } else {
                    intent.putExtra("key", editText.getText().toString().trim());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
