package org.hot100;

public class S860 {
    public boolean lemonadeChange(int[] bills) {
        int[] count = new int[2];
        for(int bill : bills){
            if (bill == 5){
                count[0]++;
            } else if (bill == 10) {
                if (count[0] > 0){
                    count[0]--;
                    count[1]++;
                }else{
                    return false;
                }
            }else {
                if (count[0]>0 && count[1]>0){
                    count[0]--;
                    count[1]--;
                }else if (count[0] >= 3){
                    count[0] -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        System.out.println(new S860().lemonadeChange(bills));
    }
}
