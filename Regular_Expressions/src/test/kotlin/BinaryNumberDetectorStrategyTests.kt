import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regular_expressions.FirstStateFactory
import regular_expressions.Verifier

class BinaryNumberDetectorStrategyTests {
    val verifier = Verifier()
    val binaryState = FirstStateFactory().createFirstState("binary")!!

    @Test
    fun testValidBinaries() {
        assertTrue(verifier.verify("1", binaryState))
        assertTrue(verifier.verify("11", binaryState))
        assertTrue(verifier.verify("101", binaryState))
        assertTrue(verifier.verify("111111", binaryState))
        assertTrue(verifier.verify("10011010001", binaryState))
    }

    @Test
    fun testInvalidBinaries() {
        assertFalse(verifier.verify("01", binaryState))
        assertFalse(verifier.verify("10", binaryState))
        assertFalse(verifier.verify("1000010", binaryState))
        assertFalse(verifier.verify("100a01", binaryState))
    }
}
