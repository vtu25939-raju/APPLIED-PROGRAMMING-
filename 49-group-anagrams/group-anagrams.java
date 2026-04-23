import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        // Map: Sorted string (Key) -> List of original anagrams (Value)
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Convert to char array, sort it, and convert back to string
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            
            // If the key isn't in the map, add a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // Add the original string to the corresponding anagram group
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}