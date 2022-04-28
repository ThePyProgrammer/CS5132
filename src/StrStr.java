import java.util.HashSet;

public class StrStr {

    public int strStr(String haystack, String needle) {
        for(int i = 0; i <=haystack.length()-needle.length(); i++) {
            if(haystack.substring(i, i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        StrStr soln = new StrStr();
        System.out.println(soln.strStr("hell", "ll"));
        System.out.println(soln.strStr("aaaaa", "bba"));
    }
}
