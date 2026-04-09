package main;

import org.junit.jupiter.api.Test;
import test.Bogie;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainApp {

    private List<Bogie> getSampleBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 54));
        list.add(new Bogie("First Class", 24));
        return list;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = TrainApp.filterBogiesByCapacity(getSampleBogies(), 70);
        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    private static List<Bogie> filterBogiesByCapacity(List<Bogie> sampleBogies, int i) {
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Test", 70));

        List<Bogie> result = TrainApp.filterBogiesByCapacity(list, 70);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = TrainApp.filterBogiesByCapacity(getSampleBogies(), 80);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC", 65));

        List<Bogie> result = TrainApp.filterBogiesByCapacity(list, 60);
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result = TrainApp.filterBogiesByCapacity(getSampleBogies(), 100);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result = TrainApp.filterBogiesByCapacity(getSampleBogies(), 10);
        assertEquals(3, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> result = TrainApp.filterBogiesByCapacity(new List<Bogie>(), 50);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();
        int sizeBefore = original.size();

        TrainApp.filterBogiesByCapacity(original, 60);

        assertEquals(sizeBefore, original.size());
    }
}