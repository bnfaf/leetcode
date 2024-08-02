package org.hot100;

public class S440 {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k>0){
            int step = getStep(curr, n);
            if (step <= k){
                k-=step;
                curr++;
            }else{
                curr*=10;
                k--;
            }
        }
        return curr;
    }
    public int getStep(int curr, long n){
        int step = 0;
        long first = curr, last = curr;
        while (first <= n){
            step += Math.min(n, last) - first +1;
            first *= 10;
            last = last * 10 + 9;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new S440().findKthNumber(13, 2));
    }
}
