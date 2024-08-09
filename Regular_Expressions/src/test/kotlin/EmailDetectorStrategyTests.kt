import detectors.Detectors.EmailDetector
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import project5.Interfaces.Detector

class EmailDetectorStrategyTests {

    private val EmailDetector: Detector = EmailDetector()

    @Test
    fun testValidEmails() {
        assertTrue(EmailDetector.isValid("a@b.c"))                   // Valid
        assertTrue(EmailDetector.isValid("joseph.ditton@usu.edu"))   // Valid
        assertTrue(EmailDetector.isValid("{}*$.&$*(@*$%&.*&*"))      // Valid
    }

    @Test
    fun testInvalidEmails() {
        assertFalse(EmailDetector.isValid("@b.c"))                   // Part 1 is empty
        assertFalse(EmailDetector.isValid("a@b@c.com"))              // Too many @ symbols
        assertFalse(EmailDetector.isValid("a.b@b.b.c"))              // Too many periods after the @
        assertFalse(EmailDetector.isValid("joseph ditton@usu.edu"))  // Space character not allowed
        assertFalse(EmailDetector.isValid("a@b."))                   // Part 3 empty
    }
}
