package solarthon.google.com.solarcalculator;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HardwareActivity extends AppCompatActivity {
    int l, pv = 40, nS, batt = 100, nB;
      int price_inverter;
    int inverterL, inverterCap;
    double pvEff = 0.0, pvEnergy, nSolar, nBatt, load,lYear,rate_Unit=6.5;
    double cost_PV, cost_battery, cost_inverter, cost_total,cost_final,cost_wiring,roi;
int s1,s2,i1,i2,b1,b2;
double r1;
    int price_PV = 40 * 200, price_battery = 7500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware);

        cal_cost();
            }

    private void cal_cost() {
        Intent intent1 = getIntent();
        pv = Integer.parseInt(intent1.getStringExtra("solar1"));
        price_PV = Integer.parseInt(intent1.getStringExtra("solar2"));
        inverterCap = Integer.parseInt(intent1.getStringExtra("inv1"));
        price_inverter = Integer.parseInt(intent1.getStringExtra("inv2"));
        batt = Integer.parseInt(intent1.getStringExtra("batt1"));
        price_battery = Integer.parseInt(intent1.getStringExtra("batt2"));
        rate_Unit = Double.parseDouble(intent1.getStringExtra("rate"));
        l = Integer.parseInt(intent1.getStringExtra("totalL"));
        load = l / 0.81;
        pvEff = pv * 0.75 * 0.81;
        pvEnergy = pvEff * 8;
        nSolar = load / pvEnergy;
        nS = (int) Math.ceil(nSolar);

        nBatt = load / (batt * 12.0);
        nB = (int) Math.ceil(nBatt);
        cost_PV = nS * price_PV;
        cost_battery = nB * price_battery;
        cost_inverter = price_inverter;
        cost_total = cost_PV + cost_battery + cost_inverter;
        cost_wiring=Math.round(cost_total*0.05*100)*0.01;
        cost_final = cost_total + cost_wiring;
        cost_final=Math.round(cost_final*100)*0.01;
        lYear=l*0.001*365*rate_Unit;
        roi=lYear/cost_final*100;
        roi=Math.round(roi*100)*.01;
        TextView t1 = findViewById(R.id.cap_solar);
        t1.setText(Integer.toString(pv));
        TextView t2 = findViewById(R.id.q_solar);
        t2.setText(Integer.toString(nS));
        TextView t3 = findViewById(R.id.cost_solar);
        t3.setText(Double.toString(cost_PV));
        TextView t4 = findViewById(R.id.in_inverter);
        t4.setText(Integer.toString(inverterCap));
        TextView t5 = findViewById(R.id.q_inverter);
        t5.setText(Integer.toString(1));
        TextView t6 = findViewById(R.id.cost_inverter);
        t6.setText(Double.toString(cost_inverter));
        TextView t7 = findViewById(R.id.cap_battery);
        t7.setText(Integer.toString(batt));
        TextView t8 = findViewById(R.id.q_battery);
        t8.setText(Integer.toString(nB));
        TextView t9 = findViewById(R.id.cost_battery);
        t9.setText(Double.toString(cost_battery));
        TextView t10 = findViewById(R.id.cost_wiring);
        t10.setText(Double.toString(cost_wiring));
        TextView t11 = findViewById(R.id.cost_total);
        t11.setText(Double.toString(cost_final));
        TextView t12 = findViewById(R.id.roi);
        t12.setText(Double.toString(roi));
        FloatingActionButton f1 = findViewById(R.id.cal_roof);
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calRoof();
            }
        });
    }
    public void calRoof()
    {
        Intent intent = new Intent(this,RoofActivity.class);
        intent.putExtra("totalL",Double.toString(load));
        startActivity(intent);
}}