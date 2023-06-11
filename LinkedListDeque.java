import java.util.Iterator;

import static java.lang.System.in;

public class LinkedListDeque<Blorp> implements Iterable<Blorp> {
    private class Node {
        public Blorp item;
        public Node next;

        public Node(Blorp i, Node n) {
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private Node sentinel;
    private int size;

    /** Creates an empty SLList. */
    public LinkedListDeque() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public LinkedListDeque(Blorp x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }

    /** Inserts the item into the given position in
     *  the list. If position is greater than the
     *  size of the list, inserts at the end instead.
     */
    public void insert(Blorp item, int position) {
        Node p = sentinel;
        while (position > 1 && p.next != null) {
            position--;
            p = p.next;
        }
        Node newNode = new Node(item, p.next);
        p.next = newNode;
    }

    /** Adds x to the front of the list. */
    public void addFirst(Blorp x) {
        sentinel.next = new Node(x, sentinel.next);
        size = size + 1;
    }

    /** Adds x to the end of the list. */
    public void addLast(Blorp x) {
        size = size + 1;

        Node p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new Node(x, null);
    }

    /** Returns the first item in the list. */
    public Blorp getFirst() {
        return sentinel.next.item;
    }

    /** Returns the back node of our list. */
    private Node getLastNode() {
        Node p = sentinel;

        /* Move p until it reaches the end. */
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    /** Returns last item */
    public Blorp getLast() {
        Node back = getLastNode();
        return back.item;
    }

    /** Returns the ith item in the list. */
    public Blorp get(int i) {
        return get(i, sentinel.next);
    }

    private Blorp get(int i, Node p) {
        if (i == 0) {
            return p.item;
        }
        return get(i - 1, p.next);
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    /** Deletes and returns last item. */
    public Blorp removeLast() {
        Node back = getLastNode();
        if (back == sentinel) {
            return null;
        }

        Node p = sentinel;

        while (p.next != back) {
            p = p.next;
        }
        p.next = null;
        return back.item;
    }


    public void print() {
        Node p = sentinel.next;
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    private class myLinkedListDequeIt implements Iterator<Blorp> {
        private Node wizPos;
        public myLinkedListDequeIt(){
            wizPos = sentinel.next;
        }

        public boolean hasNext(){
            return wizPos != null;
        }

        public Blorp next(){
            Blorp returnItem = wizPos.item;
            wizPos = wizPos.next;
            return returnItem;
        }
    }

    public Iterator<Blorp> iterator() {
        return new myLinkedListDequeIt();
    }

    public boolean contains(Blorp x) {
        Node p = sentinel.next;
        while (p != null) {
            if (p.item.equals(x)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    @Override
    public boolean equals (Object other){
        if (this == other) {
            return true;
        }
        if (other == null){
            return false;
        }
        if (other.getClass() != this.getClass()){
            return false;
        }
        if (other instanceof LinkedListDeque otherlld) {
            if ( otherlld.size() != this.size()){
                return false;
            }
            for (Blorp x: this) {
                if (!otherlld.contains(x)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        LinkedListDeque<Integer> L = new LinkedListDeque<Integer>();
        L.addLast(20);
        L.addFirst(10);
        L.addLast(30);
        //System.out.println(L.size());
        //L.print();
        for (int x : L){
            System.out.print(x + " ");
        }
        LinkedListDeque<Integer> newL = new LinkedListDeque<Integer>();
        newL.addLast(20);
        newL.addFirst(10);
        newL.addLast(40);
        newL.print();
        System.out.println(L.equals(newL));
    }
}
