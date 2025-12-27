# Missing Number – Java Solution

## Problem Description
Given an array `nums` containing `n` distinct numbers in the range `[0, n]`,
return the one number that is missing from the array.

---

## Solution 1: Sorting (Basic Solution)

### Idea
1. Sort the array.
2. Compare each index with its value.
3. The first mismatch is the missing number.

### Time & Space Complexity
- Time: O(n log n)
- Space: O(1)

### Code Snippet
```java
Arrays.sort(nums);
for (int i = 0; i <= nums.length; i++) {
    if (nums[i] != i) return i;
}
```

---

## Solution 2: Math (Summation Formula) – Best Solution

### Idea
The sum of numbers from `0` to `n` is:
```
n * (n + 1) / 2
```
Subtract the actual sum of the array from the expected sum.
The result is the missing number.

### Time & Space Complexity
- Time: O(n)
- Space: O(1)

### Code Snippet
```java
int expectedSum = nums.length * (nums.length + 1) / 2;
int actualSum = 0;

for (int num : nums) {
    actualSum += num;
}

return expectedSum - actualSum;
```

---

## Conclusion
- The math solution is more efficient.
- No sorting required.
- Uses one loop and constant space.
