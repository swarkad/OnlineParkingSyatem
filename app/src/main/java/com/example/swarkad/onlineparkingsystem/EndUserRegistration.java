package com.example.swarkad.onlineparkingsystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class EndUserRegistration extends AppCompatActivity {

    Button backButton;
    Button clearButton;
    Button saveButton;
    EditText fullName;
    EditText mobile;
    EditText email;
    EditText postlAddress;
   // EditText aadharNo;
   // EditText panNo;
   // EditText space;
    EditText username;
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_user_registration);

        backButton = (Button) findViewById(R.id.backButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        saveButton = (Button) findViewById(R.id.saveButton);
        fullName = (EditText) findViewById(R.id.fullNameEditText);
        mobile = (EditText) findViewById(R.id.mobileEditText);
        email = (EditText) findViewById(R.id.emailEditText);
        postlAddress = (EditText) findViewById(R.id.postalAddressEditText);
      //  aadharNo = (EditText) findViewById(R.id.aadharEditText);
       // panNo = (EditText) findViewById(R.id.panEditText);
       // space = (EditText) findViewById(R.id.space);
        username = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.userPassword);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndUserRegistration.this,MainActivity.class);
                //   EditText editText = (EditText) findViewById(R.id.userPassword);
                //   String message = editText.getText().toString();
                //   intent.putExtra("", message);
                startActivity(intent);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fullName.setText("");
                mobile.setText("");
                email.setText("");
                postlAddress.setText("");


            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EndUserRegistration.this, fullName.getText().toString(), Toast.LENGTH_SHORT);

                Toast.makeText(EndUserRegistration.this, fullName.getText().toString(), Toast.LENGTH_SHORT);

                String fullname1,mobile1,email1,address1,aadharno1,panno1,space1,username1,password1,date1;
                fullname1=fullName.getText().toString();
                mobile1=mobile.getText().toString();
                email1=email.getText().toString();
                address1=postlAddress.getText().toString();
               // aadharno1=aadharNo.getText().toString();
              //  panno1=panNo.getText().toString();
               // space1=space.getText().toString();
                username1=username.getText().toString();
                password1=password.getText().toString();

                Date currentTime = Calendar.getInstance().getTime();
               // Date currentDate = currentDate.getDate();

                if(!(fullname1.equals("")) && !(fullname1.equals(null)) && !(mobile1.equals("")) && !(mobile1.equals(null)) &&
                        !(email1.equals("")) && !(email1.equals(null)) && !(address1.equals("")) && !(address1.equals(null)) &&
                        !(username1.equals("")) && !(username1.equals(null)) && !(password1.equals("")) && !(password1.equals(null)))
                {

                    String str = "EndUserRegistration";
                    BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                    backgroundTask.execute(str, fullname1, mobile1, email1, address1,username1, password1, ""+currentTime);
                    finish();
                }
                else
                {
                    Toast.makeText(EndUserRegistration.this,"please all information",Toast.LENGTH_SHORT).toString();
                    timeAlertDialog();

                }

            }
        });
    }



    public void timeAlertDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();
        //  final View dialogView = inflater.inflate(R.layout.timepicker_layout, null);
        //  dialogBuilder.setView(dialogView);

        //  final TimePicker timepicker=(TimePicker)dialogView.findViewById(R.id.timePicker);




        dialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(DialogInterface dialog, int whichButton) {
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
        dialogBuilder.setMessage("Please Fill All Information");


        final AlertDialog b = dialogBuilder.create();
        b.show();


    }

}
