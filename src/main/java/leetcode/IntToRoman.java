package leetcode;

import java.util.Collections;
import java.util.TreeMap;

public class IntToRoman {

    public static String intToRoman(int num) {
        TreeMap<Integer, String> values = new TreeMap<>(Collections.reverseOrder());
        values.put(1, "I");
        values.put(5, "V");
        values.put(10, "X");
        values.put(50, "L");
        values.put(100, "C");
        values.put(500, "D");
        values.put(1000, "M");
        values.put(4, "IV");
        values.put(9, "IX");
        values.put(40, "XL");
        values.put(90, "XC");
        values.put(400, "CD");
        values.put(900, "CM");

        StringBuilder result = new StringBuilder();

        while (num != 0){
            for (int key : values.keySet()){
                if (key <= num){
                    result.append(values.get(key));
                    num -= key;
                    break;
                }
            }
        }

        return result.toString();
    }

}
