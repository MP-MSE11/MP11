package com.example.hskim7341.mp_test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by hskim7341 on 2015-11-10.
 */
public class Ghmain extends AppCompatActivity {

    Button ghstart_button;
    Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghmain);

        ghstart_button = (Button)findViewById(R.id.start_button);
        ghstart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Ghstart_intent = new Intent(Ghmain.this, Singleplay.class);
                startActivity(Ghstart_intent);
            }
        });
        back_button = (Button)findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
