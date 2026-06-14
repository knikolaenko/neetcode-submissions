class Solution {
    HashMap<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int variants = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, variants);
        return variants;
    }
}

// 4 -> 3 -> 2 -> 1
// (3) + (2) 