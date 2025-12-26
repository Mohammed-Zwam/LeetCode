# Set Matrix Zeroes - LeetCode Solution

This is my Java solution for the LeetCode problem **"Set Matrix Zeroes"**.

---

## Problem Description

Given an `m x n` integer matrix, if an element is `0`, set its entire row and column to `0`.  
You must do it **in place**.

---

## Solution Approach

- I used two `HashSet` to keep track of the rows and columns that contain zeros.
- First, I loop through the matrix and record the indices of rows and columns that need to be zeroed.
- Then, I loop over these sets and set the corresponding rows and columns to zero.
- The solution is simple and easy to understand, though it uses extra space (`O(m + n)`).

---

## Key Points

- **Time Complexity:** `O(m * n)`  
- **Space Complexity:** `O(m + n)`  


---

## Java Code

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void setRowZeros(int rowIdx, int[][] matrix) {
        for (int i = 0; i < matrix[rowIdx].length; i++) {
            matrix[rowIdx][i] = 0;
        }
    }

    public static void setColZeros(int colIdx, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][colIdx] = 0;
        }
    }

    public static void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>(), cols = new HashSet<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    rows.add(r);
                    cols.add(c);
                }
            }
        }

        for (int rowIdx : rows) {
            setRowZeros(rowIdx, matrix);
        }
        for (int colIdx : cols) {
            setColZeros(colIdx, matrix);
        }
    }
}
```