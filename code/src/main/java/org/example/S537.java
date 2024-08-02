package org.example;

public class S537 {

    public static String complexNumberMultiply(String num1, String num2) {
        String[] num11 = num1.split("\\+");

        String[] num12 = num2.split("\\+");

        int[] num13 = {Integer.parseInt(num11[0]), Integer.parseInt(num11[1].substring(0, num11[1].length()-1))};
        int[] num14 = {Integer.parseInt(num12[0]), Integer.parseInt(num12[1].substring(0, num12[1].length()-1))};
        int count1 = num13[0] * num14[0] - num13[1] * num14[1];
        int count2 = num13[0] * num14[1] + num13[1] * num14[0];
        StringBuilder sb = new StringBuilder();
        sb.append(count1);
        sb.append("+");
        sb.append(count2);
        sb.append("i");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
