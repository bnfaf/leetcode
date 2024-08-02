package org.example;

import java.util.ArrayList;
import java.util.List;

public class S118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new java.util.ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    temp.add(1);
                }else{
                    temp.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
