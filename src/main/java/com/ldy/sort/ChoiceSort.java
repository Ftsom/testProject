package com.ldy.sort;

import com.ldy.util.RandomUtils;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by liudongyang on 2020/4/2
 * 选择排序：时间复杂度O(n*n);空间复杂度O(1)
 */
public class ChoiceSort {
    public static void main(String[] args) {
        int[] array = RandomUtils.getRandomIntRange(20);
        Stream.of(array).forEach(d -> System.out.print(Arrays.toString(d) + ","));
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int index = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    min = array[j];
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = min;
            array[index] = temp;
        }
        System.out.println();
        Stream.of(array).forEach(d -> System.out.print(Arrays.toString(d) + ","));
    }
}
