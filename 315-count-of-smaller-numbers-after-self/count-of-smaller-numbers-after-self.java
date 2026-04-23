import java.util.*;

class Solution {
    int[] count;
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        
        mergeSort(nums, indices, 0, n - 1);
        
        List<Integer> res = new ArrayList<>();
        for (int c : count) res.add(c);
        return res;
    }
    
    private void mergeSort(int[] nums, int[] indices, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, indices, left, mid);
        mergeSort(nums, indices, mid + 1, right);
        merge(nums, indices, left, mid, right);
    }
    
    private void merge(int[] nums, int[] indices, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0; // Tracks how many from the right half are smaller
        
        while (i <= mid && j <= right) {
            if (nums[indices[j]] < nums[indices[i]]) {
                // Element from right is smaller
                temp[k++] = indices[j++];
                rightCount++; 
            } else {
                // Element from left is smaller or equal
                count[indices[i]] += rightCount;
                temp[k++] = indices[i++];
            }
        }
        
        while (i <= mid) {
            count[indices[i]] += rightCount;
            temp[k++] = indices[i++];
        }
        while (j <= right) {
            temp[k++] = indices[j++];
        }
        
        System.arraycopy(temp, 0, indices, left, temp.length);
    }
}