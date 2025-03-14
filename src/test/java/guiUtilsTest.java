import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vsapry.View.guiUtils;

import static org.junit.jupiter.api.Assertions.*;

class guiUtilsTest {

    private guiUtils utils;

    @BeforeEach
    void setUp() {
        utils = new guiUtils();
    }

    @Test
    void testBoundaryValidInputRange() {
        boolean valid = utils.validateInput(4, 0);
        assertTrue(valid, "0 should be valid for 4 bits");

        valid = utils.validateInput(4, 15);
        assertTrue(valid, "15 should be valid for 4 bits");
    }

    @Test
    void testInputBelowRange() {
        boolean valid = utils.validateInput(4, -1);
        assertFalse(valid, "-1 should be invalid for 4 bits");
    }

    @Test
    void testInputAboveRange() {
        boolean valid = utils.validateInput(4, 16);
        assertFalse(valid, "16 should be invalid for 4 bits");
    }

    @Test
    void testValidateInputThreeBits() {
        assertTrue(utils.validateInput(3, 7));
        assertFalse(utils.validateInput(3, 8));
    }

    @Test
    void testValidateInputFiveBits() {
        assertTrue(utils.validateInput(5, 31));
        assertFalse(utils.validateInput(5, 32));
    }
}
