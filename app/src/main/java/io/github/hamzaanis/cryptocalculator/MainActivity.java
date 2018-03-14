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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

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
        String urlString = "https://api.coinmarketcap.com/v1/ticker/neo/";

        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        }
        HttpsURLConnection con = null;
        try {
            con = (HttpsURLConnection) url.openConnection();
        } catch (IOException ex) {
            System.out.println(ex);
        }

        // By default it is GET request
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = 0;
        try {
            responseCode = con.getResponseCode();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        System.out.println("Sending get request : " + url);
        System.out.println("Response code : " + responseCode);

        // Reading response from input Stream
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        try {
            in.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }

        //printing result from response
        System.out.println(response.toString());
        JSONArray jarray = new JSONArray(response.toString());
        JSONObject jobject = jarray.getJSONObject(0);
        String usdPrice = jobject.getString("price_usd");
        String btcPrice = jobject.getString("price_btc");
        System.out.println(btcPrice + " " + usdPrice);

        if (!DecimalValue.getText().toString().equals("")) {
            convertvalue.setText(DecimalValue.getText().toString());
            DecimalValue.setText("");
        }
    }
}
