package org.offer;

public class o14 {
    public int cuttingRope(int n) {
        int res = 1;
        for (int i = 2; i<= n / 2+1; i++){
            int count = n / i;
            res = Math.max((int)Math.pow(count, i-1) *Math.max(1,  (n - count * (i-1))), res);
            if (n - count * i != 0 && n >=(count+1) * (i-1) ){
                res = Math.max(res, (int)Math.pow(count+1, i-1) *Math.max(1,  (n - (count+1) * (i-1))));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new o14().cuttingRope(11));
    }
}
