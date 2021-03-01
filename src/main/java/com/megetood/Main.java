package com.megetood;


import java.util.*;
import java.util.stream.Collectors;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/11 18:58
 */
public class Main {
    public static int varify(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == '{' || cur == '[' || cur == '<') {
                stack.push(cur);
                continue;
            }


            if (cur == '}') {
                if (stack == null || stack.isEmpty()) {
                    res = 0;
                    break;
                }
                Character target = stack.pop();
                if (target == '{') {
                    res++;
                    continue;
                } else {
                    res = 0;
                    break;
                }
            }
            if (cur == ']') {
                if (stack == null || stack.isEmpty()) {
                    res = 0;
                    break;
                }
                Character target = stack.pop();
                if (target == '[') {
                    res++;
                    continue;
                } else {
                    res = 0;
                    break;
                }
            }
            if (cur == '>') {
                if (stack == null || stack.isEmpty()) {
                    res = 0;
                    break;
                }
                Character target = stack.pop();
                if (target == '<') {
                    res++;
                    continue;
                } else {
                    res = 0;
                    break;
                }
            }
        }
        return res;
    }

    public static void findKthNum(String str, int k) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (k < 1) {
            throw new IllegalArgumentException("illegal k");
        }

        char[] arr = str.toCharArray();
        quickSort(arr, 0, arr.length - 1);

        if (k > arr.length) {
            System.out.println(str.indexOf(arr[arr.length - 1]));
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == arr[k - 1]) {
                    System.out.println(i);
                }
            }
        }
    }

    private static void quickSort(char[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = partition(arr, l, r);
        quickSort(arr, l, mid);
        quickSort(arr, mid + 1, r);
    }

    public static int partition(char[] arr, int l, int r) {
        char target = arr[l];
        int t = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] <= target) {
                char temp = arr[i];
                arr[i] = arr[++t];
                arr[t] = temp;
            }
        }
        arr[l] = arr[t];
        arr[t] = target;
        return t;
    }

    private static class Stu {
        int cla;
        int num;
        int score1;
        int score2;

        public Stu() {
        }

        @Override
        public String toString() {
            return num + "";
        }

        public void setCla(int cla) {
            this.cla = cla;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public void setScore1(int score1) {
            this.score1 = score1;
        }

        public void setScore2(int score2) {
            this.score2 = score2;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();

        String[] sub1 = line1.split(";");
        String[] sub2 = line2.split(";");
        List<Stu> list = new ArrayList<>();
        Map<Integer, Stu> map = new HashMap<>();
        boolean hasTwo = false;

        for (int i = 0; i < sub1.length; i++) {
            String cur = sub1[i];
            String numStr = cur.substring(0, cur.indexOf(","));

            Stu stu = new Stu();
            int num = Integer.parseInt(numStr);
            int cla = Integer.parseInt(numStr.substring(0, 5));
            int score1 = Integer.parseInt(cur.substring(cur.indexOf(",") + 1));
            stu.setCla(cla);
            stu.setScore1(score1);
            stu.setNum(num);

            list.add(stu);
            map.put(num, stu);
        }
        for (int i = 0; i < sub2.length; i++) {
            String cur = sub2[i];
            String numStr = cur.substring(0, cur.indexOf(","));


            int num = Integer.parseInt(numStr);
            int cla = Integer.parseInt(numStr.substring(0, 5));
            int score2 = Integer.parseInt(cur.substring(cur.indexOf(",") + 1));


            if (map.get(num) == null) {
                Stu stu = new Stu();
                stu.setCla(cla);
                stu.setScore2(score2);
                stu.setNum(num);
                list.add(stu);
                map.put(num, stu);
            } else {
                hasTwo = true;
                map.get(num).setScore2(score2);
            }
        }

        if (!hasTwo) {
            System.out.println("NULL");
        } else {
            // 分组，排序
            list.sort(new Comparator<Stu>() {
                @Override
                public int compare(Stu o1, Stu o2) {
                    return (o1.score1 + o1.score2) - (o2.score1 + o2.score2);
                }
            });
            Map<Integer, List<Stu>> collect = list.stream().collect(Collectors.groupingBy(c -> c.cla));
            for (Integer groupId : collect.keySet()) {
                System.out.println(groupId);
                System.out.println(collect.get(groupId).toString());
            }
        }
//        test12();
    }

    private static void test12() {
        //        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        int varify = Main.varify(str);
//        System.out.println(varify);
//
//        System.out.println('a' - 0);
//        System.out.println('A' - 0);

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int k = in.nextInt();
        Main.findKthNum(str, k);
    }
}
