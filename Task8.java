class Solution {
    public int firstUniqChar(String s) {
        // Since the input consists of lowercase English letters, 
        // an array of size 26 is faster than a HashMap.
        int[] count = new int[26];
        int n = s.length();
        
        // Build the frequency map
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        // Find the first character with a frequency of 1
        for (int i = 0; i < n; i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}
