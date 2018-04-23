package iiui.mdcataggregatecalculator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toast;

import static java.lang.Math.round;

public class EcatActivity extends AppCompatActivity {
    private EditText markObtainedInter , totalMarkInter , markObtainedECAT , totalMarkECAT;
    private String result , strMarkObtainedInter , strTotalMarkInter , strMarkObtainedECAT , strTotalMarkECAT;
    private Button calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecat);

        //calculation button
        calc = (Button) findViewById(R.id.btnEcatCalc);

                calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Inter part
                markObtainedInter = (EditText) findViewById(R.id.etMarksObtainedInterE);
                totalMarkInter = (EditText) findViewById(R.id.etTotalMarksInterE);

                strMarkObtainedInter = markObtainedInter.getText().toString();
                strTotalMarkInter = totalMarkInter.getText().toString();

                double inter_Total = Integer.parseInt(strTotalMarkInter);
                double inter_Obtain = Integer.parseInt(strMarkObtainedInter);

                //ECAT part
                markObtainedECAT = (EditText) findViewById(R.id.etMarksObtainedECAT);
                totalMarkECAT = (EditText) findViewById(R.id.etTotalMarksECAT);

                strMarkObtainedECAT = markObtainedECAT.getText().toString();
                strTotalMarkECAT = totalMarkECAT.getText().toString();

                double ecat_Total = Integer.parseInt(strTotalMarkECAT);
                double ecat_obtain = Integer.parseInt(strMarkObtainedECAT);

                double inter70Per = (inter_Obtain / inter_Total) * 100 * 0.7;
                double ecat30Per = (ecat_obtain / ecat_Total ) * 100 * 0.3;

                double aggregate = ((inter70Per + ecat30Per));
                result = Double.toString(aggregate);

                AlertDialog.Builder builder = new AlertDialog.Builder(EcatActivity.this);
                builder.setTitle("Aggregate");
                builder.setMessage(result)
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // TODO: handle the OK
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}
