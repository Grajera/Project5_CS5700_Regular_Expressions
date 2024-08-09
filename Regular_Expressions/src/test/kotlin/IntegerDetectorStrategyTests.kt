import detectors.Detectors.DetectorFactory
import detectors.Detectors.DetectorType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IntegerDetectorStrategyTests {

    private val factory = DetectorFactory()

    @Test
    fun testValidIntegers() {
        val integerDetector = factory.createDetector(DetectorType.INTEGER)
        assertTrue(integerDetector.isValid("1"))                     // Valid
        assertTrue(integerDetector.isValid("65448654321"))           // Valid
        assertTrue(integerDetector.isValid("123"))                   // Valid
        assertTrue(integerDetector.isValid("3452342352434534524346"))// Valid
    }

    @Test
    fun testInvalidIntegers() {
        val integerDetector = factory.createDetector(DetectorType.INTEGER)
        assertFalse(integerDetector.isValid(""))                     // Empty string
        assertFalse(integerDetector.isValid("0123"))                 // Starts with 0
        assertFalse(integerDetector.isValid("132a"))                 // Contains invalid character
        assertFalse(integerDetector.isValid("0"))                    // Starts with 0
    }
}