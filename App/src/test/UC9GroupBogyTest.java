package test;

import main.UC9GroupBogy.Bogie;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UC9GroupBogyTest {

    // Helper method to get test bogies
    private List<Bogie> getTestBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 78),
                new Bogie("First Class", 54),
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 80)
        );
    }

    @Test
    public void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = getTestBogies();

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("First Class"));

        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("AC Chair").size());
        assertEquals(1, grouped.get("First Class").size());
    }

    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = getTestBogies();

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        List<Bogie> sleeperBogies = grouped.get("Sleeper");
        assertEquals(2, sleeperBogies.size());
    }

    @Test
    public void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = getTestBogies();

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        Set<String> keys = grouped.keySet();
        assertEquals(3, keys.size());
        assertTrue(keys.containsAll(Arrays.asList("Sleeper", "AC Chair", "First Class")));
    }

    @Test
    public void testGrouping_EmptyBogieList() {
        List<Bogie> emptyList = Collections.emptyList();

        Map<String, List<Bogie>> grouped = emptyList.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(grouped.isEmpty());
    }

    @Test
    public void testGrouping_SingleBogieCategory() {
        List<Bogie> singleCategoryList = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );

        Map<String, List<Bogie>> grouped = singleCategoryList.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(1, grouped.size());
        assertTrue(grouped.containsKey("Sleeper"));
        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = getTestBogies();

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        // Original list size unchanged
        assertEquals(5, bogies.size());
        // Original list contents unchanged
        assertEquals("Sleeper", bogies.get(0).getType());
        assertEquals("AC Chair", bogies.get(1).getType());
    }
}