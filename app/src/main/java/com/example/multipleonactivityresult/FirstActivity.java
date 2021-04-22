package com.example.multipleonactivityresult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.view.View;

import com.example.multipleonactivityresult.databinding.ActivityFirstBinding;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {


    ActivityFirstBinding binding;
    int FirstNumber,SecondNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(
            this,R.layout.activity_first);
        binding.buttonSum.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        FirstNumber=Integer.parseInt(binding.editTextFirstNumber.getText().toString());
        SecondNumber=Integer.parseInt(binding.editTextSecondNumber.getText().toString());

        Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
        intent.putExtra("firstNumber",FirstNumber);
        intent.putExtra("secondNumber",SecondNumber);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                int result=data.getIntExtra("result",0);
                binding.textViewResult.setText("Sum is = "+String.valueOf(result));
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//on
}