import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    static String compose(Date birth, int reg, String sex, int seq) throws Exception {

        StringBuilder embg = new StringBuilder(); // because append costs O(1)

        /*
            Getting the right format of day,month and year
         */
        long timestamp = birth.getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp);

        int year = cal.get(Calendar.YEAR);
        int yearFinal = year % 1000;

        String day = dayMonthFormat(cal.get(Calendar.DAY_OF_MONTH));
        String month = dayMonthFormat(cal.get(Calendar.MONTH));


        embg.append(day);
        embg.append(month);
        embg.append(format(yearFinal));

        String formatedSeq = format(seq);
        String formatedReq = dayMonthFormat(reg);

        embg.append(formatedReq);

        if (validateSeq(sex, formatedSeq)) {
            embg.append(formatedSeq);
        } else {
            throw new Exception();
        }

        embg.append(checksum(embg.toString()));

        return embg.toString();
    }


    static String dayMonthFormat(int i) {
        StringBuilder sb = new StringBuilder();
        if (i > 0 && i < 10) {
            sb.append(0);
            sb.append(i);
            return sb.toString();
        }
        return String.valueOf(i);
    }

    static String format(int seq) {
        StringBuilder sb = new StringBuilder();
        if (seq == 0) {
            sb.append("000");
            return sb.toString();
        }
        if (seq > 0 && seq < 10) {
            sb.append("00");
            sb.append(seq);
            return sb.toString();
        }
        if (seq >= 10 && seq < 100) {
            sb.append(0);
            sb.append(seq);
            return sb.toString();
        }
        return String.valueOf(seq);
    }


    static boolean validateSeq(String sex, String seq1) {
        int seq = Integer.parseInt(seq1);
        if (sex.equals("F") && seq > 499 && seq < 1000) {
            return true;
        } else if (sex.equals("M") && seq >= 0 && seq < 500) {
            return true;
        }

        return false;
    }

    static String returnSex(String seq1) {
        int seq = Integer.parseInt(seq1);
        if (seq > 499 && seq < 1000) {
            return "F";
        } else if (seq >= 0 && seq < 500) {
            return "M";
        }

        return "";
    }


    static int checksum(String embg) {
        char[] c = embg.toCharArray();
        int m = 11 - ((7 * (Character.getNumericValue(c[0]) + Character.getNumericValue(c[6]))
                + 6 * (Character.getNumericValue(c[1]) + Character.getNumericValue(c[7]))
                + 5 * (Character.getNumericValue(c[2]) + Character.getNumericValue(c[8]))
                + 4 * (Character.getNumericValue(c[3]) + Character.getNumericValue(c[9]))
                + 3 * (Character.getNumericValue(c[4]) + Character.getNumericValue(c[10]))
                + 2 * (Character.getNumericValue(c[5]) + Character.getNumericValue(c[11]))) % 11);
        if (m > 0 && m < 10) return m;

        return 0;
    }

    static boolean validate(String embgTest) throws Exception {
        String kk = "0101006500006";
        StringBuilder year = new StringBuilder();
        StringBuilder month = new StringBuilder();
        StringBuilder day = new StringBuilder();
        StringBuilder region = new StringBuilder();
        StringBuilder sequence = new StringBuilder();


        year.append(1); // this doesn''t matter may be 1 or 2 but ether way is not nedded because of mod
        year.append(embgTest.charAt(4));
        year.append(embgTest.charAt(5));
        year.append(embgTest.charAt(6));
        int inYear = Integer.parseInt(year.toString());

        month.append(embgTest.charAt(2));
        month.append(embgTest.charAt(3));
        int inMonth = Integer.parseInt(month.toString());

        day.append(embgTest.charAt(0));
        day.append(embgTest.charAt(1));
        int inDay = Integer.parseInt(day.toString());

        Date d = new GregorianCalendar(inYear, inMonth, inDay).getTime();

        region.append(embgTest.charAt(7));
        region.append(embgTest.charAt(8));

        sequence.append(embgTest.charAt(9));
        sequence.append(embgTest.charAt(10));
        sequence.append(embgTest.charAt(11));

        int reg = Integer.parseInt(region.toString());
        String sex = returnSex(sequence.toString());
        int seq = Integer.parseInt(sequence.toString());


        String returnedEmbg = compose(d, reg, sex, seq);
        if (returnedEmbg.equals(embgTest)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Date d = new GregorianCalendar(2006, 1, 1).getTime();
        System.out.println(compose(d, 50, "M", 000));
        System.out.println(validate("0101006500006"));
    }
}
