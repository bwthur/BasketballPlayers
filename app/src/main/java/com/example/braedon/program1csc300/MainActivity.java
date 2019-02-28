package com.example.braedon.program1csc300;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.*;

public class MainActivity extends AppCompatActivity
{

    private ListView listView;
    private PlayerFormArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //initializes the array of Strings so there are place holder strings in there
        for(int i = 0; i < Core.thePlayers.length; i++)
        {
            Core.thePlayers[i] = new PlayerForm();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.aa = new PlayerFormArrayAdapter(this, R.layout.list_view_row_advanced, Core.thePlayers);
        this.listView = (ListView)this.findViewById(R.id.listView);
        this.listView.setAdapter(aa);

        //Start Listening for changes to the database
        Core.listenForDatabaseChanges(); //non-blocking!!!!


    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        System.out.println("****** ON RESTART!!!!!!");
        this.aa.notifyDataSetChanged();
    }

    public void onAddPlayerFormPressed(View v)
    {
        Intent i = new Intent(this, PlayerFormAddNewActivity.class);
        this.startActivity(i);
    }
}