import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regular_expressions.FirstStateFactory
import regular_expressions.Verifier

class IntegerDetectorStrategyTests {

    val verifier = Verifier()
    val integerPointState = FirstStateFactory().createFirstState("integer")!!

    @Test
    fun testValidIntegers() {
        assertTrue(verifier.verify("1",integerPointState))                     // Valid
        assertTrue(verifier.verify("65448654321",integerPointState))           // Valid
        assertTrue(verifier.verify("123",integerPointState))                   // Valid
        assertTrue(verifier.verify("3452342352434534524346",integerPointState))// Valid
    }

    @Test
    fun testInvalidIntegers() {
        assertFalse(verifier.verify("",integerPointState))                     // Empty string
        assertFalse(verifier.verify("0123",integerPointState))                 // Starts with 0
        assertFalse(verifier.verify("132a",integerPointState))                 // Contains invalid character
        assertFalse(verifier.verify("0",integerPointState))                    // Starts with 0
    }
}