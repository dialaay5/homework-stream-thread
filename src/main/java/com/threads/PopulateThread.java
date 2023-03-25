package com.threads;

import java.util.Arrays;

public class PopulateThread extends Thread{
    protected int[] arr;

    public PopulateThread(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        System.out.println(Arrays.toString(this.arr));
    }

}
