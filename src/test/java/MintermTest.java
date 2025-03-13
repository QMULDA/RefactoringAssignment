import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vsapry.Model.Minterm;

import static org.junit.jupiter.api.Assertions.*;

public class MintermTest {

    private Minterm minTermA;
    private Minterm minTermB;

    @BeforeEach
    void setUp() {
        minTermA = new Minterm("0000");
        minTermB = new Minterm("1111");
    }

    @Test
    void testIntegersToString() {
        assertEquals("0000", minTermA.toString());
        assertEquals("1111", minTermB.toString());
    }

    @Test
    void testIsSameTrue() {
        Minterm anotherA = new Minterm("0000");
        assertTrue(minTermA.isSame(anotherA));
    }

    @Test
    void testIsSameFalse() {
        assertFalse(minTermA.isSame(minTermB));
    }


    @Test
    void testIsSameThrowsExceptionWhenLengthMintermsMismatched() {
        Minterm twoChars = new Minterm("00");
        assertThrows(IllegalArgumentException.class, () -> {minTermA.isSame(twoChars);});
    }

    @Test
    void testNumberOfDifferencesBetweenMintermsIs1() {
        Minterm a = new Minterm("0000");
        Minterm b = new Minterm("0001");
        int numberOfDifferences = a.numberOfDifferencesBetweenMinterms(b);
        assertEquals(1, numberOfDifferences);
    }

    @Test
    void testNumberOfDifferencesBetweenMintermsIs3(){
        Minterm a = new Minterm("0000");
        Minterm b = new Minterm("0111");

        assertEquals(3, a.numberOfDifferencesBetweenMinterms(b));
    }

    @Test
    void testNumberOfDifferencesBetweenMintermsThrowsException(){
        Minterm twoChars = new Minterm("00");
        assertThrows(IllegalArgumentException.class, () -> {minTermA.numberOfDifferencesBetweenMinterms(twoChars);});
    }

    @Test
    void testCombine(){
        Minterm a = new Minterm("0111");
        Minterm b = new Minterm("1111");

        assertEquals("_111", Minterm.combine(a, b).toString());
    }

}
