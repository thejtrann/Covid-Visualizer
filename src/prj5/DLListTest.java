// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Group 152 (Anvitha, Jason, Xinbei)

package prj5;

import java.util.Iterator;
import student.TestCase;
import java.util.NoSuchElementException;

/**
 * Doubly linked list tests.
 * 
 * @author Jason Tran (thejtrann)
 * @author Anvitha Anumolu (anvithanumolu)
 * @author Xinbei Zhu (helen19)
 * 
 * @version 11/21/2020
 *
 */
public class DLListTest extends TestCase {
    /**
     * the list we will be using
     */
    private DLList<String> list;
    private DLList<String> list2;

    /**
     * run before every test case
     */
    @Override
    public void setUp() {
        list = new DLList<String>();
        list2 = new DLList<String>();
    }


    /**
     * Tests that an IndexOutOfBounds exception is thrown when the index is
     * greater than or equal to size and less than zero
     */
    public void testRemoveException() {
        list.add("A");
        Exception e = null;
        try {
            list.remove(2);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.remove(-1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests that objects can be removed at the beginning and end and that the
     * size is changed
     */
    public void testRemoveIndex() {
        list.add("A");
        list.add("B");
        assertTrue(list.remove(1));
        assertEquals(1, list.size());
        list.add("B");
        assertTrue(list.remove(0));
        assertEquals(1, list.size());
    }


    /**
     * Tests the add method. Ensures that it adds the object is added at the end
     * and the size is increased
     */
    public void testAdd() {
        assertEquals(0, list.size());
        list.add("A");
        assertEquals(1, list.size());
        list.add("B");
        assertEquals(2, list.size());
        assertEquals("B", list.get(1));

    }


    /**
     * Tests that objects can be added at the beginning and end and that they
     * are placed correctly
     */
    public void testAddIndex() {
        list.add("B");
        list.add(0, "A");
        assertEquals("A", list.get(0));
        assertEquals(2, list.size());
        list.add(2, "D");
        assertEquals("D", list.get(2));
        list.add(2, "C");
        assertEquals("C", list.get(2));
    }


    /**
     * This tests that the add method throws a null pointer exception when
     * adding null data to the list
     */
    public void testAddNullException() {
        Exception e = null;
        try {
            list.add(null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests that the add method throws a Invalid argument when adding null
     * data to the list
     */
    public void testAddIndexNullException() {
        Exception e = null;
        try {
            list.add(0, null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests when the add method is called and the index is greater than
     * size or less than zero
     */
    public void testAddException() {
        list.add("A");
        Exception e = null;
        try {
            list.add(2, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.add(-1, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests removing a object changes the size appropiately and that you can
     * remove the first and last elements
     */
    public void testRemoveObj() {
        assertFalse(list.remove(null));
        list.add("A");
        list.add("B");
        assertTrue(list.remove("A"));
        assertEquals("B", list.get(0));
        assertEquals(1, list.size());
        list.add("C");
        assertTrue(list.remove("C"));
        assertEquals("B", list.get(0));
    }


    /**
     * Tests get when the index is greater than or equal to size and when the
     * index is less than zero
     */
    public void testGetException() {
        Exception exception = null;
        try {
            list.get(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        list.add("A");
        try {
            list.get(1);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test contains when it does and does not contain the object
     */
    public void testContains() {
        assertFalse(list.contains("A"));
        list.add("A");
        assertTrue(list.contains("A"));
        assertFalse(list.contains("B"));
        list.add("B");
        assertTrue(list.contains("B"));
    }

    /**
     * Test lastIndexOf when the list is empty, when the object is not in the
     * list, and when it is at the beginning or end
     */
    public void testLastIndexOf() {
        assertEquals(-1, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(0, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(1, list.lastIndexOf("A"));
        list.add("B");
        assertEquals(1, list.lastIndexOf("A"));
        assertEquals(2, list.lastIndexOf("B"));
        list.add("A");
        assertEquals(3, list.lastIndexOf("A"));
    }


    /**
     * Tests isEmpty when empty and full
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }


    /**
     * Ensures that all of the objects are cleared and the size is changed
     */
    public void testClear() {
        list.add("A");
        list.clear();
        assertEquals(0, list.size());
        assertFalse(list.contains("A"));
    }


    /**
     * Tests the toString when there are 0, 1, and 2 objects in the list
     */
    public void testToString() {
        assertEquals("{}", list.toString());
        list.add("A");
        assertEquals("{A}", list.toString());
        list.add("B");
        assertEquals("{A, B}", list.toString());
    }


    /**
     * Tests removing from an empty list
     */
    public void testRemoveFromEmpty() {
        list.add("dance");
        list.add(0, "safety");
        list.clear();
        assertFalse(list.remove("safety"));
        Exception exception;
        exception = null;
        try {
            list.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        DLList<String> emptyList = new DLList<String>();
        exception = null;
        try {
            emptyList.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the boolean hasNext() method.
     */
    public void testHasNextIterator() {

        Iterator<String> iterator = list.iterator();
        Iterator<String> iter = list2.iterator();

        assertFalse(iterator.hasNext());

        // adding to our list to check if hasNext() is true
        list2.add("obj1");
        list2.add("obj2");
        list2.add("obj3");

        assertTrue(iter.hasNext());
    }


    /**
     * Tests the iteratorNext() method.
     */
    public void testIteratorNext() {
        Iterator<String> iter = list2.iterator();

        // adding to our list to check iteratorNext() outputs
        list2.add("obj1");
        list2.add("obj2");
        list2.add("obj3");

        assertEquals("obj1", iter.next());
        assertEquals("obj2", iter.next());
        assertEquals("obj3", iter.next());
    }


    /**
     * Tests indexOutOfBounds exception.
     */
    public void testNextException() {
        Iterator<String> iter = list.iterator();

        // creating a null exception variable
        Exception e = null;

        try {
            iter.next();
        }
        catch (Exception exc) {
            e = exc;
        }
        // checking if e was thrown and if type was correct
        assertTrue(e instanceof NoSuchElementException);
    }


    /**
     * Tests the NoSuchElementException thrown.
     */
    public void testNextExceptionIterator() {
        Iterator<String> iter = list.iterator();

        // adding to list beforehand
        list.add("obj1");
        list.add("obj2");
        list.add("obj3");

        Exception e = null; // creating null exception object
        try {
            for (int i = 0; i <= 3; i++) {
                iter.next();
            }
        }
        catch (Exception exc) {
            e = exc;
        }
        // checking if e was thrown and if type was correct
        assertTrue(e instanceof NoSuchElementException);
    }


    /**
     * Tests the remove() function.
     */
    public void testRemoveIterator() {
        Iterator<String> iter = list.iterator();

        list.add("obj1");
        list.add("obj2");
        list.add("obj3");

        Exception e = null; // creating null exception object
        try {
            iter.remove();
        }
        catch (Exception exc) {
            e = exc;
        }
        // checking if e was thrown and if type was correct
        assertTrue(e instanceof IllegalStateException);
    }


    /**
     * Tests remove() to see if it functions properly!
     */
    public void testRemove() {
        Iterator<String> iter = list.iterator();

        // adding 3 strings to the list
        list.add("obj1");
        list.add("obj2");
        list.add("obj3");

        assertEquals("obj1", iter.next());
        // calling remove() below to remove obj1 from list
        iter.remove();

        assertFalse(list.contains("obj1"));
    }
}
