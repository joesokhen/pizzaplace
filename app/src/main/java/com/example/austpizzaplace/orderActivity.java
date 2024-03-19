package com.example.austpizzaplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class orderActivity extends AppCompatActivity {

    RadioButton vg, pe, lb;
    Spinner qty;
    Button placeOrder, clear;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        vg = findViewById(R.id.rbVegeterian);
        pe = findViewById(R.id.rbPepperoni);
        lb = findViewById(R.id.rbLebanese);

        qty = findViewById(R.id.spQty);
        result = findViewById(R.id.tvResult);

        placeOrder = findViewById(R.id.btnPlaceOrder);

        clear = findViewById(R.id.btnClear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//prevent stacking activities by clearing it after ordering.
            }
        });
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double price = 0;
                String type = "";
                //!! We should not should use isSelected!!
                if (vg.isChecked()) {
                    price = 5;
                    type = vg.getText().toString();
                }

                if (pe.isChecked()) {
                    price = 7;
                    type = pe.getText().toString();
                }

                if (lb.isChecked()) {
                    price = 10;
                    type = lb.getText().toString();
                }


                String q = qty.getSelectedItem().toString();
                double total = price * Double.parseDouble(q);

//                Toast.makeText(orderActivity.this, "Total Price: "+total, Toast.LENGTH_SHORT).show();
                result.setText("Order Details : \n\n" + "Pizza Type: "+ type + "\nQuantity: " + q + "\nPrice: " + total);

            }
        });
    }
}