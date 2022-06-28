import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
    /**
     * This is a recursive function to compute the permutations of a string.
     * Given a string, it traverses through the string and compiles it again with the character added to the permutation
     * This is a very time-consuming function (ideally O(n!))
     *
     * @param str String to be considered
     * @param ans String being created in recursive function (default "")
     * @param arr Array to add permutations to
     * @return
     */
    static ArrayList<String> compile(String str, String ans, ArrayList<String> arr)
    {
        if (str.length() == 0) arr.add(ans);

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            arr = compile(ros, ans + ch, arr);
        }

        return arr;
    }

    /**
     * Using the same function given above, we compile all permutations of s1 into a variable list.
     * Then we traverse through this list (which has n! elements) and check if s2 matches any of them.
     * @param s1 First string
     * @param s2 Second string
     * @return If s1 and s2 are anagrams of one another
     */
    public static boolean m1(String s1, String s2) {
        ArrayList<String> list = compile(s1, "", new ArrayList<>());
        for(String s: list) {
            if(s.equals(s2)) return true;
        }
        return false;
    }

    /**
     * O(N^2) Solution
     *
     * This solution checks through every element in s1 and finds if the corresponding element in s2 exists.
     * To avoid repetitions, it marks through the string as elements are found.
     *
     * @param s1 First string
     * @param s2 Second string
     * @return If s1 and s2 are anagrams of one another
     */
    public static boolean m2(String s1, String s2) {
        // Corner Case
        if(s1.length() != s2.length()) return false;

        // Array to store whether any value in s2 has been checked
        boolean[] checked = new boolean[s1.length()];

        for(int i = 0; i < s1.length(); i++) {
            // Mapping success if found and broken out
            boolean success = false;
            for(int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j) & !checked[j]) {
                    success = true;
                    checked[j] = true;
                    break;
                }
            }
            if(!success) return false;
        }
        return true;
    }

    /**
     * O(N log N) Solution
     * This is a very strange solution, but it does work so that's all that matters.
     * Basically, we sort the strings (when converted to char arrays), which is O(n log n) in time.
     * Then we compare them.
     * @param s1 First string
     * @param s2 Second string
     * @return If s1 and s2 are anagrams of one another
     */
    public static boolean m3(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();

        // O(n log n) for both (assuming same length n)
        Arrays.sort(c1);
        Arrays.sort(c2);

        return (new String(c1)).equals(new String(c2));
    }

    /**
     * The O(N) Solution
     * This is literally just a representation of the "use HashMap for everything" meme
     * We utilise these data structures to store the positions and values of the different characters in the strings
     * We then use equals to test if they're the same
     * These are all O(N)
     * Even the equals: https://stackoverflow.com/questions/18841098/complexity-of-equals-in-hashmap-and-sortedmap)
     *
     * @param s1 First string
     * @param s2 Second string
     * @return If s1 and s2 are anagrams of one another
     */
    public static boolean m4(String s1, String s2) {
        HashMap<Character, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        // O(n) for each of the below statements
        for(char c: s1.toCharArray()) m1.put(c, m1.getOrDefault(c, 0)+1);
        for(char c: s2.toCharArray()) m2.put(c, m2.getOrDefault(c, 0)+1);
        return m1.equals(m2);
    }


    public static void main(String[] args) {
        String s1 = "algorithms", s2 = "olsagrimth";
        long startTime, stopTime;
        boolean result;
        System.out.println(s1 + " to " + s2);

        // Bruteforce Testing
        startTime = System.nanoTime();
        result = m1(s1, s2);
        stopTime = System.nanoTime();
        System.out.println("Bruteforcing to get "+ result + " took "+ (stopTime-startTime) + " nanoseconds");

        // O(N^2) Testing
        startTime = System.nanoTime();
        result = m2(s1, s2);
        stopTime = System.nanoTime();
        System.out.println("O(N^2) to get "+ result + " took "+ (stopTime-startTime) + " nanoseconds");

        // O(NlogN) Testing
        startTime = System.nanoTime();
        result = m3(s1, s2);
        stopTime = System.nanoTime();
        System.out.println("O(NlogN) to get "+ result + " took "+ (stopTime-startTime) + " nanoseconds");

        // O(N) Testing
        startTime = System.nanoTime();
        result = m4(s1, s2);
        stopTime = System.nanoTime();
        System.out.println("O(N) to get "+ result + " took "+ (stopTime-startTime) + " nanoseconds");

        s1 = "iamastudentatnushighschoolandilikegamesandcswithmrlimbecausemathandcsarefun";
        s2 = "idltemunfsaosaaciecalcmmksdbmhrdrhieoainsauathgesnmutaeasncdnhgielswntiuath";
        System.out.println(s1 + " to " + s2);

        // O(N^2) Testing
        startTime = System.nanoTime();
        result = m2(s1, s2);
        stopTime = System.nanoTime();
        System.out.println("O(N^2) to get "+ result + " took "+ (stopTime-startTime) + " nanoseconds");

        // O(NlogN) Testing
        startTime = System.nanoTime();
        result = m3(s1, s2);
        stopTime = System.nanoTime();
        System.out.println("O(NlogN) to get "+ result + " took "+ (stopTime-startTime) + " nanoseconds");

        // O(N) Testing
        startTime = System.nanoTime();
        result = m4(s1, s2);
        stopTime = System.nanoTime();
        System.out.println("O(N) to get "+ result + " took "+ (stopTime-startTime) + " nanoseconds");
    }
}
