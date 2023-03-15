//Name: Jamar Bailey III

package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents an integer set, which is a collection of integers.
 * It provides methods for adding, removing, and manipulating the set.
 * @author Jamar
 */

public class IntegerSet {
    // Hint: probably best to use an array list.  You will need to do a little research
    private List<Integer> set = new ArrayList<Integer>();

    // Default Constructor
    public IntegerSet() {
    }

    // Clears the internal representation of the set
    public void clear() {
        set.clear();
    }

    // Returns length of the set
    public int length() {
        return set.size();
    }

    /*
     * Returns true if the 2 sets are equal, false otherwise; Two sets are equal if they contain all of the
     * same values in ANY order.
     */
    public boolean equals(IntegerSet b) {
        return set.containsAll(b.set) && b.set.containsAll(set);
    }

    // Returns true if the set contains the value, otherwise false
    public boolean contains(int value) {
        return set.contains(value);
    }

    // Returns the largest item in the set; Throws the IntegerSetException if the set is empty
    public int largest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("The set is empty");
        }
        return set.stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    // Returns the smallest item in set; Throws a IntegerSetException if the set is empty
    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("The set is empty");
        }
        return set.stream().mapToInt(Integer::intValue).min().getAsInt();
    }

    // Adds an item to the set or does nothing it already there
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    // Removes an item from the set, otherwise do nothing if not there
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    // Set union
    public void union(IntegerSet intSetb) {
        set.addAll(intSetb.set);
    }

    // Set intersection
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    // Set difference, i.e., s1 –s2
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    // Returns true if the set is empty, false otherwise
    boolean isEmpty() {
        return set.isEmpty();
    }

    // Return String representation of your set
    public String toString() {
        return set.toString();
    }
}