package com.example.weatherapivolley;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Button fetchButton;
    private TextView jsonTextView1,jsonTextView2,jsonTextView3,jsonTextView4,jsonTextView5,jsonTextView6,jsonTextView7,jsonTextView8;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchButton = findViewById(R.id.fetchButton);
        jsonTextView1 = findViewById(R.id.jsonTextView1);
        jsonTextView2 = findViewById(R.id.jsonTextView2);
        jsonTextView3 = findViewById(R.id.jsonTextView3);
        jsonTextView4 = findViewById(R.id.jsonTextView4);
        jsonTextView5 = findViewById(R.id.jsonTextView5);
        jsonTextView6 = findViewById(R.id.jsonTextView6);
        jsonTextView7 = findViewById(R.id.jsonTextView7);
        jsonTextView8 = findViewById(R.id.jsonTextView8);



        // Initialize Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://yjchousing.apcfss.in/yjcapi/YJCAPI/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of the ApiService
        apiService = retrofit.create(ApiService.class);

        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a LoginRequest object with username and password
                LoginRequest loginRequest = new LoginRequest("0679718","Apshcl@2022");
                loginRequest.setUsername("0679718");
                loginRequest.setPassword("Apshcl@2022");

                // API call
                Call<ResponseModel> call = apiService.authenticate(loginRequest);
                call.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ResponseModel responseData = response.body();
                            String status = responseData.getStatus();
                            String msg = responseData.getMsg();
                            String id  = responseData.getMsg();
                            String username  = responseData.getUsername();
                            int roles = responseData.getRoles();
                            String currentTimeStamp = responseData.getCurrentTimeStamp();
                            String tokenType = responseData.getTokenType();
                            String accessToken = responseData.getAccessToken();

                            // Display the access token in the TextView
                            jsonTextView1.setText("Status : " + status);
                            jsonTextView2.setText("Msg : " + msg);
                            jsonTextView3.setText("Id : " + id);
                            jsonTextView4.setText("Username : " + username);
                            jsonTextView5.setText("Roles : " + roles);
                            jsonTextView6.setText("CurrentTimestamp : " + currentTimeStamp);
                            jsonTextView7.setText("Token Type: " + tokenType);
                            jsonTextView8.setText("Access Token: " + accessToken);
                        } else {
                            jsonTextView1.setText("API call failed.");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        jsonTextView1.setText("API call failed.");
                    }
                });
            }
        });
    }
}
