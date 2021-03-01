package com.megetood.structure;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/08/23 3:36
 */
public class Array<E> {
    private static final int CAPACITY = 10;
    private E[] data;
    private int size;

    // 默认
    public Array() {
        this(CAPACITY);
    }

    // 自定义数组容量
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 获取数组中元素个数
    public int getSize() {
        return this.size;
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 在所有元素后面添加一个元素
    public void addLast(E e) {
        add(size, e);
    }

    // 在所有元素前面添加一个新元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 向指定位置添加元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Require index >= 0 and index <= size.");
        }
        // 达到数组最大容量，扩容
        if (size == data.length) {
//            throw new IllegalArgumentException("Add failed, Array is full.");
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    // 获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed, Index is illegal.");
        }
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    // 修改index索引位置的元素
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed, Index is illegal.");
        }
        data[index] = e;
    }

    // 数组是否包含某个元素
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素，返回其对应的索引值
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 删除某个元素，返回删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove fialed. Index is illegal.");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // 帮助垃圾回收
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    // 删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 删除指定元素
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
