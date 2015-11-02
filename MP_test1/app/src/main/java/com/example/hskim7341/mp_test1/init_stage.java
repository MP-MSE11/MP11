package com.example.hskim7341.mp_test1;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by hskim7341 on 2015-11-02.
 */
public class init_stage{

    public static final int imagearray[]= new int[]{R.drawable.bbc, R.drawable.bbs, R.drawable.bbt,R.drawable.brc, R.drawable.brs, R.drawable.brt, R.drawable.byc, R.drawable.bys, R.drawable.byt,
            R.drawable.gbc, R.drawable.gbs, R.drawable.gbt, R.drawable.grc, R.drawable.grs, R.drawable.grt, R.drawable.gyc, R.drawable.gys, R.drawable.gyt,
            R.drawable.wbc, R.drawable.wbs, R.drawable.wbt, R.drawable.wrc, R.drawable.wrs, R.drawable.wrt, R.drawable.wyc, R.drawable.wys, R.drawable.wyt};

    ArrayList<Integer> ranNumber = new ArrayList<Integer>();
    public init_image[] block_array = new init_image[27];

    init_stage(){
        for(int a =0 ; a<27; a++){
            ranNumber.add(a);
            block_array[a] = new init_image();
        }

        for(int temp = 0; temp < 27; temp++) {
            block_array[temp].image = imagearray[temp];
            if (temp / 9 == 0) {//background color is black
                block_array[temp].back_color = 0; //back_color == 0 is black
            } else if (temp / 9 == 1) {//background color is gray
                block_array[temp].back_color = 1; //back_color == 1 is gray
            } else if (temp / 9 == 2) {//background color is white
                block_array[temp].back_color = 2; //back_color == 2 is white
            }

            if (temp % 9 == 0 || temp % 9 == 1 || temp % 9 == 2) {//shape color is blue
                block_array[temp].shape_color = 0;
            } else if (temp % 9 == 3 || temp % 9 == 4 || temp % 9 == 5) {//shape color is red
                block_array[temp].shape_color = 1;
            } else if (temp % 9 == 6 || temp % 9 == 7 || temp % 9 == 8) {//shape color is yellow
                block_array[temp].shape_color = 2;
            }

            if (temp % 3 == 0) {//shape is circle
                block_array[temp].shape = 0;
            } else if (temp % 3 == 1) {//shape is square
                block_array[temp].shape = 1;
            } else if (temp % 3 == 2) {//shape is triangle
                block_array[temp].shape = 2;
            }
        }

    }

}
