package com.mine.tiku;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class FenBean {
    private List<FenBean2> list = new ArrayList<>();

    public static class FenBean2 {
        private int fen;
        private long time;

        public int getFen() {
            return fen;
        }

        public void setFen(int fen) {
            this.fen = fen;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }
    }

    public List<FenBean2> getList() {
        return list;
    }

    public void setList(List<FenBean2> list) {
        this.list = list;
    }
}
