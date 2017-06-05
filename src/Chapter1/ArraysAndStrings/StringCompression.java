package Chapter1.ArraysAndStrings;

/**
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {
    public static String compress(String str) {
        StringBuilder result = new StringBuilder();
        str = str + " ";
        int counter = 1;
        char tmp = str.charAt(0);
        for (int i = 1; i < str.length(); ++i) {
            if (str.charAt(i) == tmp) {
                counter++;
            } else {
                result.append(tmp);
                result.append(counter);
                tmp = str.charAt(i);
                counter = 1;
            }
        }
        if (str.length() < result.length()) return str;
        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(compress("aaaannnbbbcv"));
    }
}
