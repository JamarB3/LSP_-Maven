//Name: Jamar Bailey III
package org.howard.edu.lsp.assignment5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class IntegerSetTest {

    private IntegerSet integerSet;
    
    @BeforeEach
    //This sets up a new set to be tested for every method execution
    public void setUp() {
        integerSet = new IntegerSet();
        
    }

    @Test
    @DisplayName("Test case for clear")
    public void testClear() {
        integerSet.add(1);
        integerSet.add(2);
        integerSet.clear();
        Assertions.assertTrue(integerSet.isEmpty());
    }

    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        integerSet.add(1);
        integerSet.add(2);
        Assertions.assertEquals(2, integerSet.length());
    }

    @Test
    @DisplayName("Test case for equal")
    public void testEquals() {
        IntegerSet b = new IntegerSet();
        b.add(2);
        b.add(1);
        integerSet.add(1);
        integerSet.add(2);
        Assertions.assertTrue(integerSet.equals(b));
    }

    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        integerSet.add(1);
        Assertions.assertTrue(integerSet.contains(1));
        Assertions.assertFalse(integerSet.contains(2));
    }

    @Test
    @DisplayName("Test case for largest")
    public void testLargest() throws IntegerSetException {
        integerSet.add(1);
        integerSet.add(2);
        Assertions.assertEquals(2, integerSet.largest());
        
        
        IntegerSet emptySet = new IntegerSet();
        assertThrows(IntegerSetException.class, () -> emptySet.largest());
    }

    @Test
    @DisplayName("Test case for smallest")
    public void testSmallest() throws IntegerSetException {
        integerSet.add(1);
        integerSet.add(1);
        Assertions.assertEquals(1, integerSet.smallest());
        
        //Created emptySet to test for empty set edge case
        IntegerSet emptySet = new IntegerSet();
        assertThrows(IntegerSetException.class, () -> emptySet.smallest());
    }	

    @Test
    @DisplayName("Test case for add")
    public void testAdd() {
        integerSet.add(1);
        integerSet.add(1);
        Assertions.assertEquals(1, integerSet.length());

        //Edge cases, add negative
        integerSet.add(0);
        integerSet.add(-1);
        integerSet.add(-2);
        integerSet.add(-3);
        integerSet.add(-4);
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        integerSet.add(4);
        Assertions.assertEquals(9, integerSet.length());
    }

    @Test
    @DisplayName("Test case for remove")
    public void testRemove() throws IntegerSetException {
        integerSet.add(1);
        integerSet.remove(1);
        Assertions.assertTrue(integerSet.isEmpty());
    }
        
        

    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        integerSet.add(1);
        integerSet.add(2);
        IntegerSet intSetb = new IntegerSet();
        intSetb.add(3);
        intSetb.add(4);
        integerSet.union(intSetb);
        Assertions.assertEquals(4, integerSet.length());
    }

    @Test
    @DisplayName("Test case for intersect")
    public void testIntersect() {
        integerSet.add(1);
        integerSet.add(2);
        IntegerSet intSetb = new IntegerSet();
        intSetb.add(2);
        intSetb.add(3);
        integerSet.intersect(intSetb);
        Assertions.assertEquals(1, integerSet.length());
    }

    @Test
    @DisplayName("Test case for diff")
    public void testDiff() {
        integerSet.add(1);
        integerSet.add(2);
        IntegerSet intSetb = new IntegerSet();
        intSetb.add(2);
        intSetb.add(3);
        integerSet.diff(intSetb);
        Assertions.assertEquals(1, integerSet.length());
    }

    @Test
    @DisplayName("Test case for isEmpty")
    public void testIsEmpty() {
        Assertions.assertTrue(integerSet.isEmpty());
        integerSet.add(1);
        Assertions.assertFalse(integerSet.isEmpty());
    }

    @Test
    @DisplayName("Test case for toString")
    public void testToString() {
        integerSet.add(1);
        integerSet.add(2);
        Assertions.assertEquals("[1, 2]", integerSet.toString());
    }
}

