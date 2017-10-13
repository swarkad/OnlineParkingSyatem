package com.example.swarkad.onlineparkingsystem;



import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Locale;

public class OwnerUserProfile extends AppCompatActivity {

    Button showbtn, listviewbtn,showMapButton;
    String json_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_user_profile);
        showbtn = (Button) findViewById(R.id.showbtn);
        listviewbtn = (Button) findViewById(R.id.listviewbtn);
        showMapButton = (Button) findViewById(R.id.mapButton);
        json_data = "";


        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BackgroundTask1 backgroundTask1 = new BackgroundTask1();
                backgroundTask1.execute("s", null, "sdfk");
            }
        });



        showMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OwnerUserProfile.this,MapsActivity.class);
                //   EditText editText = (EditText) findViewById(R.id.userPassword);
                //   String message = editText.getText().toString();
                //   intent.putExtra("", message);
                startActivity(intent);


//                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?saddr=%f,%f&daddr=%f,%f", null, null, null, null);
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//                startActivity(intent);

            }
        });


        listviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(AdminUserProfile.this, OwnerUserList.class);
//                intent.putExtra("data", json_data);
//                startActivity(intent);


                Intent intent = new Intent(OwnerUserProfile.this,OwnerUserList.class);
                intent.putExtra("data", json_data);
                startActivity(intent);

            }
        });


    }


    public class BackgroundTask1 extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String login_url = "http://10.0.2.2/parkingsystem/json_get_data.php";

            String str = params[0];


            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String lines = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((lines = bufferedReader.readLine()) != null) {
                    stringBuilder.append(lines + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString();

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // return"login successfull welcome";


            return "-----------------";
        }

        @Override
        protected void onProgressUpdate(Void... values)

        {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView = (TextView) findViewById(R.id.textView1);
            textView.setText(result);

            json_data = result;

            // return result;
        }
    }

}

