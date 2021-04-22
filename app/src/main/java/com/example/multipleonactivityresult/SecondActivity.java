package com.example.multipleonactivityresult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.multipleonactivityresult.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    ActivitySecondBinding binding;
    int FirstNumber,SecondNumber,Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_second);
        FirstNumber=getIntent().getIntExtra("firstNumber",0);
        SecondNumber=getIntent().getIntExtra("secondNumber",0);
        binding.textViewResult.setText(String.valueOf(FirstNumber)+" + "+String.valueOf(SecondNumber));
        binding.buttonSum.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
//        Result=FirstNumber+SecondNumber;
//        Intent returnIntent=new Intent();
//        returnIntent.putExtra("result",Result);
//        setResult(Activity.RESULT_OK,returnIntent);
//        finish();

        Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
        intent.putExtra("firstNumber",FirstNumber);
        intent.putExtra("secondNumber",SecondNumber);
        intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        startActivity(intent);
        finish();
    }
}