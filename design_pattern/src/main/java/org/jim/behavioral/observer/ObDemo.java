package org.jim.behavioral.observer;


import com.google.common.eventbus.EventBus;

class ConcreteObserverOne implements Observer {
    @Override
    public void update(String String) {
        //TODO: 获取消息通知，执行自己的逻辑...
        System.out.println("ConcreteObserverOne is notified.");
    }
}

class ConcreteObserverTwo implements Observer {
    @Override
    public void update(String String) {
        //TODO: 获取消息通知，执行自己的逻辑...
        System.out.println("ConcreteObserverTwo is notified.");
    }
}

public class ObDemo {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers(new String());
    }
}
