package org.example;

public class s50 {
    double[] res;
    public double myPow(double x, int n) {
        int flag = n < 0?-1:1;
        n = Math.abs(n);
        res = new double[n+1];
        res[0]= 1;
        res[1] = x;
        double res = count(x, n);
        return flag < 0 ? 1/res : res;
    }
    public double count(double x, int n){
        if (res[n] - 0 >1e-5){
            return res[n];
        }else{
            int mid = n / 2;
            return count(x, mid) * count(x, mid) * count(x, n - mid*2);
        }
    }
}
