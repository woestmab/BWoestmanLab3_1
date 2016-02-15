package com.example.bWoestmanLab3_1;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends FragmentActivity implements OnClickListener
{

//    private String filename = "MySampleFile.txt";
//    private String filepath = "MyFileStorage";
//    File myInternalFile;
//    File myExternalFile;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    private GoogleApiClient client;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragmentContainer) != null)
        {
            if (savedInstanceState != null)
            {
                return;
            }
            MainFragment mainFragment = new MainFragment();
            mainFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentContainer, mainFragment)
                    .commit();
        }

//        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
//        File directory = contextWrapper.getDir(filepath, Context.MODE_PRIVATE);
//        myInternalFile = new File(directory, filename);

//        Button saveToInternalStorage =
//                (Button) findViewById(R.id.saveInternalStorage);
//        saveToInternalStorage.setOnClickListener(this);
//
//        Button readFromInternalStorage =
//                (Button) findViewById(R.id.getInternalStorage);
//        readFromInternalStorage.setOnClickListener(this);
//
//        Button saveToExternalStorage =
//                (Button) findViewById(R.id.saveExternalStorage);
//        saveToExternalStorage.setOnClickListener(this);
//
//        Button readFromExternalStorage =
//                (Button) findViewById(R.id.getExternalStorage);
//        readFromExternalStorage.setOnClickListener(this);

        //check if external storage is available and not read only
//        if (!isExternalStorageAvailable() || isExternalStorageReadOnly())
//        {
//            saveToExternalStorage.setEnabled(false);
//        } else
//        {
//            myExternalFile = new File(getExternalFilesDir(filepath), filename);
//        }

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void onClick(View v)
    {

        EditText myInputText = (EditText) findViewById(R.id.myInputText);
        TextView responseText = (TextView) findViewById(R.id.responseText);
//        String myData = "";
//
//        switch (v.getId())
//        {
//            case R.id.saveInternalStorage:
//                try
//                {
//                    FileOutputStream fos = new FileOutputStream(myInternalFile);
//                    fos.write(myInputText.getText().toString().getBytes());
//                    fos.close();
//                } catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
//                myInputText.setText("");
//                responseText.setText("MySampleFile.txt saved to Internal Storage...");
//                break;
//
//            case R.id.getInternalStorage:
//                try
//                {
//                    FileInputStream fis = new FileInputStream(myInternalFile);
//                    DataInputStream in = new DataInputStream(fis);
//                    BufferedReader br =
//                            new BufferedReader(new InputStreamReader(in));
//                    String strLine;
//                    while ((strLine = br.readLine()) != null)
//                    {
//                        myData = myData + strLine;
//                    }
//                    in.close();
//                } catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
//                myInputText.setText(myData);
//                responseText.setText("MySampleFile.txt data retrieved from Internal Storage...");
//                break;
//
//            case R.id.saveExternalStorage:
//                try
//                {
//                    FileOutputStream fos = new FileOutputStream(myExternalFile);
//                    fos.write(myInputText.getText().toString().getBytes());
//                    fos.close();
//                } catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
//                myInputText.setText("");
//                responseText
//                        .setText("MySampleFile.txt saved to External Storage...");
//                break;
//
//            case R.id.getExternalStorage:
//                try
//                {
//                    FileInputStream fis = new FileInputStream(myExternalFile);
//                    DataInputStream in = new DataInputStream(fis);
//                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
//                    String strLine;
//                    while ((strLine = br.readLine()) != null)
//                    {
//                        myData = myData + strLine;
//                    }
//                    in.close();
//                } catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
//                myInputText.setText(myData);
//                responseText.setText("MySampleFile.txt data retrieved from Internal Storage...");
//                break;
//
//        }
    }
//
//    private static boolean isExternalStorageReadOnly()
//    {
//        String extStorageState = Environment.getExternalStorageState();
//        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState))
//        {
//            Log.d("Debug", "MEDIA_MOUNTED_READ_ONLY-- external storage is read only");
//            return true;
//        }
//        Log.d("Debug", "MEDIA_MOUNTED_READ_ONLY-- external storage is NOT read only");
//        return false;
//    }
//
//    private static boolean isExternalStorageAvailable()
//    {
//        String extStorageState = Environment.getExternalStorageState();
//        if (Environment.MEDIA_MOUNTED.equals(extStorageState))
//        {
//            Log.d("Debug", "MEDIA_MOUNTED--External Storage is Available");
//            return true;
//        }
//        Log.d("Debug", "MEDIA_MOUNTED--External Storage is NOT Available");
//        return false;
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


//    @Override
//    public void onStart()
//    {
//        super.onStart();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app deep link URI is correct.
//                Uri.parse("android-app://com.example.bWoestmanLab3_1/http/host/path")
//        );
//        AppIndex.AppIndexApi.start(client, viewAction);
//    }

//    @Override
//    public void onStop()
//    {
//        super.onStop();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app deep link URI is correct.
//                Uri.parse("android-app://com.example.bWoestmanLab3_1/http/host/path")
//        );
//        AppIndex.AppIndexApi.end(client, viewAction);
//        client.disconnect();
//    }
}
