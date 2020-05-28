package com.ldy.sortCase;

/**
 * Create by liudongyang8 on 2020/5/27
 * 同余原理
 */
public class ModeByK {
    public static void main(String[] args) {
        int[] A = new int[]{4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByK(A, k));
    }

    public static int subarraysDivByK(int[] A, int K) {
//        Map<Integer, Integer> record = new HashMap<>();
//        record.put(0, 1);
        int[] record = new int[5];
        record[0] = 1;

        int sum = 0, ans = 0;
        for (int elem : A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
//            int same = record.getOrDefault(modulus, 0);
            int same = record[modulus];
            ans += same;
            record[modulus] = same + 1;
//            record.put(modulus, same + 1);
        }
        return ans;
    }
}
