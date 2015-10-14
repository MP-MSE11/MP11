package com.example.hskim7341.mp_test1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button singleplay_button;
    Button HTP_button;
    Button creater_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singleplay_button = (Button)findViewById(R.id.single_button);
        singleplay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Single_intent = new Intent(MainActivity.this, Singleplay.class);
                startActivity(Single_intent);
            }
        });
        HTP_button = (Button)findViewById(R.id.HTP_button);
        HTP_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent HTP_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=33D3A3196A64C8C09178A1F9C4B3F1CB3996&outKey=V126304d30c9ef7dd19f156e9be4b1ee33e3d451d4289d9abf61d56e9be4b1ee33e3d&width=720&height=438"));
                startActivity(HTP_intent);
            }
        });
        creater_button = (Button)findViewById(R.id.Creater_button);
        creater_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent Creater_intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(Creater_intent);
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
