import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        
        // Start the traversal from room 0
        dfs(rooms, 0, visited);
        
        // Check if every room was visited
        for (boolean v : visited) {
            if (!v) return false;
        }
        
        return true;
    }
    
    private void dfs(List<List<Integer>> rooms, int currentRoom, boolean[] visited) {
        visited[currentRoom] = true;
        
        // Look at all keys in the current room
        for (int key : rooms.get(currentRoom)) {
            if (!visited[key]) {
                dfs(rooms, key, visited);
            }
        }
    }
}