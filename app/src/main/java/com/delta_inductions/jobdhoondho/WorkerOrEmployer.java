package com.delta_inductions.jobdhoondho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class WorkerOrEmployer extends AppCompatActivity implements View.OnClickListener{
private CardView employer;
private CardView worker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_or_employer);
        employer = findViewById(R.id.employer);
        worker = findViewById(R.id.worker);
        employer.setOnClickListener(this);
        worker.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==employer.getId())
            startActivity(new Intent(this,EmployerActivity.class));
    }
}