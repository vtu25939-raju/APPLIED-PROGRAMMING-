import java.util.*;

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // 1. Assign unique group IDs to items without a group
        int groupId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = groupId++;
            }
        }

        // 2. Initialize graphs and in-degrees
        List<List<Integer>> itemAdj = new ArrayList<>();
        List<List<Integer>> groupAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) itemAdj.add(new ArrayList<>());
        for (int i = 0; i < groupId; i++) groupAdj.add(new ArrayList<>());

        int[] itemInDegree = new int[n];
        int[] groupInDegree = new int[groupId];

        // 3. Fill graphs and in-degrees
        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {
                itemAdj.get(prev).add(i);
                itemInDegree[i]++;
                
                if (group[i] != group[prev]) {
                    groupAdj.get(group[prev]).add(group[i]);
                    groupInDegree[group[i]]++;
                }
            }
        }

        // 4. Perform Topological Sorts
        List<Integer> itemOrder = topoSort(itemAdj, itemInDegree, n);
        List<Integer> groupOrder = topoSort(groupAdj, groupInDegree, groupId);

        if (itemOrder.isEmpty() || groupOrder.isEmpty()) return new int[0];

        // 5. Group items by their group ID
        Map<Integer, List<Integer>> groupToItems = new HashMap<>();
        for (int item : itemOrder) {
            groupToItems.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

        // 6. Concatenate items based on the sorted group order
        int[] result = new int[n];
        int idx = 0;
        for (int g : groupOrder) {
            List<Integer> items = groupToItems.getOrDefault(g, new ArrayList<>());
            for (int item : items) {
                result[idx++] = item;
            }
        }

        return idx == n ? result : new int[0];
    }

    private List<Integer> topoSort(List<List<Integer>> adj, int[] inDegree, int count) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            for (int neighbor : adj.get(curr)) {
                if (--inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }
        return result.size() == count ? result : new ArrayList<>();
    }
}