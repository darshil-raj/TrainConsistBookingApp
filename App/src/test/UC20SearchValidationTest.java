package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC20SearchValidationTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] data = {};

        Exception ex = assertThrows(IllegalStateException.class, () -> {
            UC20SearchValidation.searchBogie(data, "BG101");
        });

        assertEquals("No bogies available for search", ex.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] data = {"BG101","BG205"};

        assertDoesNotThrow(() -> {
            UC20SearchValidation.searchBogie(data, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] data = {"BG101","BG205","BG309"};

        assertTrue(UC20SearchValidation.searchBogie(data, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] data = {"BG101","BG205","BG309"};

        assertFalse(UC20SearchValidation.searchBogie(data, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] data = {"BG101"};

        assertTrue(UC20SearchValidation.searchBogie(data, "BG101"));
    }
}