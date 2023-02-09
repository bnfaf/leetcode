package org.example;

/**
 * @author Administrator
 */
public class S88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cnt = nums1.length - 1;
        m -= 1;
        n -= 1;
        while (m >=0 && n >= 0){
            if (nums1[m] >= nums2[n]){
                nums1[cnt--] = nums1[m--];
            }else {
                nums1[cnt--] = nums2[n--];
            }
        }
        while (m>=0){
            nums1[cnt--] = nums1[m--];
        }
        while (n >= 0){
            nums1[cnt--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        S88 solution = new S88();
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[] {2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
    }
}
