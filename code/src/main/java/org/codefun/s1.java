package org.codefun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class s1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int[] nums = new int[s.length];
        int[] sum = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int maxValue = in.nextInt();
        Arrays.sort(nums);
        for (int i = 0; i < s.length; i++) {
            if (i == 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
        if (sum[sum.length-1] <= maxValue){
            System.out.println(-1);
            return;
        }

        int num = 0;
        int index = 0;
        while (index < s.length) {
            if (sum[index] + nums[index] * (s.length - 1 - index) <= maxValue) {

                index++;
            } else {
                break;
            }
        }

       int left = nums[index-1], right = nums[index];
        while (left < right){
            int mid = (left + right) >>1;
            int target = sum[index-1] + mid * (s.length-index);
            if (target < maxValue){
                left = mid+1;
            }else if (target > maxValue){
                right = mid-1;
            }else{
                System.out.println(mid);
                break;
            }
        }
        System.out.println(left-1);

    }
}
