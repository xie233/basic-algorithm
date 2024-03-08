package org.jim.structural.proxy;

public class UserService implements IUserService{

    @Override
    public void printUserName() {
        System.out.println("this is good one");
    }
}
