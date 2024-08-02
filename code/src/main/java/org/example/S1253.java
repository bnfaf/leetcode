package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class S1253 {
    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (upper + lower != Arrays.stream(colsum).sum()){
            return ans;
        }
        for (int i = 0; i < n; i++) {
            if (upper > 0 && colsum[i]== 2){
                temp.add(1);
                colsum[i] -= 1;
                upper -= 1;
            }else{
                temp.add(0);
            }
        }
        for (int i = 0; i < n; i++) {
            if (upper > 0 && colsum[i]== 1 && temp.get(i) != 1){
                temp.set(i, 1);
                colsum[i] -= 1;
                upper -= 1;
            }
        }
        if (Arrays.stream(colsum).sum()!= lower){
            return ans;
        }
        ans.add(temp);
        ans.add(Arrays.stream(colsum).boxed().collect(Collectors.toList()));
        return ans;
    }

    public static void main(String[] args) {
        int[] colsum = {2,1,2,0,1,0,1,2,0,1};
        System.out.println(reconstructMatrix(5, 5, colsum));
    }
}
