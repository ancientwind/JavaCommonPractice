package com.oom;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 212331901
 * @date 1/8/2020
 */
public class BasicOOM {

    private Map heap = new HashMap();

    private void generateOOM() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            heap.put(i, new byte[1024*1024]); // add 1MB to map
            try {
                TimeUnit.SECONDS.sleep(5L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BasicOOM basicOOM = new BasicOOM();
        basicOOM.generateOOM();
    }
}
