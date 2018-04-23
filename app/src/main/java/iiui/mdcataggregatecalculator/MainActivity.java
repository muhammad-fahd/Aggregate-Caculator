package iiui.mdcataggregatecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button mdcat , ecat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mdcat = (Button) findViewById(R.id.btnMdcat);
        mdcat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this , MdcatActivity.class);
                startActivity(intent);
            }
        });

        ecat = (Button) findViewById(R.id.btnEcat);
        ecat.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this , EcatActivity.class);
                startActivity(intent);
            }

        });

    }
}
