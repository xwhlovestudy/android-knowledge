package com.xh229050532.Asian_Game_Knowledge;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    public static List<TiBean> ti = new ArrayList<>();
    public static List<FenBean> fens = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        addTi();
//        创建问题
        TiBean tiBean = new TiBean();
//        题号
        tiBean.setId(1);
//        答案解析
        tiBean.setInfo("降到了萨科技的萨克来得及奥斯卡了大街上");
//        题目
        tiBean.setTi("下列哪项不是Ancroid四大组件");
//        选项
        tiBean.setDaan(new String[]{"A.Seivice", "B. Activity", "C.Handler", "D. Content Provider"});
//        正确选项
        tiBean.setDui(3);
//        添加到题库
        ti.add(tiBean);

        TiBean tiBean2 = new TiBean();
        tiBean2.setId(2);
        tiBean2.setInfo("大家撒枯鲁杜鹃阿斯利康");
        tiBean2.setTi("Android是如何组织Activity的");
        tiBean2.setDaan(new String[]{"A以堆的方式组织Activity", "B.以栈的方式组织Activity", "C.以树形方式组织Activity", "D.以链式方式组织Activity"});
        tiBean2.setDui(2);
        ti.add(tiBean2);
        TiBean tiBean3 = new TiBean();
        tiBean3.setTi("关于线程说法不正确的是");
        tiBean3.setInfo("dsakldjaskl");
        tiBean3.setId(3);
        tiBean3.setDaan(new String[]{"A.在android 中，我们可以在主线程中，创建一个新的线程"
                , "B.在创建的新线程中，它可以操作UI 组件"
                , "C.新线程可以和 Handler共同使用"
                , "D.创建的 Hand1er对象，它隶属于创建它的线程"});
        tiBean3.setDui(2);
        ti.add(tiBean3);
        TiBean tiBean4 = new TiBean();
        tiBean4.setId(4);
        tiBean4.setInfo("降到了萨科技的萨克来得及奥斯卡了大街上");
        tiBean4.setTi("设置xm1布局文件中的字体大小一般用什么单位");
        tiBean4.setDaan(new String[]{"A.dp", "B. px", "C.sp", "D. Content pt"});
        tiBean4.setDui(3);
        ti.add(tiBean4);
        TiBean tiBean5 = new TiBean();
        tiBean5.setId(5);
        tiBean5.setInfo("降到了萨科技的萨克来得及奥斯卡了大街上");
        tiBean5.setTi("下面哪个选项不是Adapterv1ew的子类");
        tiBean5.setDaan(new String[]{"A.Listview", "B.Gridview", "C.Scro11v1ew", "D.Spinner"});
        tiBean5.setDui(3);
        ti.add(tiBean5);
        TiBean tiBean6 = new TiBean();
        tiBean6.setId(6);
        tiBean6.setInfo("降到了萨科技的萨克来得及奥斯卡了大街上");
        tiBean6.setTi("Activity 从可见状态变为半透明遮盖状态时，生命周期中哪个方法被调用");
        tiBean6.setDaan(new String[]{"A.onStop()", "B. onPause()", "C.onRestart()", "D. onStart()"});
        tiBean6.setDui(2);
        ti.add(tiBean6);
        TiBean tiBean7 = new TiBean();
        tiBean7.setId(7);
        tiBean7.setInfo("降到了萨科技的萨克来得及奥斯卡了大街上");
        tiBean7.setTi("对一些资源以及状态的操作保存，最好是保存在生命周期的哪个函数中进行");
        tiBean7.setDaan(new String[]{"A.onPause()", "B. onCreate()", "C.onResume()", "D. onStart()"});
        tiBean7.setDui(4);
        ti.add(tiBean7);
        TiBean tiBean8 = new TiBean();
        tiBean8.setId(1);
        tiBean8.setInfo("降到了萨科技的萨克来得及奥斯卡了大街上");
        tiBean8.setTi("Android解析xml 的方法中，将整个文件加载到内存中进行解析的是?");
        tiBean8.setDaan(new String[]{"A.SAX", "B. PULLC", "C.DOM", "D. JSON"});
        tiBean8.setDui(3);
        ti.add(tiBean8);
        TiBean tiBean9 = new TiBean();
        tiBean9.setId(9);
        tiBean9.setInfo("降到了萨科技的萨克来得及奥斯卡了大街上");
        tiBean9.setTi("使用Android系统进行拍照用到的类有");
        tiBean9.setDaan(new String[]{"A.SurfaceView", "B. SurfaceHolderc", "C.CallbackD", "D. Camera"});
        tiBean9.setDui(4);
        ti.add(tiBean9);
        TiBean tiBean10 = new TiBean();
        tiBean10.setId(10);
        tiBean10.setInfo("降到了萨科技的萨克来得及奥斯卡了大街上");
        tiBean10.setTi("在android程序中，Log.w()用于输出什么级别的日志信息?");
        tiBean10.setDaan(new String[]{"A.调试", "B. 信息", "C.警告", "D. 错误"});
        tiBean10.setDui(3);
        ti.add(tiBean10);
        TiBean tiBean11 = new TiBean();
        tiBean11.setId(11);
        tiBean11.setInfo("降到了萨科技的萨克来得及奥斯卡了大街上");
        tiBean11.setTi("给一个TextView设置红色字体，应该使用以下哪种写法? ");
        tiBean11.setDaan(new String[]{"A. setTextColor(OxfmO000);", "B.setColor(\"OxfImo000\")", "C.setTextColor(\"oxffIo000\")", "D. setColor(\"red\")"});
        tiBean11.setDui(1);
        ti.add(tiBean11);
        TiBean tiBean12 = new TiBean();
        tiBean12.setId(12);
        tiBean12.setInfo("降到了萨科技的萨克来得及奥斯卡了大街上");
        tiBean12.setTi("在Android应用程序中，图片应放在那个目录下?");
        tiBean12.setDaan(new String[]{"A.raw", "B. values", "C.layout", "D. drawable"});
        tiBean12.setDui(4);
        ti.add(tiBean12);
        TiBean tiBean13 = new TiBean();
        tiBean13.setId(13);
        tiBean13.setInfo("降到了萨科技的萨克来得及奥斯卡了大街上");
        tiBean13.setTi("Activity生命周期中，第一个需要执行的方法是什么?");
        tiBean13.setDaan(new String[]{"A.onStart", "B. onCreate", "C.onRestart", "D. onResume"});
        tiBean13.setDui(3);
        ti.add(tiBean13);
    }

    private void addTi() {

    }

    public void setQuestion(String string) {
    }

    public void setOption1(String string) {
    }

    public void setOption2(String string) {
    }

    public void setOption3(String string) {
    }

    public void setAnswerNr(int anInt) {
    }

    public String getQuestion() {
        return null;
    }

    public String getOption1() {
        return null;
    }

    public String getOption2() {
        return null;
    }

    public String getOption3() {
        return null;
    }

    public int getAnswerNr() {
        return 0;
    }
}
