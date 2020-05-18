package com.abner.caculater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.abner.caculater.utils.CalculateUtil;

public class CalculaterActivity extends AppCompatActivity {
    private EditText inputView;
    private View handleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculater);
        initView();
    }

    private void initView() {
        inputView = findViewById(R.id.calculate_input);
        handleView = findViewById(R.id.calculate_handle);

        inputView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        handleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputView.setText(CalculateUtil.calculate(inputView.getText().toString()));
            }
        });

    }
}
