package com.example.hw_3_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);
        Button sendEmailButton = findViewById(R.id.sendEmailButton);
        Button goToSecondScreenButton = findViewById(R.id.goToSecondScreenButton);

        sendEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        goToSecondScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondScreen();
            }
        });
    }

    private void sendEmail() {
        String emailText = emailEditText.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:")); // только email
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Тема письма");
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        }
    }

    private void goToSecondScreen() {
        Intent intent = new Intent(MainActivity.this, SecondActivity1.class);
        startActivity(intent);
    }
}
