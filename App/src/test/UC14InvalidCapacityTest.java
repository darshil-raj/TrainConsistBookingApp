package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC14InvalidCapacityTest {

    @Test
    void testException_ValidCapacityCreation() throws InvalidCapacityException {
        PassengerBogie b = new PassengerBogie("Sleeper", 72);
        assertNotNull(b);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Sleeper", -10);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("AC", 0);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("First Class", -1);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie b = new PassengerBogie("Sleeper", 72);

        assertEquals("Sleeper", b.getType());
        assertEquals(72, b.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
        PassengerBogie b2 = new PassengerBogie("AC", 60);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}