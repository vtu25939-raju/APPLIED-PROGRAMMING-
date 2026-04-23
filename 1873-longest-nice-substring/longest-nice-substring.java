import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        
        Set<Character> chars = new HashSet<>();
        for (char c : s.toCharArray()) chars.add(c);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If both upper and lower versions exist, this char is "fine" for now
            if (chars.contains(Character.toUpperCase(c)) && chars.contains(Character.toLowerCase(c))) {
                continue;
            }
            
            // If we reach here, s.charAt(i) is a "bad" character. 
            // Split the string and check both sides.
            String s1 = longestNiceSubstring(s.substring(0, i));
            String s2 = longestNiceSubstring(s.substring(i + 1));
            
            return s1.length() >= s2.length() ? s1 : s2;
        }
        
        // If the loop finishes, the entire string is nice!
        return s;
    }
}