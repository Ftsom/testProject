package com.ldy.util;

import java.util.Random;

/**
 * Created by liudongyang on 2020/4/2
 */
public class RandomUtils {
    private static Random random = new Random();

    public static int[] getRandomIntRange(int upLimit) {
        int[] array = new int[upLimit];
        for (int i = 0; i < upLimit; i++) {
            array[i] = random.nextInt(upLimit);
        }
        return array;
    }
}
