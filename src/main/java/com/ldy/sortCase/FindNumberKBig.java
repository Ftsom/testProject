package com.ldy.sortCase;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Create by liudongyang8 on 2020/5/28
 */
public class FindNumberKBig {
    public static void main(String[] args) {
        int[] arrayTest = new int[]{1,3,4,6,5,8,9};
        int k = 3;
        PriorityQueue<Integer> queen = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for(int numTemp:arrayTest) {
            queen.add(numTemp);
            if(queen.size() > k) {
                queen.poll();
            }
        }
        System.out.println(queen.poll());
    }
}
