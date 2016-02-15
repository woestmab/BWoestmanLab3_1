package com.example.bWoestmanLab3_1;


import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Brian Woestman on 2/14/16.
 * Android Programming
 * We 5:30p - 9:20p
 */
public class MainFragment extends Fragment implements View.OnClickListener
{
    private String filename = "MySampleFile.txt";
    private String filepath = "MyFileStorage";
    File myInternalFile;
    File myExternalFile;
    private GoogleApiClient client;

    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null (which
     * is the default implementation).  This will be called between
     * {@link #onCreate(Bundle)} and {@link #onActivityCreated(Bundle)}.
     * <p/>
     * <p>If you return a View from here, you will later be called in
     * {@link #onDestroyView} when the view is being released.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view
     *                           itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState)
    {
        setHasOptionsMenu(true);
        client = new GoogleApiClient.Builder(getActivity()).addApi(AppIndex.API).build();
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    /**
     * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     *
     * @param view               The View returned by {@link #onCreateView(LayoutInflater,
     * ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {

        ContextWrapper contextWrapper = new ContextWrapper(getActivity().getApplicationContext());
        File directory = contextWrapper.getDir(filepath, Context.MODE_PRIVATE);
        myInternalFile = new File(directory, filename);

        Button saveToInternalStorage =
                (Button) getView().findViewById(R.id.saveInternalStorage);
        saveToInternalStorage.setOnClickListener(this);

        Button readFromInternalStorage =
                (Button) getView().findViewById(R.id.getInternalStorage);
        readFromInternalStorage.setOnClickListener(this);

        Button saveToExternalStorage =
                (Button) getView().findViewById(R.id.saveExternalStorage);
        saveToExternalStorage.setOnClickListener(this);

        Button readFromExternalStorage =
                (Button) getView().findViewById(R.id.getExternalStorage);
        readFromExternalStorage.setOnClickListener(this);

        //check if external storage is available and not read only
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly())
        {
            saveToExternalStorage.setEnabled(false);
        } else
        {
            myExternalFile = new File(getActivity().getExternalFilesDir(filepath), filename);
        }

        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to {link Activity#onStart() Activity.onStart} of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onStart()
    {
        super.onStart();
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
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v)
    {
        EditText myInputText = (EditText) getView().findViewById(R.id.myInputText);
        TextView responseText = (TextView) getView().findViewById(R.id.responseText);
        String myData = "";

        switch (v.getId())
        {
            case R.id.saveInternalStorage:
                try
                {
                    FileOutputStream fos = new FileOutputStream(myInternalFile);
                    fos.write(myInputText.getText().toString().getBytes());
                    fos.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                myInputText.setText("");
                responseText.setText("MySampleFile.txt saved to Internal Storage...");
                break;

            case R.id.getInternalStorage:
                try
                {
                    FileInputStream fis = new FileInputStream(myInternalFile);
                    DataInputStream in = new DataInputStream(fis);
                    BufferedReader br =
                            new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    while ((strLine = br.readLine()) != null)
                    {
                        myData = myData + strLine;
                    }
                    in.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                myInputText.setText(myData);
                responseText.setText("MySampleFile.txt data retrieved from Internal Storage...");
                break;

            case R.id.saveExternalStorage:
                try
                {
                    FileOutputStream fos = new FileOutputStream(myExternalFile);
                    fos.write(myInputText.getText().toString().getBytes());
                    fos.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                myInputText.setText("");
                responseText
                        .setText("MySampleFile.txt saved to External Storage...");
                break;

            case R.id.getExternalStorage:
                try
                {
                    FileInputStream fis = new FileInputStream(myExternalFile);
                    DataInputStream in = new DataInputStream(fis);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    while ((strLine = br.readLine()) != null)
                    {
                        myData = myData + strLine;
                    }
                    in.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                myInputText.setText(myData);
                responseText.setText("MySampleFile.txt data retrieved from Internal Storage...");
                break;
        }
    }

    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to <var>menu</var>.  For this method
     * to be called, you must have first called {@link #setHasOptionsMenu}.  See
     * {link Activity#onCreateOptionsMenu(Menu) Activity.onCreateOptionsMenu}
     * for more information.
     *
     * @param menu     The options menu in which you place your items.
     * @param inflater
     * @see #setHasOptionsMenu
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    /**
     * Called when the Fragment is no longer started.  This is generally
     * tied to {link Activity#onStop() Activity.onStop} of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onStop()
    {
        super.onStop();

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
    }

    private static boolean isExternalStorageReadOnly()
    {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState))
        {
            Log.d("Debug", "MEDIA_MOUNTED_READ_ONLY-- external storage is read only");
            return true;
        }
        Log.d("Debug", "MEDIA_MOUNTED_READ_ONLY-- external storage is NOT read only");
        return false;
    }

    private static boolean isExternalStorageAvailable()
    {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState))
        {
            Log.d("Debug", "MEDIA_MOUNTED--External Storage is Available");
            return true;
        }
        Log.d("Debug", "MEDIA_MOUNTED--External Storage is NOT Available");
        return false;
    }
}
