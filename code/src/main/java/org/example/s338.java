package org.example;

public class s338 {
    public int[] countBits(int n){
        int[] res = new int[n+1];
        if (n == 0){
            return res;
        }
        res[1] = 1;
        int pre = 1;
        for (int i = 2; i <= n; i++) {
            if (i == 2 * pre){
                res[i] = 1;
                pre = i;
            }else{
                res[i] = res[pre] + res[i-pre];
            }
        }
        return res;
    }
}
