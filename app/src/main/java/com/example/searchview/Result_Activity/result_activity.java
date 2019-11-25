package com.example.searchview.Result_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.searchview.Adapter.Model.modelclass;
import com.example.searchview.R;

public class result_activity extends AppCompatActivity
{
    TextView show_text;
    modelclass mclass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);

        show_text = findViewById(R.id.show_text);

        mclass = (modelclass)getIntent().getSerializableExtra("modelclass");
        show_text.setText(String.valueOf(mclass.getName()));


    }
}
