package test;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UC13ComparisonTest {

    private List<Bogie> createData() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 50),
                new Bogie("First Class", 80),
                new Bogie("Goods", 40)
        );
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> data = createData();
        List<Bogie> result = UC13Comparison.filterWithLoop(data);

        for (Bogie b : result) {
            assertTrue(b.getCapacity() > 60);
        }
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> data = createData();
        List<Bogie> result = UC13Comparison.filterWithStream(data);

        for (Bogie b : result) {
            assertTrue(b.getCapacity() > 60);
        }
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> data = createData();

        List<Bogie> loopResult = UC13Comparison.filterWithLoop(data);
        List<Bogie> streamResult = UC13Comparison.filterWithStream(data);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> data = createData();

        long start = System.nanoTime();
        UC13Comparison.filterWithLoop(data);
        long end = System.nanoTime();

        assertTrue((end - start) > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bigData = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            bigData.add(new Bogie("Sleeper", 72));
            bigData.add(new Bogie("AC", 55));
        }

        List<Bogie> result = UC13Comparison.filterWithLoop(bigData);

        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}