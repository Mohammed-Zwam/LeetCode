import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        /*== Basic Solution ==*/
        /*
            Arrays.sort(nums);
            int expected;
            for (expected = 0; expected <= nums.length; expected++) {
                if (expected != nums[expected]) break;
            }
            return expected;
        */

        //==========================================//
        
        /*== Math Solution ==*/
        // HINT: Summation Theory => (n * (n + 1)) / 2
        int expectedSum = (nums.length * (nums.length + 1) / 2), actualSum = 0;
        for (int i = 0; i < nums.length; i++) {
           actualSum += nums[i];
        }
        return expectedSum - actualSum; // O(1)
    }
}