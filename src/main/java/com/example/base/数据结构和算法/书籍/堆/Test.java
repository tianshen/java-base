package com.example.base.数据结构和算法.书籍.堆;

/**
 * @author xue
 * @date 2023/4/25 23:42
 */
public class Test {

    public static void main(String[] args) {

        Heap heap = new Heap(7);
        heap.insert(34);
        heap.insert(23);
        heap.insert(78);
        heap.insert(2);
        heap.insert(76);
        heap.insert(9);
        heap.insert(100);
        // System.out.println(heap.getHeapArray());
        Node[] heapArray = heap.getHeapArray();
        for (Node node : heapArray) {
            System.out.println(node.getKey());
        }
        System.out.println("完成");

        Node remove1 = heap.remove();
        System.out.println(remove1.getKey());
        Node remove2 = heap.remove();
        System.out.println(remove2.getKey());
        Node remove3 = heap.remove();
        System.out.println(remove3.getKey());



        System.out.println("--------------------------");
        for (Node node : heapArray) {
            System.out.println(node.getKey());
        }

        heap.change(2, 45);

        System.out.println("--------------------------");
        for (Node node : heapArray) {
            System.out.println(node.getKey());
        }
    }
}
