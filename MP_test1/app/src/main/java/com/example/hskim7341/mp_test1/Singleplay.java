package com.example.hskim7341.mp_test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import static com.example.hskim7341.mp_test1.init_stage.*;


public class Singleplay extends AppCompatActivity implements View.OnClickListener{

    private int[] index_array = new int[3];
    private int click_count=0;
    private int score = 0;

    init_stage i_stage = new init_stage();

    public ImageButton[] ButtonArray = new ImageButton[9];

    public init_block[] button_block = new init_block[9];

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

        for(int i =0; i<9; i++){
            ButtonArray[i].setOnClickListener(this);
            ButtonArray[i].setImageResource(i_stage.imagearray[i_stage.ranNumber.get(i)]);
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
