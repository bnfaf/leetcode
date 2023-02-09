package org.example;

public class S69 {
    public int mySqrt(int x) {
        if (x <= 1){
            return x;
        } else if (x < 4) {
            return 1;
        }else {
            int left = 2, right = x/2, mid;
            while (right - left > 1){
                mid = (left + right) / 2;
                if (mid < x/mid){
                    left = mid;
                } else if (mid > x/mid) {
                    right = mid;
                } else {
                    return mid;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
        S69 solution = new S69();
        System.out.println(solution.mySqrt(10));;
    }
}
