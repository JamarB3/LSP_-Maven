//Name: Jamar Bailey III

package org.howard.edu.lsp.mid_term.problem51;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class IntegerRangeTest {
	
	@Test
	@DisplayName("tests contains")
    void testContains() {
        IntegerRange range = new IntegerRange(1, 10);
        Assertions.assertTrue(range.contains(5));
        Assertions.assertFalse(range.contains(15));
    }

    @Test
    @DisplayName("tests overlaps")
    void testOverlaps() throws EmptyRangeException {
        IntegerRange range1 = new IntegerRange(1, 10);
        IntegerRange range2 = new IntegerRange(5, 15);

        Assertions.assertTrue(range1.overlaps(range2));
        Assertions.assertTrue(range2.overlaps(range1));
    }

    @Test
    @DisplayName("tests size")
    void testSize() {
        IntegerRange range = new IntegerRange(1, 10);
        Assertions.assertEquals(10, range.size());
    }

    
}
