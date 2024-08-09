import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regular_expressions.StateMachineFactory
import regular_expressions.Verification

class IntegerDetectorStrategyTests {

    val verification = Verification()
    val integerPointState = StateMachineFactory().crateStateMachine("integer")!!

    @Test
    fun testValidIntegers() {
        assertTrue(verification.verify("1",integerPointState))                     // Valid
        assertTrue(verification.verify("65448654321",integerPointState))           // Valid
        assertTrue(verification.verify("123",integerPointState))                   // Valid
        assertTrue(verification.verify("3452342352434534524346",integerPointState))// Valid
    }

    @Test
    fun testInvalidIntegers() {
        assertFalse(verification.verify("",integerPointState))                     // Empty string
        assertFalse(verification.verify("0123",integerPointState))                 // Starts with 0
        assertFalse(verification.verify("132a",integerPointState))                 // Contains invalid character
        assertFalse(verification.verify("0",integerPointState))                    // Starts with 0
    }
}