package com.example.awesomefat.towerofhanoi_csc300_spring2018;

import android.content.Context;
import android.view.ViewGroup;

/**
 * Created by awesomefat on 2/15/18.
 */

public class Tower
{
    //create a bottom up design.
    private Disk root;
    protected Disk top;
    private Disk prev;

    public Tower()
    {
        this.root = null;
        this.top = null;
        this.prev = null;
    }

    public static void push(Disk r1, Tower stack)
    {
        //moves a disk from the register onto the top of the stack
        //if the stack is empty, we put the disk on top of the base and label it as the top
        if(stack.root == null)
        {
            stack.root.setNextDisk(r1);
            r1 = null;
            stack.top = stack.root.getNextDisk();
        }
        //else, if there is a top, we point it to the new disk, and label the new disk as top.
        else
        {
            stack.top.setNextDisk(r1);
            r1 = null;
            stack.prev = stack.top;
            stack.top = stack.top.getNextDisk();
        }
    }

    public static Disk peek(Tower stack)
    {
        return stack.top;
    }

    public static void pop(Disk r1, Tower stack)
    {
        //removes the top disk of the stack and puts it in the register
        //fills the register with null if the stack is empty.
        r1 = stack.top;
        stack.top = stack.prev;
        stack.top.setNextDisk(null);
    }

    public void display(ViewGroup v, Context c)
    {
        Disk counter = this.root.getNextDisk();
        do
        {
            counter.displayDisk(v, c);
        }while(counter != null);

    }

    public void initTow(int size)
    {
        Disk d1 = new Disk(1);
        size --;
        this.prev = this.top;
        this.top = d1;
        this.root.setNextDisk(this.top);
        for(int i = 1; i < size; i++)
        {
            d1 = new Disk(i + 1);
            this.prev = this.top;
            this.top = d1;
        }
    }
}
