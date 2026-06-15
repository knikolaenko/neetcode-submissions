class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 1, 3, 5, 0, 0, 0
        // 2, 4, 6

        int curr1 = m - 1;
        int curr2 = n - 1;
        while (curr1 >= 0 || curr2 >= 0) {
            if (curr1 < 0) {
                nums1[curr2] = nums2[curr2];
                curr2--;
                continue;
            }
            if (curr2 < 0) {
                nums1[curr1] = nums1[curr1];
                curr1--;
                continue;
            }
            if (nums1[curr1] > nums2[curr2]) {
                nums1[curr1 + curr2 + 1] = nums1[curr1];
                curr1--;
            } else {
                nums1[curr1 + curr2 + 1] = nums2[curr2];
                curr2--;
            }
        }
    }
}