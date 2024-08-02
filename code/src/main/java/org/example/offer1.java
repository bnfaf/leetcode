package org.example;

public class offer1 {
    public int divide(int a, int b) {
        // 1. 考虑边端极值，如-的极值转换成正时会出现误差，
        //2. 实现快速的计算，这里使用快重传
        boolean  rev = true;
        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            }
            if (b == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (a == 0) {
            return 0;
        }
        if (a>0){
            a = -a;
            rev = !rev;
        }
        if (b > 0){
            b = -b;
            rev = !rev;
        }
        int res = 0;
        while (a <= b){
            int i = 1;
            int bt = b;
            while (a<=bt){
                a -= bt;
                res += i;
                if (bt < -1000000000){
                    break;
                }
                bt += bt;
                i += i;
            }
        }
        return rev? res:-res;
    }

    public static void main(String[] args) {
        offer1 solution = new offer1();
        System.out.println(solution.divide(1100540749, -1090366779));
    }
}
