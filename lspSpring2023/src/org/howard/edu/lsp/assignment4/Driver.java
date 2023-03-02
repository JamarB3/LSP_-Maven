//Name: Jamar Bailey III
package org.howard.edu.lsp.assignment4;

import java.util.Scanner;

/**
 * The Driver utilizes test cases stored inside itself and the methods created in IntegerSet.java.
 * Test cases are ran here with basic ones presented below.
 * @return set
 */
public class Driver {

    public static void main(String[] args) {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();

        // test adding and removing elements from a set
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        setA.add(5);
        System.out.println("Set A after adding 1, 2, 3, 4, 5: " + setA.toString());
        setA.remove(3);
        setA.remove(5);
        System.out.println("Set A after removing 3, 5: " + setA.toString());

        // tests union, intersection, and difference operations
        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(6);
        System.out.println("Set B: " + setB.toString());
        setA.union(setB);
        System.out.println("Set A after union with B: " + setA.toString());
        setA.intersect(setB);
        System.out.println("Set A after intersection with B: " + setA.toString());
        setA.diff(setB);
        System.out.println("Set A after difference with B: " + setA.toString());

        // tests the largest and smallest element operations
        setA.add(7);
        setA.add(8);
        setA.add(9);
        try {
            System.out.println("Largest element in set A: " + setA.largest());
            System.out.println("Smallest element in set A: " + setA.smallest());
        } catch (IntegerSetException e) {
            System.out.println(e.getMessage());
        }

        // test the equals and isEmpty operations
        setB.clear();
        setB.add(8);
        setB.add(9);
        setB.add(7);
        System.out.println("Set B after adding 8, 9, 7: " + setB.toString());
        System.out.println("Is set A equal to set B? " + setA.equals(setB));
        System.out.println("Is set A empty? " + setA.isEmpty());
    }

}



