package io.github.hamzaanis.cryptocalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button Convert;
TextView convertvalue;
EditText DecimalValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Convert = (Button) findViewById(R.id.button);
        convertvalue = (TextView) findViewById(R.id.text);
        DecimalValue = (EditText) findViewById(R.id.editText);

    }

    public void Convert(View view) {
        if (!DecimalValue.getText().toString().equals("")){
            convertvalue.setText(DecimalValue.getText().toString());
            DecimalValue.setText("");
        }
    }
}
