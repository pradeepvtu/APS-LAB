class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate the total sum of the array first
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            // RightSum is totalSum - leftSum - current element
            int rightSum = totalSum - leftSum - nums[i];
            
            // Calculate counts of elements on left and right
            int leftCount = i;
            int rightCount = n - 1 - i;
            
            // Apply the formula
            int leftTotalDiff = (leftCount * nums[i]) - leftSum;
            int rightTotalDiff = rightSum - (rightCount * nums[i]);
            
            result[i] = leftTotalDiff + rightTotalDiff;
            
            // Update leftSum for the next iteration
            leftSum += nums[i];
        }
        
        return result;
    }
}
