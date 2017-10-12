package com.example.swarkad.onlineparkingsystem;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner userTypeSpinner,newUserRegistrationSpinner;
    TextView userTypeTextView;
    Button loginButton,clearButton,mapButton;
    EditText userName,userPassword;
    ArrayAdapter<String> myAdapter;
    String userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userTypeTextView=(TextView) findViewById(R.id.textView);
        userTypeSpinner=(Spinner)findViewById(R.id.spinner);
        newUserRegistrationSpinner=(Spinner)findViewById(R.id.newRegistrationSpinner);
        loginButton=(Button)findViewById(R.id.loginButton);
        clearButton=(Button)findViewById(R.id.clearButton);
        mapButton=(Button)findViewById(R.id.mapButton);
        userName=(EditText)findViewById(R.id.userName);
        userPassword=(EditText)findViewById(R.id.userPassword);

        myAdapter=new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.app_users));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userTypeSpinner.setAdapter(myAdapter);

        myAdapter=new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.app_users_registration));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        newUserRegistrationSpinner.setAdapter(myAdapter);

        userTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                userType=(String) userTypeSpinner.getSelectedItem();
               // userTypeTextView.setText(userType);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                //   EditText editText = (EditText) findViewById(R.id.userPassword);
                //   String message = editText.getText().toString();
                //   intent.putExtra("", message);
                startActivity(intent);

//                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?saddr=%f,%f&daddr=%f,%f", null, null, null, null);
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//                startActivity(intent);

            }
        });

        newUserRegistrationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String userType=(String) newUserRegistrationSpinner.getSelectedItem();
                // userTypeTextView.setText(userType);

                if(userType.equalsIgnoreCase("Owner User Registration"))
                {
                    Intent intent = new Intent(MainActivity.this,NewOwnerRegistration.class);
                 //   EditText editText = (EditText) findViewById(R.id.userPassword);
                 //   String message = editText.getText().toString();
                 //   intent.putExtra("", message);
                    startActivity(intent);
                }

                if(userType.equalsIgnoreCase("End User Registration"))
                {
                    Intent intent = new Intent(MainActivity.this,EndUserRegistration.class);
                    //   EditText editText = (EditText) findViewById(R.id.userPassword);
                    //   String message = editText.getText().toString();
                    //   intent.putExtra("", message);
                    startActivity(intent);
                }
               // Toast.makeText(MainActivity.this,userType,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }


    public void clear(View view)
    {
        userName.setText("");
        userPassword.setText("");

    }


    public void checkLogin(View view)
    {

        if(userType.equals("Select User"))
        {
            showAlertDialog("Please Select User Type From Top DropDwon List");
        }

        if(userType.equals("Admin User"))
        {
            if((userName.getText().toString().equals("satish")) && (userPassword.getText().toString().equals("password")))
            {
                Intent intent = new Intent(MainActivity.this,AdminUserProfile.class);
                //   EditText editText = (EditText) findViewById(R.id.userPassword);
                //   String message = editText.getText().toString();
                //   intent.putExtra("", message);
                startActivity(intent);

                clear(clearButton);

            }
            else
            {
                showAlertDialog("Wrong Admin UserName or Password");
            }
        }

        if(userType.equals("Owner User"))
        {
            if((userName.getText().toString().equals("satish")) && (userPassword.getText().toString().equals("password")))
            {
                Intent intent = new Intent(MainActivity.this,AdminUserProfile.class);
                //   EditText editText = (EditText) findViewById(R.id.userPassword);
                //   String message = editText.getText().toString();
                //   intent.putExtra("", message);
                startActivity(intent);

                clear(clearButton);

            }
            else
            {
                showAlertDialog("Wrong Owner UserName or Password");
            }
        }


        if(userType.equals("End User"))
        {
            if((userName.getText().toString().equals("satish")) && (userPassword.getText().toString().equals("password")))
            {
                Intent intent = new Intent(MainActivity.this,AdminUserProfile.class);
                //   EditText editText = (EditText) findViewById(R.id.userPassword);
                //   String message = editText.getText().toString();
                //   intent.putExtra("", message);
                startActivity(intent);

                clear(clearButton);

            }
            else
            {
                showAlertDialog("Wrong End UserName or Password");
            }
        }


//        String str="loginmethod";
//
//        BackgroundTask backgroundTask=new BackgroundTask(getApplicationContext());
//        backgroundTask.execute(str,"satish","pass");
//        finish();
//
//        String username,password;
//      //  username=userName.getText();
//        if((userName.getText().toString().equals("satish")) && (userPassword.getText().toString().equals("password")))
//        {
//            Toast.makeText(MainActivity.this,"login Successfully",Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            Toast.makeText(MainActivity.this,"userName or Password is worng",Toast.LENGTH_SHORT).show();
//        }




//        String str="loginmethod";
//
//        BackgroundTask backgroundTask=new BackgroundTask(getApplicationContext());
//        backgroundTask.execute(str,"satish","pass");
//        finish();
//
    }




    public void showAlertDialog(String message) {
        android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();
        //  final View dialogView = inflater.inflate(R.layout.timepicker_layout, null);
        //  dialogBuilder.setView(dialogView);

        //  final TimePicker timepicker=(TimePicker)dialogView.findViewById(R.id.timePicker);




        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(DialogInterface dialog, int whichButton) {
                clear(clearButton);
                //do something with edt.getText().toString();
                // timeTextView.setText("Time : "+timepicker.getHour()+" : "+timepicker.getMinute());

            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        //        dialogBuilder.setNeutralButton("clear", new DialogInterface.OnClickListener() {
        //            public void onClick(DialogInterface dialog, int whichButton) {
        //                //pass
        //            }
        //        });

        dialogBuilder.setCancelable(true) ;
        dialogBuilder.setTitle("Custom dialog");
        dialogBuilder.setMessage(" "+message);


        final android.app.AlertDialog b = dialogBuilder.create();
        b.show();


    }

}



