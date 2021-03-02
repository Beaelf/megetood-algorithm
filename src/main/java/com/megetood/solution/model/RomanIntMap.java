package com.megetood.solution.model;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/02 13:32
 */
public class RomanIntMap {

    /**
     * I can be placed before V (5) and X (10) to make 4 and 9. 
     * X can be placed before L (50) and C (100) to make 40 and 90. 
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     */
    public static final Map<Character, Integer> ROMAN_INT_MAP = new HashMap<Character, Integer>();

    static {
        ROMAN_INT_MAP.put('I', 1);
        ROMAN_INT_MAP.put('V', 5);
        ROMAN_INT_MAP.put('X', 10);
        ROMAN_INT_MAP.put('L', 50);
        ROMAN_INT_MAP.put('C', 100);
        ROMAN_INT_MAP.put('D', 500);
        ROMAN_INT_MAP.put('M', 1000);
    }
}
