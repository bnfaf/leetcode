package org.example;

public class offer72 {
    public int mySqrt(int x) {
        if (x <= 1){
            return x;
        }
        int left = 2, right = x / 2;
        while (left <= right){
            int mid = (left + right) / 2;
            if ((long) mid * mid <(long)x){
                left = mid + 1;
            } else if ((long) mid * mid > (long)x) {
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        offer72 solution = new offer72();
        System.out.println(solution.mySqrt(2147395599));
    }
}
