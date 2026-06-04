class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxNumOfConsecutiveOnes = 0;
        int currNumOfConsecutiveOnes = 0;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == 1) {
                currNumOfConsecutiveOnes++;
            } else {
                if (maxNumOfConsecutiveOnes < currNumOfConsecutiveOnes) {
                    maxNumOfConsecutiveOnes = currNumOfConsecutiveOnes;
                }
                currNumOfConsecutiveOnes = 0;
            }
        }
        if (maxNumOfConsecutiveOnes < currNumOfConsecutiveOnes) {
            maxNumOfConsecutiveOnes = currNumOfConsecutiveOnes;
        }
        return maxNumOfConsecutiveOnes;
    }
}