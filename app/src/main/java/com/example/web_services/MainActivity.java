package com.example.web_services;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText txt_id, txtTitle, txt_content;
    Button btnEnviar, btnActualizar, BtnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_id = findViewById(R.id.id_user);
        txtTitle = findViewById(R.id.txt_title);
        txt_content = findViewById(R.id.content);
        btnEnviar = findViewById(R.id.btn_send);
        btnActualizar = findViewById(R.id.btn_update);
        BtnEliminar = findViewById(R.id.btn_delete);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    //LeerWs();

                    enviarWs(txtTitle.getText().toString(),txt_content.getText().toString(), txt_id.getText().toString());

            }
        });
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizarWs(txtTitle.getText().toString(),txt_content.getText().toString(), txt_id.getText().toString());
            }
        });
        BtnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarWs(txtTitle.getText().toString(),txt_content.getText().toString(), txt_id.getText().toString());
            }
        });
    }

    private void LeerWs(){
        String url = "https://jsonplaceholder.typicode.com/posts/10";

        StringRequest postRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    txt_id.setText(jsonObject.getString("userId"));
                    txtTitle.setText(jsonObject.getString("title"));
                    txt_content.setText(jsonObject.getString("body"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error",error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postRequest);
    }

    private void enviarWs(String title, String body, String id){
        String url = "https://jsonplaceholder.typicode.com/posts";

        StringRequest postRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    /*txt_id.setText(jsonObject.getString("userId"));
                    txtTitle.setText(jsonObject.getString("title"));
                    txt_content.setText(jsonObject.getString("body"));*/
                    Toast.makeText(MainActivity.this,"RESULTADO = "+ response,Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error",error.getMessage());
            }
        })
        {
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();
                params.put("title", title);
                params.put("body", body);
                params.put("userId", id);
                return params;


            }
        }
                ;
        Volley.newRequestQueue(this).add(postRequest);
    }
    private void actualizarWs(String title, String body, String id){
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        StringRequest postRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    /*txt_id.setText(jsonObject.getString("userId"));
                    txtTitle.setText(jsonObject.getString("title"));
                    txt_content.setText(jsonObject.getString("body"));*/
                    Toast.makeText(MainActivity.this,"RESULTADO = "+ response,Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error",error.getMessage());
            }
        })
        {
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();
                params.put("id", "1");
                params.put("title", title);
                params.put("body", body);
                params.put("userId", id);
                return params;


            }
        }
                ;
        Volley.newRequestQueue(this).add(postRequest);
    }
    private void eliminarWs(String title, String body, String id){
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        StringRequest postRequest = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    /*txt_id.setText(jsonObject.getString("userId"));
                    txtTitle.setText(jsonObject.getString("title"));
                    txt_content.setText(jsonObject.getString("body"));*/
                    Toast.makeText(MainActivity.this,"RESULTADO = "+ response,Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error",error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postRequest);
    }
}