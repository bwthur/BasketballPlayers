package com.example.braedon.program1csc300;

import android.content.Context;
import android.graphics.Movie;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlayerFormArrayAdapter extends ArrayAdapter
{
    private Context mContext;
    private PlayerForm[] playerFormList = new PlayerForm[1000];
    private int textViewResourceId;

    public PlayerFormArrayAdapter(Context context, int textViewResourceId, PlayerForm[] list)
    {
        super(context, textViewResourceId , list);
        mContext = context;
        playerFormList = list;
        this.textViewResourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItem = convertView;
        if(listItem == null)
        {
            listItem = LayoutInflater.from(mContext).inflate(this.textViewResourceId,parent,false);
        }

        PlayerForm pf = this.playerFormList[position];

        TextView nameTV = listItem.findViewById(R.id.nameTV);
        TextView ageTV = listItem.findViewById(R.id.ageTV);

        nameTV.setText(pf.getNameString());
        ageTV.setText(pf.getNumbersString());

        //return the View after we have set all of the values
        return listItem;
    }
}
