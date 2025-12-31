# Contains Duplicate

## Problem Description
Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

---

## Solution 1: HashSet with Size Comparison

### Idea
1. Create a HashSet to store unique elements.
2. Add all elements from the array to the set.
3. If the set size is less than the array length, there must be duplicates.
4. Return true if duplicates exist, false otherwise.

### Time & Space Complexity
- Time: O(n)
- Space: O(n)

### Code Snippet
```java
Set<Integer> s = new HashSet<>();
for (int num : nums) {
    s.add(num);
}
return !(s.size() == nums.length);
```

---

## Solution 2: HashMap Frequency Check

### Idea
1. Use a HashMap to track the frequency of each element.
2. If an element has been seen before (frequency > 0), a duplicate exists.
3. Return true immediately upon finding the first duplicate.
4. Otherwise, return false.

### Time & Space Complexity
- Time: O(n)
- Space: O(n)

### Code Snippet
```java
HashMap<Integer, Integer> map = new HashMap<>();
for (int num : nums) {
    if (map.getOrDefault(num, 0) != 0) return true;
    map.put(num, 1);
}
return false;
```

---

## Solution 3: Sorting with Adjacent Comparison

### Idea
1. Sort the entire array.
2. After sorting, duplicate elements will be adjacent.
3. Compare each element with the next one.
4. If any two adjacent elements are equal, return true.

### Time & Space Complexity
- Time: O(n log n)
- Space: O(1)

### Code Snippet
```java
Arrays.sort(nums);
for (int i = 0; i < nums.length - 1; i++) {
    if(nums[i] == nums[i + 1]) return true;
}
return false;
```

---

## Solution 4: HashSet with add() Return Value – Best Solution

### Idea
1. Use a HashSet to track seen elements.
2. The `add()` method returns `false` if the element already exists in the set.
3. If `add()` returns false, a duplicate has been found.
4. Return true immediately upon finding the first duplicate.

### Time & Space Complexity
- Time: O(n)
- Space: O(n)

### Code Snippet
```java
Set<Integer> s = new HashSet<>();
for (int num : nums) {
    if(!s.add(num)) return true;
}
return false;
```

