package org.example;

import java.util.HashSet;
import java.util.Set;

public class s202 {
    public boolean isHappy(int n) {
        Set<Integer> res = new HashSet<Integer>();
        if (n == 1){
            return true;
        }
        res.add(n);
        int sum, key;
        while (n != 1){
            sum = 0;
            while (n > 0){
                key = n % 10;
                sum += key * key;
                n /= 10;
            }
            if (res.contains(sum)){
                return false;
            }
            res.add(sum);
            n = sum;
        }
        return true;
    }
}
