package com.megetood.structure;

/**
 * 最大堆
 *
 * @author chengdong.lei@hand-china.com 2020/09/04 12:49
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    // 去除堆中最大元素
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    // 去除堆中最大元素，并替换成元素e
    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }

            // 上面逻辑执行后，data[j]是leftChild与rightChild中的最大值
            if(data.get(k).compareTo(data.get(j))>=0){
                break;
            }
            data.swap(k,j);
            k = j;
        }
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>();
        Integer[] in = {5,7,6};
        for (int i = 0; i < in.length; i++) {
            heap.add(in[i]);
        }
        System.out.println(heap.data);
        for (int i = 0; i < in.length; i++) {
            Integer max = heap.extractMax();
            System.out.println(max);
        }


    }
}

