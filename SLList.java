
public class SLList<LochNess> {
    private class StuffNode {
        public LochNess item;
        public StuffNode next;

        public StuffNode(LochNess i, StuffNode n){
            item = i;
            next = n;
        }
    }

    private StuffNode first;
    //private IntNode sentinel;
    public SLList (LochNess x){
        // can replace first by sentinel.next
        // sentinel = new IntNode(63, null)
        first = new StuffNode(x, null);
    }

    public void addFirst(LochNess x){
        first = new StuffNode(x, first);
    }

    public void addLast(LochNess x){
        StuffNode p = first;
        while (p.next != null){
            p = p.next;
        }
        p.next = new StuffNode(x, null);
    }

    public LochNess getFirst(){
        return first.item;
    }

    public int size(){
        int cnt = 1;
        StuffNode p = first;
        while (p.next != null){
            p = p.next;
            cnt = cnt + 1;
        }
        return  cnt;
    }

    public static void main(String[] args){
        SLList mylist = new SLList(15);
        mylist.addFirst(10);
        mylist.addFirst(5);
        SLList<String> s1 = new SLList<String>("bone");
        s1.addFirst("thugs");
        System.out.println(s1.getFirst());
        System.out.println(mylist.size());
    }
}
