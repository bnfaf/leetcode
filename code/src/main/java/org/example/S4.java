package org.example;

public class S4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int left = (n+m+1)/2, right = (n+m+2)/2;
        return (getKth(nums1, 0, n-1, nums2, 0, m-1, left) + getKth(nums1, 0, n-1, nums2, 0, m-1, right));

    }
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        int len1 = end1 - start1 + 1, len2 = end2 - start2 + 1;
        if (len1 > len2){
            return getKth(nums2, start2,  end2, nums1, start1, end1, k);
        }
        if (len1 == 0){
            return nums2[start2 + k - 1];
        }
        if (k == 1){
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2,  k / 2) - 1;
        if (nums1[i] > nums2[j]){
            return getKth(nums1, start1, end1, nums2, j+1, end2, k - (j-start2+1));
        }else {
            return getKth(nums1, i+1, end1, nums2, start2, end2, k - (i-start1+1));
        }
    }
}
