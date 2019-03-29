package com.example.myother;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner dropdownmenu;
    private EditText amountindollars;
    private Button gotosecondactivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating Button
        gotosecondactivity = (Button) findViewById(R.id.convertID);
        gotosecondactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Conversion Logic

                //The different currencies
                double cedi,franc,euro,won,pound;
                cedi = 109.99;
                franc = 6.70962;
                euro = 1.35075;
                won = 1132.98;
                pound = 41.8120;

                //Result holders
                double cedi1,franc1,euro1,won1,pound1;

                double value;


                //Take value user enters in the amountindollars,parse as a double and store in resultvalue
                Double resultvalue = Double.parseDouble(amountindollars.getText().toString());
                cedi1 = resultvalue*cedi;
                franc1 = resultvalue*franc;
                euro1 = resultvalue*euro;
                won1 = resultvalue*won;
                pound1 = resultvalue*pound;

                // amountindollars.setText(resultvalue);

                // Double value = Double.parseDouble(amountindollars.getText().toString());
                Intent intent = new Intent(MainActivity.this,ShowCurrency.class);
                intent.putExtra("show", resultvalue);
                startActivity(intent);




            }
        });


        //Getting Amount in Dollars
        amountindollars = (EditText) findViewById(R.id.fromdollarsID);

        //Creating the SPINNER
        //Creating the list of currencies to be displayed
        dropdownmenu = (Spinner) findViewById(R.id.currenciesID);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.currencies,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownmenu.setAdapter(adapter );
        dropdownmenu.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String itemvalue = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), itemvalue, Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
