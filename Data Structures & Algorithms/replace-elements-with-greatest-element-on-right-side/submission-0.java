class Solution {
    public int[] replaceElements(int[] arr) {
        int maxSoFar = -1;
        for (int i = arr.length - 1; i>=0; i--) {
            int num = arr[i];
            arr[i] = maxSoFar;
            if (num > maxSoFar){
                maxSoFar = num;
            }
        }
        return arr;
    }
}