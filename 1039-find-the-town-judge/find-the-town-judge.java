class Solution {
    public int findJudge(int n, int[][] trust) {
        // We use size n + 1 because people are labeled 1 to n
        int[] trustScores = new int[n + 1];
        
        for (int[] relation : trust) {
            int reacher = relation[0];
            int trusted = relation[1];
            
            // The person who trusts loses a point (cannot be judge)
            trustScores[reacher]--;
            // The person being trusted gains a point
            trustScores[trusted]++;
        }
        
        for (int i = 1; i <= n; i++) {
            // The judge must have been trusted by n-1 people 
            // and trusted 0 people (Score: (n-1) - 0)
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}