package org.example;

public class s440 {
    public int findKthNumber(int n, int k) {
        int  curr = 1;
        k--;
        while (k > 0){
            int steps = getSteps(curr, n);
            if (steps <= k ){
                k -= steps;
                curr++;
            }else{
                curr *= 10;
                k--;
            }
        }
        return curr;
    }
    public int getSteps(int curr, long n ){
        int steps = 0;
        long first = curr, last =curr;
        while (first <= n){
            steps += Math.min(last, n) - first+1;
            first *= 10;
            last = last * 10 + 9;
        }
        return steps;
    }

    public static void main(String[] args) {
        s440 solution = new s440();
        System.out.println(solution.findKthNumber(2, 2));
    }
}
