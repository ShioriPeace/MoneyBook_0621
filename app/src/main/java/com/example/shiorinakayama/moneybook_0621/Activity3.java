package com.example.shiorinakayama.moneybook_0621;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;

public class Activity3 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item_top:
                finish();
                return true;

            case R.id.item1:
                finish();
                Intent varIntent1 = new Intent(Activity3.this,Activity1.class);
                startActivity(varIntent1);
                return true;
            case R.id.item2:
                finish();
                Intent varIntent2 = new Intent(Activity3.this,Activity2.class);
                startActivity(varIntent2);
                return true;

            case R.id.item3:
                finish();
                Intent varIntent3 = new Intent(Activity3.this,Activity3.class);
                startActivity(varIntent3);
                return true;

        }
        return super.onOptionsItemSelected(item);

    }


}
