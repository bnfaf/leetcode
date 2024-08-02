package org.example;

public class s135 {
    public int candy(int[] ratings) {
        int[] cand = new int[ratings.length];
        cand[0] = 1;
        for (int i = 1;i < ratings.length; i++){
            if (ratings[i] > ratings[i-1]){
                cand[i] = cand[i-1]+1;
            }else{
                cand[i] = 1;
            }
        }
        int res = 0;
        for (int i = cand.length - 2; i >= 0; i--){
            if (ratings[i+1] < ratings[i]){
                cand[i] = Math.max(cand[i+1]+1, cand[i]);
            }
            res += cand[i];
        }
        res += cand[cand.length-1];
        return res;
    }

    public static void main(String[] args) {
        s135 solution = new s135();
        System.out.println(solution.candy(new int[]{1, 3, 4, 5, 2}));
    }

}
