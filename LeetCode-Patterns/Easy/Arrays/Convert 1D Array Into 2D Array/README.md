# Convert 1D Array Into 2D Array

## Problem Description
Given a **0-indexed** 1D array `original` of length `m * n` and two integers `m` and `n`, construct a **2D array** with dimensions `m x n` using all the elements from `original`.

The elements from `original` should be filled into `result` in **row-major order**.

If it's impossible to construct such a 2D array, return an **empty 2D array**.

---

## Solution: Direct Index Mapping

### Idea
1. Check if `m * n` equals the length of the original array. If not, return an empty 2D array.
2. Create a 2D array with dimensions `m x n`.
3. Iterate through the original array and fill the 2D array sequentially using a single index.
4. Map the 1D index to 2D coordinates as you fill.

### Time & Space Complexity
- Time: O(m * n)
- Space: O(m * n) - for the result array

### Code Snippet
```java
public int[][] construct2DArray(int[] original, int m, int n) {
    if (m * n != original.length)
        return new int[0][0];

    int[][] result = new int[m][n];
    int idx = 0;
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++, idx++) {
            result[i][j] = original[idx];
        }
    }
    return result;
}
```

