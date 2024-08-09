import detectors.Detectors.EmailDetector
import detectors.Detectors.IntegerDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regular_expressions.Detector
import regular_expressions.StateMachineFactory
import regular_expressions.Verification

class IntegerDetectorStrategyTests {

    private val IntegerDetector: Detector = IntegerDetector()

    @Test
    fun testValidIntegers() {
        assertTrue(IntegerDetector.isValid("1"))                     // Valid
        assertTrue(IntegerDetector.isValid("65448654321"))           // Valid
        assertTrue(IntegerDetector.isValid("123"))                   // Valid
        assertTrue(IntegerDetector.isValid("3452342352434534524346"))// Valid
    }

    @Test
    fun testInvalidIntegers() {
        assertFalse(IntegerDetector.isValid(""))                     // Empty string
        assertFalse(IntegerDetector.isValid("0123"))                 // Starts with 0
        assertFalse(IntegerDetector.isValid("132a"))                 // Contains invalid character
        assertFalse(IntegerDetector.isValid("0"))                    // Starts with 0
    }
}