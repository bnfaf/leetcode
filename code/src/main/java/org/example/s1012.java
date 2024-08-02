package org.example;

import java.util.Arrays;

/**
 * 数位DP 模板
 * 给定正整数 n，返回在 [1, n] 范围内具有 至少 1 位 重复数字的正整数的个数
 */
public class s1012 {
    char[] s;
    int[][] memo;
    public int numDupDigitsAtMostN(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        memo = new int[m][1<<10];
        for (int i = 0; i < m; i++){
            Arrays.fill(memo[i], -1);
        }
        // 正难则反，n-不含相同数字的数字=总数
        return n - f(0, 0, true, false);
    }

    /**
     *
     * @param i  第i位
     * @param mask 已经使用过哪些数字，0-9，10位，可以进行统计
     * @param isLimit  是否进行限制，假设n=123,第一位选0，则第二位不做限制，若第1位选1，则第二位最大为2
     * @param isNum 是否为数字，这个主要阐述的是前面的是否有被选择过
     * @return 给定条件下的不含相同数字的数字总数
     */
    public int f(int i, int mask, boolean isLimit, boolean isNum){
        if (i == s.length){
            return isNum ? 1:0;
        }
        if (!isLimit && isNum && memo[i][mask] != -1){
            return memo[i][mask];
        }
        int res = 0;
        if (!isNum){
            res = f(i+1, mask, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1;d <= up; d++){
            if ((mask >> d & 1) == 0){
                res += f(i+1, mask | (1<<d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum){
            memo[i][mask] = res;
        }
        return res;
    }
}
