import detectors.Detectors.DetectorFactory
import detectors.Detectors.DetectorType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FloatingPointDetectorStrategyTests {
    private val factory = DetectorFactory()

    @Test
    fun testValidFloatingPoints() {
        val floatingPointDetector = factory.createDetector(DetectorType.FLOATING_POINT)
        assertTrue(floatingPointDetector.isValid("1.0"))                       // Valid
        assertTrue(floatingPointDetector.isValid("123.34"))                    // Valid
        assertTrue(floatingPointDetector.isValid("0.20000"))                   // Valid
        assertTrue(floatingPointDetector.isValid("12349871234.12340981234098")) // Valid
        assertTrue(floatingPointDetector.isValid(".123"))                      // Valid
    }

    @Test
    fun testInvalidFloatingPoints() {
        val floatingPointDetector = factory.createDetector(DetectorType.FLOATING_POINT)
        assertFalse(floatingPointDetector.isValid("123"))                      // No period
        assertFalse(floatingPointDetector.isValid("123.123."))                 // Too many periods
        assertFalse(floatingPointDetector.isValid("123.02a"))                  // Invalid character
        assertFalse(floatingPointDetector.isValid("123."))                     // Nothing follows period
        assertFalse(floatingPointDetector.isValid("012.4"))                    // Starting 0 not followed by period
    }

}
