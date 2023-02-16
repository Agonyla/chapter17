package com.hspedu.cpu;

/**
 * @Author Agony
 * @Create 2023/2/16 18:40
 * @Version 1.0
 */
public class CpuNum {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        int i = runtime.availableProcessors();
        System.out.println(i);
    }
}
