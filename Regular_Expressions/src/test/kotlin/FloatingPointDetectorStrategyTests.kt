import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regular_expressions.FirstStateFactory
import regular_expressions.Verifier

class FloatingPointDetectorStrategyTests {
    val verifier = Verifier()
    val floatingPointState = FirstStateFactory().createFirstState("float")!!

    @Test
    fun testValidFloatingPoints() {
        assertTrue(verifier.verify("1.0", floatingPointState))                       // Valid
        assertTrue(verifier.verify("123.34", floatingPointState))                    // Valid
        assertTrue(verifier.verify("0.20000", floatingPointState))                   // Valid
        assertTrue(verifier.verify("12349871234.12340981234098", floatingPointState)) // Valid
        assertTrue(verifier.verify(".123", floatingPointState))                      // Valid
    }

    @Test
    fun testInvalidFloatingPoints() {
        assertFalse(verifier.verify("123", floatingPointState))                      // No period
        assertFalse(verifier.verify("123.123.", floatingPointState))                 // Too many periods
        assertFalse(verifier.verify("123.02a", floatingPointState))                  // Invalid character
        assertFalse(verifier.verify("123.", floatingPointState))                     // Nothing follows period
        assertFalse(verifier.verify("012.4", floatingPointState))                    // Starting 0 not followed by period
    }

}
