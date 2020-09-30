package solarthon.google.com.solarcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RoofActivity extends AppCompatActivity {
    AutoCompleteTextView ac;
    int i=0;
    double ir,area,l;
    String state[]={"Andaman and Nicobar Islands","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chhattisgarh","Dadar and Nagar Haveli","Daman and Diu","Goa","Gujrat","Haryana","Himachal Pradesh","Jammu & Kashmir","Jharkhand","Karnataka","Kerala","Lakshadweep","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Puducherry (Pondicherry)","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
    String state1;
     double irradiance[]={1156.39,1266.52,1046.26,1046.26,1156.39,1156.39,1266.52,1266.52,1266.52,1266.52,1266.52,1156.39,1046.26,1046.26,1156.52,1266.52,1266.52,1266.52,1266.52,1266.52,1046.26,1046.26,1046.26,1046.26,1156.39,1156.39,1266.52,1156.39,1266.52,1046.26,1266.52,1266.52,1046.26,1156.39,1046.26,1156.39};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roof);
        Intent intent = getIntent();
        l = Double.parseDouble(intent.getStringExtra("totalL"));
        calRoof();
    }
    public void calRoof()
    {
        ac=findViewById(R.id.states);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.select_dialog_item,state);
        ac.setThreshold(1);
        ac.setAdapter(adapter);
        Button b1=findViewById(R.id.calculate);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1 = findViewById(R.id.states);
                state1 = e1.getText().toString();
                while (i < 35 && state1.equalsIgnoreCase(state[i++])==false) ;
                ir = irradiance[i];
                area = l/ (0.18 * ir);
                area=Math.round(area*100)/100.0;
                TextView e2 = findViewById(R.id.calArea);
                e2.setText("Required Area= " + Double.toString(area) + " sq. m");
                TextView e3 = findViewById(R.id.irr);
                e3.setText("Net Irradiance at your location= " + Double.toString(ir) + " W/sq. m");
            }

    });
            }
            }

