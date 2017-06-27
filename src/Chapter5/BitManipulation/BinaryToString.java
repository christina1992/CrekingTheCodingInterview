package Chapter5.BitManipulation;

/**
 * Created by hnastevska on 6/26/2017.
 */
public class BinaryToString {
    static String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (num > 0) {
            //Setting a limit on length: 32 characters
            if (binary.length() >= 32) {
                return "Error";
            }
            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        System.out.println( printBinary(0.72));
    }
}
