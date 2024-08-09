import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regular_expressions.StateMachineFactory
import regular_expressions.Verification

class BinaryNumberDetectorStrategyTests {
    val verification = Verification()
    val binaryState = StateMachineFactory().crateStateMachine("binary")!!

    @Test
    fun testValidBinaries() {
        assertTrue(verification.verify("1", binaryState))
        assertTrue(verification.verify("11", binaryState))
        assertTrue(verification.verify("101", binaryState))
        assertTrue(verification.verify("111111", binaryState))
        assertTrue(verification.verify("10011010001", binaryState))
    }

    @Test
    fun testInvalidBinaries() {
        assertFalse(verification.verify("01", binaryState))
        assertFalse(verification.verify("10", binaryState))
        assertFalse(verification.verify("1000010", binaryState))
        assertFalse(verification.verify("100a01", binaryState))
    }
}
