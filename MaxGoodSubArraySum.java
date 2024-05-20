public class MaxGoodSubArraySum {
    public long maximumSubarraySum(int[] nums, int k) {

        long maxSum = 0; // Initialize the max sum as 0, which will also handle the case where no good subarray is found
        boolean foundGoodSubarray = false;

        for (int i = 0; i < nums.length; i++) {
            long currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j]; // Sum the current subarray
                if (Math.abs(nums[i] - nums[j]) == k) { // Check if the subarray is good
                    foundGoodSubarray = true;
                    maxSum = Math.max(maxSum, currentSum); // Update the max sum if this subarray is better
                }
            }
        }

        return foundGoodSubarray ? maxSum : 0; // Return 0 if no good subarray was found
    }

    public static void main(String[] args) {
        MaxGoodSubArraySum solution = new MaxGoodSubArraySum();
        int[] nums = {1, -2, 3, 4, -5, 6};
        int k = 5;
        System.out.println(solution.maximumSubarraySum(nums, k)); // Example usage
    }
}
