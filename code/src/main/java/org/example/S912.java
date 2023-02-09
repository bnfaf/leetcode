package org.example;

import java.util.Random;

public class S912 {
    int[] tmp;
    public int[] sortArray(int[] nums) {
//        randomizedQuicksort(nums, 0, nums.length-1);
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
    public void randomizedQuicksort(int[] nums, int l, int r){
        if (l < r){
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos-1);
            randomizedQuicksort(nums, pos+1, r);
        }
    }
    public int randomizedPartition(int[] nums, int l, int r){
        int i = new Random().nextInt(r-l+1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }
    public  int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot){
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, right);
        return i+1;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void heapSort(int[] nums){
        int len = nums.length - 1;
        // 建立最大堆
        buildMaxHeap(nums, len);
        for (int i = len; i>=1;i--){
            // 将最大值放在最后
            swap(nums, i, 0);
            // 长度减1
            len -= 1;
            // 调整堆，
            maxHeapify(nums, 0, len);
        }
    }
    public void buildMaxHeap(int[] nums, int len){
        for (int i = len / 2; i >= 0; --i){
            // 从底到上构建最大堆
            maxHeapify(nums, i, len);
        }
    }
    public void maxHeapify(int[] nums, int i, int len){
        for (;(i<<1) +1 < len; ){
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large;
            if (lson <= len && nums[lson] >nums[i]){
                large = lson;
            }else {
                large = i;
            }
            if (rson <= len && nums[rson] > nums[large]){
                large = rson;
            }
            if (large != i){
                swap(nums, i, large);
                i = large;
            }else {
                break;
            }
        }
    }

    public void mergeSort(int[] nums, int l, int r){
        if (l >= r){
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, l);
        int i = l, j = mid + 1, cnt = 0;
        while (i <= mid && j <= r){
            if (nums[i] <= nums[j]){
                tmp[cnt++] = nums[i++];
            }else {
                tmp[cnt++] = nums[j++];
            }
        }
        while ( i <= mid){
            tmp[cnt++] = nums[i++];
        }
        while (j <= r){
            tmp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r-l+1; k++){
            nums[k+l] = tmp[k];
        }
    }
}
