package com.mine.tiku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private LvAdapter lvAdapter;
    private List<TiBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        lv = findViewById(R.id.lv);
        Button btn1 = findViewById(R.id.btn1);
        TextView tv_me = findViewById(R.id.tv_me);
        Button btn2 = findViewById(R.id.btn2);
        list = new ArrayList<>();
        lvAdapter = new LvAdapter(this, R.layout.item_ti, list);
        lv.setAdapter(lvAdapter);
        getData();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main3Activity.class));
            }
        });
        tv_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main4Activity.class));
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("id",list.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    private void getData() {
        list.clear();
        //获取已保存的
        SharedPreferences ti = getSharedPreferences("ti", MODE_PRIVATE);
        String tistr = ti.getString("ti", new Gson().toJson(new Ti()));
        System.out.println("======"+tistr);
        Ti fromJson = new Gson().fromJson(tistr, Ti.class);
        List<Integer> ids = fromJson.getIds();
        for (int i = 0; i < App.ti.size(); i++) {
            TiBean tiBean = App.ti.get(i);
            for (int j = 0; j < ids.size(); j++) {
                if (tiBean.getId() == ids.get(j)) {
                    list.add(tiBean);
                }
            }

        }
        lvAdapter.notifyDataSetChanged();

    }
}
