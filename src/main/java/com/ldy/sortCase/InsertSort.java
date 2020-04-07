package com.ldy.sort;

import com.ldy.util.RandomUtils;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by liudongyang on 2020/4/2
 * 插入排序：时间复杂度O(n*n);空间复杂度O(1)
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = RandomUtils.getRandomIntRange(20);
        Stream.of(array).forEach(d -> System.out.print(Arrays.toString(d) + ","));
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }
            }
        }
        System.out.println();
        Stream.of(array).forEach(d -> System.out.print(Arrays.toString(d) + ","));
    }
}
