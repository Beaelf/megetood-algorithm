package com.megetood.solution;

import com.megetood.solution.model.ListNode;
import com.megetood.solution.model.RomanIntMap;
import com.megetood.structure.Array;
import com.megetood.structure.SegmentTree;

import java.util.*;


/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/08/23 14:49
 */
public class Solution {
    // 括号匹配
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == '}' && topChar != '{') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == ')' && topChar != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // 整数反转
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res < Integer.MIN_VALUE || res > Integer.MAX_VALUE ? 0 : (int) res;
    }

    // 回文数 121 -121
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int target = x;
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res == target;
    }

    // 最长字符子串
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l = 0;
        int r = -1;
        int res = 0;
        while (l < s.length()) {

            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
            } else {
                freq[s.charAt(l++)]--;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    // 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int len = Math.min(prefix.length(), strs[i].length());
            int j = 0;
            for (; j < len; j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

    // 罗马数字翻译称阿拉伯数字
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0) {
                res = res + RomanIntMap.ROMAN_INT_MAP.get(c);
            } else {// ixc
                char l = s.charAt(i - 1);
                if (('V' == c || 'X' == c) && 'I' == l) {
                    int temp = RomanIntMap.ROMAN_INT_MAP.get(c) - RomanIntMap.ROMAN_INT_MAP.get(l);
                    res = res - RomanIntMap.ROMAN_INT_MAP.get(l) + temp;
                    continue;
                }
                if (('L' == c || 'C' == c) && 'X' == l) {
                    int temp = RomanIntMap.ROMAN_INT_MAP.get(c) - RomanIntMap.ROMAN_INT_MAP.get(l);
                    res = res - RomanIntMap.ROMAN_INT_MAP.get(l) + temp;
                    continue;
                }
                if (('D' == c || 'M' == c) && 'C' == l) {
                    int temp = RomanIntMap.ROMAN_INT_MAP.get(c) - RomanIntMap.ROMAN_INT_MAP.get(l);
                    res = res - RomanIntMap.ROMAN_INT_MAP.get(l) + temp;
                    continue;
                }
                res = res + RomanIntMap.ROMAN_INT_MAP.get(c);
            }
        }
        return res;
    }

    // 合并两个有序列表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    // 有序数组去重
    public int removeDuplicates(int[] nums) {
        int t = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[t]) {
                nums[++t] = nums[i];
            }
        }
        return t + 1;
    }

    // 唯一摩尔斯密码词
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i) - 'a']);
            }
            set.add(res.toString());
        }
        return set.size();
    }

    // 两个数组的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer s : list) {
            res[i++] = s;
        }
        return res;
    }

    // 两个数组的交集
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
                if (map.get(nums2[i]) == 0) {
                    map.remove(nums2[i]);
                }

            }
        }

        int[] res = new int[list.size()];
        int i = 0;
        for (Integer s : list) {
            res[i++] = s;
        }
        return res;
    }

    // 返回其中出现频率前 k 高的元素
    private class Freq implements Comparable<Freq> {
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            if (this.freq < o.freq) {
                return -1;
            } else if (this.freq > o.freq) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> queue = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > queue.peek().freq) {
                queue.remove();
                queue.add(new Freq(key, map.get(key)));
            }
        }

        int[] res = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.remove().e;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                res.append(cur.val + "->");
                cur = cur.next;
            }
            res.append("NULL");
            return res.toString();
        }
    }

    /*
        计算两数之和
        给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        sum(prev, new ListNode(0), l1, l2);
        return prev;
    }

    private void sum(ListNode prev, ListNode temp, ListNode l1, ListNode l2) {
        int y = 0;
        if (l1 != null && l2 != null) {
            y = l1.val + l2.val + temp.val;
        } else if (l1 != null && l2 == null) {
            y = l1.val + temp.val;
        } else if (l1 == null && l2 != null) {
            y = l2.val + temp.val;
        } else {
            if (temp.val > 0) {
                prev.next = new ListNode(temp.val);
            }
            return;
        }
        if (y < 10) {
            prev.next = new ListNode(y);
            temp = new ListNode(0);
            sum(prev.next, temp, l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        } else {
            prev.next = new ListNode(y % 10);
            temp = new ListNode(y / 10);
            sum(prev.next, temp, l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        }
    }

    //寻找两个正序数组的中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLengh = nums1.length + nums2.length;
        if (totalLengh % 2 == 0) {
            int midIndex1 = totalLengh / 2;
            int midIndex2 = totalLengh / 2 + 1;
            return (getKthElement(nums1, nums2, 0, 0, midIndex1) + getKthElement(nums1, nums2, 0, 0, midIndex2)) / 2.0;
        } else {
            int midIndex = totalLengh / 2 + 1;
            return getKthElement(nums1, nums2, 0, 0, midIndex);
        }
    }

    private int getKthElement(int[] nums1, int[] nums2, int index1, int index2, int k) {

        if (index1 == nums1.length) {
            return nums2[index2 + k - 1];
        }
        if (index2 == nums2.length) {
            return nums1[index1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[index1 + k - 1], nums2[index2 + k - 1]);
        }
        int half = k / 2 - 1;
        int newIndex1 = Math.min(nums1.length - 1, index1 + half);
        int newIndex2 = Math.min(nums2.length - 1, index2 + half);
        if (nums1[newIndex1] >= nums2[newIndex2]) {
            return getKthElement(nums1, nums2, index1, newIndex2 + 1, k - (newIndex2 - index2 + 1));
        } else {
            return getKthElement(nums1, nums2, newIndex1 + 1, index2, k - (newIndex1 - index1 + 1));
        }
    }

    /*
        Given an array nums, write a function to move all 0's to the end of it
        while maintaining the relative order of the non-zero elements.
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j++;
            } else {
                if (i > 0 && nums[i] != 0 && nums[i - 1] == 0) {
                    nums[i - j] = nums[i];
                    nums[i] = 0;
                }
            }
        }
        System.out.println(j);
    }

    public String longestPalindrome(String s) {
        int t = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {

            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(arr));
        new Solution().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

    }

}
