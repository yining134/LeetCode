package utils;

import java.util.ArrayList;

public class MaxHeap <E extends Comparable<E>>{
    private ArrayList<E> data;

    MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    MaxHeap (E[] arr) {
        data = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            data.add(arr[i]);
        }
        //下滤法，找到最后一个节点的父节点，将其视为一个堆，从该节点开始向前,不断加入节点
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap (int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    private void siftUp(int k) {
        E temp = data.get(k);
        E parent = null;
        while (k > 0) {
            parent = data.get(parent(k));
            if (parent.compareTo(temp) < 0) {
                data.set(k, parent);
                k = parent(k);
            } else {
                break;
            }
        }
        data.set(k, temp); // 兼顾k=0的情况
    }

    private void siftDown(int k) {
        E temp = data.get(k);
        E max = null;
        int maxChild;
        while (leftChild(k) < data.size()) {
            //考虑只有左孩子的情况，避免溢出
            if (leftChild(k) + 1 >= data.size()) {
                max = data.get(leftChild(k));
                maxChild = leftChild(k);
            } else {
                E left = data.get(leftChild(k));
                E right = data.get(rightChild(k));
                if (left.compareTo(right) > 0) {
                    max = left;
                    maxChild = leftChild(k);
                } else {
                    max = right;
                    maxChild = rightChild(k);
                }
            }

            if (max.compareTo(temp) > 0) {
                data.set(k, max);
                k = maxChild;
            } else break;
        }
        data.set(k, temp);
    }

    private void add(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    private E pop() {
        E ret = data.get(0);
        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        if (data.size() != 0) siftDown(0);
        return ret;
    }

    private boolean isEmpty() {
        return data.isEmpty();
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(new Integer[]{1, 2, 3, 5, 4, 7});
        maxHeap.add(6);
        while(!maxHeap.isEmpty()) {
            System.out.printf(maxHeap.pop() + "\t");
        }
    }
}
