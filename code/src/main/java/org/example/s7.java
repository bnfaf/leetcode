package org.example;

import java.util.ArrayList;
import java.util.List;

public class s7 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0){
            int tmp = x % 10;
            if (res >214748364 || (res == 214748364 && tmp == 7) ){
                return 0;
            }
            if (res < -214748364 || (res == -214748364 && tmp < -8)){
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        s7 solution = new s7();
        System.out.println(solution.reverse(123));
    }
}
