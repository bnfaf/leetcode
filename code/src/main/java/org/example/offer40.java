package org.example;

import java.util.PriorityQueue;
import java.util.Random;

public class offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
//        PriorityQueue<Integer> que = new PriorityQueue<Integer>((a, b) ->{
//            return a-b;
//        });
//        for (int i = 0; i < arr.length; i++) {
//            que.add(arr[i]);
//        }
//        int[] nums = new int[k];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = que.poll();
//        }
//        return nums;
        randomizedSelected(arr, 0, arr.length-1, k);
        int[] nums = new int[k];
        for (int i = 0; i < k; i++){
            nums[i] = arr[i];
        }
        return nums;
    }
    private void randomizedSelected(int[] arr, int l, int r, int k){
        if (l>=r){
            return;
        }
        int pos = randomPartition(arr, l, r);
        int num = pos - l +1;
        if (num == k){
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos-1, k);
        }else{
            randomizedSelected(arr, pos+1, r, k-num);
        }
    }
    private int randomPartition(int[] arr, int l, int r){
        int i = new Random().nextInt(r-l+1)+l;
        swap(arr, r, i);
        return partition(arr, l, r);
    }
    private int partition(int[] arr, int l, int r){
        int pivot = arr[r];
        int point = l;
        for (int i = l; i < r; i++) {
            if (arr[i] <= pivot){
                swap(arr, point++, i);
            }
        }
        swap(arr, point, r);
        return point;
    }
    private void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
