package com.example.hackeru.tipcalculator;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText priceET, percentET;
    private TextView resultTV;
    private Button calculateBtn;
    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priceET = (EditText) findViewById(R.id.activity_main_price_edit_text);
        percentET = (EditText) findViewById(R.id.activity_main_percent_edit_text);
        resultTV = (TextView) findViewById(R.id.activity_main_result_text_view);
        calculateBtn = (Button) findViewById(R.id.activity_main_calculate_button);

        group = (RadioGroup) findViewById(R.id.activity_main_radio_group);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
                /*
                if (checkedId == R.id.third_radio_button) {
                    percentET.setVisibility(View.VISIBLE);
                }else{
                    percentET.setVisibility(View.INVISIBLE);
                }
                */
                calculateBtn.setEnabled(true);
                percentET.setVisibility(checkedId == R.id.third_radio_button ? View.VISIBLE : View.INVISIBLE);
            }
        });

    }

    public void calculate(View view) {
        String priceAsString = priceET.getText().toString();
        String percentAsString = percentET.getText().toString();
        int percent = 0;
        double price = 0;
        try {
            price = Double.parseDouble(priceAsString);
            percent = Integer.parseInt(percentAsString);
        }catch(NumberFormatException e) {

        }
        if (price == 0) {
            priceET.setError("Problem with price");
            return;
        }
        int checkedId = group.getCheckedRadioButtonId();
        switch (checkedId) {
            case R.id.first_radio_button:
                calculate(price, 10);
                break;
            case R.id.second_radio_button:
                calculate(price, 20);
                break;
            default:
                if (percent > 0 && percent <= 100) {
                    calculate(price, percent);
                }else{
                    percentET.setError("WOW!!!!! too much");
                }
        }
    }

    private void calculate(double price, int percent) {
        double total = price * percent / 100;
        resultTV.setText("Your tip is: " + total + "\nThe total price is: " + (total + price));
    }
}
