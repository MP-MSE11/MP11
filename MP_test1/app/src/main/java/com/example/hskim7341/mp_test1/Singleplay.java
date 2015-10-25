package com.example.hskim7341.mp_test1;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


public class Singleplay extends AppCompatActivity implements View.OnClickListener {

    private ImageButton[] ButtonArray = new ImageButton[9];
    private int[] index_array = new int[3];
    private int i;
    private int click_count=0;
    private int r_index = 3;
    ArrayList<Integer> ranNumber = new ArrayList<Integer>();

    public static final int imagearray[] = {R.drawable.bbc, R.drawable.bbs, R.drawable.bbt, R.drawable.brc, R.drawable.brs, R.drawable.brt, R.drawable.byc, R.drawable.bys, R.drawable.byt,
            R.drawable.gbc, R.drawable.gbs, R.drawable.gbt, R.drawable.grc, R.drawable.grs, R.drawable.grt, R.drawable.gyc, R.drawable.gys, R.drawable.gyt,
            R.drawable.wbc, R.drawable.wbs, R.drawable.wbt, R.drawable.wrc, R.drawable.wrs, R.drawable.wrt, R.drawable.wyc, R.drawable.wys, R.drawable.wyt};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplay);

        ButtonArray[0] = (ImageButton)findViewById(R.id.block1);
        ButtonArray[1] = (ImageButton)findViewById(R.id.block2);
        ButtonArray[2] = (ImageButton)findViewById(R.id.block3);

        ButtonArray[3] = (ImageButton)findViewById(R.id.block4);
        ButtonArray[4] = (ImageButton)findViewById(R.id.block5);
        ButtonArray[5] = (ImageButton)findViewById(R.id.block6);

        ButtonArray[6] = (ImageButton)findViewById(R.id.block7);
        ButtonArray[7] = (ImageButton)findViewById(R.id.block8);
        ButtonArray[8] = (ImageButton)findViewById(R.id.block9);

        for(int temp = 0; temp < 27; temp++){
            ranNumber.add(temp);
        }
        Collections.shuffle(ranNumber);

        for(i=0; i<9; i++){
            ButtonArray[i].setOnClickListener(this);
            r_index = ranNumber.get(i);
            ButtonArray[i].setImageResource(imagearray[r_index]);
        }
    }

    public void onClick(View v)
    {
        if(click_count<3){
            index_array[click_count] = click_count+1;
            click_count++;
        }
        if (click_count == 3) {
            Toast.makeText(this, "clicked "+ index_array[2] +" Button", Toast.LENGTH_SHORT).show();
            click_count = 0;
        }

    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_singleplay, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
