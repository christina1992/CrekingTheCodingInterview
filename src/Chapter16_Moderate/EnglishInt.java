package Chapter16_Moderate;

import java.util.LinkedList;

/**
 * English tnt: Given any integer, print an English phrase that describes the integer (e.g ., "One
 * Thousand, Two Hundred Thirty Four").
 */
public class EnglishInt {
    String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven"
            , "Twelve", "Thirteen", "Fourteenu"
            , "Fifteenu"
            , "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"};
    String[] bigs = {"", "Thousand", "Million", "Billion"};
    String hundred = "Hundred" ;
    String negative = "Negative" ;

    String convert(int num) {
        if (num == 0) {
            return smalls[0];
        } else if (num < 0) {
            return negative + " " + convert(-1 * num);
        }

        LinkedList<String> parts = new LinkedList<>();
        int chunkCount = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                String chunk = convertChunk(num % 1000) + " " + bigs[chunkCount];
                parts.addFirst(chunk);
            }
            num /= 1000; // shift chunk
            chunkCount++;
        }
        return listToString(parts);
    }

    public String convertChunk(int number) {
        LinkedList<String> parts = new LinkedList<>();
        //Convert hundreds place
        if (number >= 100) {
            parts.addLast(smalls[number / 100]);
            parts.addLast(hundred);
            number %= 100;
        }
        //Convert tens place
        if (number >= 1 && number <= 9) {
            parts.addLast(smalls[number]);
        }
        return listToString(parts);
    }

    private String listToString(LinkedList<String> parts) {
        StringBuilder sb = new StringBuilder();
        while (parts.size() > 1) {
            sb.append(parts.pop());
            sb.append("");
        }
        sb.append(parts.pop());
        return sb.toString();
    }
}
