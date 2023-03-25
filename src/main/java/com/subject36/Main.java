package com.subject36;

import java.util.HashMap;


public class Main {
    public static void twoSum(Integer target, Integer[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] == target - arr[i]) {
                map.put(i, i + 1);
            }
        }
        System.out.println(map);
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        Integer[] arr = {1,8,7,2,3};
        twoSum(1, arr);









    }
}
