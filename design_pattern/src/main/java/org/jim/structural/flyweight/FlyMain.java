package org.jim.structural.flyweight;

public class FlyMain {
    public static void main(String[] args) {

//        public static Integer valueOf(int i) {
//            if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high)
//                return Integer.IntegerCache.cache[i + (-Integer.IntegerCache.low)];
//            return new Integer(i);
//        }
        //[-128,127]
        //自定义方法一：
        //-Djava.lang.Integer.IntegerCache.high=255
        //方法二：
        //-XX:AutoBoxCacheMax=255
        Integer i1 = 56;
        Integer i2 = 56;
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i1 == i2); //true
        System.out.println(i3 == i4); //false


        String s1 = "设计模式";
        String s2 = "设计模式";
        String s3 = new String("设计模式");

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
    }
}
