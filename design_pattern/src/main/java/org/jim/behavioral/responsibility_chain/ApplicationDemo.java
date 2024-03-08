package org.jim.behavioral.responsibility_chain;





public class ApplicationDemo {

    public static void main(String[] args) {
        SensitiveWordFilterChain filterChain = new SensitiveWordFilterChain();
        filterChain.addFilter(new AdsWordFilter());
        filterChain.addFilter(new SexyWordFilter());
        filterChain.addFilter(new PoliticalWordFilter());

        boolean legal = filterChain.filter("Goocnsjbv dj");
        if (!legal) {
            // 不发表
        } else {
            // 发表
        }
    }
}
