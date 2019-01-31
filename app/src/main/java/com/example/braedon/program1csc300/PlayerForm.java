package com.example.braedon.program1csc300;

public class PlayerForm
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

    public void display()
    {
        System.out.println(this.playerName + " " + this.jerseyNumber + " " + this.age + " " + this.heightFeet + "\'" + this.heightInches + "\"");
    }

//    public String getPlayerName()
//    {
//        return playerName;
//    }
//
//    public int getJerseyNumber()
//    {
//        return jerseyNumber;
//    }
//
//    public int getAge()
//    {
//        return age;
//    }
//
//    public int getHeightFeet()
//    {
//        return heightFeet;
//    }
//
//    public int getHeightInches()
//    {
//        return heightInches;
//    }
}
