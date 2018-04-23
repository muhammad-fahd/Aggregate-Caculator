package iiui.mdcataggregatecalculator;

import android.content.DialogInterface;
import android.renderscript.Double2;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MdcatActivity extends AppCompatActivity {
    private EditText metricTotal , metricObt , interTotal , interObt , mdcatTotal , mdcatObt;
    private String result;
    Button calculate ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdcat);

        calculate = (Button) findViewById(R.id.btnMdcatCalc);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                metricObt = (EditText) findViewById(R.id.etMarksObtainedMetric);
                metricTotal = (EditText) findViewById(R.id.etTotalMarksMetric);

                interObt = (EditText) findViewById(R.id.etMarksObtainedInter);
                interTotal = (EditText) findViewById(R.id.etTotalMarksInter);

                mdcatObt = (EditText) findViewById(R.id.etMarksObtainedMDCAT);
                mdcatTotal = (EditText) findViewById(R.id.etTotalMarksMDCAT);

                double metric_Total = Double.parseDouble(metricTotal.getText().toString());
                double metric_Obtain = Double.parseDouble(metricObt.getText().toString());

                double inter_Total = Double.parseDouble(interTotal.getText().toString());
                double inter_Obtain = Double.parseDouble(interObt.getText().toString());

                double mdcat_Total = Double.parseDouble(mdcatTotal.getText().toString());
                double mdcat_Obtain = Double.parseDouble(mdcatObt.getText().toString());

                double metric10Per = (metric_Obtain / metric_Total) * 100 * 0.1;
                double inter40Per = (inter_Obtain / inter_Total) * 100 * 0.4;
                double mdcat50Per = (mdcat_Obtain / mdcat_Total) * 100 * 0.5;

                double aggregate = metric10Per + inter40Per + mdcat50Per;
                result = Double.toString(aggregate);

                AlertDialog.Builder builder = new AlertDialog.Builder(MdcatActivity.this);
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
