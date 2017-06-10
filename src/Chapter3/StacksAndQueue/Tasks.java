package Chapter3.StacksAndQueue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 * https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
 */
public class Tasks {
    public static double round(double value, int decimals) {
        if (decimals < 0) return value;
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(decimals, RoundingMode.HALF_UP); //HALF_UP is the rounding mode "commonly taught at school"
        return bd.doubleValue();
    }

    static String compose(Date birth, int reg, String sex, int seq) {
        System.out.println(birth.getDay());
        return null;
    }

    static boolean validate(String embg) {
        embg = "abcdefghijklm";
        char[] c = embg.toCharArray();
        int m = 11 - ((7 * (Character.getNumericValue(c[0]) + Character.getNumericValue(c[6])) + 6 * (Character.getNumericValue(c[1]) + Character.getNumericValue(c[7]))
                + 5 * (Character.getNumericValue(c[3]) + Character.getNumericValue(c[8])) + 4 * (Character.getNumericValue(c[3]) + Character.getNumericValue(c[9]))
                + 3 * (Character.getNumericValue(c[4]) + Character.getNumericValue(c[10])) + 2 * (Character.getNumericValue(c[5]) + Character.getNumericValue(c[10]))) % 11);
        int real = Character.getNumericValue(c[12]);
        return m == real;
    }

    public static void main(String[] args) {
        Date d = new Date();
        compose(d,1,"F",1);
    }
}
