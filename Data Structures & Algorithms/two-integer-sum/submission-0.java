class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexByNumber = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (indexByNumber.containsKey(target - num)) {
                return new int[]{indexByNumber.get(target - num), i};
            }
            indexByNumber.put(num, i);
        }
        return null;
    }
}
