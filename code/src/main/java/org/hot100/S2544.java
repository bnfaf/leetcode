package org.hot100;

public class S2544 {
    public int alternateDigitSum(int n) {
        int count = 0;
        int flag = 1;
        int res = 0;
        while (n >0){
            int pre = n % 10;
            res += pre * flag;
            flag = - flag;
            count++;
            n /= 10;
        }
        if ((count &1) == 1){
            return res;
        }else{
            return -res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new S2544().alternateDigitSum(886996));
    }
}
