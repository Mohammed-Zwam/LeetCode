import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void addDisappearedNumbers(int start, int end, List<Integer> disappearedNumbers) {
        while (start < end) {
            disappearedNumbers.add(start++);
        }
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<>();
        /* ======= BASIC SOLUTION ======= */
        /*
            int appearedNum = 1;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == appearedNum)
                    appearedNum++;
                else if (appearedNum < nums[i]) {
                    addDisappearedNumbers(appearedNum, nums[i], disappearedNumbers);
                    appearedNum = nums[i] + 1;
                }
            }
            addDisappearedNumbers(appearedNum, nums.length + 1, disappearedNumbers);
            return disappearedNumbers;
        */


        // ============================================================================================== //
        /* ======= SOLUTION BY USING HASH SET (O(n * O(hashSet contains function))) ======= */
        /*
            HashSet<Integer> hashSet = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                hashSet.add(nums[i]);
            }
            for (int num = 1; num <= nums.length; num++) {
                if (!hashSet.contains(num))
                    disappearedNumbers.add(num);
            }
            return disappearedNumbers;
        */

        // ============================================================================================== //
        /* ======= SOLUTION BY USING FREQ TECHNIQUE (O(N)) ======= */
        int [] freq = new int [nums.length + 1]; // auto initiate by 0
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]] = 1;
        }
        for(int i = 1; i <= nums.length; i++) {
            if(freq[i] == 0) disappearedNumbers.add(i);
        }
         return disappearedNumbers;
    }
}