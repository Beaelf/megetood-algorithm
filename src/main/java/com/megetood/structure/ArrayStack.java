package com.megetood.structure;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/08/23 14:21
 */
public class ArrayStack<E> implements Stack<E> {
    Array<E> array;

    public ArrayStack() {
        array = new Array<>();
    }

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    // 查看栈顶元素
    @Override
    public E peek() {
        return array.getLast();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i!=array.getSize()-1){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
