public class minimumSizeSubarraySum {
    /*
    * Given an array of positive integers nums and a positive integer target, return the minimal length of a
      subarray
      whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
        Example 1:
        Input: target = 7, nums = [2,3,1,2,4,3]
        Output: 2
        Explanation: The subarray [4,3] has the minimal length under the problem constraint.
        Example 2:
        Input: target = 4, nums = [1,4,4]
        Output: 1
        Example 3:
        Input: target = 11, nums = [1,1,1,1,1,1,1,1]
        Output: 0
        Constraints:
        1 <= target <= 109
        1 <= nums.length <= 105
        1 <= nums[i] <= 104
        Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
    * */

    /*
    * public static void main(String[] args) {
        minimumSizeSubarraySum m = new minimumSizeSubarraySum();
        int[] nums1 = new int []{2,3,1,2,4,3};
        int[] nums2 = new int[]{1,4,4};
        System.out.println(m.minSubArrayLen(4, nums2));
    }
    * */
    public int minSubArrayLen(int target, int[] nums) {
        //slide - window
        int left = 0, right = 0, sum = 0, ans = Integer.MAX_VALUE;
        for ( ; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
