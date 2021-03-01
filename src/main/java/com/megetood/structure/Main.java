package com.megetood.structure;

import com.megetood.util.FileOperation;
import com.megetood.Student;
import com.megetood.util.TimeCounter;
import com.megetood.executor.ArrayGenerator;

import java.util.ArrayList;
import java.util.Random;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/08/23 3:59
 */
public class Main {
    public static void main(String[] args) {
//        int num = 10000;
//
//        testStack(new ArrayStack<Integer>(),num);
//        testStack(new LinkedListStack<Integer>(),num);
//        testLoopQueue();
//        compareQueueTest();
//        compareSet();

//        compareMap();
//        testMaxHeap();
//        tetSegmentTree();
//        compareTrieSet();
//        compareAvlBSTmap();
        testMap(new BSTMap<>());
        testMap(new AVLTree<>());
        testMap(new RBTree<>());

        testMap(new HashTable<>());

    }

    private static void compareAvlBSTmap() {
        AVLTree<String, Integer> map = new AVLTree<>();
        TimeCounter timer = new TimeCounter();
        timer.start();
        ArrayList<String> words = testMap(map);
        timer.end();
        timer.between().print();
        for(String word: words){
            map.remove(word);
            if(!map.isBST()||!map.isBalanced()){
                throw new RuntimeException("error not bst balance");
            }
        }
        boolean res = map.isBST();
        System.out.println("is bst: "+res);
        System.out.println("is balance: "+ map.isBalanced());
        System.out.println("--------------");


        BSTMap<String, Integer> bstMap = new BSTMap<>();
        timer.start();
        testMap(bstMap);
        timer.end();
        timer.between().print();
    }

    private static void testUF() {
        int size = 10000000;
        int m = 10000000;
//        UnionFind1 uf1 = new UnionFind1(size);
//        UnionFind2 uf2 = new UnionFind2(size);
        UnionFind3 uf3 = new UnionFind3(size);
        UnionFind4 uf4 = new UnionFind4(size);
        UnionFind5 uf5 = new UnionFind5(size);
        UnionFind6 uf6 = new UnionFind6(size);

//        testUF(uf1,m);
//        testUF(uf2,m);
        testUF(uf3,m);
        testUF(uf4,m);
        testUF(uf5,m);
        testUF(uf6,m);
    }

