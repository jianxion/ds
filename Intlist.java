import java.sql.PreparedStatement;

public class Intlist {
    public int first;
    public Intlist rest;
    public Intlist(int f, Intlist r){
        first = f;
        rest = r;
    }

    public static Intlist[] partition(Intlist lst, int k){
        Intlist[] array = new Intlist[k];
        int index = 0;
        while (lst != null){
            Intlist tempArray = array[index];
            Intlist tempNext = lst.rest;
            array[index] = lst;
            array[index].rest = tempArray;
            lst = tempNext;
            index = (index + 1) % k;
        }
        return array;
    }

    public static Intlist incrList(Intlist L, int x){
        if (L == null){
            return null;
        }
        L.first = L.first + x;
        L.rest = incrList(L.rest, x);
        return L;
    }

    public int get(int index) {
        if (index == 0) {
            return first;
        }
        if (rest == null) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return rest.get(index - 1);
    }

    public static void main(String[] args){
        Intlist L = new Intlist(2, null);
        L = new Intlist(4, L);
        L = new Intlist(1, L);
        L = new Intlist(3,L);
        L = new Intlist(2,L);
        Intlist[] result = partition(L, 2);
        System.out.println(result[1].get(2));
    }
}
