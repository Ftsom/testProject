package com.ldy.sortCase;

/**
 * Create by liudongyang8 on 2020/5/27
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(myAtoi(" "));
    }

    public static int myAtoi(String str) {
        char[] charTemp = str.toCharArray();
        int n = charTemp.length;
        int idx = 0;
        int result = 0;
        while (idx < n && charTemp[idx] == ' ') {
            idx++;
        }
        if(idx == n ) {
            return 0;
        }
        boolean symbol = true;
        if (charTemp[idx] == '+') {
            idx++;
        } else if (charTemp[idx] == '-') {
            symbol = false;
            idx++;
        } else if (!Character.isDigit(charTemp[idx])) {
            return 0;
        }
        while (idx < n && Character.isDigit(charTemp[idx])) {
            int current = charTemp[idx] - '0';
            if (result > (Integer.MAX_VALUE - current) / 10) {
                return symbol ? Integer.MAX_VALUE :Integer.MIN_VALUE;
            }
            result = result * 10 + current;
            idx++;
        }
        return symbol ? result : -result;
    }
}

