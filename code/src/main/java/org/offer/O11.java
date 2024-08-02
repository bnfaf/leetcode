package org.offer;

import java.util.Map;

public class O11 {
    public int minArray(int[] numbers) {
        int n = numbers.length;
        int left = 0, right = n-1;

        while (left < right){
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]){
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            }else{
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] numbers = {3,3,1,3};
        System.out.println(new O11().minArray(numbers));
    }
}
