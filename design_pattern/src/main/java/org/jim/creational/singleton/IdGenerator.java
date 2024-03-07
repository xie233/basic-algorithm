package org.jim.creational.singleton;

import java.util.concurrent.atomic.AtomicLong;

/*
单例有下面几种经典的实现方式。
1、饿汉式
在类加载的期间，就已经将 instance 静态实例初始化好了，不支持延迟加载实例
2、懒汉式
支持延迟加载，频繁加锁、释放锁，以及并发度低等问题
3、双重检测
既支持延迟加载、又支持高并发
4、静态内部类
利用 Java 的静态内部类来实现单例。这种实现方式，既支持延迟加载，也支持高并发，实现起来也比双重检测简单
5、枚举
通过 Java 枚举类型本身的特性，保证了实例创建的线程安全性和实例的唯一性。
 */


// 饿汉式
// 不支持延迟加载，
// 采用饿汉式实现方式，将耗时的初始化操作，提前到程序启动的时候完成
// 按照 fail-fast 的设计原则（及早暴露资源不够）
//public class IdGenerator {
//    private AtomicLong id = new AtomicLong(0);
//    private static final IdGenerator instance = new IdGenerator();
//    private IdGenerator() {}
//    public static IdGenerator getInstance() {
//        return instance;
//    }
//    public long getId() {
//        return id.incrementAndGet();
//    }
//}

//懒汉式
//加了一把大锁，导致这个函数的并发度很低
//public class IdGenerator {
//    private AtomicLong id = new AtomicLong(0);
//    private static IdGenerator instance;
//    private IdGenerator() {}
//    public static synchronized IdGenerator getInstance() {
//        if (instance == null) {
//            instance = new IdGenerator();
//        }
//        return instance;
//    }
//    public long getId() {
//        return id.incrementAndGet();
//    }
//}

//双重检测
//既支持延迟加载、又支持高并发的单例实现方式
//加volatile关键字的原因：CPU 指令重排序可能导致在 IdGenerator 类的对象被关键字 new 创建并赋值给 instance 之后，还没来得及初始化（执行构造函数中的代码逻辑），就被另一个线程使用了。这样，另一个线程就使用了一个没有完整初始化的 IdGenerator 类的对象
public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static volatile IdGenerator instance;
    private IdGenerator() {}
    public static IdGenerator getInstance() {
        if (instance == null) {
            synchronized(IdGenerator.class) { // 此处为类级别的锁
                if (instance == null) {
                    instance = new IdGenerator();
                }
            }
        }
        return instance;
    }
    public long getId() {
        return id.incrementAndGet();
    }
}

//静态内部类
//有点类似饿汉式，但又能做到了延迟加载
/*
SingletonHolder 是一个静态内部类，当外部类 IdGenerator 被加载的时候，
并不会创建 SingletonHolder 实例对象。
只有当调用 getInstance() 方法时，SingletonHolder 才会被加载，
这个时候才会创建 instance。instance 的唯一性、创建过程的线程安全性，都由 JVM 来保证。
所以，这种实现方法既保证了线程安全，又能做到延迟加载。
 */
//public class IdGenerator {
//    private AtomicLong id = new AtomicLong(0);
//    private IdGenerator() {}
//
//    private static class SingletonHolder{
//        private static final IdGenerator instance = new IdGenerator();
//    }
//
//    public static IdGenerator getInstance() {
//        return SingletonHolder.instance;
//    }
//
//    public long getId() {
//        return id.incrementAndGet();
//    }
//}

//枚举
//基于枚举类型的单例实现。这种实现方式通过 Java 枚举类型本身的特性，保证了实例创建的线程安全性和实例的唯一性
//public enum IdGenerator {
//    INSTANCE;
//    private AtomicLong id = new AtomicLong(0);
//
//    public long getId() {
//        return id.incrementAndGet();
//    }
//}
