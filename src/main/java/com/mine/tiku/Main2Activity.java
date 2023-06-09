package com.mine.tiku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private List<Integer> randomNum;
    private TextView tv_ti;
    private TextView tv_zhunbei;
    private TextView tv_daojishi;
    private TextView tv_tool;
    private ListView lv_daan;
    private int tool = 0;
    private int down = 0;

    private CountDownTimer countDownTimer2;
    private LinearLayout ll_zunbei;
    private LinearLayout ll_ti;
    private LinearLayout ll_daan;
    private Button btn;
    private Button btn_next;
    private int id;
    private int max = 10;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        initView();

    }

    private void initView() {

        ll_zunbei = findViewById(R.id.ll_zunbei);
        ll_daan = findViewById(R.id.ll_daan);
        ll_ti = findViewById(R.id.ll_ti);
        tv_ti = findViewById(R.id.tv_ti);
        tv_daojishi = findViewById(R.id.tv_daojishi);
        tv_zhunbei = findViewById(R.id.tv_zhunbei);
        tv_tool = findViewById(R.id.tv_tool);
        btn = findViewById(R.id.btn);
        btn_next = findViewById(R.id.btn_next);
        lv_daan = findViewById(R.id.lv_daan);
        chronometer = findViewById(R.id.chronometer);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextTi();
            }
        });
        if (id != -1) {
            max = 1;
            chronometer.setVisibility(View.GONE);
        }else {
            chronometer.setVisibility(View.VISIBLE);
        }

        randomNum = getRandomNum(0, App.ti.size() - 1, max);

        countDownTimer2 = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int i = (int) (millisUntilFinished / 1000);
                tv_zhunbei.setText((i) + "");
            }

            @Override
            public void onFinish() {
                chronometer.start();
                ll_zunbei.setVisibility(View.GONE);
                ll_ti.setVisibility(View.VISIBLE);
                setTi(down);
                countDownTimer2.cancel();

            }
        };
        if (id == -1) {
            countDownTimer2.start();
        }else {
            ll_zunbei.setVisibility(View.GONE);
            ll_ti.setVisibility(View.VISIBLE);
            setTi(down);
        }

    }

    private void nextTi() {
        if (down < max - 1) {
            down++;
            setTi(down);
        } else {
            ll_zunbei.setVisibility(View.VISIBLE);
            ll_ti.setVisibility(View.GONE);
            tv_zhunbei.setText("");
            tv_tool.setText("你的得分是:" + tool + "分");
            btn.setVisibility(View.VISIBLE);
//保存
            SharedPreferences ti = getSharedPreferences("fen", MODE_PRIVATE);
            SharedPreferences.Editor edit = ti.edit();
            String tistr = ti.getString("fen", new Gson().toJson(new FenBean()));
            FenBean fromJson = new Gson().fromJson(tistr, FenBean.class);
            FenBean.FenBean2 bean = new FenBean.FenBean2();
            bean.setFen(tool);
            bean.setTime(System.currentTimeMillis());
            fromJson.getList().add(bean);
            edit.putString("fen", new Gson().toJson(fromJson));
            edit.commit();

        }
    }

    private void setTi(int i) {
        ll_daan.setVisibility(View.GONE);
        final TiBean tiBean;
        if (id == -1) {
            tiBean = App.ti.get(randomNum.get(i));
        } else {
            tiBean = App.ti.get(id - 1);
        }
        tv_ti.setText((i + 1) + "  " + tiBean.getTi());
        String[] daan = tiBean.getDaan();
        final String[] str = new String[]{"0", "A", "B", "C", "D"};
        lv_daan.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, daan));
        lv_daan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (ll_daan.getVisibility() == View.VISIBLE) {
                    return;
                }
                //                显示
                ll_daan.setVisibility(View.VISIBLE);
                tv_daojishi.setText("正确答案:" + str[tiBean.getDui()] + "\n" + tiBean.getInfo() + "\n");
//                回答正确,加分
                if (position + 1 == tiBean.getDui()) {
                    tool += 10;
                    tv_daojishi.append("回答正确!+10分");
                    san(tiBean.getId());
                } else {
                    tv_daojishi.append("你选择了" + str[position + 1] + ",回答错误");
                    baocun(tiBean.getId());
                }


            }
        });

    }

    private void baocun(int id) {

        //获取已保存的
        SharedPreferences ti = getSharedPreferences("ti", MODE_PRIVATE);
        SharedPreferences.Editor edit = ti.edit();
        String tistr = ti.getString("ti", new Gson().toJson(new Ti()));
        System.out.println("======" + tistr);
        Ti fromJson = new Gson().fromJson(tistr, Ti.class);
        List<Integer> ids = fromJson.getIds();
//        判断是否已添加
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == id) {
                return;
            }
        }
        fromJson.getIds().add(id);
        edit.putString("ti", new Gson().toJson(fromJson));
        edit.commit();
    }

    private void san(int id) {

        //获取已保存的
        SharedPreferences ti = getSharedPreferences("ti", MODE_PRIVATE);
        SharedPreferences.Editor edit = ti.edit();
        String tistr = ti.getString("ti", new Gson().toJson(new Ti()));
        System.out.println("======" + tistr);
        Ti fromJson = new Gson().fromJson(tistr, Ti.class);
        List<Integer> ids = fromJson.getIds();
//        判断是否已添加
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == id) {
                fromJson.getIds().remove(i);
            }
        }
        edit.putString("ti", new Gson().toJson(fromJson));
        edit.commit();
    }


    public List<Integer> getRandomNum(int requMin, int requMax, int targetLength) {
        if (requMax - requMin < 1) {
            System.out.print("最小值和最大值数据有误");
            return null;
        } else if (requMax - requMin < targetLength) {
            System.out.print("指定随机个数超过范围");
            return null;
        }
        int target = targetLength;
        List<Integer> list = new ArrayList<>();

        List<Integer> requList = new ArrayList<>();
        for (int i = requMin; i <= requMax; i++) {
            requList.add(i);
        }

        for (int i = 0; i < targetLength; i++) {

            // 取出一个随机角标
            int r = (int) (Math.random() * requList.size());
            list.add(requList.get(r));

            // 移除已经取过的值
            requList.remove(r);


        }

        return list;
    }
}
