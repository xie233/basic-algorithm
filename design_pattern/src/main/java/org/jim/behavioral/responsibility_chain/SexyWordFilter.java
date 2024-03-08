package org.jim.behavioral.responsibility_chain;

public class SexyWordFilter implements SensitiveWordFilter{

    @Override
    public boolean doFilter(String content) {
        boolean legal = true;
        //...
        return legal;
    }
}
