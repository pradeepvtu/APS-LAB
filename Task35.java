import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task
        int[] frequencies = new int[26];
        for (char t : tasks) {
            frequencies[t - 'A']++;
        }

        // Step 2: Sort frequencies to find the maximum
        Arrays.sort(frequencies);
        int maxFreq = frequencies[25];
        
        // Step 3: Calculate the number of tasks that have the same max frequency
        int maxFreqCount = 0;
        for (int i = 25; i >= 0; i--) {
            if (frequencies[i] == maxFreq) {
                maxFreqCount++;
            } else {
                break; // Since it's sorted, we can stop early
            }
        }

        // Step 4: Formula application
        // (maxFreq - 1) is the number of "chunks" or gaps
        // (n + 1) is the size of each chunk (the task itself + the cooling period)
        // maxFreqCount is the number of tasks that fill the very last partial chunk
        int result = (maxFreq - 1) * (n + 1) + maxFreqCount;

        // Step 5: Return the maximum of result or the actual task length
        // If we have many unique tasks, the formula might be smaller than task count
        return Math.max(result, tasks.length);
    }
}
