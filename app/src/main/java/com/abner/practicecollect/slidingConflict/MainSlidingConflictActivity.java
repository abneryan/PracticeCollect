package com.abner.practicecollect.slidingConflict;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abner.practicecollect.R;

public class MainSlidingConflictActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_conflict);
        findViewById(R.id.conflict1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //scrollView + RecycleView   //相向方向时间冲突
                Intent conflictIntent = new Intent(getBaseContext(), ScrollViewRecycleViewActivity.class);
                startActivity(conflictIntent);
            }
        });
        findViewById(R.id.conflict2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
