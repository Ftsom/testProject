package com.ldy.sortCase;

/**
 * Create by liudongyang8 on 2020/5/29
 */
public class IntHuiwen {
    public static void main(String[] args) {
        int a = 12221;
        System.out.println(isPalindrome(a));
    }

    public static boolean isPalindrome(int x) {
//        int div = 1;
//        while (x / div >= 10) {
//            div *= 10;
//        }
//        while (x > 0) {
//            int left = x / div;
//            int right = x % 10;
//            if (left != right) {
//                return false;
//            }
//            x = (x % div) / 10;
//            div /= 100;
//        }
//        return true;

        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return reverseNum == x || reverseNum / 10 == x;
    }
}
