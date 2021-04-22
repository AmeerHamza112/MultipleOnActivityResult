package com.example.multipleonactivityresult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.multipleonactivityresult.databinding.ActivitySecondBinding;
import com.example.multipleonactivityresult.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityThirdBinding binding;
    int FirstNumber,SecondNumber,Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_third);

        FirstNumber=getIntent().getIntExtra("firstNumber",0);
        SecondNumber=getIntent().getIntExtra("secondNumber",0);
        binding.textViewResult.setText(String.valueOf(FirstNumber)+" + "+String.valueOf(SecondNumber));
        binding.buttonSum.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent intent=new Intent(this,FourthActivity.class);
        intent.putExtra("firstNumber",FirstNumber);
        intent.putExtra("secondNumber",SecondNumber);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                setResult(resultCode);
                int result=data.getIntExtra("result",0);


                Intent returnIntent=new Intent();
                returnIntent.putExtra("result",result);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//on
}