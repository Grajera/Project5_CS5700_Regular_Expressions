import detectors.Detectors.BinaryNumberDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import project5.Interfaces.Detector

class BinaryNumberDetectorStrategyTests {
    private val binaryDetector: Detector = BinaryNumberDetector()

    @Test
    fun testValidBinaries() {
        assertTrue(binaryDetector.isValid("1"))                      // Valid
        assertTrue(binaryDetector.isValid("11"))                     // Valid
        assertTrue(binaryDetector.isValid("101"))                    // Valid
        assertTrue(binaryDetector.isValid("111111"))                 // Valid
        assertTrue(binaryDetector.isValid("10011010001"))           // Valid
    }

    @Test
    fun testInvalidBinaries() {
        assertFalse(binaryDetector.isValid("01"))                    // Doesn't start with 1
        assertFalse(binaryDetector.isValid("10"))                    // Doesn't end with 1
        assertFalse(binaryDetector.isValid("1000010"))               // Doesn't end with 1
        assertFalse(binaryDetector.isValid("100a01"))                // Contains invalid character
    }
}
