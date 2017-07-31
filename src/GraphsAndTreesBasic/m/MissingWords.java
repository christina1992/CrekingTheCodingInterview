package GraphsAndTreesBasic.m;

import java.util.*;

/**
 * Created by hnastevska on 7/23/2017.
 */
public class MissingWords {


    public static String[] missing(String s, String t) {
        String[] splitS = s.split(" ");
        String[] splitT = t.split(" ");
        String[] finalArray = new String[Math.abs(splitS.length - splitT.length)];
        for (int j = 0; j < splitS.length; j++) {
            int flag = 0;
            for (int i = 0; i < splitT.length; i++) {
                if (splitS[j].equals(splitT[i]))
                    flag = 1;
            }
            if (flag == 0) {
                finalArray[j] = splitS[j];
            }
        }
        List<String> list = new ArrayList<String>();

        for (String s1 : finalArray) {
            if (s1 != null && s1.length() > 0) {
                list.add(s1);
            }
        }
        System.out.println(list.size());
        return list.toArray(new String[list.size()]);

    }



    public static String[] missing1(String s1, String s2) {
        String[] wordss1 = s1.split(" ");
        String[] wordss2 = s2.split(" ");
        int strSize=0;
        String[] longer = wordss1.length > wordss2.length ? wordss1 : wordss2;
        String[] smaller = wordss1.length < wordss2.length ? wordss1 : wordss2;

        //Filling the hash table

        String[] finalS = new String[Math.abs(wordss1.length - wordss2.length)];
        LinkedHashMap<String, Integer> holder = new LinkedHashMap<>();
        for (int i = 0; i <longer.length ; i++) {
            if (holder.get(longer[i]) != null){
                holder.put(longer[i],holder.get(longer[i])+1);
            }else {
                holder.put(longer[i],1);
            }
        }

        // Check the words from smaller sentence

        for (int i = 0; i <smaller.length ; i++) {
            if (holder.get(smaller[i]) != null){
                holder.put(smaller[i],holder.get(smaller[i])-1);
            }
        }

        // Only add the elements with value greater then 0 to the string array
        for ( String unit : holder.keySet()){
                int value = holder.get(unit);
            if (value > 0){
                finalS[strSize] = unit;
                strSize++;
            }
        }

        return finalS;
    }

    public static void main(String[] args) {
        String[] words = missing1("am hackerrank to improve ", "I am using hackerrank to improve programming");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
