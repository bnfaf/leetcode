package org.example;

import java.util.ArrayList;
import java.util.List;

public class S2178 {

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res =  new ArrayList<>();
        if ((finalSum & 1) == 1){
            return res;
        }
        long internal = 2;
        while (finalSum >= 0){
            if (internal > finalSum){
                res.set(res.size()-1, internal-2+finalSum);
                break;
            }
            res.add(internal);
            finalSum -= internal;
            internal += 2;
        }
        return res;
    }


    public static void main(String[] args) {
        
        System.out.println(new S2178().maximumEvenSplit(12));
    }
}
