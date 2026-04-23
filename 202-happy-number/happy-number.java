class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        
        // Move 'slow' by 1 step and 'fast' by 2 steps
        // If there's a cycle, they will eventually meet
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        
        // If the fast pointer reached 1, it's a happy number
        return fast == 1;
    }
    
    // Helper function to calculate the sum of squares of digits
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}