    private static void testUF(UF uf, int m){
        int size = uf.getSize();
        Random random = new Random();

        TimeCounter timer = new TimeCounter();
        timer.start();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a,b);
        }
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a,b);
        }
        timer.end();
        timer.between().print();
    }
    private static void compareTrieSet() {
        System.out.println("pride and prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("D:\\worksapce\\ideaspace\\enhance\\megetood-algorithm\\src\\main\\" +
                "java\\com\\megetood\\testfile\\pride-and-prejudice.txt", words)){
            TimeCounter timer = new TimeCounter();

            BSTSet<String> set = new BSTSet<>();
            for(String word: words){
                set.add(word);
            }
            timer.start();
            for(String word: words){
                set.contains(word);
            }

            timer.end();
            System.out.println("total diferent words: " + set.getSize());
            timer.between().print();

            Trie trie = new Trie();
            for(String word: words){
                trie.add(word);
            }
            timer.start();
            for(String word: words){
                trie.contains(word);
            }
            timer.end();
            System.out.println("total diferent words: " + trie.getSize());
            timer.between().print();


        }
    }

    private static void tetSegmentTree() {
        Integer[] nums = {1,2,3,1,2,3};
        SegmentTree<Integer> tree = new SegmentTree<>(nums,(a, b)->a+b);
        System.out.println(tree.query(1,4));
        System.out.println(tree.toString());
    }

    private static void testMaxHeap() {
        int n = 1000000;
        MaxHeap<Integer> heap = new MaxHeap<>();
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

        int[] array = new int[n];
        for(int i = 0; i < array.length; i++) {
            array[i] = heap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if(array[i-1]<array[i]){
                throw new RuntimeException("Error");
            }
        }

        System.out.println("Test MaxHeap completed.");
    }

    private static void compareMap() {
        TimeCounter timer = new TimeCounter();
        timer.start();
        testMap(new LinkedListMap<>());
        timer.end();
        timer.between().print();


        timer.start();
        testMap(new BSTMap<>());
        timer.end();
        timer.between().print();
    }

    private static ArrayList<String> testMap(Map<String,Integer> map) {
        System.out.println(map.getClass().getSimpleName());
        System.out.println("pride and prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("D:\\worksapce\\ideaspace\\enhance\\megetood-algorithm\\src\\main\\" +
                "java\\com\\megetood\\testfile\\pride-and-prejudice.txt", words1);
        System.out.println("total words: " + words1.size());
        TimeCounter timer = new TimeCounter();
        timer.start();
        for (String word : words1) {
            if(map.contains(word)){
                map.set(word, map.get(word )+1);
            }else {
                map.add(word,1);
            }
        }
        timer.end();
        System.out.println("time: "+timer.between().getTime());
        timer.start();
        for (String word : words1) {
            map.contains(word);
        }
        timer.end();
        System.out.println("total different words: " + map.getSize());
        System.out.println("frequency of pride: "+map.get("pride"));
        System.out.println("frequency of prejudice: "+map.get("prejudice"));
        System.out.println("time: "+timer.between().getTime());
        System.out.println();
        return words1;
    }

    private static void compareSet() {
        TimeCounter timer = new TimeCounter();

        timer.start();
        testBSTSet();
        timer.end();
        timer.between().print();

        timer.start();
        testLinkedListSet();
        timer.end();
        timer.between().print();
    }

    private static void testLinkedListSet() {
        System.out.println("pride and prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("D:\\worksapce\\ideaspace\\enhance\\megetood-algorithm\\src\\main\\java\\com\\megetood\\testfile\\pride-and-prejudice.txt", words1);
        System.out.println("total words: " + words1.size());

        LinkedListSet<String> set1 = new LinkedListSet<>();
        for (String word : words1) {
            set1.add(word);
        }
        System.out.println("total different words: " + set1.getSize());

        System.out.println("pride and prejudice");
        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("D:\\worksapce\\ideaspace\\enhance\\megetood-algorithm\\src\\main\\java\\com\\megetood\\testfile\\a-tale-of-two-cities.txt", words2);
        System.out.println("total words: " + words2.size());

        LinkedListSet<String> set2 = new LinkedListSet<>();
        for (String word : words2) {
            set2.add(word);
        }
        System.out.println("total different words: " + set2.getSize());
    }

    private static void testBSTSet() {
        System.out.println("pride and prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("D:\\worksapce\\ideaspace\\enhance\\megetood-algorithm\\src\\main\\java\\com\\megetood\\testfile\\pride-and-prejudice.txt", words1);
        System.out.println("total words: " + words1.size());

        BSTSet<String> set1 = new BSTSet<>();
        for (String word : words1) {
            set1.add(word);
        }
        System.out.println("total different words: " + set1.getSize());

        System.out.println("pride and prejudice");
        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("D:\\worksapce\\ideaspace\\enhance\\megetood-algorithm\\src\\main\\java\\com\\megetood\\testfile\\a-tale-of-two-cities.txt", words2);
        System.out.println("total words: " + words2.size());

        BSTSet<String> set2 = new BSTSet<>();
        for (String word : words2) {
            set2.add(word);
        }
        System.out.println("total different words: " + set2.getSize());
    }

    private static void testStack(Stack<Integer> q, int opCount) {
        TimeCounter timeCounter = new TimeCounter();
        timeCounter.start();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.pop();
        }

        timeCounter.end();
        System.out.println(q.getClass().getSimpleName());
        timeCounter.between().print();
    }

    private static void testLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            list.addLast(i);
            System.out.println(list);
        }
        list.add(2, 4);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.removeFirst();
        list.removeLast();
        System.out.println(list);
    }

    private static void compareQueueTest() {
        int opCount = 100000;
        LinkedListQueue<Integer> q1 = new LinkedListQueue<>();
        double t1 = testQueue(q1, opCount);
        System.out.println("LinkedListQueue, time: " + t1 + "s");
        LoopQueue<Integer> q2 = new LoopQueue<>();
        double t2 = testQueue(q2, opCount);
        System.out.println("LoopQueue, time: " + t2 + "s");
    }

    // 测试q 运行opCount个入队出队操作消耗时间
    private static double testQueue(Queue<Integer> q, int opCount) {
        TimeCounter timeCounter = new TimeCounter();
        timeCounter.start();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        timeCounter.end();
        return timeCounter.between().getTime();
    }

    private static void testLoopQueue() {
        LinkedListQueue<Integer> qu = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            qu.enqueue(i);
            System.out.println(qu);

            if (i % 3 == 2) {
                qu.dequeue();
                System.out.println(qu);
            }
        }
        ;
    }

    private static void testArrayQueue() {
        ArrayQueue<Integer> qu = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            qu.enqueue(i);
            System.out.println(qu);

            if (i % 3 == 2) {
                qu.dequeue();
                System.out.println(qu);
            }
        }
        ;
    }

    private static void testStack() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }

    private static void testArray2() {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("tom", 99));
        arr.addLast(new Student("bob", 93));
        arr.addLast(new Student("jact", 89));
        System.out.println(arr);
    }

    private static void testArray() {
        Array<Integer> arr = new Array<>(5);
        for (int i = 0; i < 5; i++) {
            arr.addLast(i);
        }
        arr.add(5, 100);
        System.out.println(arr);

        arr.addFirst(00);
        System.out.println(arr);

        arr.remove(0);
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);
    }
}
