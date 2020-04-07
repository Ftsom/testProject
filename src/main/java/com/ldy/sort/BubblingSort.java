package com.ldy.sort;

import com.ldy.util.RandomUtils;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by liudongyang on 2020/4/1
 * 冒泡排序：时间复杂度O(n*n);空间复杂度O(1)
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] array = RandomUtils.getRandomIntRange(20);
        Stream.of(array).forEach(d -> System.out.print(Arrays.toString(d) + ","));
        //外层控制循环次数
        for (int k = 0; k < array.length; k++) {
            //内循环选出剩余元素最大
            for (int p = 0; p < array.length - 1 - k; p++) {
                if (array[p] > array[p + 1]) {
                    int temp = array[p + 1];
                    array[p + 1] = array[p];
                    array[p] = temp;
                }
            }
        }
        System.out.println();
        Stream.of(array).forEach(d -> System.out.print(Arrays.toString(d) + ","));
    }
}
