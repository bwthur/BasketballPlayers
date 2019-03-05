package com.example.braedon.program1csc300;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayerFormAddNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_form_add_new);
    }

    public void onAddButtonPressed(View v)
    {
        EditText playerNameET = this.findViewById(R.id.playerNameET);
        EditText jerseyNumberET = this.findViewById(R.id.jerseyNumberET);
        EditText ageET = this.findViewById(R.id.ageET);
        EditText heightFeetET = this.findViewById(R.id.heightFeetET);
        EditText heightInchesET = this.findViewById(R.id.heightInchesET);

        String name = playerNameET.getText().toString();
        int jerseyNumber = Integer.parseInt(jerseyNumberET.getText().toString());
        int age = Integer.parseInt(ageET.getText().toString());
        int heightFt = Integer.parseInt(heightFeetET.getText().toString());
        int heightIn = Integer.parseInt(heightInchesET.getText().toString());
        PlayerForm pf = new PlayerForm(name, jerseyNumber, age, heightFt, heightIn);
        Core.addPlayerFormLocal(pf);
        this.finish();
    }
}
