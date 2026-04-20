class Solution {
    public void moveZeroes(int[] nums) {
        // Edge case: if array is null or has only one element, no need to process
        if (nums == null || nums.length <= 1) {
            return;
        }

        int lastNonZeroFoundAt = 0;

        // Iterate through the array
        for (int cur = 0; cur < nums.length; cur++) {
            // If the current element is non-zero
            if (nums[cur] != 0) {
                // Swap elements at 'cur' and 'lastNonZeroFoundAt'
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[cur];
                nums[cur] = temp;

                // Move the pointer for the next non-zero element
                lastNonZeroFoundAt++;
            }
        }
    }
}
