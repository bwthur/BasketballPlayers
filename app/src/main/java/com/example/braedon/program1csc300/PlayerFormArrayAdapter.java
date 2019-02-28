package com.example.braedon.program1csc300;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlayerFormArrayAdapter extends ArrayAdapter
{
    private Context mContext;
    private PlayerForm[] patientRecordList = new PlayerForm[1000];
    private int textViewResourceId;

    public PlayerFormArrayAdapter(Context context, int textViewResourceId, PlayerForm[] list)
    {
        //call my parent's constructor - MUST BE FIRST LINE
        super(context, textViewResourceId , list);
        this.mContext = context;
        this.patientRecordList = list;
        this.textViewResourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        //android will re-use existing rows for performance reasons.
        //this checks to see if the convertView is already a thing or not
        //if it is not a thing, it inflates the layout for use this time
        //it will likely be a thing the next time we process this row.
        View listItem = convertView;
        if(listItem == null)
        {
            listItem = LayoutInflater.from(mContext).
                    inflate(this.textViewResourceId,parent,false);
        }

        //Get the PatientRecord object from bucket position which
        //is the row in our listview we are currently filling
        PlayerForm pr = this.patientRecordList[position];

        TextView nameTV = (TextView)listItem.findViewById(R.id.nameTV);
        TextView ageTV = (TextView)listItem.findViewById(R.id.ageTV);

        nameTV.setText(pr.getNameString());
        //ageTV.setText(pr.getAgeString());
        ageTV.setText("HEllo world!!!!!!!!~" + position);

        //return the View after we have set all of the values
        return listItem;
    }
}
