package solarthon.google.com.solarcalculator;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name1[]=new String[20];
    int wattage1[]=new int[20];
    int usage1[]=new int[20];
    int quantity1[]=new int[20];
    int tLoad=0;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);i=0;
        FloatingActionButton f1 = findViewById(R.id.find_cost);
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

cost();


            }
        });
    }
    public void addLoad(View view) {
        EditText e1 =findViewById(R.id.appliance);
        EditText e2 =findViewById(R.id.wattage);
        EditText e3 =findViewById(R.id.usage);
        EditText e4 =findViewById(R.id.quantity);
        usage1[i] = Integer.parseInt(e3.getText().toString());
        if (usage1[i]>24)
            Toast.makeText(MainActivity.this,"Usage cannot be greater than 24 hours",Toast.LENGTH_SHORT).show();
        name1[i] = e1.getText().toString();
        wattage1[i] = Integer.parseInt(e2.getText().toString());

        quantity1[i] = Integer.parseInt(e4.getText().toString());
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        i++;
    }
    public void delete(View view){
        i--;}
        public void calculate(View view){
tLoad=0;
        for(int j=0;j<=i;j++)
        {tLoad+=wattage1[j]*usage1[j]*quantity1[j];}
        double tLoad1=tLoad*0.001;
        EditText e5 =findViewById(R.id.total_load);
        e5.setText(Double.toString(tLoad1));}
        public void cost()
        {
            Intent intent = new Intent(this,HardwareInfoActivity.class);
            intent.putExtra("totalL",Integer.toString(tLoad));
            startActivity(intent);
        }

                }
