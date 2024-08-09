import detectors.Detectors.PasswordDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import project5.Interfaces.Detector

class PasswordDetectorStrategyTests {

    private val PasswordDetector: Detector = PasswordDetector()

    @Test
    fun testValidPasswords() {
        assertTrue(PasswordDetector.isValid("aaaaH!aa"))                   // Valid
        assertTrue(PasswordDetector.isValid("1234567*9J"))                 // Valid
        assertTrue(PasswordDetector.isValid("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH")) // Valid
    }

    @Test
    fun testInvalidPasswords() {
        assertFalse(PasswordDetector.isValid("a"))                          // Too short
        assertFalse(PasswordDetector.isValid("aaaaaaa!"))                  // No capital letter and ends with special char
        assertFalse(PasswordDetector.isValid("aaaHaaaaa"))                 // No special char
        assertFalse(PasswordDetector.isValid("Abbbbbbb!"))                 // Ends with special char
    }
}
