// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSort(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    public void quickSort(List<Pair> pairs, int start, int end) {
        if (end - start <= 0) {
            return;
        }

        int pivot = pairs.get(end).key;
        
        int left = start;
        for (int right = start; right < end; right++) {
            if (pairs.get(right).key < pivot) {
                Pair temp = pairs.get(left);
                pairs.set(left, pairs.get(right));
                pairs.set(right, temp);
                left++;
            }
        }

        Pair temp = pairs.get(left);
        pairs.set(left, pairs.get(end));
        pairs.set(end, temp);

        quickSort(pairs, start, left - 1);
        quickSort(pairs, left + 1, end);
    }
}
