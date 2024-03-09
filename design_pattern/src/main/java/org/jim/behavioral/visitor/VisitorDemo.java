package org.jim.behavioral.visitor;

interface Base {
    void execute(Base target);
    void doJob(FOO target);
    void doJob(BAR target);
    void doJob(BAZ target);
}

class FOO implements Base {
    public void execute(Base base) {
        base.doJob(this);
    }

    public void doJob(FOO foo) {
        System.out.println("FOO object calls by yourself");
    }

    public void doJob(BAR bar) {
        System.out.println("BAR object was called from FOO");
    }

    public void doJob(BAZ baz) {
        System.out.println("BAZ object was called from FOO");
    }
}

class BAR implements Base {
    public void execute(Base base) {
        base.doJob(this);
    }

    public void doJob(FOO foo) {
        System.out.println("FOO object was called from BAR" );
    }

    public void doJob(BAR bar) {
        System.out.println("BAR object calls by yourself");
    }

    public void doJob(BAZ baz) {
        System.out.println("BAZ object was called from BAR");
    }
}

class BAZ implements Base {
    public void execute(Base base) {
        base.doJob( this);
    }

    public void doJob(FOO foo) {
        System.out.println("FOO object was called from BAZ");
    }

    public void doJob(BAR bar) {
        System.out.println("BAR object was called from BAZ");
    }

    public void doJob(BAZ baz) {
        System.out.println("BAZ object calls by yourself");
    }
}

public class VisitorDemo {
    public static void main(String[] args) {
        Base objects[] = {new FOO(), new BAR(), new BAZ()};
        for (Base object : objects) {
            object.execute(object);
            System.out.println();
        }
    }
}

