package com.example.swarkad.onlineparkingsystem;

/**
 * Created by swarkad on 09-10-2017.
 */


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//import static com.bmc.practiceapp.R.layout.row_layout;

//import static com.bmc.practiceapp.R.id.et2;

public class OwnerUserList extends AppCompatActivity
{

    String json_data,name,username,userpass,rec="";
    JSONArray jsonArray;
    JSONObject jsonObject;

    ListView listView;
    String str;
   // TextView textView;


    //  String namearray[]=new String[1];

    List<String> namelist=new ArrayList<String>();
    List<String> unamelist=new ArrayList<String>();
    List<String> upasslist=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owneruser_list);

       // textView=(TextView)findViewById(R.id.textView1);

        //  contantsAdapter=new ContantsAdapter(this, row_layout);
        listView=(ListView)findViewById(R.id.listview1);
        //    listView.setAdapter(contantsAdapter);



        json_data=getIntent().getExtras().getString("data");


      //  textView.setText(json_data);

        if (json_data != null) {
            try {
                JSONObject jsonObj = new JSONObject(json_data);

                // Getting JSON Array node
                JSONArray contacts = jsonObj.getJSONArray("server_response");

                // looping through All Contacts

                // String str[]=new String[contacts.length()];

                // namearray[]=new String[contacts.length()];
                for (int i = 0; i < contacts.length(); i++) {
                    JSONObject c = contacts.getJSONObject(i);

                    //  str[i] = c.getString("name");
                    namelist.add(c.getString("name"));
                    unamelist.add(c.getString("email"));
                    upasslist.add(c.getString("pass"));
                    // namearray[1]=str[i];
                    // unamearray[i] = c.getString("user_name");
                    // upassarray[i] = c.getString("user_pass");

                    // textView.append();
                    //  String email = c.getString("email");
                    //  String address = c.getString("address");
                    //  String gender = c.getString("gender");
                }

                // ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,str);

                // listView.setAdapter(adapter);


                CustomAdapter customAdapter=new CustomAdapter();
                listView.setAdapter(customAdapter);

            } catch (final JSONException e)
            {
            }
        }



        // CustomAdapter customAdapter=new CustomAdapter();
        // listView.setAdapter(customAdapter);


    }





    public class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return namelist.size();
        }

        @Override
        public Object getItem(int position)
        {
            return namelist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent)
        {

            view =getLayoutInflater().inflate(R.layout.owner_row_layout,null);

            TextView textViewname=(TextView)view.findViewById(R.id.name);
            TextView textViewuname=(TextView)view.findViewById(R.id.uname);
            TextView textViewupass=(TextView)view.findViewById(R.id.upass);

            // imageView.setImageResource(images[i]);
            textViewname.setText(namelist.get(i));
            textViewuname.setText(unamelist.get(i));
            textViewupass.setText(upasslist.get(i));


            return view;
        }
    }



}