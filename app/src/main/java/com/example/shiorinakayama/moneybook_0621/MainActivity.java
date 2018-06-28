package com.example.shiorinakayama.moneybook_0621;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(this);
        setContentView(myView);

    }


    class MyView extends View {
        private Paint paint;
        private float xRect = 0;
        private float xRect2 = 0;
        private float yRect = 0;
        private float xa = 140 + xRect;
        private float xb = 140 + xRect2;

        final TextView textView = (TextView)findViewById(R.id.all);




        @Override
        public boolean onTouchEvent(MotionEvent event) {
            xRect = event.getX();
            xRect2 = event.getX();
            yRect = event.getY();

            this.invalidate();


            return true;
        }

        public  MyView(Context context){
            super(context);
            paint = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas){
            //背景
            canvas.drawARGB(255,255,255,255);
            paint.setARGB(255,132,255,193);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);

            Bitmap eat = BitmapFactory.decodeResource(getResources(),R.drawable.eating);
            Bitmap shirt = BitmapFactory.decodeResource(getResources(),R.drawable.shirt);
            //緑の円
            canvas.drawCircle(550,400,350, paint);
            //白い円
            paint.setARGB(255, 255, 255, 255);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(550, 400, 170, paint);
            //白い弧
            canvas.drawArc(150,40,1050,850,0,0 + xRect/5 + xRect2/5,true,paint);

            if (yRect<1250) {
                xRect = 0;

            } else {

                xRect2 = 0;

            }
            //ピンク短形
            paint.setColor(Color.argb(255, 255, 142, 198));
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRect(0, 1300, 180 + xRect, 1500, paint);
            //アイコン
            canvas.drawBitmap(eat,0 + xRect,1300,paint);

            //青短径
            paint.setColor(Color.argb(255, 147, 201, 255));
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRect(0, 1050, 185 + xRect2, 1250, paint);
            canvas.drawBitmap(shirt,0 + xRect2,1050,paint);


        }


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

                Intent varIntent_back = new Intent(MainActivity.this,MainActivity.class);
                startActivity(varIntent_back);
                return true;

            case R.id.item1:
                Intent varIntent1 = new Intent(MainActivity.this,Activity1.class);
                startActivity(varIntent1);
                return true;

            case R.id.item2:
                Intent varIntent2 = new Intent(MainActivity.this,Activity2.class);
                startActivity(varIntent2);
                return true;

            case R.id.item3:
                Intent varIntent3 = new Intent(MainActivity.this,Activity3.class);
                startActivity(varIntent3);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
