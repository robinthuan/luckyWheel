package com.ryan.luckywheel;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rubikstudio.library.LuckyWheelView;
import rubikstudio.library.model.LuckyItem;
import rubikstudio.library.PielView;

public class MainActivity extends AppCompatActivity {
    List<LuckyItem> data = new ArrayList<>();
     LuckyWheelView luckyWheelView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
         luckyWheelView = (LuckyWheelView) findViewById(R.id.luckyWheel);

        LuckyItem luckyItem1 = new LuckyItem();

        luckyItem1.color=getResources().getColor(R.color.blue);
        luckyItem1.text=getResources().getString(R.string.blue);
        data.add(luckyItem1);

        LuckyItem luckyItem2 = new LuckyItem();
        luckyItem2.color=getResources().getColor(R.color.red);
        luckyItem2.text=getResources().getString(R.string.red_one);
        data.add(luckyItem2);

        LuckyItem luckyItem3 = new LuckyItem();
        luckyItem3.color=getResources().getColor(R.color.yellow);
        luckyItem3.text=getResources().getString(R.string.yellow_one);
        data.add(luckyItem3);

        //////////////////
        LuckyItem luckyItem4 = new LuckyItem();
        luckyItem4.color=getResources().getColor(R.color.green);
        luckyItem4.text=getResources().getString(R.string.green_one);
        data.add(luckyItem4);

        LuckyItem luckyItem5 = new LuckyItem();
        luckyItem5.color=getResources().getColor(R.color.ping);
        luckyItem5.text=getResources().getString(R.string.ping_one);
        data.add(luckyItem5);

        LuckyItem luckyItem6 = new LuckyItem();
        luckyItem6.text=getResources().getString(R.string.red_two);

        luckyItem6.color=getResources().getColor(R.color.red);
        data.add(luckyItem6);


        //////////////////////
        LuckyItem luckyItem7 = new LuckyItem();
        luckyItem7.color=getResources().getColor(R.color.yellow);
        luckyItem7.text=getResources().getString(R.string.yellow_two);

        data.add(luckyItem7);

        LuckyItem luckyItem8 = new LuckyItem();
        luckyItem8.color=getResources().getColor(R.color.green);
        luckyItem8.text=getResources().getString(R.string.green_two);
        data.add(luckyItem8);



        ////////////////////////



        /////////////////////

        luckyWheelView.setData(data);
        luckyWheelView.setRound(getRandomRound());

        /*luckyWheelView.setLuckyWheelBackgrouldColor(0xff0000ff);
        luckyWheelView.setLuckyWheelTextColor(0xffcc0000);
        luckyWheelView.setLuckyWheelCenterImage(getResources().getDrawable(R.drawable.icon));
        luckyWheelView.setLuckyWheelCursorImage(R.drawable.ic_cursor);*/

/*
        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = getRandomIndex();
                luckyWheelView.startLuckyWheelWithTargetIndex(index);
            }
        });*/

        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                Toast.makeText(getApplicationContext(), data.get(index-1).text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int index=getRandomIndex();
        switch (keyCode){
            case KeyEvent.KEYCODE_TV_CONTENTS_MENU:
                luckyWheelView.startLuckyWheelWithTargetIndex(index);
                break;
            case KeyEvent.KEYCODE_ENTER:
                luckyWheelView.startLuckyWheelWithTargetIndex(index);
                break;
        default:break;
        }
        return true;
    }

    private int getRandomIndex() {
        Random rand = new Random();
        return rand.nextInt(data.size() - 1) + 0;
    }

    private int getRandomRound() {
        Random rand = new Random();
        return rand.nextInt(10) + 15;
    }
}
