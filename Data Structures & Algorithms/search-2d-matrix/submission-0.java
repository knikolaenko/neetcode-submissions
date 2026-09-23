class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            int middleValue = matrix[middle / n][middle % n];

            if (middleValue > target) {
                end = middle - 1;
            } else if (middleValue < target) {
                start = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
