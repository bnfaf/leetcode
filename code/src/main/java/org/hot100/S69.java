package org.hot100;

public class S69 {
    public int mySqrt(int x) {
        if (x <= 1){
            return x;
        }else{
            int left = 1, right = x / 2+1;
            while (left + 1 < right){
                int mid = (left + right) / 2;
                if ((long)mid * mid > x){
                    right = mid;
                } else if ((long)mid * mid < x) {
                    left = mid;
                }else{
                    return mid;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
        System.out.println(new S69().mySqrt(2147395599));
    }
}
