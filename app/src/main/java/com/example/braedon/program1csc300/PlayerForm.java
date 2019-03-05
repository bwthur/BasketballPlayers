package com.example.braedon.program1csc300;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PlayerForm implements Serializable
{
    private String playerName;
    private int jerseyNumber;
    private int age;
    private int heightFeet;
    private int heightInches;



    public PlayerForm(String playerName, int jerseyNumber, int age, int heightFeet, int heightInches)
    {
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.age = age;
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
    }

    public PlayerForm()
    {
        this.playerName = "PLAYERNAME";
        this.jerseyNumber = 0;
        this.age = 0;
        this.heightFeet = 0;
        this.heightInches = 0;
    }

    @Exclude
    public String getNameString()
    {
        return this.playerName;
    }

    @Exclude
    public String getNumbersString()
    {
        return "Jersey Number: " + this.jerseyNumber + " - " + this.heightFeet + "\'" + this.heightInches + "\" (" + this.age + ")";
    }

    @Exclude
    public String toString()
    {
        return this.playerName + " " + this.jerseyNumber + " " + this.age + " " + this.heightFeet + "\'" + this.heightInches + "\"";
    }



    public void display()
    {
        System.out.println(this.playerName + " " + this.jerseyNumber + " " + this.age + " " + this.heightFeet + "\'" + this.heightInches + "\"");
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public int getJerseyNumber()
    {
        return jerseyNumber;
    }

    public int getAge()
    {
        return age;
    }

    public int getHeightFeet()
    {
        return heightFeet;
    }

    public int getHeightInches()
    {
        return heightInches;
    }
}
