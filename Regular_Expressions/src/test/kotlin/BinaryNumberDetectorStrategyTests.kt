import detectors.Detectors.DetectorFactory
import detectors.Detectors.DetectorType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BinaryNumberDetectorStrategyTests {

    private val factory = DetectorFactory()

    @Test
    fun testValidBinaries() {
        val binaryDetector = factory.createDetector(DetectorType.BINARY_NUMBER)
        assertTrue(binaryDetector.isValid("1"))                      // Valid
        assertTrue(binaryDetector.isValid("11"))                     // Valid
        assertTrue(binaryDetector.isValid("101"))                    // Valid
        assertTrue(binaryDetector.isValid("111111"))                 // Valid
        assertTrue(binaryDetector.isValid("10011010001"))           // Valid
    }

    @Test
    fun testInvalidBinaries() {
        val binaryDetector = factory.createDetector(DetectorType.BINARY_NUMBER)
        assertFalse(binaryDetector.isValid("01"))                    // Doesn't start with 1
        assertFalse(binaryDetector.isValid("10"))                    // Doesn't end with 1
        assertFalse(binaryDetector.isValid("1000010"))               // Doesn't end with 1
        assertFalse(binaryDetector.isValid("100a01"))                // Contains invalid character
    }
}
