package org.example;

public class s9 {
    public boolean isPalindrome(int x) {
        if (x < 0 ||(x % 10 == 0 && x!=0)){
            return false;
        }
        int res = 0;
        while (res  < x){
            int temp = x % 10;
            x /= 10;
            res = res * 10 + temp;
        }
        return x == res || x == res / 10;
    }

    public static void main(String[] args) {
        s9 solution = new s9();
        System.out.println(solution.isPalindrome(1));
    }
}
