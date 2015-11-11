package com.example.hskim7341.mp_test1;

public class check_match{
    check_match(){

    }
    int match(init_block button1, init_block button2, init_block button3){
        if(button1.b_shape == button2.b_shape && button2.b_shape == button3.b_shape){
            if(button1.b_shapecolor == button2.b_shapecolor && button2.b_shapecolor == button3.b_shapecolor){
                if(button1.b_backcolor == button2.b_backcolor && button2.b_backcolor == button3.b_backcolor){
                    return 1;
                }
                else if(button1.b_backcolor +  button2.b_backcolor + button3.b_backcolor == 3){
                    return 1;
                }
            }
            else if(button1.b_shapecolor +  button2.b_shapecolor + button3.b_shapecolor == 3){
                if(button1.b_backcolor == button2.b_backcolor && button2.b_backcolor == button3.b_backcolor){
                    return 1;
                }
                else if(button1.b_backcolor +  button2.b_backcolor + button3.b_backcolor == 3){
                    return 1;
                }
            }
        }
        else if(button1.b_shape + button2.b_shape + button3.b_shape  == 3){
            if(button1.b_shapecolor == button2.b_shapecolor && button2.b_shapecolor == button3.b_shapecolor){
                if(button1.b_backcolor == button2.b_backcolor && button2.b_backcolor == button3.b_backcolor){
                    return 1;
                }
                else if(button1.b_backcolor +  button2.b_backcolor + button3.b_backcolor == 3){
                    return 1;
                }
            }
            else if(button1.b_shapecolor +  button2.b_shapecolor + button3.b_shapecolor == 3){
                if(button1.b_backcolor == button2.b_backcolor && button2.b_backcolor == button3.b_backcolor){
                    return 1;
                }
                else if(button1.b_backcolor +  button2.b_backcolor + button3.b_backcolor == 3){
                    return 1;
                }
            }
        }
        return -1;
    }

}
