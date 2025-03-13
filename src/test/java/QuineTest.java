import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vsapry.Model.MinTerm;
import org.vsapry.Model.Quine;

import javax.naming.LimitExceededException;

import static org.junit.jupiter.api.Assertions.*;

public class QuineTest {

    private Quine quine;

    @BeforeEach
    void setUp() {
        quine = new Quine();
    }

    @Test
    public void testAddTerm() throws LimitExceededException {
        quine.addTerm("0");
        quine.addTerm("1");

        assertEquals(2, quine.numMinTermsInTerm);

        assertTrue(quine.hasTerm(new MinTerm("0")));
        assertTrue(quine.hasTerm(new MinTerm("1")));
    }

    @Test
    public void testExceptionThrownIfAddTermExceedsMax() throws LimitExceededException {
        for (int i = 0; i < 255; i++) {
            quine.addTerm(String.valueOf(i));
        }

        assertThrows(LimitExceededException.class, () -> quine.addTerm("255"));
    }

    @Test
    void testAddTermWithDuplicateTerms() throws LimitExceededException {
        quine.addTerm("0");
        quine.addTerm("0");

        assertEquals(2, quine.numMinTermsInTerm);
    }

    @Test
    public void testToString() throws LimitExceededException {
        quine.addTerm("0000");
        quine.addTerm("1111");

        String output = quine.toString();
        assertNotNull(output);
        assertFalse(output.isBlank());

        assertTrue(output.contains("0"), "Expected '0' in the output string.");
        assertTrue(output.contains("1"), "Expected '1' in the output string.");
    }

    @Test
    void testHasTermWhenTermDoesNotExistReturnsFalse() throws LimitExceededException {
        quine.addTerm("0");

        assertFalse(quine.hasTerm(new MinTerm("1")));
    }


    @Test
    public void testSimplifyAndReduce() throws LimitExceededException {
        quine.addTerm("0");
        quine.addTerm("1");

        quine.simplify();

        assertTrue(quine.numMinTermsInTerm > 0, "There should be at least one prime implicant");
        assertTrue(quine.numMinTermsInTerm <= 4, "Some minterms should be combined, so count should be <= 4.");
    }

    @Test
    void testNoMergesInReduceFunctionWhenMinTermsDifferInMoreThan1Bit() throws LimitExceededException {
        quine.addTerm("000");
        quine.addTerm("111");

        quine.simplify();
        assertEquals(2, quine.numMinTermsInTerm);
    }

    @Test
    void testReduceSingleMergeWhenMinTermsDifferBy1Bit() throws LimitExceededException {
        quine.addTerm("000");
        quine.addTerm("001");

        quine.simplify();
        assertEquals(1, quine.numMinTermsInTerm);
        assertTrue(quine.toString().contains("00_"));
    }

    @Test
    void testReduce1OccurenceOfAMerge() throws LimitExceededException {
        quine.addTerm("000");
        quine.addTerm("001");
        quine.addTerm("010");

        quine.simplify();
        assertTrue(quine.toString().contains("0_0"));
        assertTrue(quine.toString().contains("00_"));
    }

    @Test
    void testReduce2OccurencesOfMerges() throws LimitExceededException {
        quine.addTerm("000");
        quine.addTerm("001");
        quine.addTerm("010");
        quine.addTerm("101");

        quine.simplify();
        assertEquals(3, quine.numMinTermsInTerm);
    }
}