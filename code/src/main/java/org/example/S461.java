package org.example;

public class S461 {
    public int hammingDistance(int x, int y) {
//        int dis = 0;
//        while (x != 0 || y != 0){
//            int x1 = x & 1;
//            int y1 =y & 1;
//            if (x1 != y1){
//                dis++;
//            }
//            x = x >> 1;
//            y >>=1;
//        }
//        return dis;
        return Integer.bitCount(x^y);
    }

    public static void main(String[] args) {
        System.out.println(new S461().hammingDistance(1, 4));
    }
}
