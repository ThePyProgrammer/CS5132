import java.util.HashMap;

public class Roman {
    public String intToRoman(int num) {
        int[] integers = new int[]{1000, 900, 500,400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<integers.length;i++) {
            int inte = integers[i];
            String sym = romans[i];
            for(int j=0;j<num/inte;j++) sb.append(sym);
            num %= inte;
        }
        return sb.toString();
    }

    public int romanToInt(String roman) {
        roman = roman.replaceAll("CM", "6").replaceAll("CD", "5")
                .replaceAll("XC", "4").replaceAll("XL", "3")
                .replaceAll("IX", "2").replaceAll("IV", "1");

        int[] integers = new int[]{1000, 900, 500,400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        char[] romans = new char[]{'M', '6', 'D', '5', 'C', '4', 'L', '3', 'X', '2', 'V', '1', 'I'};

        HashMap<Character, Integer> lookup = new HashMap<>();
        for(int i = 0; i < integers.length; i++) lookup.put(romans[i], integers[i]);

        int num = 0;
        for(char c: roman.toCharArray()) num += lookup.get(c);

        return num;
    }

    public static void main(String[] args) {
        Roman soln = new Roman();

        System.out.println("3 : "+soln.intToRoman(3));
        System.out.println("58 : "+soln.intToRoman(58));
        System.out.println("1994 : "+soln.intToRoman(1994));


        System.out.println("III : "+soln.romanToInt("III"));
        System.out.println("LVIII : "+soln.romanToInt("LVIII"));
        System.out.println("MCMXCIV : "+soln.romanToInt("MCMXCIV"));
    }
}
