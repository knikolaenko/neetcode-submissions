class Solution {
    public void sortColors(int[] nums) {
        int[] aux = new int[]{0, 0, 0};

        for (int i = 0; i < nums.length; i++) {
            aux[nums[i]]++;
        }

        int currentIdx = 0;
        for (int color = 0; color < 3; color++) {
            for (int i = 0; i < aux[color]; i++) {
                nums[currentIdx] = color;
                currentIdx ++;
            }
        }
    }
}