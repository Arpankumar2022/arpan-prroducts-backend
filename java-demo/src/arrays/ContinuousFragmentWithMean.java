package arrays;
import java.util.HashMap;
import java.util.Map;
public class ContinuousFragmentWithMean {




        public static int countSubarraysWithMean(int[] A, int S) {
            int n = A.length;
            int targetSum, count = 0;
            int[] prefixSum = new int[n + 1];

            // Calculate prefix sums
            for (int i = 0; i < n; i++) {
                prefixSum[i + 1] = prefixSum[i] + A[i];
            }
            for (int i = 0; i < prefixSum.length; i++) {
                System.out.println(prefixSum[i]);
            }


            // Map to store the frequency of prefix sums
            Map<Integer, Integer> prefixSumCount = new HashMap<>();

            // Initialize with the prefix sum at -1 index to handle subarrays starting from index 0
            prefixSumCount.put(0, 1);

            // Iterate through the prefix sum array
            for (int i = 1; i <= n; i++) {
                // Calculate the target sum for the current subarray
                targetSum = prefixSum[i] - S * i;

                // Check if this target sum has been seen before
                count += prefixSumCount.getOrDefault(targetSum, 0);

                // Update the map with the current prefix sum
                prefixSumCount.put(prefixSum[i], prefixSumCount.getOrDefault(prefixSum[i], 0) + 1);
            }

            return count;
        }

        public static void main(String[] args) {
            int[] A = {1, 2, 3, 4, 5};
            int S = 3;
            System.out.println(countSubarraysWithMean(A, S));  // Output: 2
        }


}
