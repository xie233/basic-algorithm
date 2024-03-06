package org.jim.linkedlist;


import org.junit.jupiter.api.Test;

public class LRUArrayTest {

    @Test
    public void defaultConstructorTest() {
        System.out.println("======无参测试========");
        LRUArray<Integer> lru = new LRUArray<Integer>();
        lru.offer(1);
        lru.offer(2);
        lru.offer(3);
        lru.offer(4);
        lru.offer(5);
        System.out.println(lru);
        lru.offer(6);
        lru.offer(7);
        lru.offer(8);
        lru.offer(9);
        System.out.println(lru);
    }

    @Test
    public  void testSpecifiedConstructor() {
        System.out.println("======有参测试========");
        LRUArray<Integer> lru = new LRUArray<Integer>(4);
        lru.offer(1);
        System.out.println(lru);
        lru.offer(2);
        System.out.println(lru);
        lru.offer(3);
        System.out.println(lru);
        lru.offer(4);
        System.out.println(lru);
        lru.offer(2);
        System.out.println(lru);
        lru.offer(4);
        System.out.println(lru);
        lru.offer(7);
        System.out.println(lru);
        lru.offer(1);
        System.out.println(lru);
        lru.offer(2);
        System.out.println(lru);
    }



}
