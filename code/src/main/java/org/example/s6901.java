package org.example;

public class s6901 {
    public static int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        while (mainTank>=5){
            int mod = mainTank / 5;
            int temp = mainTank % 5;
            res += (mainTank - temp) * 10;
            mainTank = temp + Math.min(additionalTank, mod);
            additionalTank -= Math.min(additionalTank, mod);
        }
        return res + mainTank * 10;
    }

    public static void main(String[] args) {
        System.out.println(distanceTraveled(5, 10));
    }
}
