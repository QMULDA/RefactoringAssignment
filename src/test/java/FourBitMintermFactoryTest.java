import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vsapry.Model.BitFactories.FourBitMintermFactory;
import org.vsapry.Model.Minterm;

import static org.junit.jupiter.api.Assertions.*;

class FourBitMintermFactoryTest {

    private FourBitMintermFactory factory;

    @BeforeEach
    void setUp() {
        factory = new FourBitMintermFactory();
    }

    @Test
    void testCreateMintermWithValidInputs() {
        Minterm zero = factory.createMinterm(0);
        assertEquals("0000", zero.toString());

        Minterm one = factory.createMinterm(1);
        assertEquals("0001", one.toString());

        Minterm fifteen = factory.createMinterm(15);
        assertEquals("1111", fifteen.toString());
    }

    @Test
    void testCreateMintermThrowsExceptionWhenTooSmall() {
        assertThrows(IllegalArgumentException.class, () -> factory.createMinterm(-1));
    }

    @Test
    void testCreateMintermThrowsExceptionWhenTooLarge() {
        assertThrows(IllegalArgumentException.class, () -> factory.createMinterm(16));
    }
}
