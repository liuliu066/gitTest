package com.study.thread;

/**
 * @author lwh
 * @date 2021/12/30 16:22
 */
public class ThreadUnsafeExample {

    private int cnt = 0;

    public void add() {
        cnt++;
    }

    public int get() {
        return cnt;
    }
}
