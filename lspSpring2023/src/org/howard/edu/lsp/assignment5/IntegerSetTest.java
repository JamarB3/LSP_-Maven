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
    	
    	//Tests for clearing an already empty set
    	integerSet.clear();
        Assertions.assertTrue(integerSet.isEmpty());
    	
        integerSet.add(1);
        integerSet.add(2);
        integerSet.clear();
        Assertions.assertTrue(integerSet.isEmpty());
    }

    @Test
    @DisplayName("Test case for length")
    public void testLength() {
    	
    	
    	//Tests for empty set, should be 0
    	Assertions.assertEquals(0, integerSet.length());
    	
    	
        integerSet.add(1);
        integerSet.add(2);
        Assertions.assertEquals(2, integerSet.length());
        
        //Test case for a very large set
        for (int num = 1; num <= 100; num++) {
            integerSet.add(num);
        }
        Assertions.assertEquals(100, integerSet.length());
    }

    @Test
    @DisplayName("Test case for equal")
    public void testEquals() {
    	
    	
        IntegerSet b = new IntegerSet();
        //Tests empty set
        Assertions.assertTrue(integerSet.equals(b));
        
        b.add(2);
        b.add(1);
        integerSet.add(1);
        
        //Tests different size set
        Assertions.assertFalse(integerSet.equals(b));
        
        //Normal test, both should be equal by this point
        integerSet.add(2);
        Assertions.assertTrue(integerSet.equals(b));
        
        
        
        
    }

    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
    	
    	//Testing empty set contain
    	Assertions.assertFalse(integerSet.contains(1));
    	
        integerSet.add(1);
        Assertions.assertTrue(integerSet.contains(1));
        Assertions.assertFalse(integerSet.contains(2));
        
        //Tests multiple elements, some in and some not in the set
        integerSet.add(2);
        integerSet.add(3);
        Assertions.assertTrue(integerSet.contains(1));
        Assertions.assertTrue(integerSet.contains(2));
        Assertions.assertTrue(integerSet.contains(3));
        Assertions.assertFalse(integerSet.contains(4));
    }

    @Test
    @DisplayName("Test case for largest")
    public void testLargest() throws IntegerSetException {
        integerSet.add(1);
        integerSet.add(2);
        Assertions.assertEquals(2, integerSet.largest());
        
        //Tests exception
        IntegerSet emptySet = new IntegerSet();
        assertThrows(IntegerSetException.class, () -> emptySet.largest());
        
        
        //Test for duplicates
        integerSet.add(5);
        integerSet.add(5);
        Assertions.assertEquals(5, integerSet.largest());
       
        
        
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
        
       
    
        
        //Test case for smallest with negative elements
        integerSet.add(-3);
        integerSet.add(-1);
        integerSet.add(-2);
        Assertions.assertEquals(-3, integerSet.smallest());
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
    	
    	//Tests if empty
    	IntegerSet intSetc = new IntegerSet();
        integerSet.union(intSetc);
        Assertions.assertTrue(integerSet.isEmpty());
        
        
        
        integerSet.add(1);
        integerSet.add(2);
        IntegerSet intSetd = new IntegerSet();
        intSetd.add(3);
        intSetd.add(4);
        integerSet.union(intSetd);
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
        
        //Test case for intersect with no common elements
        integerSet.add(1);
        integerSet.add(2);
        IntegerSet intSetc = new IntegerSet();
        intSetc.add(3);
        intSetc.add(4);
        integerSet.intersect(intSetc);
        Assertions.assertTrue(integerSet.isEmpty());
        
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
        
        
     // Test case 2: diff with set having common elements
        integerSet.clear();
        integerSet.add(1);
        integerSet.add(2);
        IntegerSet intSetc = new IntegerSet();
        intSetc.add(2);
        intSetc.add(3);
        integerSet.diff(intSetc);
        Assertions.assertEquals(1, integerSet.length());
        Assertions.assertTrue(integerSet.contains(1));
        Assertions.assertFalse(integerSet.contains(2));
        Assertions.assertFalse(integerSet.contains(3));
        
        
        // Test case 3: diff with set having no common elements
        integerSet.clear();
        integerSet.add(1);
        integerSet.add(2);
        IntegerSet intSetd = new IntegerSet();
        intSetd.add(3);
        intSetd.add(4);
        integerSet.diff(intSetd);
        Assertions.assertEquals(2, integerSet.length());
        Assertions.assertTrue(integerSet.contains(1));
        Assertions.assertTrue(integerSet.contains(2));
        Assertions.assertFalse(integerSet.contains(3));
        Assertions.assertFalse(integerSet.contains(4));
    }

    @Test
    @DisplayName("Test case for isEmpty")
    public void testIsEmpty() {
        Assertions.assertTrue(integerSet.isEmpty());
        integerSet.add(1);
        Assertions.assertFalse(integerSet.isEmpty());
        
        //Test case for isEmpty with multiple items in the set
        integerSet.add(1);
        integerSet.add(2);
        Assertions.assertFalse(integerSet.isEmpty());
        
        
        //Test case for for removing from set, checking for empty
        integerSet.add(1);
        integerSet.add(2);
        integerSet.remove(1);
        integerSet.remove(2);
        Assertions.assertTrue(integerSet.isEmpty());
    }

    @Test
    @DisplayName("Test case for toString")
    public void testToString() {
    	
    	//For single element set
    	integerSet.add(1);
        Assertions.assertEquals("[1]", integerSet.toString());
        
        //For duo element set
        integerSet.add(1);
        integerSet.add(2);
        Assertions.assertEquals("[1, 2]", integerSet.toString());
        
        //For duplicates in Set
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(1);
        Assertions.assertEquals("[1, 2]", integerSet.toString());
        
    }
    
    
}

