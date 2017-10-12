package com.example.swarkad.onlineparkingsystem;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
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

/**
 * Created by swarkad on 02-10-2017.
 */

public class BackgroundTask extends AsyncTask<String,String,String>
{

    Context ctx;
    AlertDialog alertDialog;

    BackgroundTask(Context ctx)
    {
        this.ctx=ctx;
    }

    @Override
    protected void onPreExecute()
    {
        alertDialog=new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("login information ============");
    }

    @Override
    protected String doInBackground(String... params)
    {
        String reg_url="http://10.0.2.2/parkingsystem/OwnerUserRegistration.php";
        String reg_url1="http://10.0.2.2/parkingsystem/EndUserRegistration.php";
        String login_url="http://10.0.2.2/parkingsystem/login.php";

        String str=params[0];
        if(str.equals("OwnerUserRegistration"))
        {
            String fullname,mobile,email,address,aadharno,panno,space,username,password,date;

            fullname=params[1];
            mobile=params[2];
            email=params[3];
            address=params[4];
            aadharno=params[5];
            panno=params[6];
            space=params[7];
            username=params[8];
            password=params[9];
            date=params[10];

          //  Log.d(user+" "+user_name+" ",user_pass);
            try {
                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);


                OutputStream os=httpURLConnection.getOutputStream();
                // OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data= URLEncoder.encode("fullname","UTF-8")+"="+URLEncoder.encode(fullname,"UTF-8")+"&"+
                        URLEncoder.encode("mobile","UTF-8")+"="+URLEncoder.encode(mobile,"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8")+"&"+
                        URLEncoder.encode("aadharno","UTF-8")+"="+URLEncoder.encode(aadharno,"UTF-8")+"&"+
                        URLEncoder.encode("panno","UTF-8")+"="+URLEncoder.encode(panno,"UTF-8")+"&"+
                        URLEncoder.encode("space","UTF-8")+"="+URLEncoder.encode(space,"UTF-8")+"&"+
                        URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                        URLEncoder.encode("date","UTF-8")+"="+URLEncoder.encode(date,"UTF-8");


                //  Log.d(user+" "+user_name+" ",user_pass+data);
                bufferedWriter.write(data);
                //  Log.d(user+" "+user_name+" ",user_pass+data);

                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();



                InputStream is=httpURLConnection.getInputStream();
                is.close();

                return"registration successfull()";


            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }

        if(str.equals("EndUserRegistration"))
        {
            String fullname,mobile,email,address,aadharno,panno,space,username,password,date;

            fullname=params[1];
            mobile=params[2];
            email=params[3];
            address=params[4];
            username=params[5];
            password=params[6];
            date=params[7];

            //  Log.d(user+" "+user_name+" ",user_pass);
            try {
                URL url=new URL(reg_url1);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);


                OutputStream os=httpURLConnection.getOutputStream();
                // OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data= URLEncoder.encode("fullname","UTF-8")+"="+URLEncoder.encode(fullname,"UTF-8")+"&"+
                        URLEncoder.encode("mobile","UTF-8")+"="+URLEncoder.encode(mobile,"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8")+"&"+
                        URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                        URLEncoder.encode("date","UTF-8")+"="+URLEncoder.encode(date,"UTF-8");


                //  Log.d(user+" "+user_name+" ",user_pass+data);
                bufferedWriter.write(data);
                //  Log.d(user+" "+user_name+" ",user_pass+data);

                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();



                InputStream is=httpURLConnection.getInputStream();
                is.close();

                return"registration successfull()";


            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }

        if (str.equals("loginmethod"))
        {
            String username, password;
            username = params[1];
            password = params[2];

            try {
                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);


                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data= URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();


                //  Log.d("aaaaaaaaaa","bbbbbbbbbbbbbbb");

                InputStream inputStream=httpURLConnection.getInputStream();

                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="",lines="";

                while((lines=bufferedReader.readLine())!=null)
                {
                    response+=lines;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return response;

            }catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // return"login successfull welcome";

        }

        return"-----------------";
    }

    @Override
    protected void onProgressUpdate(String... progress)
    {
        super.onProgressUpdate(progress);
    }

    @Override
    protected void onPostExecute(String result)
    {
        if(result.equals("registration successfull()"))
            Toast.makeText(ctx,result+"-----------",Toast.LENGTH_LONG).show();
        else
        {
            Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
            Log.d("error ---",result);
        }

    }
}
