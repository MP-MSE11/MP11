package com.example.hskim7341.mp_test1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
    private int finish_check_count = 0;
    int position = 0;
    Button back_button;
    ImageButton finish_button;

    init_stage i_stage = new init_stage();
    check_match c_match = new check_match();

    public ImageButton[] ButtonArray = new ImageButton[9];
    public init_block[] button_block = new init_block[9];
    public TextView s_view;
    public TextView hab_view;

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

        back_button = (Button)findViewById(R.id.ghback_button);
        back_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
        finish_button = (ImageButton)findViewById(R.id.finish_button);
        finish_button.setOnClickListener(this);
        finish_button.setImageResource(R.drawable.finish_button);

        Collections.shuffle(i_stage.ranNumber);

        for(int i =0; i<9; i++){
            ButtonArray[i].setTag(i);
            ButtonArray[i].setOnClickListener(this);
            temp_index = i_stage.ranNumber.get(i);
            ButtonArray[i].setImageResource(i_stage.block_array[temp_index].image);
            ButtonArray[i].setBackgroundColor(Color.WHITE);
            button_block[i].b_backcolor = i_stage.block_array[temp_index].back_color;
            button_block[i].b_shapecolor = i_stage.block_array[temp_index].shape_color;
            button_block[i].b_shape = i_stage.block_array[temp_index].shape;
            button_block[i].b_position = 0;
        }

        s_view.setText(String.format("Score : %d점", score));
        finishcount = i_stage.check_finishcount(button_block);
        finish_check_count = finishcount;
    }


    public void onClick(View v) {
        ImageButton newButton = (ImageButton) v;
        int flag = 0;
        for (ImageButton tempButton : ButtonArray) {
            if (tempButton == newButton) {
                flag = 1;
                position = (Integer) v.getTag();
                if (click_count < 3) {
                    index_array[click_count] = position + 1;
                    if (button_block[position].b_position == 0) {
                        click_count++;
                        button_block[position].b_position = 1;
                        ButtonArray[position].setBackgroundColor(Color.LTGRAY);
                    } else if (button_block[position].b_position == 1) {
                        button_block[position].b_position = 0;
                        click_count--;
                        ButtonArray[position].setBackgroundColor(Color.WHITE);
                    }
                }
                if (click_count == 3) {
                    this.i_stage.uppersort(index_array);
                    if(c_match.match(button_block[index_array[0]-1], button_block[index_array[1]-1], button_block[index_array[2]-1]) == 1){
                        for(int t = 0; t < finish_check_count; t ++){
                            if(i_stage.hab_array[t][1] == index_array[0] - 1){
                                if(i_stage.hab_array[t][2] == index_array[1] - 1) {
                                    if(i_stage.hab_array[t][3] == index_array[2] - 1){
                                        if(i_stage.hab_array[t][0] == 0){
                                            Toast.makeText(this, "clicked "+ index_array[0] + ", " + index_array[1] + ", " + index_array[2] + " Button\n" + "정답. +1점", Toast.LENGTH_SHORT).show();
                                            score++;
                                            finishcount--;
                                            i_stage.hab_array[t][0] = 1;
                                            s_view.setText(String.format("Score : %d점",score));
                                        }
                                        else{
                                            Toast.makeText(this, "clicked "+ index_array[0] + ", " + index_array[1] + ", " + index_array[2] + " Button\n" + "이미 선택하셨습니다. -1점", Toast.LENGTH_SHORT).show();
                                            score--;
                                            s_view.setText(String.format("Score : %d점", score));
                                        }
                                    }else continue;
                                }else continue;
                            }else continue;
                        }
                    }
                    else{
                        Toast.makeText(this, "clicked "+ index_array[0] + ", " + index_array[1] + ", " + index_array[2] + " Button\n"+ "합이 아닙니다. -1점", Toast.LENGTH_SHORT).show();
                        score--;
                        s_view.setText(String.format("Score : %d점",score));
                    }
                    for(int t=0; t<3; t++){
                        ButtonArray[index_array[t]-1].setBackgroundColor(Color.WHITE);
                        button_block[index_array[t]-1].b_position = 0;
                        index_array[t] = 0;
                    }
                    click_count = 0;
                }
            }
        }
        if(flag == 0){
            if(newButton == finish_button){
                if (finishcount == 0) {
                    Toast.makeText(Singleplay.this, "결. +3점", Toast.LENGTH_SHORT).show();
                    score = score + 3;
                    Collections.shuffle(i_stage.ranNumber);

                    for(int i =0; i<9; i++){
                        ButtonArray[i].setTag(i);
                        ButtonArray[i].setOnClickListener(this);
                        temp_index = i_stage.ranNumber.get(i);
                        ButtonArray[i].setImageResource(i_stage.block_array[temp_index].image);
                        ButtonArray[i].setBackgroundColor(Color.WHITE);
                        button_block[i].b_backcolor = i_stage.block_array[temp_index].back_color;
                        button_block[i].b_shapecolor = i_stage.block_array[temp_index].shape_color;
                        button_block[i].b_shape = i_stage.block_array[temp_index].shape;
                        button_block[i].b_position = 0;
                    }

                    s_view.setText(String.format("Score : %d점", score));
                    finishcount = i_stage.check_finishcount(button_block);

                } else {
                    Toast.makeText(Singleplay.this, "결이 아닙니다. -1점", Toast.LENGTH_SHORT).show();
                    score--;
                    s_view.setText(String.format("Score : %d점", score));
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
