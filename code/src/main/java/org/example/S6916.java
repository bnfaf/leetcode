package org.example;

import java.util.*;

public class S6916 {
    int mx = (int) (Math.pow(10, 6)+1);
    List<Integer> primes = new ArrayList<Integer>();
    boolean[] isPrime = new boolean[mx+1];
    S6916() {
        Arrays.fill(isPrime, true);
        for (int i = 2; i < mx; i++) {
            if (isPrime[i]){
                primes.add(i);
                for (long j = (long) i *i; j < mx; j+=i) {
                    isPrime[(int) j] = false;
                }
            }
        }
    }

    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int num : primes){
            int j = n - num;
            if (j < num){
                break;
            }
            if (isPrime[j]){
                ans.add(new ArrayList<>(Arrays.asList(num, j)));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        S6916 s6916 = new S6916();
        System.out.println(s6916.findPrimePairs(10));
    }
}
