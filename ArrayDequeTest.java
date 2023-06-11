package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addIsEmptySizeTest() {
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        deque.ArrayDeque<String> ad1 = new deque.ArrayDeque<String>();
        assertTrue("A newly initialized LLDeque should be empty", ad1.isEmpty());

        ad1.addFirst("front");
        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, ad1.size());
        assertFalse("lld1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("middle");
        assertEquals(2, ad1.size());

        ad1.addLast("back");
        assertEquals(3, ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        deque.ArrayDeque<Integer> ad2 = new deque.ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad2 should be empty upon initialization", ad2.isEmpty());

        ad2.addFirst(10);
        // should not be empty
        assertFalse("ad2 should contain 1 item", ad2.isEmpty());

        ad2.removeFirst();
        // should be empty
        assertTrue("ad2 should be empty after removal", ad2.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        deque.ArrayDeque<Integer> ad2 = new deque.ArrayDeque<>();
        ad2.addFirst(3);

        ad2.removeLast();
        ad2.removeFirst();
        ad2.removeLast();
        ad2.removeFirst();

        int size = ad2.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {

        deque.ArrayDeque<String>  lld1 = new deque.ArrayDeque<String>();
        deque.ArrayDeque<Double>  lld2 = new deque.ArrayDeque<Double>();
        deque.ArrayDeque<Boolean> lld3 = new deque.ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        deque.ArrayDeque<Integer> lld1 = new deque.ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        deque.ArrayDeque<Integer> lld1 = new deque.ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

    }
}
