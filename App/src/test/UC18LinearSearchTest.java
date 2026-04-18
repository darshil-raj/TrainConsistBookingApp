package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC18LinearSearchTest {

    @Test
    void testSearch_BogieFound() {
        String[] data = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(UC18LinearSearch.linearSearch(data, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] data = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(UC18LinearSearch.linearSearch(data, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] data = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(UC18LinearSearch.linearSearch(data, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] data = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(UC18LinearSearch.linearSearch(data, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] data = {"BG101"};

        assertTrue(UC18LinearSearch.linearSearch(data, "BG101"));
    }
}