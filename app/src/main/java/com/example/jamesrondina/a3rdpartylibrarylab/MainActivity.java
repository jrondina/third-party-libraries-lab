package com.example.jamesrondina.a3rdpartylibrarylab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button benjamin;

    private String myUrl = "https://www.chess.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        benjamin = (Button) findViewById(R.id.benjamin);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myUrl = editText.getText().toString();

                final StringRequest stringRequest = new StringRequest(Request.Method.GET, myUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                textView.setText(response);


                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, "There was an error", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();

                    }
                });

                Volley.newRequestQueue(MainActivity.this).add(stringRequest);

            }
        };

        benjamin.setOnClickListener(listener);



    }
}
