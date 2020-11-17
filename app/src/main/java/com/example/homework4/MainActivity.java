package com.example.homework4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText urlEditText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button=findViewById(R.id.button);
        this.urlEditText=findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String url=urlEditText.getText().toString();
                Intent intent=new Intent(Intent.ACTION_VIEW);
                Uri uri=Uri.parse(url);
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }
}
