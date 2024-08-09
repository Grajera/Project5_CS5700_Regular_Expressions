import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regular_expressions.StateMachineFactory
import regular_expressions.Verification

class FloatingPointDetectorStrategyTests {
    val verification = Verification()
    val floatingPointState = StateMachineFactory().crateStateMachine("float")!!

    @Test
    fun testValidFloatingPoints() {
        assertTrue(verification.verify("1.0", floatingPointState))                       // Valid
        assertTrue(verification.verify("123.34", floatingPointState))                    // Valid
        assertTrue(verification.verify("0.20000", floatingPointState))                   // Valid
        assertTrue(verification.verify("12349871234.12340981234098", floatingPointState)) // Valid
        assertTrue(verification.verify(".123", floatingPointState))                      // Valid
    }

    @Test
    fun testInvalidFloatingPoints() {
        assertFalse(verification.verify("123", floatingPointState))                      // No period
        assertFalse(verification.verify("123.123.", floatingPointState))                 // Too many periods
        assertFalse(verification.verify("123.02a", floatingPointState))                  // Invalid character
        assertFalse(verification.verify("123.", floatingPointState))                     // Nothing follows period
        assertFalse(verification.verify("012.4", floatingPointState))                    // Starting 0 not followed by period
    }

}
