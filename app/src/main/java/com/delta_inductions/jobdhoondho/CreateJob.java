package com.delta_inductions.jobdhoondho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.delta_inductions.jobdhoondho.Model.Post;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class CreateJob extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "CreateJob";
    private static final String KEY_POSITION ="position";
    private static final String KEY_SALARY="salary";
    private FirebaseFirestore db =  FirebaseFirestore.getInstance();
    private EditText position;
    private EditText salary;
    private EditText location;
    private EditText Work_period;
    private EditText Description;
    private boolean clickedonce = false;
    private Button post;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_job);
        position = findViewById(R.id.position);
        salary = findViewById(R.id.salary);
        location = findViewById(R.id.location);
        Work_period =  findViewById(R.id.work_period);
        Description = findViewById(R.id.job_description);
        post = findViewById(R.id.btn_post);
        progressBar = findViewById(R.id.progressBar);
        position.addTextChangedListener(textWatcher);
        salary.addTextChangedListener(textWatcher);
        location.addTextChangedListener(textWatcher);
        Work_period.addTextChangedListener(textWatcher);
        Description.addTextChangedListener(textWatcher);
        post.setOnClickListener(this);
    }
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
             String positioninput = position.getText().toString().trim();
             String salaryinput = salary.getText().toString().trim();
             String locationinput = location.getText().toString().trim();
             String work_period = Work_period.getText().toString().trim();
             String description = Description.getText().toString().trim();
             post.setEnabled((!positioninput.isEmpty())&&(!salaryinput.isEmpty())&&(!locationinput.isEmpty())&&(!work_period.isEmpty())
             &&(!description.isEmpty()));
             if(post.isEnabled())
             {
                 post.setTextColor(Color.parseColor("#ffffff"));
//                 Log.d(TAG, "onTextChanged: "+true);
             }
             else
             {
//                 Log.d(TAG, "onTextChanged: "+false);
                 post.setTextColor(1107296256);
             }
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };
    @Override
    public void onClick(View v) {
        if (!clickedonce) {
            progressBar.setVisibility(View.VISIBLE);
            String positiontext = position.getText().toString();
            String salarytext = salary.getText().toString();
            String locationtext = location.getText().toString();
            String work_periodtext = Work_period.getText().toString();
            String descriptiontext = Description.getText().toString();
            CollectionReference Postref = FirebaseFirestore.getInstance().collection("Recruiter");
            Postref.add(new Post(positiontext,salarytext,locationtext,work_periodtext,descriptiontext, Timestamp.now().toDate()));
            Toast.makeText(this, "Job posted", Toast.LENGTH_SHORT).show();
            goback();
        }
        clickedonce= true;
    }
    private void goback()
    {
        super.onBackPressed();
    }
}