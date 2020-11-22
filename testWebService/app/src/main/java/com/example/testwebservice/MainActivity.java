package com.example.testwebservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.transform.ErrorListener;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private NhomPhuotApdater mAdapter;
    private List<NhomPhuotModel> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mData = new ArrayList<>();
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mAdapter = new NhomPhuotApdater(this, mData);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setAdapter(mAdapter);
        //http://localhost/Laravel/WebApiPhuot/public/api/NhomPhuot
        //http://localhost/Laravel/WebApiPhuot/public/api/NhomPhuot
        ReadJSON("http://192.168.1.5/Laravel/WebApiPhuot/public/api/NhomPhuot");



    }

    private void ReadJSON(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            //Toast.makeText(MainActivity.this, jsonArray.toString(), Toast.LENGTH_SHORT).show();
                            int len = jsonArray.length();
                            for(int i = 0; i<len;i++){
                                JSONObject item = jsonArray.getJSONObject(i);

                                //toast
                                Toast.makeText(MainActivity.this, item.toString(), Toast.LENGTH_SHORT).show();
                                int id = item.getInt("id");
                                String name = item.getString("name");
                                String ngaydi = item.getString("ngaydi");
                                int status = item.getInt("status");
                                NhomPhuotModel nhom = new NhomPhuotModel(id, name, ngaydi, status);
                                mData.add(nhom);

                            }
                            mAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }

        );
        requestQueue.add(jsonObjectRequest);

    }
}