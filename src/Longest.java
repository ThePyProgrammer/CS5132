import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class Longest {
    public HashSet<Character> slowLengthOfLongestSubstring(String s, HashSet<Character> hashset) {
        if(s.length() == 0 || hashset.contains(s.charAt(0))) return hashset;
        HashSet<Character> copy = new HashSet<>(hashset);
        copy.add(s.charAt(0));
        String newString = s.substring(1);
        HashSet<Character> take = slowLengthOfLongestSubstring(newString, copy);
        if(hashset.size() == 0) {
            HashSet<Character> notake = slowLengthOfLongestSubstring(newString, hashset);
            take = notake.size() > take.size() ? notake:take;
        }
        return take;
    }

    public int slowLengthOfLongestSubstring(String s) {
        HashSet<Character> arr = slowLengthOfLongestSubstring(s, new HashSet<>());
        return arr.size();
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        ArrayList<Character> curr_window = new ArrayList<>();
        HashSet<Character> uniq_chars = new HashSet<>();
        for(int idx = 0; idx < s.length(); idx++) {
            char c = s.charAt(idx);
            if(uniq_chars.contains(c)) {
                int split_idx = 0;
                while (split_idx <= (curr_window.size() - 1)) {
                    char c2 = curr_window.get(split_idx);
                    uniq_chars.remove(c2);
                    if (c2 == c) break;
                    split_idx++;
                }
                curr_window = new ArrayList<>(curr_window.subList(split_idx+1, curr_window.size()));
            }
            curr_window.add(c);
            result = Math.max(curr_window.size(), result);
            uniq_chars.add(c);
        }
        return result;
    }

    public static void main(String[] args) {
        Longest soln = new Longest();
        System.out.println(soln.lengthOfLongestSubstring("pwwkew"));
    }
}
