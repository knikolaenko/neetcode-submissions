class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> sCounts = new HashMap<Character, Integer>(s.length());
        for (int i = 0; i< s.length(); i++){
            char iChar = s.charAt(i);
            if (!sCounts.containsKey(iChar)){
                sCounts.put(iChar, 1);
            } else {
                sCounts.put(iChar, sCounts.get(iChar) + 1);
            }
        }
        HashMap<Character, Integer> tCounts = new HashMap<Character, Integer>(t.length());
        for (int i = 0; i< t.length(); i++){
            char iChar = t.charAt(i);
            if (!tCounts.containsKey(iChar)){
                tCounts.put(iChar, 1);
            } else {
                tCounts.put(iChar, tCounts.get(iChar) + 1);
            }
        }
        return sCounts.equals(tCounts);
    }
}
