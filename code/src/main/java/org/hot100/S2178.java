package org.hot100;

import java.util.ArrayList;
import java.util.List;

public class S2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if ((finalSum & 1) == 1){
            return res;
        }
        long intern = 2;
        while (finalSum >= intern){
            finalSum -= intern;
            res.add(intern);
            intern += 2;
        }
        if (intern != 0){
            res.set(res.size()-1, intern-2+finalSum);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new S2178().maximumEvenSplit(12L));
    }
}
