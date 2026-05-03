import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> res = new ArrayList<>();
                    if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;

                            // Min-heap storing [sum, index_of_nums1, index_of_nums2]
                                    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

                                            // Initialize heap with pairs (nums1[i], nums2[0])
                                                    // We only need to go up to k or nums1.length
                                                            for (int i = 0; i < Math.min(nums1.length, k); i++) {
                                                                        pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
                                                                                }

                                                                                        while (k-- > 0 && !pq.isEmpty()) {
                                                                                                    int[] top = pq.poll();
                                                                                                                int i = top[1];
                                                                                                                            int j = top[2];

                                                                                                                                        // Add the current smallest pair to results
                                                                                                                                                    res.add(Arrays.asList(nums1[i], nums2[j]));

                                                                                                                                                                // If there's a next element in nums2 for the current nums1[i], add it to heap
                                                                                                                                                                            if (j + 1 < nums2.length) {
                                                                                                                                                                                            pq.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                                                                                                                                                                                                        }
                                                                                                                                                                                                                }

                                                                                                                                                                                                                        return res;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            }