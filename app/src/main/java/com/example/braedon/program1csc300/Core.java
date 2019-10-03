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
    private static int numberOfPlayers = 10;
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference myRef = database.getReference("players");
    public static PlayerFormArrayAdapter aa;


    public static void listenForDatabaseChanges()
    {
        ValueEventListener pfListener = new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                System.out.println("****" + dataSnapshot.getValue());
                Core.numberOfPlayers = 0;
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    PlayerForm pf = ds.getValue(PlayerForm.class);
                }
                Core.aa.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                System.out.println("loadPost:onCancelled " + databaseError.toException());
            }
        };
        Core.myRef.addValueEventListener(pfListener);
    }

    public static void writePlayerFormToFirebase(PlayerForm pf)
    {
        Core.myRef.push().setValue(pf);
    }

    public static void addPlayerFormLocal(PlayerForm pf)
    {
        Core.thePlayers[Core.numberOfPlayers] = pf;
        Core.thePlayerStrings[Core.numberOfPlayers] = pf.toString();
        Core.numberOfPlayers++;
        Core.writePlayerFormToFirebase(pf);
    }

    public static void addPlayerFormDB(PlayerForm pf)
    {
        Core.writePlayerFormToFirebase(pf);
    }
}
