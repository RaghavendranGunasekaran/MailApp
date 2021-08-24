package com.raghav.emailapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaring EditText
    private EditText editTextEmail;
    private EditText editTextSubject;
    private EditText editTextMessage;

    //Send button
    private AppCompatButton buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing the views
        editTextEmail =  findViewById(R.id.editTextEmail);
        editTextSubject =  findViewById(R.id.editTextSubject);
        editTextMessage =  findViewById(R.id.editTextMessage);

        buttonSend =  findViewById(R.id.buttonSend);

        //Adding click listener
        buttonSend.setOnClickListener(this);
    }


    private void sendEmail() {
        //Getting content for email
        String email = editTextEmail.getText().toString().trim();
        String subject = editTextSubject.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(this, "email can't be empty", Toast.LENGTH_SHORT).show();
        }else if (subject.isEmpty()) {
            Toast.makeText(this, "subject can't be empty", Toast.LENGTH_SHORT).show();
        }else if (message.isEmpty()) {
            Toast.makeText(this, "message can't be empty", Toast.LENGTH_SHORT).show();
        }else {
            //Creating SendMail object
            SendMail sm = new SendMail(this, email, subject, message);

            //Executing sendmail to send email
            sm.execute();
        }



    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }
}