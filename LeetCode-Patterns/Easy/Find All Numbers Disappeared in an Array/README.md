# Find All Numbers Disappeared in an Array

## Problem Description
Given an array `nums` of `n` integers where `nums[i]` is in the range `[1, n]`,
return an array of all the integers in the range `[1, n]` that do not appear in `nums`.

---

## Solution 1: Sorting (Basic Solution)

### Idea
1. Sort the array.
2. Sweep through the sorted array while tracking the expected value from `1` to `n`.
3. Whenever the expected value is missing (or skipped due to duplicates), record it.

### Time & Space Complexity
- Time: O(n log n)
- Space: O(1) (if sorting in-place) or O(n) depending on the sort implementation

### Code Snippet
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

int appeared = 1;
Arrays.sort(nums);
List<Integer> disappeared = new ArrayList<>();
for (int i = 0; i < nums.length && appeared <= nums.length; i++) {
	if (nums[i] == appeared) {
		appeared++;
	} else if (nums[i] > appeared) {
		while (appeared < nums[i]) {
			disappeared.add(appeared++);
		}
		if (nums[i] == appeared) appeared++;
	}
}
while (appeared <= nums.length) disappeared.add(appeared++);
```

---

## Solution 2: Hash Set

### Idea
Use a `HashSet` to record which numbers appear, then iterate `1`..`n` and collect those not present.

### Time & Space Complexity
- Time: O(n) on average (depends on hash operations)
- Space: O(n)

### Code Snippet
```java
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

HashSet<Integer> seen = new HashSet<>();
for (int num : nums) seen.add(num);
List<Integer> disappeared = new ArrayList<>();
for (int i = 1; i <= nums.length; i++) {
	if (!seen.contains(i)) disappeared.add(i);
}
```

---

## Solution 3: Frequency / Index Marking

### Idea
Two common O(n) approaches:
- Use an auxiliary frequency array of size `n+1` and mark present numbers.
- Or mark presence in-place by negating the value at index `abs(nums[i]) - 1` (index-marking trick), which uses constant extra space.

### Time & Space Complexity
- Time: O(n)
- Space: O(n)

### Code Snippet (frequency array — matches the provided solution)
```java
import java.util.ArrayList;
import java.util.List;

public List<Integer> findDisappearedNumbers(int[] nums) {
	List<Integer> disappearedNumbers = new ArrayList<>();
	int[] freq = new int[nums.length + 1]; // default 0
	for (int i = 0; i < nums.length; i++) {
		freq[nums[i]] = 1;
	}
	for (int i = 1; i <= nums.length; i++) {
		if (freq[i] == 0) disappearedNumbers.add(i);
	}
	return disappearedNumbers;
}
```

### Code Snippet (in-place index marking — constant extra space)
```java
public List<Integer> findDisappearedNumbers(int[] nums) {
	List<Integer> res = new ArrayList<>();
	for (int i = 0; i < nums.length; i++) {
		int idx = Math.abs(nums[i]) - 1;
		if (nums[idx] > 0) nums[idx] = -nums[idx];
	}
	for (int i = 0; i < nums.length; i++) {
		if (nums[i] > 0) res.add(i + 1);
	}
	return res;
}
```

---

## Conclusion
- The index-marking (in-place) approach is the most space-efficient O(n) time.
- Frequency or HashSet approaches are straightforward and easy to reason about.
- Sorting works but is slower due to O(n log n) time and can be more complex when duplicates exist.
