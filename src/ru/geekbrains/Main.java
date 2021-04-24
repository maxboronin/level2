package ru.geekbrains;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    static final int size = 1000000;
    static  final int half = size/2;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        float arr1[] = oneThreadMethod();
        System.out.println("One thread flow work time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        float arr2[] = twoThreadsMethod();
        System.out.println("Two threads flow work time: " + (System.currentTimeMillis() - start));

        if(Arrays.equals(arr1, arr2)) {
            System.out.println("Arrays content is identical");
        }else{
            System.out.println("Arrays content is not identical");
        }
    }

    public static float[] oneThreadMethod(){
        return modifyArray(getArray());
    }

    public static float[] twoThreadsMethod() throws InterruptedException {
        float arr[] = getArray();
        float part1[] = new float[half];
        float part2[] = new float[half];

        System.arraycopy(arr, 0, part1, 0, half);
        System.arraycopy(arr, half, part2, 0, half);

        Thread flow1 = new Thread(()->{
            modifyArray(part1);
        });

        Thread flow2 = new Thread(()->{
            modifyArray(part2, half);
        });

        flow1.start();
        flow2.start();

        flow1.join();
        flow2.join();

        System.arraycopy(part1, 0, arr, 0, half);
        System.arraycopy(part2, 0, arr, half, half);

        return arr;
    }


    public static float[] modifyArray(float arr[]){
        return modifyArray(arr , 0);
    }

    public static float[] modifyArray(float arr[], int offset){
        for (int i=0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + offset) / 5) * Math.cos(0.2f + (i + offset) / 5) * Math.cos(0.4f + (i + offset) / 2));
        }
        return arr;
    }

    public static float[] getArray(){
        float arr[] = new float[size];
        for (int i=0; i< size;i++){
            arr[i] = 1;
        }
        return arr;
    }
}
