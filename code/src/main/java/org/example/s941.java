package org.example;

public class s941 {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        // 双指针
        int left = 0;
        int right = arr.length - 1;
        // 注意防止指针越界
        while (left + 1 < arr.length && arr[left] < arr[left + 1]) {
            left++;
        }
        // 注意防止指针越界
        while (right > 0 && arr[right] < arr[right - 1]) {
            right--;
        }
        // 如果left或者right都在起始位置，说明不是山峰
        if (left == right && left != 0 && right != arr.length - 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        s941 solution = new s941();
        int[] arr = new int[] {4,4,3,2,1};
        System.out.println(solution.validMountainArray(arr));
    }
}
