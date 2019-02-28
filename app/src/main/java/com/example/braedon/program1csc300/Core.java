package com.example.braedon.program1csc300;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Core
{
    public static PlayerForm[] thePlayers = new PlayerForm[1000];
    public static String[] thePlayerStrings = new String[1000];
    private static int numberOfPlayers = 0;
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference myRef = database.getReference("players");


    public static void listenForDatabaseChanges()
    {
        //async listener
        ValueEventListener prListener = new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                // Get Post object and use the values to update the UI
                System.out.println(dataSnapshot);
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    PlayerForm pr = ds.getValue(PlayerForm.class);
                    System.out.println("***** Data Changed");
                    pr.display();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                // Getting Post failed, log a message
                System.out.println("loadPost:onCancelled " + databaseError.toException());
            }
        };
        Core.myRef.addValueEventListener(prListener);
    }

    public static void writePlayerFormToFirebase(PlayerForm pr)
    {
        //static context
        Core.myRef.push().setValue(pr);
    }

    public static void addPlayerForm(PlayerForm pr)
    {
        Core.thePlayers[Core.numberOfPlayers] = pr;
        Core.thePlayerStrings[Core.numberOfPlayers] = pr.toString();
        Core.numberOfPlayers++;
        Core.writePlayerFormToFirebase(pr);
    }
}