package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T> {
    private T[] items;
    private int size;

    /* create an empty list*/
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    // insert item before index x
    public void insert(T item, int x) {
        T[] newarray = (T[]) new Object[items.length + 1];
        System.arraycopy(items, 0, newarray, 0, x);
        newarray[x] = item;
        System.arraycopy(items, x, newarray, x + 1, items.length - x);
        items = newarray;
        size = size + 1;
    }

    private void resize(int capacity) {
        T[] newdeque = (T[]) new Object[capacity];
        System.arraycopy(items, 0, newdeque, 0, size);
        items = newdeque;
    }

    public void addFirst(T item) {
        insert(item, 0);
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[size] = item;
        size += 1;
    }

    public int size() {
        return size;
    }

    public T get(int i) {
        return items[i];
    }

    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public T getFirst() {
        return items[0];
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T[] newarray = (T[]) new Object[items.length - 1];
        T temp = items[0];
        System.arraycopy(items, 1, newarray, 0, size - 1);
        size = size - 1;
        items = newarray;
        return temp;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T temp = items[size - 1];
        items[size - 1] = null;
        size = size - 1;
        return temp;
    }


    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPoz;

        public ArrayDequeIterator() {
            wizPoz = 0;
        }

        public boolean hasNext() {
            return wizPoz < size;
        }

        public T next() {
            T returnItem = items[wizPoz];
            wizPoz = wizPoz + 1;
            return returnItem;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    public boolean contains(T x){
        for (int i = 0; i < size; i += 1){
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null){
            return false;
        }
        if (other.getClass() != this.getClass()){
            return false;
        }
        if (other instanceof ArrayDeque otherad){
            if (otherad.size() != this.size()){
                return false;
            }
            for (T x : this){
                if (!otherad.contains(x)){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ArrayDeque<String> myad = new ArrayDeque<String>();
        myad.addLast("middle");
        myad.addFirst("front");
        myad.addLast("back");
        //System.out.println(myad.size());
        //System.out.println(myad.get(2));

        //String a = myad.removeFirst();
        //System.out.println(a);
        //myad.printDeque();

        for (String x : myad) {
            System.out.print(x);
        }
        ArrayDeque<String> newmyad = new ArrayDeque<String>();
        newmyad.addLast("middle");
        newmyad.addFirst("front");
        newmyad.addLast("ba");
        System.out.println(newmyad.equals(myad));


    }
}
