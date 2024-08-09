import detectors.Detectors.DetectorFactory
import detectors.Detectors.DetectorType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PasswordDetectorStrategyTests {

    private val factory = DetectorFactory()

    @Test
    fun testValidPasswords() {
        val passwordDetector = factory.createDetector(DetectorType.PASSWORD)
        assertTrue(passwordDetector.isValid("aaaaH!aa"))                   // Valid
        assertTrue(passwordDetector.isValid("1234567*9J"))                 // Valid
        assertTrue(passwordDetector.isValid("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH")) // Valid
    }

    @Test
    fun testInvalidPasswords() {
        val passwordDetector = factory.createDetector(DetectorType.PASSWORD)
        assertFalse(passwordDetector.isValid("a"))                          // Too short
        assertFalse(passwordDetector.isValid("aaaaaaa!"))                  // No capital letter and ends with special char
        assertFalse(passwordDetector.isValid("aaaHaaaaa"))                 // No special char
        assertFalse(passwordDetector.isValid("Abbbbbbb!"))                 // Ends with special char
    }
}
