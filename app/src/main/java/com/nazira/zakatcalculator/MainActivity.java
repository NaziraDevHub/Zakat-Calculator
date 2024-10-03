package com.nazira.zakatcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etCash, etGold, etLiabilities;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCash = findViewById(R.id.etCash);
        etGold = findViewById(R.id.etGold);
        etLiabilities = findViewById(R.id.etLiabilities);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mySrring1 = etCash.getText().toString();
                String mySrring2 = etGold.getText().toString();
                String mySrring3 = etLiabilities.getText().toString();

                if (mySrring1.length()>0 && mySrring2.length()>0 && mySrring3.length()>0) {

                    double cashInHand = Double.parseDouble(mySrring1);
                    double goldValue = Double.parseDouble(mySrring2);
                    double liabilities = Double.parseDouble(mySrring3);
                    double netAssets = cashInHand + goldValue - liabilities;

                    if (netAssets > 0) {

                        double zakatAmount = netAssets * 0.025;
                        DecimalFormat df = new DecimalFormat("#.##");
                        String formattedZakat = df.format(zakatAmount);


                        tvResult.setText("Your Zakat is: BDT " + formattedZakat);
                    } else {

                        tvResult.setText("No Zakat due.");
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please fill all the fields.", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}