package org.jim.behavioral.responsibility_chain;

public class PoliticalWordFilter implements SensitiveWordFilter{

    @Override
    public boolean doFilter(String content) {
        boolean legal = true;
        //...
        return legal;
    }
}
