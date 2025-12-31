import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Solution [1]
        // Set<Integer> s = new HashSet<>();
        // for (int num : nums) {
        //     s.add(num);
        // }
        // return !(s.size() == nums.length);
        /*============================================================*/
        // Solution [2]
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int num : nums) {
        //     if (map.getOrDefault(num, 0) != 0) return true;
        //     map.put(num, 1);
        // }
        // return false;
        /*============================================================*/
        // Solution [3]
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length - 1; i++) {
        //     if(nums[i] == nums[i + 1]) return true;
        // }
        // return false;
        /*============================================================*/
        // Solution [4] 
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if(!s.add(num)) return true;
        }
        return false;
    }
}