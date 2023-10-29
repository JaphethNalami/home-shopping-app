package com.example.shelf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button Milk, Sugar, Flour, Bread, Total, Discount, Net;
    private TextView Milk_p, Milk_v, Milk_a;
    private TextView Sugar_p, Sugar_v, Sugar_a;
    private TextView Flour_p, Flour_v, Flour_a;
    private TextView Bread_p, Bread_v, Bread_a;
    private TextView Grand_t;
    private TextView Discount_t;
    private TextView Net_t;

    private float grandtotal = 0;
    private float discounttotal = 0;
    private float netpaytotal =  0;

    private float milkprice = 0;
    private float sugarprice = 0;
    private float flourprice = 0;
    private float breadprice = 0;

    private int milkcount = 0;
    private int sugarcount = 0;
    private int flourcount = 0;
    private int breadcount = 0;

    private float price;
    private float shelf_price = 0;
    private float vat = 0;

    private float milkactualPrice = 0;
    private float sugaractualPrice = 0;
    private float flouractualPrice = 0;
    private float breadactualPrice = 0;


    //constructor to set the price


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buttons
        Milk = findViewById(R.id.milk);
        Sugar = findViewById(R.id.sugar);
        Flour = findViewById(R.id.flour);
        Bread = findViewById(R.id.bread);
        Total = findViewById(R.id.total);
        Discount = findViewById(R.id.discount);
        Net = findViewById(R.id.netpay);

        //milk
        Milk_p = findViewById(R.id.milk_p);
        Milk_v = findViewById(R.id.milk_v);
        Milk_a = findViewById(R.id.milk_a);

        //sugar
        Sugar_p = findViewById(R.id.sugar_p);
        Sugar_v = findViewById(R.id.sugar_v);
        Sugar_a = findViewById(R.id.sugar_a);

        //flour
        Flour_p = findViewById(R.id.flour_p);
        Flour_v = findViewById(R.id.flour_v);
        Flour_a = findViewById(R.id.flour_a);

        //bread
        Bread_p = findViewById(R.id.bread_p);
        Bread_v = findViewById(R.id.bread_v);
        Bread_a = findViewById(R.id.bread_a);

        //grand total
        Grand_t = findViewById(R.id.grand_t);

        //discount
        Discount_t = findViewById(R.id.discount_t);

        //net pay
        Net_t = findViewById(R.id.net_t);

        //initializing price of items
        milkprice = 1000;
        sugarprice = 2000;
        flourprice = 3000;
        breadprice = 4000;

        //milk button
        Milk.setOnClickListener(v -> {
            if (milkcount<4){
                milkcount++;
                shelf_price=(milkprice * milkcount);
                vat = (shelf_price*0.16f);
                milkactualPrice = (shelf_price + vat);
                Milk_p.setText(String.valueOf(shelf_price));
                Milk_v.setText(String.valueOf(vat));
                Milk_a.setText(String.valueOf(milkactualPrice));
            }
            else {
                Toast.makeText(MainActivity.this, "You have reached the maximum number of items", Toast.LENGTH_SHORT).show();
            }
        });

        //sugar button
        Sugar.setOnClickListener(v -> {
            if (sugarcount<4){
                sugarcount++;
                shelf_price=(sugarprice * sugarcount);
                vat = (shelf_price*0.16f);
                sugaractualPrice = (shelf_price + vat);
                Sugar_p.setText(String.valueOf(shelf_price));
                Sugar_v.setText(String.valueOf(vat));
                Sugar_a.setText(String.valueOf(sugaractualPrice));
            }
            else {
                Toast.makeText(MainActivity.this, "You have reached the maximum number of items", Toast.LENGTH_SHORT).show();
            }
        });

        //flour button
        Flour.setOnClickListener(v -> {
            if (flourcount<4){
                flourcount++;
                shelf_price=(flourprice * flourcount);
                vat = (shelf_price*0.16f);
                flouractualPrice = (shelf_price + vat);
                Flour_p.setText(String.valueOf(shelf_price));
                Flour_v.setText(String.valueOf(vat));
                Flour_a.setText(String.valueOf(flouractualPrice));
            }
            else {
                Toast.makeText(MainActivity.this, "You have reached the maximum number of items", Toast.LENGTH_SHORT).show();
            }
        });

        //bread button
        Bread.setOnClickListener(v -> {
            if (breadcount<4){
                breadcount++;
                shelf_price=(breadprice * breadcount);
                vat = (shelf_price*0.16f);
                breadactualPrice = (shelf_price + vat);
                Bread_p.setText(String.valueOf(shelf_price));
                Bread_v.setText(String.valueOf(vat));
                Bread_a.setText(String.valueOf(breadactualPrice));
            }
            else {
                Toast.makeText(MainActivity.this, "You have reached the maximum number of items", Toast.LENGTH_SHORT).show();
            }
        });

        //total button
        Total.setOnClickListener(v -> {
            grandtotal = (milkactualPrice + sugaractualPrice + flouractualPrice + breadactualPrice);
            Grand_t.setText(String.valueOf(grandtotal));
        });

        //discount button
        Discount.setOnClickListener(v -> {
            if(grandtotal > 10000){
            discounttotal = (grandtotal * 0.15f);
            Discount_t.setText(String.valueOf(discounttotal));
        }
            else {
                Toast.makeText(MainActivity.this, "You have not reached the minimum amount for discount", Toast.LENGTH_SHORT).show();
            }
        });

        //net pay button
        Net.setOnClickListener(v -> {
            netpaytotal = (grandtotal - discounttotal);
            Net_t.setText(String.valueOf(netpaytotal));
        });


    }
}