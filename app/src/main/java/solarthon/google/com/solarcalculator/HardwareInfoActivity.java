package solarthon.google.com.solarcalculator;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HardwareInfoActivity extends AppCompatActivity {
int s1,s2,i1,i2,b1,b2,inverterL,l;
double load,r1;
    int price_PV = 40 * 200;
    int inverter[] = {100, 200, 500, 800, 1000, 1500, 2000, 3000, 5000, 10000};
    int price_inverter[]={4100,5000,5500,5600,5662,6232,10800,43000,62700,95300};
   EditText e1,e2,e4,e5,e6,e7;TextView t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware_info);
        e1 =findViewById(R.id.in_solar);
        e2 =findViewById(R.id.p_solar);
        t3=findViewById(R.id.in_inverter);
        e5 =findViewById(R.id.in_battery);
        e6 =findViewById(R.id.p_battery);
        e4 =findViewById(R.id.p_inverter);
        e7 =findViewById(R.id.rate);
        getInfo();
    }
    public void getInfo()
    {Intent intent = getIntent();
        l = Integer.parseInt(intent.getStringExtra("totalL"));
        load = l / 0.81;
        inverterL = inverter.length;
        int i = 0;
        while (load > inverter[i++] && i < 10) ;
        if (i > 10)
            Toast.makeText(getApplicationContext(), "Limit Exceeded", Toast.LENGTH_SHORT).show();

        i1 = inverter[--i];
        t3.setText(Integer.toString(i1));
        e2.setText(Integer.toString(price_PV));
        e4.setText(Integer.toString(price_inverter[i]));
        FloatingActionButton f1 = findViewById(R.id.f_next);
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
next();
            }
        });

    }
    public void next()
    {
        s1= Integer.parseInt(e1.getText().toString());
        s2= Integer.parseInt(e2.getText().toString());
        i2= Integer.parseInt(e4.getText().toString());
        b1= Integer.parseInt(e5.getText().toString());
        b2= Integer.parseInt(e6.getText().toString());
        r1=Double.parseDouble(e7.getText().toString());
        Intent intent = new Intent(this,HardwareActivity.class);
        intent.putExtra("totalL",Integer.toString(l));
        intent.putExtra("solar1",Integer.toString(s1));
        intent.putExtra("solar2",Integer.toString(s2));
        intent.putExtra("inv1",Integer.toString(i1));
        intent.putExtra("inv2",Integer.toString(i2));
        intent.putExtra("batt1",Integer.toString(b1));
        intent.putExtra("batt2",Integer.toString(b2));
        intent.putExtra("rate",Double.toString(r1));
        startActivity(intent);

    }
}
