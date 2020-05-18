package com.abner.practicecollect.jni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.abner.practicecollect.R;

public class JNIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni);
        final JniHelper jniHelper = new JniHelper();
        View view =findViewById(R.id.hello_jni);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),jniHelper.helloJNI(),Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.int_jni).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),String.valueOf(jniHelper.add(4,5)),Toast.LENGTH_LONG).show();;
            }
        });
        findViewById(R.id.string_jni).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),jniHelper.sysHelloInC("abcd"),Toast.LENGTH_LONG).show();;
            }
        });
        findViewById(R.id.array_jni).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] arr = new int[]{1,2,3,4};
                int[] arr1 = jniHelper.arrayElementsIncrease(arr);
                for(int e:arr1){
                    System.out.println("e：" + e);
                }
            }
        });
        findViewById(R.id.callback_void).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jniHelper.callbackVoid();
            }
        });
        findViewById(R.id.callback_int).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jniHelper.callbackInt();
            }
        });

        findViewById(R.id.callback_string).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jniHelper.callbackString();
            }
        });
    }

}