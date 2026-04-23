import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        
        // Maps email string -> first account index that used it
        Map<String, Integer> emailToIndex = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    // This email connects current account 'i' to a previous account
                    dsu.union(i, emailToIndex.get(email));
                }
            }
        }
        
        // Group all emails by their representative root index
        Map<Integer, List<String>> components = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int root = dsu.find(emailToIndex.get(email));
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }
        
        // Build the final result
        List<List<String>> result = new ArrayList<>();
        for (int root : components.keySet()) {
            List<String> emails = components.get(root);
            Collections.sort(emails);
            
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(accounts.get(root).get(0)); // Get the name
            mergedAccount.addAll(emails);
            result.add(mergedAccount);
        }
        
        return result;
    }
}

class DSU {
    int[] parent;
    public DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    public int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) parent[rootI] = rootJ;
    }
}