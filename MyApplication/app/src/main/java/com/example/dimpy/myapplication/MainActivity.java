package com.example.dimpy.myapplication;

import android.app.ProgressDialog;
import android.media.tv.TvContract;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    RequestQueue requestQueue;
    StringRequest stringRequest;
    String final_response;
    ProgressDialog progressDialog;

    String DataParseUrl = "https://api.chefier.com/supplier/read";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
/*
    public void click(View view) {

        final String mobile = "shrey@gmail.com";//getEmailId;
        final String pword = "shrey";//getPassword;

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Checking details...");
        progressDialog.show();
        stringRequest = new StringRequest(Request.Method.POST, DataParseUrl, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                final_response = response;
                //Toast.makeText(getActivity().getApplicationContext(), "  " + response, Toast.LENGTH_SHORT).show();
                Log.e("response: ", "  " + response);

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        if (error != null && error.toString().length() > 0)
                            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getApplicationContext(), "Something went terribly wrong! ", Toast.LENGTH_LONG).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                //params.put("email", mobile);
                //params.put("password", pword);
                String requestBody="";
                try {
                    JSONObject jsonBody = new JSONObject();
                    jsonBody.put("email", "shrey@gmail.com");
                    jsonBody.put("password", "shrey");
                    requestBody = jsonBody.toString();
                }catch (JSONException e) {
                    e.printStackTrace();
                }

                params.put("json", requestBody);
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("X-Api-Key", "598731dd4da9c598731dd4db3f598731dd4dbf1");  //header
                params.put("Content-Type","application/json");
                //params.put("password", Pword);     //pass
                return params;
            }

        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(40000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        requestQueue = Volley.newRequestQueue(getApplicationContext().getApplicationContext());
        requestQueue.add(stringRequest);



    }
*/
    public void click (View view){

        final String mobile = "shrey@gmail.com";//getEmailId;
        final String pword = "shrey";//getPassword;

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Checking details...");
        progressDialog.show();

        Map<String, String> params = new HashMap<String, String>();

        //Pass Payload as JSON object like this
        params.put("email", "shrey@gmail.com");
        params.put("password", "shrey");

        JSONObject payload= new JSONObject(params);


        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, DataParseUrl, payload, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                Log.e(">>>>>>"," "+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressDialog.dismiss();
                Log.e(">>>>>>","Neg>>>> "+error);
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("X-Api-Key", "598731dd4da9c598731dd4db3f598731dd4dbf1");
                return headers;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplication());

        requestQueue.add(req);

    }
}