package com.gfj.yellodate;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {
    @Test
    public void testThreadLocalSetAndGet() {
        // 创建一个ThreadLocal对象
        ThreadLocal<String> tl = new ThreadLocal<>();
        // 开启两个线程
        new Thread(()->{
            tl.set("萧炎");
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
        }, "席阳").start();

        new Thread(()->{
            tl.set("药尘");
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
        }, "葛方杰").start();
    }
}
