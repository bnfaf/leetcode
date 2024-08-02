package org.example;

import javax.swing.*;

public class S1997 {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int  mod = (int) 1e9+7;
        int n = nextVisit.length;
        int[] visit = new int[n];
        int count = 0;
        int now = 0;
        int times = 0;
        while (count < n){
            visit[now]++;

            if (visit[now] == 1){
                count++;
            }
            if (visit[now] % 2 == 1){
                now = nextVisit[now];
            }else{
                now = (now + 1) % n;
            }
            times %= mod;
            times++;

        }
        return times-1;
    }

    public static void main(String[] args) {
        int[] nextvisit = {0, 0};
        System.out.println(new S1997().firstDayBeenInAllRooms(nextvisit));
    }
}
