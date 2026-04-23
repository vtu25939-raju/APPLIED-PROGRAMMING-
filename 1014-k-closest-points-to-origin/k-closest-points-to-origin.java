import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max Heap: sort by distance descending so the largest is at the top
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );
        
        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the point that is furthest away
            }
        }
        
        int[][] res = new int[k][2];
        while (k > 0) {
            res[--k] = maxHeap.poll();
        }
        return res;
    }
}