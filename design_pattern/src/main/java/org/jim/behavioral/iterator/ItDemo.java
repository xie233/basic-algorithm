package org.jim.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ArrayIterator<E> implements Iterator<E> {
    private int cursor;
    private ArrayList<E> arrayList;

    public ArrayIterator(ArrayList<E> arrayList) {
        this.cursor = 0;
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        return cursor != arrayList.size(); //注意这里，cursor在指向最后一个元素的时候，hasNext()仍旧返回true。
    }

    @Override
    public E next() {
        if (cursor >= arrayList.size()) {
            throw new NoSuchElementException();
        }
        return arrayList.get(cursor++);
    }


}

public class ItDemo {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("xxx");
        names.add("yyy");
        names.add("zzz");

        Iterator<String> iterator = new ArrayIterator(names);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
