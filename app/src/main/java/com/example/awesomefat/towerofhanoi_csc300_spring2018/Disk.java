package com.example.awesomefat.towerofhanoi_csc300_spring2018;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by awesomefat on 2/15/18.
 */

public class Disk
{
    private int size;
    private Disk nextDisk;


    public Disk(int size)
    {
        this.size = size;
        this.nextDisk = null;
    }

    public int getSize() {
        return size;
    }

    public Disk getNextDisk() {
        return nextDisk;
    }

    public void setNextDisk(Disk nextDisk) {
        this.nextDisk = nextDisk;
    }

    public void displayDisk(ViewGroup towerContainer, Context theContext)
    {
        String disk = "";
        for(int i = 0; i < size; i++)
        {
            disk = disk + "=";
        }
        TextView tv = new TextView(theContext);
        tv.setText(disk);
        tv.setGravity(Gravity.CENTER);
        towerContainer.addView(tv, 0);
    }
}
