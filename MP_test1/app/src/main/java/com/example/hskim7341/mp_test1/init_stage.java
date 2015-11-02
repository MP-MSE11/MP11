package com.example.hskim7341.mp_test1;

import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by hskim7341 on 2015-11-02.
 */
public class init_stage{
    public class init_image {
        public int image;
        public int shape;
        public int back_color;
        public int shape_color;
        init_image(){
            this.image = 0;
            this.shape = 0;
            this.back_color = 0;
            this.shape_color = 0;
        }
    }
    public static final int imagearray[]= new int[]{R.drawable.bbc, R.drawable.bbs, R.drawable.bbt,R.drawable.brc, R.drawable.brs, R.drawable.brt, R.drawable.byc, R.drawable.bys, R.drawable.byt,
            R.drawable.gbc, R.drawable.gbs, R.drawable.gbt, R.drawable.grc, R.drawable.grs, R.drawable.grt, R.drawable.gyc, R.drawable.gys, R.drawable.gyt,
            R.drawable.wbc, R.drawable.wbs, R.drawable.wbt, R.drawable.wrc, R.drawable.wrs, R.drawable.wrt, R.drawable.wyc, R.drawable.wys, R.drawable.wyt};

    ArrayList<Integer> ranNumber = new ArrayList<Integer>();
    public init_image[] block_array = new init_image[27];
    init_stage(){
        for(int temp = 0; temp < 27; temp++){
            ranNumber.add(temp);
            block_array[temp].image = imagearray[temp];
            if(temp/9 == 0){//background color is black

            }
            else if(temp/9 == 1){//background color is gray

            }
            else{//background color is white

            }
        }
        Collections.shuffle(ranNumber);
    }

}
