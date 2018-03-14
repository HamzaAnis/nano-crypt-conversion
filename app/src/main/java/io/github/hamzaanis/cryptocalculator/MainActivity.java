package io.github.hamzaanis.cryptocalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void Convert(View view) throws IOException, JSONException {
        String url = "https://api.coinmarketcap.com/v1/ticker/neo/";
        final RequestQueue ExampleRequestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest ExampleStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response.toString());
            }
        }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
            }
        }) {
        };
        ExampleRequestQueue.add(ExampleStringRequest);
        if (!DecimalValue.getText().toString().equals("")) {
            convertvalue.setText(DecimalValue.getText().toString());
            DecimalValue.setText("");
        }
    }


}

