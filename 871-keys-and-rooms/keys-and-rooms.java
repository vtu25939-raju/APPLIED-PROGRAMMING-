import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int n = rooms.size();
                    boolean[] visited = new boolean[n];
                            visited[0] = true;
                                    Queue<Integer> q = new LinkedList<>();
                                            q.offer(0);
                                                    while (!q.isEmpty()) {
                                                                int r = q.poll();
                                                                            for (int key : rooms.get(r)) {
                                                                                            if (!visited[key]) {
                                                                                                                visited[key] = true;
                                                                                                                                    q.offer(key);
                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                        }
                                                                                                                                                                                for (boolean v : visited) if (!v) return false;
                                                                                                                                                                                        return true;
                                                                                                                                                                                            }
                                                                                                                                                                                            }
                                                                                                                                                                                            