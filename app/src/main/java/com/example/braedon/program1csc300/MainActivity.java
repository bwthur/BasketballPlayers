package com.example.braedon.program1csc300;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.*;

public class MainActivity extends AppCompatActivity
{
    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        LinkedList ll = new LinkedList();
        ll.addEnd(3);
        ll.addEnd(2);
        ll.addEnd(1);
        ll.removeAtIndex(0);
        ll.display();
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(MainActivity.this);
        for(int i =0; i < Core.thePlayers.length; i++)
        {
            Core.thePlayers[i] = new PlayerForm();
        }


        setContentView(R.layout.activity_main);

        Core.aa = new PlayerFormArrayAdapter(this, R.layout.list_view_row_advanced, Core.thePlayers);
        this.lv = (ListView)this.findViewById(R.id.listView);
        this.lv.setAdapter(Core.aa);

        Core.listenForDatabaseChanges();
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Core.aa.notifyDataSetChanged();
        System.out.println("****** ON RESUME!!!!!!");

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("****** ON START!!!!!!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("****** ON PAUSE!!!!!!");

    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("****** ON STOP!!!!!!");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("****** ON RESTART!!!!!!");
        Core.aa.notifyDataSetChanged();

    }

    public void onAddPlayerFormPressed(View v)
    {
        Intent i = new Intent(this, PlayerFormAddNewActivity.class);
        this.startActivity(i);
    }
}