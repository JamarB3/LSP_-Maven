//Name: Jamar Bailey III
package org.howard.edu.lsp.mid_term.problem51;



/* 
A Range objects represents an integer range, such as 1-10 or 50701-50799. The lower and
upper bounds of a Range are given at the time the object is created. 
*/ 

public interface Range { 
	public boolean contains( int value );  
    // returns true if v is ≥ lower bound and ≤ upper bound, 
    // and false otherwise 
	public boolean overlaps( Range other ) throws EmptyRangeException; 
    // returns true if the receiver contains at least 
    // one value in common with other, and false otherwise 
    //  EmptyRangeException is thrown when a null Range object is passed to the method
	public int size(); 
    // returns the number of integers in the range
	public int getLower();    
    public int getUpper();    
}

