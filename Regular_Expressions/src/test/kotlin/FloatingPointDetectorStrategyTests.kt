import detectors.Detectors.EmailDetector
import detectors.Detectors.FloatingPointDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regular_expressions.Detector
import regular_expressions.StateMachineFactory
import regular_expressions.Verification

class FloatingPointDetectorStrategyTests {
    private val FloatingPointDetector: Detector = FloatingPointDetector()

    @Test
    fun testValidFloatingPoints() {
        assertTrue(FloatingPointDetector.isValid("1.0"))                       // Valid
        assertTrue(FloatingPointDetector.isValid("123.34"))                    // Valid
        assertTrue(FloatingPointDetector.isValid("0.20000"))                   // Valid
        assertTrue(FloatingPointDetector.isValid("12349871234.12340981234098")) // Valid
        assertTrue(FloatingPointDetector.isValid(".123"))                      // Valid
    }

    @Test
    fun testInvalidFloatingPoints() {
        assertFalse(FloatingPointDetector.isValid("123"))                      // No period
        assertFalse(FloatingPointDetector.isValid("123.123."))                 // Too many periods
        assertFalse(FloatingPointDetector.isValid("123.02a"))                  // Invalid character
        assertFalse(FloatingPointDetector.isValid("123."))                     // Nothing follows period
        assertFalse(FloatingPointDetector.isValid("012.4"))                    // Starting 0 not followed by period
    }

}
