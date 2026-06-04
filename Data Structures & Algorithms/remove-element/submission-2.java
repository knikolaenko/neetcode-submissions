class Solution {
    public int removeElement(int[] nums, int val) {
        int lastNonVal = -1;
        for (int i = nums.length - 1; i >= 0; i--){
            if (nums[i] != val) {
                lastNonVal = i;
                break;
            }
        }
        for (int i = 0; i < lastNonVal; i++) {
            if (nums[i] == val) {
                nums[i] = nums[lastNonVal];
                nums[lastNonVal] = val;

                do {
                    lastNonVal--;
                } while (nums[lastNonVal] == val && lastNonVal > i);
            }
        }
        return lastNonVal + 1;
    }
}