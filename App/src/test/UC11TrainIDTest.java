import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UC11TrainIDTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(UC11TrainID.isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(UC11TrainID.isValidTrainId("TRAIN12"));
        assertFalse(UC11TrainID.isValidTrainId("TRN12A"));
        assertFalse(UC11TrainID.isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(UC11TrainID.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UC11TrainID.isValidCargoCode("PET-ab"));
        assertFalse(UC11TrainID.isValidCargoCode("PET123"));
        assertFalse(UC11TrainID.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UC11TrainID.isValidTrainId("TRN-123"));
        assertFalse(UC11TrainID.isValidTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UC11TrainID.isValidCargoCode("PET-Ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(UC11TrainID.isValidTrainId(""));
        assertFalse(UC11TrainID.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(UC11TrainID.isValidTrainId("TRN-1234XYZ"));
        assertFalse(UC11TrainID.isValidCargoCode("PET-AB123"));
    }
}