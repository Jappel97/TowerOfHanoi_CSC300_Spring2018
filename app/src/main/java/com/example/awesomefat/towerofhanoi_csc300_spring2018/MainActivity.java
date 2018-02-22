package com.example.awesomefat.towerofhanoi_csc300_spring2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ViewGroup s0View;
    private Tower s0;
    private ViewGroup s1View;
    private Tower s1;
    private Tower s2;
    private ViewGroup s2View;
    private Disk reg1 = null;
    private EditText stackNum;
    private TextView Reg1;
    private boolean win = false;
    private int moves = 0;
    private TextView numMoves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.s0View = (ViewGroup)this.findViewById(R.id.s0View);
        this.s1View = (ViewGroup)this.findViewById(R.id.s1View);
        this.s2View = (ViewGroup)this.findViewById(R.id.s2View);
        this.stackNum = (EditText)this.findViewById(R.id.stackNum);
        this.Reg1 = (TextView)this.findViewById(R.id.Reg1);
        this.numMoves = (TextView)this.findViewById(R.id.numMoves);

        s0 = new Tower();
        s0.initTow(3);
        s0.display(s0View, this);
        s1 = new Tower();
        s1.display(s1View, this);
        s2 = new Tower();
        s2.display(s2View, this);
    }

    public void popBtnPressed(View v)
    {
        if(win)
        {
            return;
        }
        int temp = Integer.parseInt(this.stackNum.getText().toString());
        if(Reg1 != null)
        {
            Toast.makeText(this, "Register is full!", Toast.LENGTH_SHORT);
        }
        else if(temp == 0)
        {
            Tower.pop(reg1, s0);
            s0.display(s0View, this);
        }
        else if(temp == 1)
        {
            Tower.pop(reg1, s1);
            s1.display(s1View, this);
        }
        else if(temp == 2)
        {
            Tower.pop(reg1, s2);
            s2.display(s2View, this);
        }
        else
        {
            Toast.makeText(this, "Invalid tower number", Toast.LENGTH_SHORT);
        }
        Reg1.setText(reg1.getSize());
        moves++;
        this.numMoves.setText("" + moves);
    }

    public void pushBtnPressed(View v)
    {
        if(win)
        {
            return;
        }
        int temp = Integer.parseInt(this.stackNum.getText().toString());
        if(reg1 == null)
        {
            Toast.makeText(this, "Register is empty!", Toast.LENGTH_SHORT);
        }
        else if(temp == 0)
        {
            if(reg1.getSize() >= s0.top.getSize())
            {
                Tower.push(reg1, s0);
                s0.display(s0View, this);
                moves++;
            }
            else
            {
                Toast.makeText(this, "Cannot fit onto smaller disk!", Toast.LENGTH_SHORT);
            }
        }
        else if(temp == 1)
        {
            if(reg1.getSize() >= s1.top.getSize())
            {
                Tower.push(reg1, s1);
                s1.display(s1View, this);
                moves++;
            }
            else
            {
                Toast.makeText(this, "Cannot fit onto smaller disk!", Toast.LENGTH_SHORT);
            }
        }
        else if(temp == 2)
        {
            if(reg1.getSize() >= s2.top.getSize())
            {
                Tower.push(reg1, s2);
                s2.display(s2View, this);
                moves++;
            }
            else
            {
                Toast.makeText(this, "Cannot fit onto smaller disk!", Toast.LENGTH_SHORT);
            }
        }
        else
        {
            Toast.makeText(this, "Invalid tower number", Toast.LENGTH_SHORT);
        }
        Reg1.setText(reg1.getSize());
        if(s2.checkWin())
        {
            Toast.makeText(this, "You Win!", Toast.LENGTH_LONG);
            win = true;
        }
        this.numMoves.setText("" + moves);
    }


}
