package com.miaoshaproject.util;

import java.util.ArrayList;

/**
 * 复现arraylist的线程不安全的情况
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        new Thread(new Runnable(){

            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    list.add(i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1000; i < 2001; i++) {
                    list.add(i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0;i< 2001;i++) {

            System.out.println("第"+i+"的值是："+list.get(i));
        }
    }


}
