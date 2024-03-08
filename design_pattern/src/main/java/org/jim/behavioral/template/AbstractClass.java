package org.jim.behavioral.template;

public abstract class AbstractClass {
    public final void templateMethod(){
        //...
        methodOne();
        //...
        methodTwo();
    }

    abstract void methodOne();

    abstract void methodTwo();

    public static void main(String[] args) {
        AClass aClass = new AClass();
        aClass.templateMethod();
    }
}
