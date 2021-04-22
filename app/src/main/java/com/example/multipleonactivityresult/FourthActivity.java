package com.example.multipleonactivityresult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.multipleonactivityresult.databinding.ActivityFourthBinding;
import com.example.multipleonactivityresult.databinding.ActivityThirdBinding;

public class FourthActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityFourthBinding binding;
    int FirstNumber,SecondNumber,Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_fourth);

        FirstNumber=getIntent().getIntExtra("firstNumber",0);
        SecondNumber=getIntent().getIntExtra("secondNumber",0);
        binding.textViewResult.setText(String.valueOf(FirstNumber)+" + "+String.valueOf(SecondNumber));
        binding.buttonSum.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Result=FirstNumber+SecondNumber;
        Intent returnIntent=new Intent();
        returnIntent.putExtra("result",Result);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}