package com.megetood.solution.interview.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/21 9:36
 */
public class LetterCombinations {
    private String[] letterMap = {
            " ",    // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null||digits.isEmpty()) {
            return res;
        }
        findCombinations(digits.toCharArray(), 0, "");
        return res;
    }

    private void findCombinations(char[] digits, int index, String s) {
        if (index == digits.length) {
            res.add(s);
            return;
        }
        char c = digits[index];
        if (c == '1' || c < '0' || c > '9') {
            return;
        }
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombinations(digits, index + 1, s + letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        String input = "23";
        List<String> res = new LetterCombinations().letterCombinations(input);
        System.out.println(res.toString());
    }
}
