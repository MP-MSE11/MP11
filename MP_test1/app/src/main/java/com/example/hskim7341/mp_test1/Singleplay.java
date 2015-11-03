package com.example.hskim7341.mp_test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.FieldPosition;
import java.util.Collections;

public class Singleplay extends AppCompatActivity implements View.OnClickListener{

    private int[] index_array = new int[3];
    private int click_count=0;
    private int score = 0;
    private int temp_index = 0;
    private int finishcount = 0;
    int position = 0;

    init_stage i_stage = new init_stage();
    check_match c_match = new check_match();

    public ImageButton[] ButtonArray = new ImageButton[9];
    public init_block[] button_block = new init_block[9];
    public TextView s_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplay);

        for(int temp = 0; temp<9; temp++){
            button_block[temp] = new init_block();
        }

        ButtonArray[0] = (ImageButton)findViewById(R.id.block1);
        ButtonArray[1] = (ImageButton)findViewById(R.id.block2);
        ButtonArray[2] = (ImageButton)findViewById(R.id.block3);

        ButtonArray[3] = (ImageButton)findViewById(R.id.block4);
        ButtonArray[4] = (ImageButton)findViewById(R.id.block5);
        ButtonArray[5] = (ImageButton)findViewById(R.id.block6);

        ButtonArray[6] = (ImageButton)findViewById(R.id.block7);
        ButtonArray[7] = (ImageButton)findViewById(R.id.block8);
        ButtonArray[8] = (ImageButton)findViewById(R.id.block9);

        s_view = (TextView)findViewById(R.id.score_view);

        Collections.shuffle(i_stage.ranNumber);

        for(int i =0; i<9; i++){
            ButtonArray[i].setTag(i);
            ButtonArray[i].setOnClickListener(this);
            temp_index = i_stage.ranNumber.get(i);
            ButtonArray[i].setImageResource(i_stage.block_array[temp_index].image);
            button_block[i].b_backcolor = i_stage.block_array[temp_index].back_color;
            button_block[i].b_shapecolor = i_stage.block_array[temp_index].shape_color;
            button_block[i].b_shape = i_stage.block_array[temp_index].shape;
        }

        s_view.setText(String.format("Score : %d점",score));
        finishcount = i_stage.check_finishcount(button_block);
    }



    public void onClick(View v)
    {
        ImageButton newButton = (ImageButton) v;
        for(ImageButton tempButton : ButtonArray)
        {
            if(tempButton == newButton){
                position = (Integer)v.getTag();
                if(click_count<3) {
                    index_array[click_count] = position + 1;
                    click_count++;
                }
                if (click_count == 3) {
                       if(c_match.match(button_block[index_array[0]-1], button_block[index_array[1]-1], button_block[index_array[2]-1]) == 1){
                           Toast.makeText(this, "clicked "+ index_array[0] + ", " + index_array[1] + ", " + index_array[2] + " Button\n" + "정답. score + 1", Toast.LENGTH_SHORT).show();
                           score++;
                           s_view.setText(String.format("Score : %d점",score));
                       }
                       else{
                           Toast.makeText(this, "clicked "+ index_array[0] + ", " + index_array[1] + ", " + index_array[2] + " Button\n"+ "합이 아닙니다. score - 1", Toast.LENGTH_SHORT).show();
                           score--;
                           s_view.setText(String.format("Score : %d점",score));
                       }
                    click_count = 0;
                }
            }
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
