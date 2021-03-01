package com.megetood.solution.nowcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * [要求]
 * set和get方法的时间复杂度为O(1)
 * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 * 对于每个操作2，输出一个答案
 * <p>
 * 输入；
 * [[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
 * 输出：
 * [1,-1]
 *
 * @author Lei Chengdong
 * @date 2020/11/21
 */
public class LRU {
    public class LRUCache implements Cache {
        private class Node {
            int key;
            int val;
            Node prev;
            Node next;

            Node(Node prev, Node next, int key, int val) {
                this.prev = prev;
                this.next = next;
                this.key = key;
                this.val = val;
            }

            @Override
            public String toString() {
                StringBuilder res = new StringBuilder();
                Node cur = this;
                while (cur != null) {
                    res.append(cur.val).append(">");
                    cur = cur.next;
                }
                res.append("NULL");
                return res.toString();
            }
        }

        Map<Integer, Node> cache;
        int capacity;
        Node first;
        Node last;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>(capacity);
        }

        @Override
        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }

            // 调整key对应的节点位置,到最头部
            adjustPost(node);

            return node.val;
        }

        @Override
        public void set(int key, int val) {
            Node node = cache.get(key);

            // node 存在
            if (node != null) {
                node.val = val;
                // 调整key对应的节点位置,到最头部,已经在头部则不需要调整
                adjustPost(node);
            }

            // node 不存在
            // 缓存满了,删除最后节点
            if (cache.size() == capacity) {
                removeNode(last);
            }
            addFirst(key, val);
        }

        private void adjustPost(Node node) {
            int key = node.key;
            int val = node.val;

            removeNode(node);

            addFirst(key, val);
        }

        private void removeNode(Node node) {
            if (node == null) {
                return;
            }

            cache.remove(node.key);

            Node prev = node.prev;
            Node next = node.next;

            if (prev == null) {
                first = next;
            } else {
                prev.next = next;
                node.prev = null;
            }

            if (next == null) {
                last = prev;
            } else {
                next.prev = prev;
                node.next = null;
            }
            node = null;
        }

        private void addFirst(int key, int val) {
            Node node;
            Node f = first;
            node = new Node(null, first, key, val);
            first = node;
            if (f == null) {
                last = node;
            } else {
                f.prev = node;
            }

            cache.put(key, node);
        }
    }

    public interface Cache {
        int get(int key);
        void set(int key, int val);
    }


    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        if (operators == null || operators.length == 0 || k < 1) {
            return new int[]{};
        }

        Cache lru = new LRUCache(k);

        int len = 0;
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 2) {
                len++;
            }
        }
        int[] res = new int[len];

        int r = 0;
        for (int i = 0; i < operators.length; i++) {
            int[] op = operators[i];

            int flag = op[0];
            if (flag == 2) {
                res[r++] = lru.get(op[1]);
            } else {
                lru.set(op[1], op[2]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] operators = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        System.out.println("input: " + Arrays.deepToString(operators) + ", length: " + operators.length);
        int k = 3;
        int[] res = new LRU().LRU(operators, k);
        System.out.println(Arrays.toString(res));
    }


}
