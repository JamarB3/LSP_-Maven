//Name: Jamar Bailey III
package org.howard.edu.lsp.mid_term.problem51;



public class IntegerRange implements Range {
    private int lower;
   	private int upper;

	// Hint: implement getters for lower and upper

   	IntegerRange(int lower, int upper) { 	// Constructor
   		this.lower = lower;
   		this.upper = upper;
   	 }
   	//Gets lower
   	public int getLower() {
        return lower;
    }
   	//gets upper
    public int getUpper() {
        return upper;
    }
    
    // returns true if the receiver contains at least 
    // one value in common with other, and false otherwise 
    //  EmptyRangeException is thrown when a null Range object is passed to the method
   	public boolean contains(int value) {
   		return (value >= lower && value <= upper);
	}
   	
   	
   	public boolean overlaps(Range other) throws EmptyRangeException {
   		if (other == null) {
            throw new EmptyRangeException("The range object which was passed is null");
        }
        int otherLower = other.getLower();
        int otherUpper = other.getUpper();
        return (lower <= otherUpper && otherLower <= upper);
	}
   	
   	// returns the number of integers in the range
   	public int size()  {
   		return (upper - lower + 1);
	}
}


 
   