class Solution {
    public void reverseString(char[] s) {
        // Initialize two pointers
        int left = 0;
        int right = s.length - 1;
        
        // Loop until pointers meet in the middle
        while (left < right) {
            // Temporary variable to hold the character during the swap
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            // Move pointers towards each other
            left++;
            right--;
        }
    }
}
