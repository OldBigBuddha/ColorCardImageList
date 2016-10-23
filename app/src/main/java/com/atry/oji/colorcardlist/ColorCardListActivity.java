package com.atry.oji.colorcardlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ColorCardListActivity extends AppCompatActivity {

    //変数宣言
    private List<Card>       cardList       = null;
    private ColorInfoAdapter adapter        = null;
    private ListView         listView       = null;

    private final String[] COLORCODES = {"black", "red", "blue", "green", "yellow","white" };
    private final String[] COLORNAMES = {"黒", "赤", "青", "緑", "黄", "白"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_card_list);

        listView = (ListView)findViewById(R.id.listView);

        cardList = new ArrayList<>();
        for (int i = 0; i < COLORNAMES.length; i++) {
            cardList.add(new Card(COLORNAMES[i], COLORCODES[i]));
        }

        adapter = new ColorInfoAdapter(this, R.layout.card, cardList);
        listView.setAdapter(adapter);
    }
}
